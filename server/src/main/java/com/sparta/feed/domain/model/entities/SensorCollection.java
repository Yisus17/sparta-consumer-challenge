package com.sparta.feed.domain.model.entities;

import lombok.Builder;
import lombok.Value;

import java.io.Serializable;
import java.util.List;

@Value
@Builder
public class SensorCollection implements Serializable {
    private int numberOfSensors;
    private List<Sensor> sensors;
}
