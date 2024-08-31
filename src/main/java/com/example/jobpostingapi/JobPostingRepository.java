package com.example.jobpostingapi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobPostingRepository extends JpaRepository<JobPosting, Long> {
    List<JobPosting> findByTitleContainingOrLocationContainingOrRequiredSkillsContaining(String title, String location, String skill);
}
