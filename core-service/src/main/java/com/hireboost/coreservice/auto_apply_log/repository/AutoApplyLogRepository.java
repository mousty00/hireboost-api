package com.hireboost.coreservice.auto_apply_log.repository;

import com.hireboost.coreservice.auto_apply_log.entity.AutoApplyLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface AutoApplyLogRepository extends JpaRepository<AutoApplyLog, UUID> {

    List<AutoApplyLog> findAllByUserId(UUID userId);
}
