package com.sparta.feed.application.command;

import com.sparta.feed.domain.model.entities.LoadBatch;
import com.sparta.feed.domain.model.entities.Record;
import com.sparta.feed.infrastructure.repository.RecordRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class RecordCommandServiceImpl implements RecordCommandService {

    private final RecordRepository recordRepository;

    @Override
    public int loadRecordByProvider(LoadBatch data, String provider) {

        int recordCounter = 0;
        for (Record record: data.getRecords()) {
            recordRepository.save(record, provider);
            recordCounter++;
        }

        return recordCounter;
    }



}
