package com.sparta.feed.interfaces.rest.transform.utils;

import com.sparta.feed.domain.model.entities.SensorCollection;

import java.io.IOException;

public interface BatchValidator {

    boolean validateCheckSumForSensors(SensorCollection sensorCollection, Long remoteCRC32) throws IOException;

}
