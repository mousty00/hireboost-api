package com.hireboost.coreservice.job_application.mapper;

import com.hireboost.coreservice.job_application.dto.JobApplicationDTO;
import com.hireboost.coreservice.job_application.dto.JobApplicationMinimalDTO;
import com.hireboost.coreservice.job_application.entity.JobApplication;
import com.hireboost.coreservice.utils.UtilityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface JobApplicationMapper extends UtilityMapper<JobApplication, JobApplicationDTO, JobApplicationMinimalDTO> {

    @Override
    @Mapping(source = "job.id", target = "jobId")
    @Mapping(source = "cv.id", target = "cvId")
    JobApplicationDTO toDTO(JobApplication jobApplication);

    @Override
    @Mapping(target = "job", ignore = true)
    @Mapping(target = "cv", ignore = true)
    JobApplication toEntity(JobApplicationDTO jobApplicationDTO);

    @Override
    @Mapping(source = "job.id", target = "jobId")
    JobApplicationMinimalDTO toMinimalDTO(JobApplication jobApplication);
}
