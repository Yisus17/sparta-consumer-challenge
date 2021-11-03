package com.sparta.feed.interfaces.rest.transform;

import com.sparta.feed.domain.entities.Batch;

import java.io.IOException;

public interface BatchMapper {

    /**
     * @param data byte array that would be parsed to a Batch object
     * @return resultant batch object
     * @throws IOException
     */
    Batch from(byte[] data) throws IOException;
}
