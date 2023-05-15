package org.opengrower.opengrower;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class IrrigationController {
    private final static String ERROR = "-1";
    private final static String HOLD = "2";
    private final static String ON = "1";
    private final static String OFF = "0";
    private final double moistureThresholdOn = 47.0;
    private final double moistureThresholdOff = 55.0;
    private final double SATURATED = 0.0;
    private final SensorMeasurementRepository sensorMeasurementRepository;

    IrrigationController(SensorMeasurementRepository sensorMeasurementRepository) {
        this.sensorMeasurementRepository = sensorMeasurementRepository;
    }

    @GetMapping("irrigation/{sensor}")
    String getIrrigationUpdate(@PathVariable String sensor) {
        SensorMeasurement sensorMeasurement =
                sensorMeasurementRepository.findFirstBySensorOrderByTimeStampDesc(sensor);
        if(sensorMeasurement != null){
            if(sensorMeasurement.getMoisture() > moistureThresholdOff ||
                sensorMeasurement.getMoisture() <= SATURATED){
                return OFF;
            } else if (sensorMeasurement.getMoisture() < moistureThresholdOn) {
                return ON;
            } else {
                return HOLD;
            }
        } else {
            return ERROR;
        }
    }
}
