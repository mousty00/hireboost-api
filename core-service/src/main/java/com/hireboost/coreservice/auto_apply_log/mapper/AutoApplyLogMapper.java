package com.hireboost.coreservice.auto_apply_log.mapper;

import com.hireboost.coreservice.auto_apply_log.dto.AutoApplyLogDTO;
import com.hireboost.coreservice.auto_apply_log.dto.AutoApplyLogMinimalDTO;
import com.hireboost.coreservice.auto_apply_log.entity.AutoApplyLog;
import com.hireboost.coreservice.utils.UtilityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface AutoApplyLogMapper extends UtilityMapper<AutoApplyLog, AutoApplyLogDTO, AutoApplyLogMinimalDTO> {

    @Override
    @Mapping(source = "job.id", target = "jobId")
    @Mapping(source = "cv.id", target = "cvId")
    AutoApplyLogDTO toDTO(AutoApplyLog autoApplyLog);

    @Override
    @Mapping(target = "job", ignore = true)
    @Mapping(target = "cv", ignore = true)
    AutoApplyLog toEntity(AutoApplyLogDTO autoApplyLogDTO);

    @Override
    AutoApplyLogMinimalDTO toMinimalDTO(AutoApplyLog autoApplyLog);
}
