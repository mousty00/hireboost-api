package com.hireboost.coreservice.cv.mapper;

import com.hireboost.coreservice.cv.dto.CvDTO;
import com.hireboost.coreservice.cv.dto.CvInputDTO;
import com.hireboost.coreservice.cv.dto.CvMinimalDTO;
import com.hireboost.coreservice.cv.entity.Cv;
import com.hireboost.coreservice.utils.UtilityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface CvMapper extends UtilityMapper<Cv, CvDTO, CvMinimalDTO> {

    @Override
    CvDTO toDTO(Cv cv);

    @Override
    Cv toEntity(CvDTO cvDTO);

    @Override
    CvMinimalDTO toMinimalDTO(Cv cv);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "userId", ignore = true)
    @Mapping(target = "isActive", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Cv fromInput(CvInputDTO input);
}
