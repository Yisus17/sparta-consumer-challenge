package com.sparta.feed.application.command;

import com.sparta.feed.domain.entities.Batch;

public interface RecordCommandService {
    int loadRecordsByProvider(Batch data, String provider);
}
