package com.thuriya.raw.job;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity <List<Job>> findAll()
	{
		return new ResponseEntity<>(jobService.findAll(), HttpStatus.OK);
	}

	@PostMapping(path = "/jobs")
	public ResponseEntity<String> createJob(@RequestBody Job job) {
		jobService.createJob(job);
		return new ResponseEntity<>("Job added successfully" ,HttpStatus.OK );
	}
	@GetMapping("/jobs/{id}")
	public ResponseEntity<Job> getJobById(@PathVariable Long id){
		Job job = jobService.getJobById(id);
		if (job != null){
			return new ResponseEntity<>(job , HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	@DeleteMapping("jobs/{id}")
	public ResponseEntity<String> deleteJob(@PathVariable Long id){
		boolean deleted = jobService.deleteJobById(id);
		if (deleted){
			return new ResponseEntity<> ("Job deleted successfully" , HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}