package org.opengrower.opengrower;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.Date;

@RestController()
public class IrrigationController {
    private final static String ERROR = "-1";
    private final static String HOLD_ON = "2";
    private final static String HOLD_OFF = "3";
    private final static String ON = "1";
    private final static String OFF = "0";
    private final double moistureThresholdOn = 25.0;
    private final double moistureThresholdOff = 35.0;
    private final double SATURATED = 0.0;
    private final SensorMeasurementRepository sensorMeasurementRepository;
    private final SensorRepository sensorRepository;

    IrrigationController(SensorMeasurementRepository sensorMeasurementRepository,
                         SensorRepository sensorRepository) {
        this.sensorMeasurementRepository = sensorMeasurementRepository;
        this.sensorRepository = sensorRepository;
    }

    @GetMapping("irrigation/{sensor}")
    String getIrrigationUpdate(@PathVariable String sensor) {
        System.out.println(sensor);
        sensorRepository.findDistinctByName(sensor).setLatestReadingDate(Calendar.getInstance().getTime());

        SensorMeasurement sensorMeasurement =
                sensorMeasurementRepository.findFirstBySensorOrderByTimeStampDesc(sensor);
        if(sensorMeasurement != null){
            if(sensorMeasurement.getMoisture() > moistureThresholdOff ||
                sensorMeasurement.getMoisture() <= SATURATED){
                sensorRepository.findDistinctByName(sensor).setState(OFF);
                return OFF;
            } else if (sensorMeasurement.getMoisture() < moistureThresholdOn) {
                sensorRepository.findDistinctByName(sensor).setState(ON);
                return ON;
            } else {
                if(sensorRepository.findDistinctByName(sensor).getState() == ON){
                    return HOLD_ON;
                } else {
                    return HOLD_OFF;
                }
            }
        } else {
            return ERROR;
        }
    }
}
