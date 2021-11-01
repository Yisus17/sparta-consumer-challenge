package com.sparta.feed.infrastructure.repository;

import com.sparta.feed.domain.entities.Record;
import com.sparta.feed.domain.exceptions.FailedConnectionVolatileDBException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.sparta.feed.util.TestsUtils.createBatchWith2Records;
import static com.sparta.feed.util.TestsUtils.createRecord;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class RecordRepositoryVolatileTest {
    
    private RecordRepositoryVolatile recordRepository;

    @Test
    void saveTest() {
        // Given
        recordRepository = new RecordRepositoryVolatile(new HashMap<>());
        final Record record = createRecord();
        final String provider = "shell";

        // Then
        final Record expectedSavedRecord = record;
        final Record actualSavedRecord = recordRepository.save(record, provider);
        assertEquals(expectedSavedRecord, actualSavedRecord);
    }

    @Test
    void saveTest_shouldFailConnectionWithVolatileDB() {
        // Given
        recordRepository = new RecordRepositoryVolatile(null);
        final Record record = createRecord();
        final String provider = "shell";

        // Then
        Assertions.assertThrows(FailedConnectionVolatileDBException.class, () -> {
            recordRepository.save(record, provider);
        });
    }

    @Test
    void getRecordsByProviderTest() {
        // Given
        final String provider = "shell";
        final List<Record> expectedRecords = createBatchWith2Records().getRecords();
        final Map<String, List<Record>> inMemoryDB = new HashMap<>();
        
        inMemoryDB.put(provider, expectedRecords);
        recordRepository = new RecordRepositoryVolatile(inMemoryDB);

        // Then
        List<Record> actualRecordsResult = recordRepository.getRecordsByProvider(provider);
        Assertions.assertIterableEquals(expectedRecords, actualRecordsResult);
    }

    @Test
    void getRecordsByProviderTest_shouldDoesNotFoundRecordsForGivenProvider() {
        // Given
        final String provider = "shell";
        final List<Record> records = createBatchWith2Records().getRecords();
        final Map<String, List<Record>> inMemoryDB = new HashMap<>();

        inMemoryDB.put(provider, records);
        recordRepository = new RecordRepositoryVolatile(inMemoryDB);

        // Then
        List<Record> actualRecordsResult = recordRepository.getRecordsByProvider("im_not_a_provider");
        assertTrue(actualRecordsResult.isEmpty());
    }

}
