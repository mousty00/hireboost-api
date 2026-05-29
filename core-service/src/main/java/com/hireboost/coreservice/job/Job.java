package com.hireboost.coreservice.job;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CurrentTimestamp;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "job", schema = "core")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "external_id", length = Integer.MAX_VALUE)
    private String externalId;

    @Size(max = 255)
    @NotNull
    @Column(name = "title", nullable = false)
    private String title;

    @Size(max = 255)
    @NotNull
    @Column(name = "company", nullable = false)
    private String company;

    @NotNull
    @Column(name = "description", nullable = false, length = Integer.MAX_VALUE)
    private String description;

    @ColumnDefault("'{}'")
    @Column(name = "skills_required")
    private List<String> skillsRequired;

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

    @Column(name = "job_type", columnDefinition = "jobs")
    private String jobType;

    @Column(name = "salary_min")
    private Integer salaryMin;

    @Column(name = "salary_max")
    private Integer salaryMax;

    @Size(max = 100)
    @Column(name = "source", length = 100)
    private String source;

    @Column(name = "job_url", length = Integer.MAX_VALUE)
    private String jobUrl;

    @Column(name = "posted_at")
    @CurrentTimestamp
    private Instant postedAt;


}