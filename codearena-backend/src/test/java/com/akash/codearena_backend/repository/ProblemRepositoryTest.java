package com.akash.codearena_backend.repository;

//package com.akash.codearena_backend.repository;

import com.akash.codearena_backend.entity.Problem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ProblemRepositoryTest {

    @Autowired
    private ProblemRepository problemRepository;

    @Test
    void shouldReturnSeededProblems() {
        List<Problem> problems = problemRepository.findAll();

        assertThat(problems).hasSize(3);
        assertThat(problems)
                .extracting(Problem::getTitle)
                .containsExactlyInAnyOrder("Two Sum", "Valid Parentheses", "Reverse Linked List");
    }
}
