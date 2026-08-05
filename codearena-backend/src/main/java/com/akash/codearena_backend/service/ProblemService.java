package com.akash.codearena_backend.service;

import com.akash.codearena_backend.dto.ProblemResponse;
import com.akash.codearena_backend.entity.Problem;
import com.akash.codearena_backend.repository.ProblemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProblemService {

    private final ProblemRepository problemRepository;

    public ProblemService(ProblemRepository problemRepository) {
        this.problemRepository = problemRepository;
    }

    public List<ProblemResponse> getAllProblems() {
        return problemRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public Optional<ProblemResponse> getOneProblem(Long id) {

        return problemRepository.findById(id)
                .map(this::toResponse);
    }

    private ProblemResponse toResponse(Problem problem) {
        return new ProblemResponse(
                problem.getId(),
                problem.getTitle(),
                problem.getDescription(),
                problem.getDifficulty().name(),
                problem.getTags()
        );
    }
}
