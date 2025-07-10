package com.thuriya.raw.job;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class JobController {
	private List<Job> jobs = new ArrayList<>();

	@GetMapping(path = "/jobs")
	public List<Job> findAll() {
		return jobs;
	}

	@PostMapping(path = "/jobs")
	public String createJob(@RequestBody Job job) {
		jobs.add(job);
		return "Job added successfully";
	}
}