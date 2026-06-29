package com.hireboost.coreservice.job.service;

import com.hireboost.coreservice.job.dto.JobDTO;
import com.hireboost.coreservice.job.dto.JobMinimalDTO;
import com.hireboost.coreservice.job.entity.Job;
import com.hireboost.coreservice.job.mapper.JobMapper;
import com.hireboost.coreservice.job.repository.JobRepository;
import com.hireboost.coreservice.utils.UtilityService;
import org.springframework.stereotype.Service;

@Service
public class JobService extends UtilityService<Job, JobDTO, JobMinimalDTO, JobRepository, JobMapper> {

    public JobService(JobRepository repository, JobMapper mapper) {
        super(repository, mapper);
    }
}
