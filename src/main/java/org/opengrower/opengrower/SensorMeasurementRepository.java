package org.opengrower.opengrower;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface SensorMeasurementRepository extends MongoRepository<SensorMeasurement, String> {
    public List<SensorMeasurement> findBySensor(String sensor);
    public List<SensorMeasurement> findBySensorAndTimeStamp(String sensor, Date timestamp);
}