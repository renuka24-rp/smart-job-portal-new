package com.renuka.smartjobportal.controller;

import com.renuka.smartjobportal.entity.Job;
import com.renuka.smartjobportal.repository.JobRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import org.springframework.ui.Model;

@RestController
@RequestMapping("/api/jobs")
@CrossOrigin("*")
public class JobController {

    private final JobRepository jobRepository;

    public JobController(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

   @GetMapping("/admin")
public String adminPage() {
    return "admin";
}

@PostMapping("/admin/add")
public String addJob(@RequestParam String title,
                     @RequestParam String company,
                     @RequestParam String location) {

    Job job = new Job();
    job.setTitle(title);
    job.setCompany(company);
    job.setLocation(location);

    jobRepository.save(job);

    return "redirect:/";
}

   @PostMapping("/apply")
public String applyJob(@RequestParam Long jobId) {
    System.out.println("Applied for job ID: " + jobId);
    return "redirect:/?success";
}
}
