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

    @GetMapping("/")
public String viewHomePage(Model model) {
    model.addAttribute("jobs", jobRepository.findAll());
    return "index";
}

   @PostMapping("/apply")
public String applyJob(@RequestParam Long jobId) {
    System.out.println("Applied for job ID: " + jobId);
    return "redirect:/?success";
}
}
