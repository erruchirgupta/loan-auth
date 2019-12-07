package com.ms.loan.service;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.loan.dto.LoanType;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ApplicationAgentControllerService {
	
	@Autowired
	private ConcurrentHashMap<LoanType, String> task;
	
	public String callAutoAssignService(LoanType type) {
		return task.get(type);
	}

}
