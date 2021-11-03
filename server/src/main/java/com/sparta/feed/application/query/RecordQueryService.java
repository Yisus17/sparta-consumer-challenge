package com.sparta.feed.application.query;

public interface RecordQueryService {
    /**
     * @param provider owner of a list of records
     * @return loaded records quantity for a specific provider
     */
    int getTotalRecordsByProvider(String provider);
}
