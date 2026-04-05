package com.klef.fsad.electionmonitoringsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.fsad.electionmonitoringsystem.entity.DataAnalyst;
import com.klef.fsad.electionmonitoringsystem.repository.DataAnalystRepository;

@Service
public class DataAnalystServiceImpl implements DataAnalystService {

	@Autowired
	private DataAnalystRepository dataAnalystRepository;

	@Override
	public String registerDataAnalyst(DataAnalyst dataAnalyst) {
		if (dataAnalystRepository.existsById(dataAnalyst.getEmail())) {
			return "Data analyst already exists";
		}

		dataAnalystRepository.save(dataAnalyst);
		return "Data analyst registered successfully";
	}

	@Override
	public DataAnalyst verifyDataAnalystLogin(String email, String password) {
		return dataAnalystRepository.findByEmailAndPassword(email, password);
	}

}
