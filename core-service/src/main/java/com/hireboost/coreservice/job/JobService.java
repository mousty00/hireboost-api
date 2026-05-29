package com.hireboost.coreservice.job;

import com.hireboost.coreservice.utils.UtilityService;
import org.springframework.stereotype.Service;

@Service
public class JobService extends UtilityService<Job, JobDTO, JobMinimalDTO, JobRepository, JobMapper> {

    public JobService(JobRepository repository, JobMapper mapper) {
        super(repository, mapper);
    }

}
