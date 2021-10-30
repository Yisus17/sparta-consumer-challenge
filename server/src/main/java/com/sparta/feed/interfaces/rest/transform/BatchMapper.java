package com.sparta.feed.interfaces.rest.transform;

import com.sparta.feed.domain.model.entities.LoadBatch;

import java.io.IOException;

public interface BatchMapper {
    LoadBatch from(byte[] data) throws IOException;
}
