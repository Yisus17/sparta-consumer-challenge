package com.sparta.feed.interfaces.rest.transform;

import com.sparta.feed.domain.model.exceptions.FailChecksumException;
import com.sparta.feed.domain.model.entities.LoadBatch;
import com.sparta.feed.domain.model.entities.Record;
import com.sparta.feed.domain.model.entities.Sensor;
import com.sparta.feed.domain.model.entities.SensorCollection;
import com.sparta.feed.interfaces.rest.transform.utils.BatchValidator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
@AllArgsConstructor
public class BatchMapperImpl implements BatchMapper {

    private final BatchValidator batchValidator;

    @Override
    public LoadBatch from(byte[] inputData) throws IOException {

        final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(inputData);
        final DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);

        final long numberOfRecords = dataInputStream.readLong();
        final List<Record> records = new ArrayList<>();
        for (int i = 0; i < numberOfRecords; i++) {
            Record record = parseRecord(dataInputStream);
            records.add(record);
        }

        return LoadBatch.builder()
            .numberOfRecords(numberOfRecords)
            .records(records)
            .build();
    }

    private Record parseRecord(DataInputStream dataInputStream) throws IOException {

        final long recordIndex = dataInputStream.readLong();
        final long timestamp = dataInputStream.readLong();
        final String city = readStringFrom(dataInputStream);
        final int numberBytesSensorData = dataInputStream.readInt();
        final SensorCollection sensorCollection = parseSensorCollection(dataInputStream);
        final Long crc32SensorsData = dataInputStream.readLong();

        try{
            batchValidator.validateCheckSumForSensors(sensorCollection, crc32SensorsData);
        } catch (IOException | FailChecksumException e) {
            // TODO: We could implement a waiting room for invalid records
            log.error(e.getMessage());
        }

        return Record.builder()
            .recordIndex(recordIndex)
            .timestamp(timestamp)
            .city(city)
            .numberBytesSensorData(numberBytesSensorData)
            .sensorCollection(sensorCollection)
            .crc32SensorsData(crc32SensorsData)
            .build();
    }

    private SensorCollection parseSensorCollection(DataInputStream dataInputStream)
        throws IOException {

        final int numberOfSensors = dataInputStream.readInt();
        List<Sensor> sensors = new ArrayList<>();

        for (int i = 0; i < numberOfSensors; i++) {
            Sensor sensor = parseSensor(dataInputStream);
            sensors.add(sensor);
        }

        return SensorCollection.builder()
            .numberOfSensors(numberOfSensors)
            .sensors(sensors)
            .build();
    }

    private Sensor parseSensor(DataInputStream dataInputStream) throws IOException {
        final String sensorId = readStringFrom(dataInputStream);
        final int measure = dataInputStream.readInt();

        return Sensor.builder()
            .id(sensorId)
            .measure(measure)
            .build();
    }

    private String readStringFrom(DataInputStream dataInputStream) throws IOException {
        final int stringSize = dataInputStream.readInt();
        final byte[] stringValue = dataInputStream.readNBytes(stringSize);
        return new String(stringValue, StandardCharsets.UTF_8);
    }

}
