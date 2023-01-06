package org.opengrower.opengrower;

import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;

@RestController("/openGrower")
public class SoilMeasurementController {
    private final SoilMeasurementRepository soilMeasurementRepository;

    SoilMeasurementController(SoilMeasurementRepository soilMeasurementRepository) {
            this.soilMeasurementRepository = soilMeasurementRepository;
        }

        @PostMapping("/soilMeasurement")
        SoilMeasurement createSoilMeasurement(@RequestBody SoilMeasurement newSoilMeasurement) {
            return soilMeasurementRepository.save(new SoilMeasurement(newSoilMeasurement));
        }

        @GetMapping("/soilMeasurements/{sensorId}")
        List<SoilMeasurement> getSoilMeasurements(@PathVariable String sensorId) {
            return soilMeasurementRepository.findBySensorId(sensorId);
        }
    }
