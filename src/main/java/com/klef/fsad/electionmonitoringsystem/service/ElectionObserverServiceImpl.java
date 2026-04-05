package com.klef.fsad.electionmonitoringsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.fsad.electionmonitoringsystem.entity.ElectionObserver;
import com.klef.fsad.electionmonitoringsystem.repository.ElectionObserverRepository;

@Service
public class ElectionObserverServiceImpl implements ElectionObserverService
{
	@Autowired
	private ElectionObserverRepository electionObserverRepository;

	@Override
	public String registerElectionObserver(ElectionObserver electionObserver)
	{
		if (electionObserverRepository.existsById(electionObserver.getEmail()))
		{
			return "Election observer already exists";
		}

		electionObserverRepository.save(electionObserver);
		return "Election observer registered successfully";
	}

	@Override
	public ElectionObserver verifyElectionObserverLogin(String email, String password)
	{
		return electionObserverRepository.findByEmailAndPassword(email, password);
	}

}
