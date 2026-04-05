package com.klef.fsad.electionmonitoringsystem.service;

import com.klef.fsad.electionmonitoringsystem.entity.DataAnalyst;

public interface DataAnalystService {
	String registerDataAnalyst(DataAnalyst dataAnalyst);

	DataAnalyst verifyDataAnalystLogin(String email, String password);

}
