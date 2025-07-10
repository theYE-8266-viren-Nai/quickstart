package com.thuriya.raw;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestingController {
	@GetMapping(path = "/testing")
	public String testing() {
		return "testing";
	}
}
