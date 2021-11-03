package com.sparta.feed.application.command;

import com.sparta.feed.domain.entities.Batch;

public interface RecordCommandService {
    /**
     * @param provider key value to load a list of records
     * @param data record list byte array
     * @return loaded records quantity
     * @throws IOException
     */
    int loadRecordsByProvider(Batch data, String provider);
}
