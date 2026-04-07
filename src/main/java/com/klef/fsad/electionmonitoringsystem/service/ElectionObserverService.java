package com.klef.fsad.electionmonitoringsystem.service;

import java.util.List;

import com.klef.fsad.electionmonitoringsystem.entity.ElectionObserver;

public interface ElectionObserverService
{
    String registerElectionObserver(ElectionObserver electionObserver);

    ElectionObserver verifyElectionObserverLogin(String email, String password);

    List<ElectionObserver> getAllElectionObservers();

    ElectionObserver getElectionObserverByEmail(String email);

    String deleteElectionObserver(String email);

    String assignStation(String email, String assignedStation);
}
