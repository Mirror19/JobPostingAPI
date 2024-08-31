package com.example.jobpostingapi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JobPostingServiceTests {

    @Mock
    private JobPostingRepository jobPostingRepository;

    @InjectMocks
    private JobPostingService jobPostingService;

    @Test
    public void testCreateJobPosting() {
        JobPosting jobPosting = new JobPosting();
        jobPosting.setTitle("Software Developer");
        when(jobPostingRepository.save(jobPosting)).thenReturn(jobPosting);

        JobPosting result = jobPostingService.createJobPosting(jobPosting);
        assertEquals("Software Developer", result.getTitle());
    }

    // Add additional test methods here...
}
