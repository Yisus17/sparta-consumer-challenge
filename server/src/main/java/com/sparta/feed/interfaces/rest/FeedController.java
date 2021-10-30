package com.sparta.feed.interfaces.rest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;

public interface FeedController {

    int load(@PathVariable("provider") String provider, @RequestBody byte[] content)
        throws IOException;

    int total(@PathVariable("provider") String provider);

}
