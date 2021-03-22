package com.alinghinea.Server.transformer;

import com.alinghinea.Server.dto.SensorDto;
import com.alinghinea.Server.entities.Sensor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class SensorTransformer extends AbstractTransformer<Sensor, SensorDto>{
    @Override
    public SensorDto toDto(Sensor entity) {
        SensorDto sensorDto = new SensorDto();
        BeanUtils.copyProperties(entity, sensorDto);
        return sensorDto;
    }

    @Override
    public Sensor toEntity(SensorDto dto) {
        Sensor sensor = new Sensor();
        BeanUtils.copyProperties(dto, sensor);
        return sensor;
    }

    @Override
    protected Sensor findOrCreateNew(Long id) {
        return null;
    }
}
