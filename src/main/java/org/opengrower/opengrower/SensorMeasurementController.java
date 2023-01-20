package org.opengrower.opengrower;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
public class SensorMeasurementController {
    private final SensorMeasurementRepository sensorMeasurementRepository;

    SensorMeasurementController(SensorMeasurementRepository sensorMeasurementRepository) {
            this.sensorMeasurementRepository = sensorMeasurementRepository;
        }

        @PostMapping("/measurement")
        SensorMeasurement createSensorMeasurement(@RequestBody SensorMeasurement sensorMeasurement) {
            return sensorMeasurementRepository.save(new SensorMeasurement(sensorMeasurement));
        }

        @GetMapping("/measurements/{sensor}")
        List<SensorMeasurement> getSensorMeasurements(@PathVariable String sensor) {
            return sensorMeasurementRepository.findBySensor(sensor);
        }

        @GetMapping("/sensors")
        List<String> getSensors() {
            return sensorMeasurementRepository.getDistinctById();
        }
    }
