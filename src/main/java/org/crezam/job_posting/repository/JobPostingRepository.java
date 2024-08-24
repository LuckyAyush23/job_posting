package org.crezam.job_posting.repository;

import java.util.List;

import org.crezam.job_posting.dto.JobPosting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobPostingRepository extends JpaRepository<JobPosting, Long> {
    List<JobPosting> findByTitleContainingOrLocationContainingOrRequiredSkillsContaining(String title, String location, String skills);
}

