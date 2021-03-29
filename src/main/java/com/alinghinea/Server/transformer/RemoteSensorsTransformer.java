package com.alinghinea.Server.transformer;

import com.alinghinea.Server.dto.RemoteSensorsDto;
import com.alinghinea.Server.entities.RemoteSensors;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class RemoteSensorsTransformer extends AbstractTransformer<RemoteSensors, RemoteSensorsDto>{
    @Override
    public RemoteSensorsDto toDto(RemoteSensors entity) {
        RemoteSensorsDto remoteSensorsDto = new RemoteSensorsDto();
        BeanUtils.copyProperties(entity, remoteSensorsDto);
        return  remoteSensorsDto;
    }

    @Override
    public RemoteSensors toEntity(RemoteSensorsDto dto) {
        RemoteSensors remoteSensors = new RemoteSensors();
        BeanUtils.copyProperties(dto, remoteSensors);
        return remoteSensors;
    }

    @Override
    protected RemoteSensors findOrCreateNew(Long id) {
        return null;
    }
}
