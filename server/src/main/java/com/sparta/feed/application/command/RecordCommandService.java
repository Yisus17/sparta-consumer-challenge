package com.sparta.feed.application.command;

import com.sparta.feed.domain.model.entities.LoadBatch;

public interface RecordCommandService {
    int loadRecordByProvider(LoadBatch data, String provider);
}
