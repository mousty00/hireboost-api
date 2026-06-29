package com.hireboost.coreservice.job.mapper;

import com.hireboost.coreservice.job.dto.JobDTO;
import com.hireboost.coreservice.job.dto.JobMinimalDTO;
import com.hireboost.coreservice.job.entity.Job;
import com.hireboost.coreservice.utils.UtilityMapper;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface JobMapper extends UtilityMapper<Job, JobDTO, JobMinimalDTO> {

    @Override
    JobDTO toDTO(Job job);

    @Override
    Job toEntity(JobDTO jobDTO);

    @Override
    JobMinimalDTO toMinimalDTO(Job job);
}
