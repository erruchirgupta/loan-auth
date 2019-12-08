package com.ms.loan.service;

import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang3.RandomStringUtils;
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
		Map<String, String> params = new HashMap<String, String>();

			params.put("aadharNumber", "987790778512");
			params.put("custTitle", "Mr");
			params.put("custName",  RandomStringUtils.random(5, true, false));
			params.put("dob", "22-01-20");
			params.put("pannumber", RandomStringUtils.random(10, false, true));
			params.put("type", type.toString());
		task.put(type, AutoAssignMapResp.builder()
		.id(UUID.randomUUID().toString())
		.type(type.toString())
		.params(params)
				.build());
		task.entrySet().forEach(entry -> log.info(": {}", entry.getKey() + " " + entry.getValue()));
//				.stream().forEach(x -> System.out.println(x + " " + task.get(x)));
		AutoAssignMapResp loanApplication = task.get(type);
		log.info("check : {}", loanApplication);
		System.out.println(loanApplication);
		return loanApplication;
	}

}
