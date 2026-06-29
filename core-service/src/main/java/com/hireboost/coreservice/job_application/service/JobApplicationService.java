package com.hireboost.coreservice.job_application.service;

import com.hireboost.coreservice.job_application.dto.JobApplicationDTO;
import com.hireboost.coreservice.job_application.dto.JobApplicationMinimalDTO;
import com.hireboost.coreservice.job_application.entity.JobApplication;
import com.hireboost.coreservice.job_application.mapper.JobApplicationMapper;
import com.hireboost.coreservice.job_application.repository.JobApplicationRepository;
import com.hireboost.coreservice.utils.UtilityService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class JobApplicationService extends UtilityService<JobApplication, JobApplicationDTO, JobApplicationMinimalDTO, JobApplicationRepository, JobApplicationMapper> {

    public JobApplicationService(JobApplicationRepository repository, JobApplicationMapper mapper) {
        super(repository, mapper);
    }

    public List<JobApplicationMinimalDTO> getAllByUserId(UUID userId) {
        return repository.findAllByUserId(userId).stream()
                .map(mapper::toMinimalDTO)
                .toList();
    }
}
