package com.sparta.feed.application.query;

import com.sparta.feed.domain.entities.Record;
import com.sparta.feed.infrastructure.repository.RecordRepositoryVolatile;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static com.sparta.feed.util.TestsUtils.createRecord;
import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RecordQueryServiceImplTest {

    @Mock
    RecordRepositoryVolatile recordRepository;

    @InjectMocks
    RecordQueryServiceImpl recordQueryService;

    @Test
    void getTotalRecordsByProviderTest() {
        // Given
        final String provider = "shell";
        final Record record1 = createRecord();
        final Record record2 = createRecord();
        final List<Record> records = asList(record1,record2);

        // When
        when(recordRepository.getRecordsByProvider(provider)).thenReturn(records);

        // Then
        final int expectedRecordsByProviderQty = records.size();
        final int actualRecordsByProviderQty = recordQueryService.getTotalRecordsByProvider(provider);
        assertEquals(expectedRecordsByProviderQty, actualRecordsByProviderQty);
    }
}
