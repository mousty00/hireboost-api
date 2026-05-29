package com.hireboost.coreservice.job_application;

import com.hireboost.coreservice.cv.Cv;
import com.hireboost.coreservice.job.Job;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "job_application", schema = "core")
public class JobApplication {
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

    @Size(max = 255)
    @NotNull
    @Column(name = "company", nullable = false)
    private String company;

    @Size(max = 255)
    @NotNull
    @Column(name = "\"position\"", nullable = false)
    private String position;

    @Column(name = "application_status", columnDefinition = "app_status not null")
    private Object applicationStatus;

    @Size(max = 100)
    @Column(name = "location_city", length = 100)
    private String locationCity;

    @Size(max = 150)
    @Column(name = "location_country", length = 150)
    private String locationCountry;

    @Column(name = "location_lat")
    private Double locationLat;

    @Column(name = "location_lng")
    private Double locationLng;

    @Column(name = "job_url", length = Integer.MAX_VALUE)
    private String jobUrl;

    @Column(name = "notes", length = Integer.MAX_VALUE)
    private String notes;

    @Column(name = "match_score")
    private Double matchScore;

    @Column(name = "applied_at")
    private Instant appliedAt;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_at")
    private Instant createdAt;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "updated_at")
    private Instant updatedAt;


}