package com.sparta.feed.interfaces.rest.transform;

import com.sparta.feed.domain.model.entities.Load;

import java.io.IOException;

public interface BatchMapper {
    Load from(byte[] data) throws IOException;
}
