package com.example.jobpostingapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/jobpostings")
public class JobPostingController {

    @Autowired
    private JobPostingService jobPostingService;

    @PostMapping
    public ResponseEntity<JobPosting> createJobPosting(@RequestBody JobPosting jobPosting) {
        return ResponseEntity.ok(jobPostingService.createJobPosting(jobPosting));
    }

    @GetMapping
    public ResponseEntity<List<JobPosting>> getAllJobPostings() {
        return ResponseEntity.ok(jobPostingService.getAllJobPostings());
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobPosting> getJobPostingById(@PathVariable Long id) {
        return jobPostingService.getJobPostingById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<JobPosting> updateJobPosting(@PathVariable Long id, @RequestBody JobPosting jobPosting) {
        return ResponseEntity.ok(jobPostingService.updateJobPosting(id, jobPosting));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJobPosting(@PathVariable Long id) {
        jobPostingService.deleteJobPosting(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<JobPosting>> searchJobPostings(@RequestParam String keyword) {
        List<JobPosting> results = jobPostingService.getAllJobPostings()
                .stream()
                .filter(job -> job.getTitle().contains(keyword) ||
                        job.getLocation().contains(keyword) ||
                        job.getRequiredSkills().contains(keyword))
                .collect(Collectors.toList());
        return ResponseEntity.ok(results);
    }
}
