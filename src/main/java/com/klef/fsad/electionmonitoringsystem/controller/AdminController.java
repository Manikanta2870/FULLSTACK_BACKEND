package com.klef.fsad.electionmonitoringsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.klef.fsad.electionmonitoringsystem.entity.Admin;
import com.klef.fsad.electionmonitoringsystem.service.AdminService;

@RestController
@RequestMapping("/adminapi")
@CrossOrigin("*")
public class AdminController 
{
    @Autowired
    private AdminService adminService;

    @GetMapping("/")
    public String home() 
    {
        return "Backend is running";
    }

 // AdminController.java
    @PostMapping("/register")
    public ResponseEntity<?> registerAdmin(@RequestBody Admin admin) {
       try {
          if (admin == null || admin.getEmail() == null || admin.getPassword() == null) {
             return ResponseEntity.badRequest().body("Email and password are required");
          }

          admin.setEmail(admin.getEmail().trim().toLowerCase());
          admin.setPassword(admin.getPassword().trim());

          String message = adminService.registerAdmin(admin);
          if ("Admin already exists".equals(message)) {
             return ResponseEntity.status(409).body(message);
          }
          return ResponseEntity.status(201).body(message);
       } catch (Exception e) {
          return ResponseEntity.status(500).body("Internal Server Error");
       }
    }
}