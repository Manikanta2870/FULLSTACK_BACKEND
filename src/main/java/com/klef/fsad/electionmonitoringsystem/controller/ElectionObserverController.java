package com.klef.fsad.electionmonitoringsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klef.fsad.electionmonitoringsystem.entity.ElectionObserver;
import com.klef.fsad.electionmonitoringsystem.service.ElectionObserverService;

@RestController
@RequestMapping("/observerapi")
@CrossOrigin("*")
public class ElectionObserverController {

	@Autowired
	private ElectionObserverService electionObserverService;

	@GetMapping("/")
	public String home() {
		return "Election Observer API is running";
	}

	@PostMapping("/register")
	public ResponseEntity<?> registerElectionObserver(@RequestBody ElectionObserver electionObserver) {
		try {
			if (electionObserver == null || electionObserver.getEmail() == null || electionObserver.getPassword() == null) {
				return ResponseEntity.badRequest().body("Email and password are required");
			}

			electionObserver.setEmail(electionObserver.getEmail().trim().toLowerCase());
			electionObserver.setPassword(electionObserver.getPassword().trim());

			String message = electionObserverService.registerElectionObserver(electionObserver);
			if ("Election observer already exists".equals(message)) {
				return ResponseEntity.status(409).body(message);
			}

			return ResponseEntity.status(201).body(message);
		} catch (Exception e) {
			return ResponseEntity.status(500).body("Internal Server Error");
		}
	}

	@PostMapping("/login")
	public ResponseEntity<?> loginElectionObserver(@RequestBody ElectionObserver electionObserver) {
		try {
			if (electionObserver == null || electionObserver.getEmail() == null || electionObserver.getPassword() == null) {
				return ResponseEntity.badRequest().body("Email and password are required");
			}

			String email = electionObserver.getEmail().trim().toLowerCase();
			String password = electionObserver.getPassword().trim();

			ElectionObserver authenticatedElectionObserver = electionObserverService.verifyElectionObserverLogin(email, password);
			if (authenticatedElectionObserver == null) {
				return ResponseEntity.status(401).body("Invalid email or password");
			}

			return ResponseEntity.ok().body("Login successful");
		} catch (Exception e) {
			return ResponseEntity.status(500).body("Internal Server Error");
		}
	}

}
