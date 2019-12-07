package com.ms.loan.service;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.loan.dto.AutoAssignMapResp;
import com.ms.loan.dto.LoanType;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ApplicationAgentControllerService {

	@Autowired
	private ConcurrentHashMap<LoanType, AutoAssignMapResp> task;

	public AutoAssignMapResp callAutoAssignService(LoanType type) {
		AutoAssignMapResp loanApplication = task.get(type);
		task.put(type, AutoAssignMapResp.builder().id(null).type(null).params(null).build());
		System.out.println(loanApplication);
		return loanApplication;
	}

}
