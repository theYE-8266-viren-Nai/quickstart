package com.thuriya.raw.job;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class JobController {
	public JobController(JobService jobService) {
		this.jobService = jobService;
	}

	private  JobService jobService;	
	@GetMapping(path = "/jobs")
	public List<Job> findAll() {
		return jobService.findAll();
	}

	@PostMapping(path = "/jobs")
	public String createJob(@RequestBody Job job) {
		jobService.createJob(job);
		return "Job added successfully";
	}
	@GetMapping("/jobs/{id}")
	public Job getJobById(@PathVariable Long id){
		Job job = jobService.getJobById(id);
		return job;
	}

}