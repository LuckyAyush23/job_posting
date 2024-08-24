package org.crezam.job_posting.controller;


import org.crezam.*;
import org.crezam.job_posting.dto.JobPosting;
import org.crezam.job_posting.exceptionhandler.ResourceNotFoundException;
import org.crezam.job_posting.service.JobPostingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobpostings")
@Api(value = "JobPosting Management System", description = "Operations pertaining to job postings in Job Posting Management System")
public class JobPostingController {

    @Autowired
    private JobPostingService jobPostingService;

    @ApiOperation(value = "Create a new job posting")
   
    @PostMapping
    public ResponseEntity<JobPosting> createJobPosting(@RequestBody JobPosting jobPosting) {
        JobPosting newJobPosting = jobPostingService.createJobPosting(jobPosting);
        return ResponseEntity.status(HttpStatus.CREATED).body(newJobPosting);
    }

    @ApiOperation(value = "View a list of available job postings")
    @GetMapping
    public List<JobPosting> getAllJobPostings() {
        return jobPostingService.getAllJobPostings();
    }

    @ApiOperation(value = "Get a job posting by ID")
    @GetMapping("/{id}")
    public ResponseEntity<JobPosting> getJobPostingById(@PathVariable Long id) {
        JobPosting jobPosting = jobPostingService.getJobPostingById(id);
        return ResponseEntity.ok(jobPosting);
    }

    @ApiOperation(value = "Update a job posting by ID")
    @PutMapping("/{id}")
    public ResponseEntity<JobPosting> updateJobPosting(@PathVariable Long id, @RequestBody JobPosting jobPostingDetails) {
        JobPosting updatedJobPosting = jobPostingService.updateJobPosting(id, jobPostingDetails);
        return ResponseEntity.ok(updatedJobPosting);
    }

    @ApiOperation(value = "Delete a job posting by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJobPosting(@PathVariable Long id) {
        jobPostingService.deleteJobPosting(id);
        return ResponseEntity.noContent().build();
    }

    @ApiOperation(value = "Search for job postings by keyword")
    @GetMapping("/search")
    public List<JobPosting> searchJobPostings(@RequestParam String keyword) {
        return jobPostingService.searchJobPostings(keyword, keyword, keyword);
    }
}
