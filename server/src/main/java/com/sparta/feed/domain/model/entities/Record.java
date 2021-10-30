package com.sparta.feed.domain.model.entities;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Record {

    private long recordIndex;
    private long timestamp;
    private String city;
    private int numberBytesSensorData;
    private SensorCollection sensorCollection;
    private long crc32SensorsData;

}
