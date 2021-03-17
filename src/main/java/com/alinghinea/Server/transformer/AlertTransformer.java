package com.alinghinea.Server.transformer;

import com.alinghinea.Server.dto.AlertDto;
import com.alinghinea.Server.entities.Alert;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AlertTransformer extends AbstractTransformer<Alert, AlertDto>{
    @Override
    public AlertDto toDto(Alert entity) {
        AlertDto alertDto = new AlertDto();
        BeanUtils.copyProperties(entity, alertDto);
        return alertDto;
    }

    @Override
    public Alert toEntity(AlertDto dto) {
        Alert alert = new Alert();
        BeanUtils.copyProperties(dto, alert);
        return alert;
    }

    @Override
    protected Alert findOrCreateNew(Long id) {
        return null;
    }
}
