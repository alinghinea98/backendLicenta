package com.alinghinea.Server.transformer;

import org.springframework.beans.BeanUtils;

import com.alinghinea.Server.dto.SensorsDto;
import com.alinghinea.Server.entities.Sensors;

public class SensorsTransformer extends AbstractTransformer<Sensors, SensorsDto>{

	
	@Override
	public SensorsDto toDto(Sensors entity) {
		SensorsDto sensorsDto = new SensorsDto();
		BeanUtils.copyProperties(entity, sensorsDto);
		return sensorsDto;
	}

	@Override
	public Sensors toEntity(SensorsDto dto) {
		Sensors sensors = new Sensors();
		BeanUtils.copyProperties(dto, sensors);
		return sensors;
	}

	@Override
	protected Sensors findOrCreateNew(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
