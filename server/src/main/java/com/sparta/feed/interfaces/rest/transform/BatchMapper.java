package com.sparta.feed.interfaces.rest.transform;

import com.sparta.feed.domain.entities.Batch;

import java.io.IOException;

public interface BatchMapper {
    Batch from(byte[] data) throws IOException;
}
