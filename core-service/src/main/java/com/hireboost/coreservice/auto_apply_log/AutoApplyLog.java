package com.hireboost.coreservice.auto_apply_log;

import com.hireboost.coreservice.cv.Cv;
import com.hireboost.coreservice.job.Job;
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

    @Column(name = "status", columnDefinition = "auto_apply_log_status not null")
    private Object status;

    @Column(name = "error_message", length = Integer.MAX_VALUE)
    private String errorMessage;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "triggered_at")
    private Instant triggeredAt;


}