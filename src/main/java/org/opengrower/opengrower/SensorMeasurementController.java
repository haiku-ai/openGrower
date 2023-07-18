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
        SensorMeasurement createSensorMeasurement(@RequestBody SensorMeasurement measurement) {
            SensorMeasurement sensorMeasurement = new SensorMeasurement(measurement);
            return sensorMeasurementRepository.save(sensorMeasurement);
        }

        @GetMapping("/measurements/{sensor}")
        List<SensorMeasurement> getSensorMeasurements(@PathVariable String sensor) {
            return sensorMeasurementRepository.findBySensor(sensor);
        }

        @GetMapping("/measurements/latest10/{sensor}")
        List<SensorMeasurement> getLatest10SensorMeasurements(@PathVariable String sensor) {
            return sensorMeasurementRepository.findFirst10BySensorOrderByTimeStampDesc(sensor);
        }
        @GetMapping("/measurements/latest100/{sensor}")
            List<SensorMeasurement> getLatest100SensorMeasurements(@PathVariable String sensor) {
            return sensorMeasurementRepository.findFirst100BySensorOrderByTimeStampDesc(sensor);
        }

    }
