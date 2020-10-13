package com.dinesh.cms.service.mapper;

public interface EntityModelMapper<E, M> {

    M entityToModel(E entity);

    E modelToEntity(M model);
}
