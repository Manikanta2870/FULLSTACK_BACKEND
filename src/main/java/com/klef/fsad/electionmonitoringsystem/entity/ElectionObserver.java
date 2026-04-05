package com.klef.fsad.electionmonitoringsystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "electionobserver_table")
public class ElectionObserver 
{
    @Id
    @Column(length = 100)
    private String email;

    @Column(length = 50, nullable = false)
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "ElectionObserver [email=" + email + ", password=" + password + "]";
    }
}