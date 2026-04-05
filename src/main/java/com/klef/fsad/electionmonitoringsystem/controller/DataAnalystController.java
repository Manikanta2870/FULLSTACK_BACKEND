package com.klef.fsad.electionmonitoringsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klef.fsad.electionmonitoringsystem.entity.DataAnalyst;
import com.klef.fsad.electionmonitoringsystem.service.DataAnalystService;

@RestController
@RequestMapping("/analystapi")
@CrossOrigin("*")
public class DataAnalystController {

	@Autowired
	private DataAnalystService dataAnalystService;

	@GetMapping("/")
	public String home() {
		return "Data Analyst API is running";
	}

	@PostMapping("/register")
	public ResponseEntity<?> registerDataAnalyst(@RequestBody DataAnalyst dataAnalyst) {
		try {
			if (dataAnalyst == null || dataAnalyst.getEmail() == null || dataAnalyst.getPassword() == null) {
				return ResponseEntity.badRequest().body("Email and password are required");
			}

			dataAnalyst.setEmail(dataAnalyst.getEmail().trim().toLowerCase());
			dataAnalyst.setPassword(dataAnalyst.getPassword().trim());

			String message = dataAnalystService.registerDataAnalyst(dataAnalyst);
			if ("Data analyst already exists".equals(message)) {
				return ResponseEntity.status(409).body(message);
			}

			return ResponseEntity.status(201).body(message);
		} catch (Exception e) {
			return ResponseEntity.status(500).body("Internal Server Error");
		}
	}

	@PostMapping("/login")
	public ResponseEntity<?> loginDataAnalyst(@RequestBody DataAnalyst dataAnalyst) {
		try {
			if (dataAnalyst == null || dataAnalyst.getEmail() == null || dataAnalyst.getPassword() == null) {
				return ResponseEntity.badRequest().body("Email and password are required");
			}

			String email = dataAnalyst.getEmail().trim().toLowerCase();
			String password = dataAnalyst.getPassword().trim();

			DataAnalyst authenticatedDataAnalyst = dataAnalystService.verifyDataAnalystLogin(email, password);
			if (authenticatedDataAnalyst == null) {
				return ResponseEntity.status(401).body("Invalid email or password");
			}

			return ResponseEntity.ok().body("Login successful");
		} catch (Exception e) {
			return ResponseEntity.status(500).body("Internal Server Error");
		}
	}


}
