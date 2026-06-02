package com.hireboost.authservice.user.entity;

import com.hireboost.authservice.enums.EJobType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user", schema = "auth")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, columnDefinition = "uuid")
    private UUID id;

    @Email
    @NotBlank
    @Column(name = "email", nullable = false, columnDefinition = "citext")
    String email;

    @NotBlank
    @Column(name = "password", nullable = false, columnDefinition = "text")
    String password;

    @NotBlank
    @Column(name = "legal_name", nullable = false, columnDefinition = "text")
    String name;

    @NotBlank
    @Column(name = "surname", nullable = false, columnDefinition = "text")
    String surname;

    @NotBlank
    @Column(name = "preferred_location", columnDefinition = "text")
    String preferred_location;

    @NotBlank
    @Column(name = "salary_min" , columnDefinition = "integer")
    Integer salary_min;

    @NotBlank
    @Column(name = "salary_max", columnDefinition = "integer")
    String salary_max;

    @NotBlank
    @Enumerated(EnumType.STRING)
    @Column(name = "job_type")
    EJobType job_type;

    @NotBlank
    @Column(name = "created_at", columnDefinition = "timestamp", insertable = false, updatable = false)
    LocalDateTime created_at;

    @NotBlank
    @Column(name = "updated_at", columnDefinition = "timestamp", insertable = false, updatable = false)
    LocalDateTime updated_at;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;
}
