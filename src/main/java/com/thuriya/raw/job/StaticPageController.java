package com.thuriya.raw.job;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StaticPageController {

	@GetMapping("/job-listings")
	public String jobListings() {
		return "job-listings.html";
	}
}