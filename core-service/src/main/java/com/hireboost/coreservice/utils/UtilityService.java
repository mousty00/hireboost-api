package com.hireboost.coreservice.utils;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public abstract class UtilityService<
        ENTITY,
        DTO,
        MINIMAL_DTO,
        REPOSITORY extends JpaRepository<ENTITY, UUID>,
        MAPPER extends UtilityMapper<ENTITY, DTO, MINIMAL_DTO>> {

    protected final REPOSITORY repository;
    protected final MAPPER mapper;

    public Optional<DTO> getById(UUID id) {
        return repository.findById(id)
                .map(mapper::toDTO);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }
}
