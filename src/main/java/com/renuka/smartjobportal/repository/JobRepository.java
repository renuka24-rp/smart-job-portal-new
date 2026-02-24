package com.renuka.smartjobportal.repository;

import com.renuka.smartjobportal.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
}
