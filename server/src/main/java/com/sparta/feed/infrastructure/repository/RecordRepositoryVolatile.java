package com.sparta.feed.infrastructure.repository;

import com.sparta.feed.domain.entities.Record;
import com.sparta.feed.domain.exceptions.FailedConnectionVolatileDBException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.lang.annotation.Inherited;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

@Slf4j
@Component
@AllArgsConstructor
@Data
public class RecordRepositoryVolatile  implements RecordRepository{

    private final Map<String, List<Record>> inMemoryDB;

    @Override
    public Record save(Record record, String provider) {
        return addRecord(provider, record);
    }

    @Override
    public List<Record> getRecordsByProvider(String provider) {
       final List<Record> records = inMemoryDB.get(provider);
       if(records == null){
           return asList();
       }
       return records;
    }

    private Record addRecord(String provider, Record record) {
        try {
            inMemoryDB
                .computeIfAbsent(provider, list -> new ArrayList<>())
                .add(record);

            return record;
        } catch (Exception e){
            throw new FailedConnectionVolatileDBException("RecordRepositoryVolatile", e.getMessage());
        }
    }



}
