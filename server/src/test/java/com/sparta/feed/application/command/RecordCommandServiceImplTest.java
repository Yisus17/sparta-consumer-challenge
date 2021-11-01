package com.sparta.feed.application.command;

import com.sparta.feed.domain.entities.Batch;
import com.sparta.feed.infrastructure.repository.RecordRepositoryVolatile;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.sparta.feed.util.TestsUtils.createBatchWith0Records;
import static com.sparta.feed.util.TestsUtils.createBatchWith1Records;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class RecordCommandServiceImplTest {

    @Mock
    RecordRepositoryVolatile recordRepository;

    @InjectMocks
    private RecordCommandServiceImpl recordCommandService;

    @Test
    void loadRecordsByProviderTest() {
        // Given
        final int expectedRecordsByProviderQty = 1;
        final Batch batch = createBatchWith1Records();
        final String provider = "shell";

        // When
        when(recordRepository.save(batch.getRecords().get(0), provider)).thenReturn(
            batch.getRecords().get(0));

        // Then
        int actualRecordsByProviderQty = recordCommandService.loadRecordsByProvider(batch, provider);
        assertEquals(expectedRecordsByProviderQty, actualRecordsByProviderQty);
    }

    @Test
    void loadRecordsByProviderTest_shouldProcessZeroRecords() {
        // Given
        final int expectedRecordsByProviderQty = 0;
        final Batch batch = createBatchWith0Records();
        final String provider = "    ";

        // Then
        int actualRecordsByProviderQty = recordCommandService.loadRecordsByProvider(batch, provider);
        assertEquals(expectedRecordsByProviderQty, actualRecordsByProviderQty);
    }

}
