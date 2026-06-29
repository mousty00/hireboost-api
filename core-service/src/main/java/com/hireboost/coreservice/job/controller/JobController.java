package com.hireboost.coreservice.job.controller;

import com.hireboost.coreservice.exception.JobException;
import com.hireboost.coreservice.job.dto.JobDTO;
import com.hireboost.coreservice.job.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/jobs")
@RequiredArgsConstructor
public class JobController {

    private final JobService jobService;

    @GetMapping("/{id}")
    public JobDTO getJobById(@PathVariable UUID id) {
        return jobService.getById(id).orElseThrow(JobException::notFound);
    }
}
