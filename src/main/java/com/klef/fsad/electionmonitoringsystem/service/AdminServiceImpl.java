package com.klef.fsad.electionmonitoringsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.fsad.electionmonitoringsystem.entity.Admin;
import com.klef.fsad.electionmonitoringsystem.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService
{
    @Autowired
    private AdminRepository adminRepository;

    @Override
    public String registerAdmin(Admin admin) 
    {
        if (adminRepository.existsById(admin.getEmail())) 
        {
            return "Admin already exists";
        }
        adminRepository.save(admin);
        return "Admin registered successfully";
    }

    // ✅ ADD THIS METHOD (THIS FIXES YOUR ERROR)
    @Override
    public Admin verifyAdminLogin(String email, String password) 
    {
        return adminRepository.findByEmailAndPassword(email, password);
    }
}