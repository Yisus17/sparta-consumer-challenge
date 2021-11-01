package com.sparta.feed.domain.entities;

import lombok.Builder;
import lombok.ToString;
import lombok.Value;
import java.util.List;

@Value
@Builder
@ToString
public class Batch {
    private long numberOfRecords;
    private List<Record> records;
}
