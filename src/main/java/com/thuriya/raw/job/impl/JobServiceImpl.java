package com.thuriya.raw.job.impl;

import com.thuriya.raw.job.Job;
import com.thuriya.raw.job.JobRepository;
import com.thuriya.raw.job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {
//	private List<Job> jobs = new ArrayList<>();
	JobRepository jobRepository;
	private long nextId = 1L;

	public JobServiceImpl(JobRepository jobRepository) {
		this.jobRepository = jobRepository;
	}

	@Override

	public List<Job> findAll() {
		return jobRepository.findAll();
	}

	@Override
	public void createJob(Job job) {
		job.setId(nextId++);
		jobRepository.save(job);
	}


	@Override
	public Job getJobById(Long id){
		return jobRepository.findById(id).orElse(null);
	}

	@Override
	public boolean deleteJobById(Long id) {
	try {
		jobRepository.deleteById(id);
		return true;
	} catch (Exception e){
		return false;
	}
	}

	@Override
	public boolean updateJob(Long id, Job updatedJob) {
		Optional<Job> jobOptional = jobRepository.findById(id);
		if (jobOptional.isPresent()) {
			Job job = jobOptional.get();
			job.setTitle(updatedJob.getTitle());
			job.setDescription(updatedJob.getDescription());
			job.setMaxSalary(updatedJob.getMaxSalary());
			job.setMinSalary(updatedJob.getMinSalary());
			job.setLocation(updatedJob.getLocation());
			jobRepository.save(job); // Persist the updated job
			return true;
		}
		return false;
	}
	}

