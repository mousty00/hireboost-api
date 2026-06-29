package com.hireboost.coreservice.job.repository;

import com.hireboost.coreservice.job.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JobRepository extends JpaRepository<Job, UUID> {
}
