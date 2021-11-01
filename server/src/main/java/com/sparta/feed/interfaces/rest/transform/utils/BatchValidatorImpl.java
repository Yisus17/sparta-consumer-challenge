package com.sparta.feed.interfaces.rest.transform.utils;

import com.sparta.feed.domain.entities.Sensor;
import com.sparta.feed.domain.entities.SensorCollection;
import com.sparta.feed.domain.exceptions.FailChecksumException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.zip.CRC32;

@Slf4j
@Component
@AllArgsConstructor
public class BatchValidatorImpl implements BatchValidator {

    @Override
    public boolean validateCheckSumForSensors(SensorCollection sensorCollection,
        Long remoteChecksum) throws IOException, FailChecksumException {

        // Creating Streams
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataStream = new DataOutputStream(byteArrayOutputStream);

        // Writing on it
        dataStream.writeInt(sensorCollection.getNumberOfSensors());
        for (Sensor sensor : sensorCollection.getSensors()) {
            final byte[] stringAsBytes = sensor.getId().getBytes();
            dataStream.writeInt(stringAsBytes.length);
            dataStream.write(stringAsBytes);
            dataStream.writeInt(sensor.getMeasure());
        }
        dataStream.flush();

        // Getting byte array
        final byte[] sensorCollectionAsBytes = byteArrayOutputStream.toByteArray();

        // Checksum validation
        CRC32 localChecksum = new CRC32();
        localChecksum.update(sensorCollectionAsBytes);

        if (localChecksum.getValue() != remoteChecksum) {
            throw new FailChecksumException(localChecksum.getValue(), remoteChecksum);
        }

        return true;
    }

}
