package com.sparta.feed.domain.model.entities;

import lombok.Builder;
import lombok.Value;
import java.util.List;

@Value
@Builder
public class Load {
    private long numberOfRecords;
    private List<Record> records;
}
