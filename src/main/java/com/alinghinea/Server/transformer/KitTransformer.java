package com.alinghinea.Server.transformer;

import com.alinghinea.Server.dto.KitDto;
import com.alinghinea.Server.entities.Kit;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class KitTransformer extends  AbstractTransformer<Kit, KitDto>{
    @Override
    public KitDto toDto(Kit entity) {
        KitDto kitDto = new KitDto();
        BeanUtils.copyProperties(entity, kitDto);
        return kitDto;
    }

    @Override
    public Kit toEntity(KitDto dto) {
        Kit kit = new Kit();
        BeanUtils.copyProperties(dto, kit);
        return kit;
    }

    @Override
    protected Kit findOrCreateNew(Long id) {
        return null;
    }
}
