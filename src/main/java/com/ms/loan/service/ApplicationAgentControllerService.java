package com.ms.loan.service;

import java.util.Arrays;
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
		log.info("testt : {}", task);
		task.entrySet().forEach(entry -> log.info(": {}", entry.getKey() + " " + entry.getValue()));
//				.stream().forEach(x -> System.out.println(x + " " + task.get(x)));
		AutoAssignMapResp loanApplication = task.get(type);
		log.info("check : {}", loanApplication);
		task.put(type, null);
		System.out.println(loanApplication);
		return loanApplication;
	}

}
