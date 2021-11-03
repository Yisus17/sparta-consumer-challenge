package com.sparta.feed.util;

import com.sparta.feed.domain.entities.Batch;
import com.sparta.feed.domain.entities.Record;
import com.sparta.feed.domain.entities.Sensor;
import com.sparta.feed.domain.entities.SensorCollection;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.util.Arrays.asList;

public class TestsUtils {

    public static final Path BASE_TEST_RESOURCES_MESSAGE =
        Paths.get("src", "test", "resources", "message");
    public static final String INPUT_DATA_FILE = "byte_array_input_data.txt";

    public static Batch createBatchWith0Records() {
        return Batch.builder().numberOfRecords(0).records(asList()).build();
    }

    public static Batch createBatchWith1Records() {
        return Batch.builder().numberOfRecords(1).records(asList(
            Record.builder().recordIndex(0).timestamp(810758661).city("Gulltown")
                .numberBytesSensorData(356).sensorCollection(
                    SensorCollection.builder().numberOfSensors(8).sensors(asList(
                        Sensor.builder().id("fde93d84-894b-47f3-b29f-e99acee2bced").measure(6447)
                            .build(),
                        Sensor.builder().id("c04e8ecc-d280-4b81-b853-89476e5c7e8e").measure(1053)
                            .build(),
                        Sensor.builder().id("477817eb-2502-433a-a936-22de449c6fb4").measure(9761)
                            .build(),
                        Sensor.builder().id("59c7c955-aafd-4521-9c0d-9502c79aa146").measure(2854)
                            .build(),
                        Sensor.builder().id("898e8b53-f07d-4665-a3ad-81ca11a749e1").measure(2677)
                            .build(),
                        Sensor.builder().id("c18dc5ea-d56d-4d37-8648-85b63d419085").measure(4262)
                            .build(),
                        Sensor.builder().id("8fdf6b91-b338-4b42-9002-8c2c099b8ad4").measure(8844)
                            .build(),
                        Sensor.builder().id("1acb46ec-32f5-4bf9-a3bc-65ea6f101a83").measure(7875)
                            .build())).build()).build())).build();
    }

    public static Batch createBatchWith2Records() {
        return Batch.builder().numberOfRecords(2).records(asList(
            Record.builder().recordIndex(0).timestamp(810758661).city("Gulltown")
                .numberBytesSensorData(356).sensorCollection(
                    SensorCollection.builder().numberOfSensors(8).sensors(asList(
                        Sensor.builder().id("fde93d84-894b-47f3-b29f-e99acee2bced").measure(6447)
                            .build(),
                        Sensor.builder().id("c04e8ecc-d280-4b81-b853-89476e5c7e8e").measure(1053)
                            .build(),
                        Sensor.builder().id("477817eb-2502-433a-a936-22de449c6fb4").measure(9761)
                            .build(),
                        Sensor.builder().id("59c7c955-aafd-4521-9c0d-9502c79aa146").measure(2854)
                            .build(),
                        Sensor.builder().id("898e8b53-f07d-4665-a3ad-81ca11a749e1").measure(2677)
                            .build(),
                        Sensor.builder().id("c18dc5ea-d56d-4d37-8648-85b63d419085").measure(4262)
                            .build(),
                        Sensor.builder().id("8fdf6b91-b338-4b42-9002-8c2c099b8ad4").measure(8844)
                            .build(),
                        Sensor.builder().id("1acb46ec-32f5-4bf9-a3bc-65ea6f101a83").measure(7875)
                            .build())).build()).build(),

            Record.builder().recordIndex(1).timestamp(810758661).city("Winterfell")
                .numberBytesSensorData(178).sensorCollection(
                    SensorCollection.builder().numberOfSensors(4).sensors(asList(
                        Sensor.builder().id("898e8b53-f07d-4665-a3ad-81ca11a749e1").measure(2677)
                            .build(),
                        Sensor.builder().id("c18dc5ea-d56d-4d37-8648-85b63d419085").measure(4262)
                            .build(),
                        Sensor.builder().id("8fdf6b91-b338-4b42-9002-8c2c099b8ad4").measure(8844)
                            .build(),
                        Sensor.builder().id("1acb46ec-32f5-4bf9-a3bc-65ea6f101a83").measure(7875)
                            .build())).build()).build())).build();
    }

    public static Record createRecord() {
        return Record.builder().recordIndex(0).timestamp(810758661).city("Gulltown")
            .numberBytesSensorData(356).sensorCollection(
                SensorCollection.builder().numberOfSensors(8).sensors(asList(
                    Sensor.builder().id("fde93d84-894b-47f3-b29f-e99acee2bced").measure(6447)
                        .build(),
                    Sensor.builder().id("c04e8ecc-d280-4b81-b853-89476e5c7e8e").measure(1053)
                        .build(),
                    Sensor.builder().id("477817eb-2502-433a-a936-22de449c6fb4").measure(9761)
                        .build(),
                    Sensor.builder().id("59c7c955-aafd-4521-9c0d-9502c79aa146").measure(2854)
                        .build(),
                    Sensor.builder().id("898e8b53-f07d-4665-a3ad-81ca11a749e1").measure(2677)
                        .build(),
                    Sensor.builder().id("c18dc5ea-d56d-4d37-8648-85b63d419085").measure(4262)
                        .build(),
                    Sensor.builder().id("8fdf6b91-b338-4b42-9002-8c2c099b8ad4").measure(8844)
                        .build(),
                    Sensor.builder().id("1acb46ec-32f5-4bf9-a3bc-65ea6f101a83").measure(7875)
                        .build())).build()).build();
    }

    public static SensorCollection createSensorCollection(){
        return SensorCollection.builder().numberOfSensors(8).sensors(asList(
                Sensor.builder().id("fde93d84-894b-47f3-b29f-e99acee2bced").measure(6447).build(),
                Sensor.builder().id("c04e8ecc-d280-4b81-b853-89476e5c7e8e").measure(1053).build(),
                Sensor.builder().id("477817eb-2502-433a-a936-22de449c6fb4").measure(9761).build(),
                Sensor.builder().id("59c7c955-aafd-4521-9c0d-9502c79aa146").measure(2854).build(),
                Sensor.builder().id("898e8b53-f07d-4665-a3ad-81ca11a749e1").measure(2677).build(),
                Sensor.builder().id("c18dc5ea-d56d-4d37-8648-85b63d419085").measure(4262).build(),
                Sensor.builder().id("8fdf6b91-b338-4b42-9002-8c2c099b8ad4").measure(8844).build(),
                Sensor.builder().id("1acb46ec-32f5-4bf9-a3bc-65ea6f101a83").measure(7875).build()))
            .build();
    }

    public static byte[] createInputData() throws IOException {
        final String inputDataAsString =
            Files.readString(BASE_TEST_RESOURCES_MESSAGE.resolve(Paths.get(INPUT_DATA_FILE)));

        final String[] byteValues =
            inputDataAsString.substring(1, inputDataAsString.length() - 1).split(",");
        final byte[] inputDataAsByteArray = new byte[byteValues.length];

        for (int i = 0; i < byteValues.length; i++) {
            inputDataAsByteArray[i] = Byte.parseByte(byteValues[i].trim());
        }

        return inputDataAsByteArray;
    }


}
