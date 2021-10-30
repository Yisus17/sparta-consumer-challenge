package com.sparta.feed.interfaces.rest;

import com.sparta.feed.application.command.RecordCommandService;
import com.sparta.feed.application.query.RecordQueryService;
import com.sparta.feed.domain.model.entities.LoadBatch;
import com.sparta.feed.interfaces.rest.transform.BatchMapper;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@AllArgsConstructor
public class FeedRestController implements FeedController{

    private final BatchMapper batchMapper;
    private final RecordCommandService recordCommandService;
    private final RecordQueryService recordQueryService;

    @PostMapping("/load/{provider}")
    @Override
    public int load(@PathVariable("provider") String provider, @RequestBody byte[] content) throws IOException {
        LoadBatch loadBatch = batchMapper.from(content);
        return recordCommandService.loadRecordByProvider(loadBatch, provider);
    }

    @GetMapping("/data/{provider}/total")
    @Override
    public int total(@PathVariable("provider") String provider) {
        return recordQueryService.getTotalRecordsByProvider(provider);
    }

}
