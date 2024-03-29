package com.alinghinea.Server.controller;

import com.alinghinea.Server.dto.SensorDto;
import com.alinghinea.Server.entities.Sensor;
import com.alinghinea.Server.service.SensorService;
import com.alinghinea.Server.transformer.SensorTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/sensor")
public class SensorController {

    @Autowired
    private SensorService service;

    @Autowired
    private SensorTransformer transformer;

    @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody
    SensorDto createSensor(SensorDto sensorDto) {
        return transformer.toDto(service.createSensor(transformer.toEntity(sensorDto)));
    }

    @GetMapping(value="/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<SensorDto> getSensors() {
        List<Sensor> sensors = service.getSensors();
        List<SensorDto> dtos = new ArrayList<SensorDto>();
        for (int i = 0; i < sensors.size(); i++) {
            dtos.add(transformer.toDto(sensors.get(i)));
        }
        return dtos;
    }
}
