package com.akash.codearena_backend.repository;

import com.akash.codearena_backend.entity.Difficulty;
import com.akash.codearena_backend.entity.Problem;
import com.akash.codearena_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProblemRepository extends JpaRepository<Problem, Long> {
    List<Problem> findByDifficulty(Difficulty difficulty);
}

