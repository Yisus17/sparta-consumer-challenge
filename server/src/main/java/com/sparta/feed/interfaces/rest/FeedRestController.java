package com.sparta.feed.interfaces.rest;

import com.sparta.feed.application.command.RecordCommandService;
import com.sparta.feed.application.query.RecordQueryService;
import com.sparta.feed.domain.entities.Batch;
import com.sparta.feed.interfaces.rest.transform.BatchMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
    @ApiOperation("Load a batch of records for a given provider")
    @Override
    public int load(@PathVariable("provider") String provider, @RequestBody byte[] content) throws IOException {
        Batch batch = batchMapper.from(content);
        return recordCommandService.loadRecordsByProvider(batch, provider);
    }

    @GetMapping("/data/{provider}/total")
    @ApiOperation("Get total of records saved by a provider")
    @Override
    public int total(@PathVariable("provider") String provider) {
        return recordQueryService.getTotalRecordsByProvider(provider);
    }

}
