package com.example.jobpostingapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobPostingService {

    @Autowired
    private JobPostingRepository jobPostingRepository;

    public JobPosting createJobPosting(JobPosting jobPosting) {
        return jobPostingRepository.save(jobPosting);
    }

    public List<JobPosting> getAllJobPostings() {
        return jobPostingRepository.findAll();
    }

    public Optional<JobPosting> getJobPostingById(Long id) {
        return jobPostingRepository.findById(id);
    }

    public JobPosting updateJobPosting(Long id, JobPosting jobPostingDetails) {
        JobPosting jobPosting = jobPostingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job not found with id: " + id));

        jobPosting.setTitle(jobPostingDetails.getTitle());
        jobPosting.setDescription(jobPostingDetails.getDescription());
        jobPosting.setLocation(jobPostingDetails.getLocation());
        jobPosting.setCompany(jobPostingDetails.getCompany());
        jobPosting.setSalaryRange(jobPostingDetails.getSalaryRange());
        jobPosting.setRequiredSkills(jobPostingDetails.getRequiredSkills());
        jobPosting.setApplicationDeadline(jobPostingDetails.getApplicationDeadline());

        return jobPostingRepository.save(jobPosting);
    }

    public void deleteJobPosting(Long id) {
        JobPosting jobPosting = jobPostingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job not found with id: " + id));
        jobPostingRepository.delete(jobPosting);
    }
}
