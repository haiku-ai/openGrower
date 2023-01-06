package org.opengrower.opengrower;

import org.springframework.data.annotation.Id;

import java.util.Calendar;
import java.util.Date;

public class SoilMeasurement {

    @Id
    public String id;

    public String sensorId;
    public Integer moistureLevel;
    public Double saltContent;
    public Double temperature;
    public Date timeStamp;

    public SoilMeasurement(){}

    public SoilMeasurement(String sensorId, Integer moistureLevel, Double saltContent, Double temperature) {
        this.sensorId = sensorId;
        this.moistureLevel = moistureLevel;
        this.saltContent = saltContent;
        this.temperature = temperature;
        this.timeStamp = Calendar.getInstance().getTime();
    }

    public SoilMeasurement(SoilMeasurement soilMeasurement) {
        this.sensorId = soilMeasurement.sensorId;
        this.moistureLevel = soilMeasurement.moistureLevel;
        this.saltContent = soilMeasurement.saltContent;
        this.temperature = soilMeasurement.temperature;
        this.timeStamp = Calendar.getInstance().getTime();
    }

    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }

    public void setMoistureLevel(Integer moistureLevel) {
        this.moistureLevel = moistureLevel;
    }

    public void setSaltContent(Double saltContent) {
        this.saltContent = saltContent;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Date getTimeStamp() {
        return this.timeStamp;
    }

    @Override
    public String toString() {
        return String.format(
                "SoilMeasurement[id=%s, sensorId='%s', moistureLevel='%s', saltContent='%s', temperature='%s', timeStamp='%s']",
                id, sensorId, moistureLevel, saltContent, temperature, timeStamp);
    }

}