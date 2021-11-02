package com.sparta.feed.integration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.sparta.feed.util.TestsUtils.createInputData;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class LoadAndTotalFlowIT {

    public static final String PROVIDER = "shell";
    public static final String LOAD_URL = "/load/{provider}";
    public static final String TOTAL_URL = "/data/{provider}/total";

    @Autowired
    private MockMvc mockMvc;

    @Test
    void totalTestIT() throws Exception {
        // Given
        final byte[] inputData = createInputData();

        mockMvc.perform(MockMvcRequestBuilders
            .post(LOAD_URL, PROVIDER)
            .content(inputData)
            .accept(MediaType.ALL))
            .andDo(
                loadResponse -> {
                //Then
                final var totalResponse = mockMvc.perform(
                    MockMvcRequestBuilders.get(TOTAL_URL, PROVIDER).accept(MediaType.ALL)).andReturn();
    
                final String expectedTotalCallResult = loadResponse.getResponse().getContentAsString();
                final String actualTotalCallResult = totalResponse.getResponse().getContentAsString();

                Assertions.assertEquals(expectedTotalCallResult, actualTotalCallResult);
        });

    }
}
