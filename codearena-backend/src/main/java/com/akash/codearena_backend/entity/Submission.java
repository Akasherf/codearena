package com.akash.codearena_backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "submissions")
@Getter
@Setter
@NoArgsConstructor
public class Submission {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "problem_id", nullable = false)
    private Problem problem;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String code;

    @Column(nullable = false, length = 20)
    private String language;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SubmissionStatus status;

    @Column(name = "runtime_ms")
    private Integer runtimeMs;

    @Generated(GenerationTime.INSERT)
    @Column(name = "submitted_at", nullable = false, updatable = false, insertable = false)
    private Instant submittedAt;

}

//CREATE TYPE submission_status AS ENUM (
//    'PENDING', 'RUNNING', 'ACCEPTED', 'WRONG_ANSWER',
//            'TIME_LIMIT_EXCEEDED', 'RUNTIME_ERROR', 'COMPILE_ERROR'
//);
//
//CREATE TABLE submissions (
//        id              UUID PRIMARY KEY DEFAULT gen_random_uuid(),
//user_id         UUID NOT NULL REFERENCES users(id) ON DELETE SET NULL,
//problem_id      BIGINT NOT NULL REFERENCES problems(id) ON DELETE CASCADE,
//code            TEXT NOT NULL,
//language        VARCHAR(20) NOT NULL,
//status          submission_status NOT NULL DEFAULT 'PENDING',
//runtime_ms      INTEGER,
//submitted_at    TIMESTAMPTZ NOT NULL DEFAULT now()
//);