package com.alinghinea.Server.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.alinghinea.Server.dto.SensorsDto;
import com.alinghinea.Server.entities.Sensors;
import com.alinghinea.Server.service.SensorsService;
import com.alinghinea.Server.transformer.SensorsTransformer;

@RestController
@RequestMapping("/sensors")
public class SensorsController {
	
	@Autowired
	private SensorsService service;
	
	@Autowired
	private SensorsTransformer transformer;
	
	@GetMapping(value="/:id",produces = MediaType.APPLICATION_JSON_VALUE)
	public SensorsDto getSensors(@Param("id") long id) {
		return transformer.toDto(service.getById(id));
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody SensorsDto createSensors(SensorsDto sensors) {
		return transformer.toDto(service.createSensors(transformer.toEntity(sensors)));
	}
	
	@GetMapping(value="/user/:id",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<SensorsDto> getSensorsByUser(@Param("id") long id) {
		List<Sensors> sensors = service.getListByUserId(id);
		List<SensorsDto> sensorsDto = new ArrayList<SensorsDto>();
		for (int i = 0; i < sensors.size(); i++) {
			sensorsDto.add(transformer.toDto(sensors.get(i)));
		}
		return sensorsDto;
	}
	
}
