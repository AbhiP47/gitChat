package com.springRag.gitChat.repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.springRag.gitChat.entity.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RepositoryRepository extends JpaRepository<Repository, UUID> {
    List<Repository> findByUserIdOrderByFullNameAsc(UUID userId);

    Optional<Repository> findByIdAndUserId(UUID id, UUID userId);

    Optional<Repository> findByUserIdAndGithubRepoId(UUID userId, Long githubRepoId);
}