package com.hireboost.coreservice.cv.repository;

import com.hireboost.coreservice.cv.entity.Cv;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CvRepository extends JpaRepository<Cv, UUID> {

    List<Cv> findAllByUserId(UUID userId);
}
