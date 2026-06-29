package com.hireboost.coreservice.auto_apply_log.service;

import com.hireboost.coreservice.auto_apply_log.dto.AutoApplyLogDTO;
import com.hireboost.coreservice.auto_apply_log.dto.AutoApplyLogMinimalDTO;
import com.hireboost.coreservice.auto_apply_log.entity.AutoApplyLog;
import com.hireboost.coreservice.auto_apply_log.mapper.AutoApplyLogMapper;
import com.hireboost.coreservice.auto_apply_log.repository.AutoApplyLogRepository;
import com.hireboost.coreservice.utils.UtilityService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AutoApplyLogService extends UtilityService<AutoApplyLog, AutoApplyLogDTO, AutoApplyLogMinimalDTO, AutoApplyLogRepository, AutoApplyLogMapper> {

    public AutoApplyLogService(AutoApplyLogRepository repository, AutoApplyLogMapper mapper) {
        super(repository, mapper);
    }

    public List<AutoApplyLogMinimalDTO> getAllByUserId(UUID userId) {
        return repository.findAllByUserId(userId).stream()
                .map(mapper::toMinimalDTO)
                .toList();
    }
}
