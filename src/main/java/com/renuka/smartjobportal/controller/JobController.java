package com.renuka.smartjobportal.controller;

import com.renuka.smartjobportal.entity.Job;
import com.renuka.smartjobportal.repository.JobRepository;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public Job createJob(@RequestBody Job job) {
        return jobRepository.save(job);
    }
}
