package com.alinghinea.Server.service;

import com.alinghinea.Server.entities.Sensor;
import com.alinghinea.Server.repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class SensorService {

    @Autowired
    public SensorRepository sensorRepository;

    public Sensor createSensor(Sensor sensor) {
        return sensorRepository.save(sensor);
    }

    public List<Sensor> getSensors() {
        return sensorRepository.findAll();
    }

    public void deleteSensor(Sensor sensor) {
         sensorRepository.delete(sensor);
    }
}
