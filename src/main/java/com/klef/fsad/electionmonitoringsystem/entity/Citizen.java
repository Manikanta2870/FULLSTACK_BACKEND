package com.klef.fsad.electionmonitoringsystem.entity;

import com.fasterxml.jackson.annotation.JsonAlias;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "citizen_table")
public class Citizen 
{
    @Id
    @Column(length = 100)
    private String username;

    @JsonAlias({"aadhaarId", "AadhaarNumber"})
    @Column(name = "aadhaar_number", length = 50, nullable = false, unique = true)
    private String aadhaarNumber;

    @Column(length = 100, nullable = false)
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAadhaarNumber() {
        return aadhaarNumber;
    }

    public void setAadhaarNumber(String aadhaarNumber) {
        this.aadhaarNumber = aadhaarNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Citizen [username=" + username + ", AadhaarNumber=" + aadhaarNumber + "]";
    }
}