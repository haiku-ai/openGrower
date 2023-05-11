package org.opengrower.opengrower;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class OpenGrowerWebController {
    private final SensorMeasurementRepository sensorMeasurementRepository;

    private final SensorRepository sensorRepository;

    OpenGrowerWebController(SensorMeasurementRepository sensorMeasurementRepository, SensorRepository sensorRepository) {
        this.sensorMeasurementRepository = sensorMeasurementRepository;
        this.sensorRepository = sensorRepository;
    }

    @GetMapping("/sensors")
    public String sensors(@RequestParam(name = "name", required = false, defaultValue = "") String name, Model model) {
        final List<Sensor> sensors = sensorRepository.findAll();
        final List<String> sensorNames = new ArrayList<>();
        for(final Sensor sensor : sensors) {
            sensorNames.add(sensor.getName());
        }
        model.addAttribute("sensors", sensorNames);
        return "sensors";
    }

}