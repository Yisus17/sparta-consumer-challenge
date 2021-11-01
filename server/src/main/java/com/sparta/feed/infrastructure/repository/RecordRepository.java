package com.sparta.feed.infrastructure.repository;

import com.sparta.feed.domain.entities.Record;

import java.util.List;

public interface RecordRepository {
    Record save(Record record, String provider);

    List<Record> getRecordsByProvider(String provider);
}
