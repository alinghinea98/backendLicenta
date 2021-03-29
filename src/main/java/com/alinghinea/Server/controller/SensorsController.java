package com.alinghinea.Server.controller;

import com.alinghinea.Server.dto.SensorsDto;
import com.alinghinea.Server.entities.Sensors;
import com.alinghinea.Server.service.SensorsService;
import com.alinghinea.Server.transformer.SensorsTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/sensors")
public class SensorsController {
	
	@Autowired
	private SensorsService service;
	
	@Autowired
	private SensorsTransformer transformer;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public SensorsDto getSensors(@RequestParam("id") long id) {
		return transformer.toDto(service.getById(id));
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody SensorsDto createSensors(SensorsDto sensors) {
		return transformer.toDto(service.createSensors(transformer.toEntity(sensors)));
	}
	
	@GetMapping(value="/user",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<SensorsDto> getSensorsByUser(@RequestParam("id") long id) {
		List<Sensors> sensors = service.getListByUserId(id);
		List<SensorsDto> sensorsDto = new ArrayList<SensorsDto>();
		for (int i = 0; i < sensors.size(); i++) {
			sensorsDto.add(transformer.toDto(sensors.get(i)));
		}
		return sensorsDto;
	}

	@GetMapping(value="/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<SensorsDto> getSensorsList() {
		List<Sensors> sensors = service.getSensorsList();
		List<SensorsDto> sensorsDto = new ArrayList<SensorsDto>();
		for (int i = 0; i < sensors.size(); i++) {
			sensorsDto.add(transformer.toDto(sensors.get(i)));
		}
		return sensorsDto;
	}
}
