package com.alinghinea.Server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alinghinea.Server.entities.Sensors;
import com.alinghinea.Server.repository.SensorsRepository;

@Service
@Transactional
public class SensorsService {
	
	@Autowired
	private SensorsRepository sensorsRep;
	
	public Sensors createSensors(Sensors sensors) {
		return this.sensorsRep.save(sensors);
		
	}
	
	public List<Sensors> getListByUserId(long id) {
		return this.sensorsRep.getByUser(id);
	}
	
	public Sensors getById(long id) {
		return this.sensorsRep.getOne(id);
	}
}
