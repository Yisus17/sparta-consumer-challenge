package com.sparta.feed.application.query;

import com.sparta.feed.domain.model.entities.Record;
import com.sparta.feed.infrastructure.repository.RecordRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@AllArgsConstructor
public class RecordQueryServiceImpl implements RecordQueryService{

    private final RecordRepository recordRepository;

    @Override
    public int getTotalRecordsByProvider(String provider) {
        List<Record> records = recordRepository.getRecordsByProvider(provider);
        return records.size();
    }
}
