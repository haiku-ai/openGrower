package org.opengrower.opengrower;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Controller
public class OpenGrowerWebController {
    private final SensorMeasurementRepository sensorMeasurementRepository;

    OpenGrowerWebController(SensorMeasurementRepository sensorMeasurementRepository) {
        this.sensorMeasurementRepository = sensorMeasurementRepository;
    }

    @GetMapping("/sensors")
    public String sensors(@RequestParam(name = "name", required = false, defaultValue = "") String name, Model model) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
       /* final List<String> sensors = sensorMeasurementRepository.getDistinctByTimeStampAfter(calendar.getTime());
        final List<String> sensorsParsed = new ArrayList<>();
        for(final String sensor : sensors) {
            sensorsParsed.add(sensor.);
        }
        model.addAttribute("sensors", sensors);*/
        return "sensors";
    }

}