package com.klef.fsad.electionmonitoringsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klef.fsad.electionmonitoringsystem.entity.DataAnalyst;

@Repository
public interface DataAnalystRepository extends JpaRepository<DataAnalyst, String>
{
    // Login using email and password
    DataAnalyst findByEmailAndPassword(String email, String password);
}