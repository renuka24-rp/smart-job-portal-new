package com.renuka.smartjobportal.controller;

import com.renuka.smartjobportal.entity.Job;
import com.renuka.smartjobportal.repository.JobRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final JobRepository jobRepository;

    public HomeController(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @GetMapping("/")
    public String home(Model model) {

        List<Job> jobs = jobRepository.findAll();

        if (jobs.isEmpty()) {
            jobRepository.save(new Job(null,"Software Engineer","Accenture","Pune"));
            jobRepository.save(new Job(null,"Java Developer","TCS","Mumbai"));
            jobRepository.save(new Job(null,"Backend Developer","Infosys","Bangalore"));

            jobs = jobRepository.findAll();
        }

        model.addAttribute("jobs", jobs);
        return "index";
    }
}
