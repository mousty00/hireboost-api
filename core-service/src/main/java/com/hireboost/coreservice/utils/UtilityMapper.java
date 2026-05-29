package com.hireboost.coreservice.utils;

public interface UtilityMapper<ENTITY, DTO, MINIMAL_DTO> {

    DTO toDTO(ENTITY entity);
    ENTITY toEntity(DTO dto);
    MINIMAL_DTO toMinimalDTO(ENTITY entity);
}
