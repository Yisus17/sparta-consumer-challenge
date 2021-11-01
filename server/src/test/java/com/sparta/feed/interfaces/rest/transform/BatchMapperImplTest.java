package com.sparta.feed.interfaces.rest.transform;

import com.sparta.feed.domain.entities.Batch;
import com.sparta.feed.interfaces.rest.transform.utils.BatchValidatorImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BatchMapperImplTest {

    public static final Path BASE_TEST_RESOURCES_MESSAGE =
        Paths.get("src", "test", "resources", "message");
    public static final String INPUT_DATA_FILE = "byte_array_input_data.txt";

    @Mock
    private BatchValidatorImpl batchValidator;

    @InjectMocks
    private BatchMapperImpl batchMapper;

    @Test
    void fromByteArrayToBatchTest() throws IOException {
        // Given
        final String inputDataAsString =
            Files.readString(BASE_TEST_RESOURCES_MESSAGE.resolve(Paths.get(INPUT_DATA_FILE)));

        final int expectedNumberOfRecords = 360;

        final String[] byteValues =
            inputDataAsString.substring(1, inputDataAsString.length() - 1).split(",");
        final byte[] inputDataAsByteArray = new byte[byteValues.length];

        for (int i = 0; i < byteValues.length; i++) {
            inputDataAsByteArray[i] = Byte.parseByte(byteValues[i].trim());
        }

        // When
        when(batchValidator.validateCheckSumForSensors(any(), any())).thenReturn(true);

        // Then
        final Batch actualResult = batchMapper.from(inputDataAsByteArray);

        assertAll(
            () -> assertNotNull(actualResult),
            () -> assertEquals(expectedNumberOfRecords, actualResult.getRecords().size()),
            () -> assertEquals(expectedNumberOfRecords, actualResult.getNumberOfRecords())
        );
    }
}
