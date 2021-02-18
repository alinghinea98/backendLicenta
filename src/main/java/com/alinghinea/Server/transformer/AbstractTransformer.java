package com.alinghinea.Server.transformer;

import java.util.ArrayList;
import java.util.List;

import com.alinghinea.Server.dto.BaseDto;
import com.alinghinea.Server.entities.BaseEntity;

public abstract class AbstractTransformer<T extends BaseEntity, X extends BaseDto> {

	public final List<X> toDtoList(List<T> entities) {
		List<X> dtoList = new ArrayList<>();
		for (T entity : entities) {
			dtoList.add(toDto(entity));
		}
		return dtoList;
	}

	public abstract X toDto(T entity);

	public abstract T toEntity(X dto);

	protected abstract T findOrCreateNew(Long id);

}