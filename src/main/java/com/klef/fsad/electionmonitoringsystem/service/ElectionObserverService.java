package com.klef.fsad.electionmonitoringsystem.service;

import com.klef.fsad.electionmonitoringsystem.entity.ElectionObserver;

public interface ElectionObserverService {
	String registerElectionObserver(ElectionObserver electionObserver);

	ElectionObserver verifyElectionObserverLogin(String email, String password);

}
