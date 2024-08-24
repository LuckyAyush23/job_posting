package org.crezam.job_posting.service;

import java.util.List;

import org.crezam.job_posting.dto.JobPosting;
import org.crezam.job_posting.repository.JobPostingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobPostingService {
    @Autowired
    private JobPostingRepository jobPostingRepository;
    
    public List<JobPosting> searchJobPostings(String title, String location, String skills) {
        return jobPostingRepository.findByTitleContainingOrLocationContainingOrRequiredSkillsContaining(title, location, skills);
    }
    
    public JobPosting createJobPosting(JobPosting jobPosting) {
        return jobPostingRepository.save(jobPosting);
    }
    
    public JobPosting getJobPostingById(Long id) {
        return jobPostingRepository.findById(id).orElseThrow();
    }
    public List<JobPosting> getAllJobPostings() {
        return jobPostingRepository.findAll();
    }
    
    public JobPosting updateJobPosting(Long id, JobPosting jobPosting) {
        JobPosting existingJobPosting = getJobPostingById(id);
        existingJobPosting.setTitle(jobPosting.getTitle());
        existingJobPosting.setDescription(jobPosting.getDescription());
        // update other fields
        return jobPostingRepository.save(existingJobPosting);
    }
    
    public void deleteJobPosting(Long id) {
        jobPostingRepository.deleteById(id);
    }

	
}
