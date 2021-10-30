package com.sparta.feed.infrastructure.repository;

import com.sparta.feed.domain.model.entities.Record;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
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
    public void save(Record record, String provider) {
        addRecord(provider, record);
        System.out.println("----");
    }

    @Override
    public List<Record> getRecordsByProvider(String provider) {
       return inMemoryDB.get(provider);
    }

    private void addRecord(String provider, Record record) {
        inMemoryDB
            .computeIfAbsent(provider, list -> new ArrayList<>())
            .add(record);
    }



}
