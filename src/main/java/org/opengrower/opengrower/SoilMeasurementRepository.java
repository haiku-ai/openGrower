package org.opengrower.opengrower;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface SoilMeasurementRepository extends MongoRepository<SoilMeasurement, String> {

    public List<SoilMeasurement> findBySensorId(String sensorId);
}