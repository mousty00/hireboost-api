package com.hireboost.coreservice.cv.service;

import com.hireboost.coreservice.cv.dto.CvDTO;
import com.hireboost.coreservice.cv.dto.CvMinimalDTO;
import com.hireboost.coreservice.cv.entity.Cv;
import com.hireboost.coreservice.cv.mapper.CvMapper;
import com.hireboost.coreservice.cv.repository.CvRepository;
import com.hireboost.coreservice.utils.UtilityService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CvService extends UtilityService<Cv, CvDTO, CvMinimalDTO, CvRepository, CvMapper> {

    public CvService(CvRepository repository, CvMapper mapper) {
        super(repository, mapper);
    }

    public List<CvMinimalDTO> getAllByUserId(UUID userId) {
        return repository.findAllByUserId(userId).stream()
                .map(mapper::toMinimalDTO)
                .toList();
    }
}
