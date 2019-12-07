package com.ms.loan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.loan.dto.LoanAuthRequest;
import com.ms.loan.dto.LoanAuthResponse;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class LoanAuthControllerService {
	
	@Autowired
	private AutoAssignService autoAssignService;
	
	public LoanAuthResponse processApplication(LoanAuthRequest request) {
		return new LoanAuthResponse(request.getType(), "YES", null, "00");
	}
}
