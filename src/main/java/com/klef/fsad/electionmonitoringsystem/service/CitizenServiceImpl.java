package com.klef.fsad.electionmonitoringsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.fsad.electionmonitoringsystem.entity.Citizen;
import com.klef.fsad.electionmonitoringsystem.repository.CitizenRepository;

@Service
public class CitizenServiceImpl implements CitizenService
{
    @Autowired
    private CitizenRepository citizenRepository;

    @Override
    public String registerCitizen(Citizen citizen) 
    {
        if(citizenRepository.findByUsername(citizen.getUsername()) != null)
        {
            return "Username already exists!";
        }

        if(citizenRepository.findByAadhaarNumber(citizen.getAadhaarNumber()) != null)
        {
            return "Aadhaar already registered!";
        }

        citizenRepository.save(citizen);
        return "Citizen Registered Successfully";
    }

    @Override
    public Citizen verifyCitizenLogin(String username, String password) 
    {
        return citizenRepository.findByUsernameAndPassword(username, password);
    }

    @Override
    public Citizen getCitizenByUsername(String username) 
    {
        return citizenRepository.findByUsername(username);
    }

    @Override
    public Citizen getCitizenByAadhaar(String aadhaarNumber) 
    {
        return citizenRepository.findByAadhaarNumber(aadhaarNumber);
    }
}