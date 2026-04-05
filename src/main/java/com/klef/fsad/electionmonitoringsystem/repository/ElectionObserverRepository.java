package com.klef.fsad.electionmonitoringsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klef.fsad.electionmonitoringsystem.entity.ElectionObserver;

@Repository
public interface ElectionObserverRepository extends JpaRepository<ElectionObserver, String>
{
    // Login using email and password
    ElectionObserver findByEmailAndPassword(String email, String password);
}