package com.hireboost.coreservice.auto_apply_log.entity;

import com.hireboost.coreservice.cv.entity.Cv;
import com.hireboost.coreservice.enums.EAutoApplyLogStatus;
import com.hireboost.coreservice.job.entity.Job;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "auto_apply_log", schema = "core")
public class AutoApplyLog {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @NotNull
    @Column(name = "user_id", nullable = false)
    private UUID userId;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "job_id", nullable = false)
    private Job job;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cv_id", nullable = false)
    private Cv cv;

    @NotNull
    @Column(name = "match_score", nullable = false)
    private Double matchScore;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private EAutoApplyLogStatus status;

    @Column(name = "error_message", length = Integer.MAX_VALUE)
    private String errorMessage;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "triggered_at")
    private Instant triggeredAt;
}
