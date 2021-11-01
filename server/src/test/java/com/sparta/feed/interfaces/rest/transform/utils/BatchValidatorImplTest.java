package com.sparta.feed.interfaces.rest.transform.utils;

import com.sparta.feed.domain.entities.SensorCollection;
import com.sparta.feed.domain.exceptions.FailChecksumException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static com.sparta.feed.util.TestsUtils.createSensorCollection;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BatchValidatorImplTest {

    private final BatchValidatorImpl BatchValidator = new BatchValidatorImpl();

    @Test
    void validateCheckSumForSensorsTest() throws IOException {
        // Given
        final SensorCollection sensorCollection = createSensorCollection();
        final Long remoteChecksum = 2125082487L;

        // Then
        assertTrue(BatchValidator.validateCheckSumForSensors(sensorCollection, remoteChecksum));
    }

    @Test
    void validateCheckSumForSensorsTest_shouldFailWithInvalidChecksumException() throws IOException {
        // Given
        final SensorCollection sensorCollection = createSensorCollection();
        final Long remoteChecksum = 99999L;

        // Then
        Assertions.assertThrows(FailChecksumException.class, () -> {
            BatchValidator.validateCheckSumForSensors(sensorCollection, remoteChecksum);
        });
    }

}
