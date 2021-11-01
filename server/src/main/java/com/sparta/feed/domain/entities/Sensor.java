package com.sparta.feed.domain.entities;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Sensor {
    private String id;
    private int measure;
}
