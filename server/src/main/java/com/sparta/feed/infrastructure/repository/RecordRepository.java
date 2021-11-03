package com.sparta.feed.infrastructure.repository;

import com.sparta.feed.domain.entities.Record;

import java.util.List;

public interface RecordRepository {

    /**
     * @param provider the key field to save the records
     * @return list of records for a provider
     */
    Record save(Record record, String provider);

    /**
     * @param provider key field to get a group of records
     * @return list of records for a provider
     */
    List<Record> getRecordsByProvider(String provider);
}
