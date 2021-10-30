package com.sparta.feed.interfaces.rest;

import com.sparta.feed.domain.model.entities.Load;
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

    @PostMapping("/load/{provider}")
    @Override
    public int load(@PathVariable("provider") String provider, @RequestBody byte[] content) throws IOException {
        Load load = batchMapper.from(content);
        return load.getRecords().size();
    }

    @GetMapping("/data/{provider}/total")
    @Override
    public int total(@PathVariable("provider") String provider) {
        System.out.println("------TOTAL------");
        return 0;
    }

}
