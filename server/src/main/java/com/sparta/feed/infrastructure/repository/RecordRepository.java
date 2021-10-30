package com.sparta.feed.infrastructure.repository;

import com.sparta.feed.domain.model.entities.Record;

import java.util.List;

public interface RecordRepository {
    void save(Record record, String provider);

    List<Record> getRecordsByProvider(String provider);
}
