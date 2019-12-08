package com.ms.loan.service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.loan.dto.AutoAssignRequest;
import com.ms.loan.dto.LoanAuthRequest;
import com.ms.loan.dto.LoanAuthResponse;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class LoanAuthControllerService {
	
	@Autowired
	private AutoAssignService autoAssignService;
	
	public LoanAuthResponse processApplication(LoanAuthRequest request) {
		Integer num = Integer.parseInt(""+request.getDob().charAt(request.getDob().length()-1));
		if(num % 2 != 0) {
			setResponseAndProcess(request);
			return new LoanAuthResponse(request.getType(), "NO", null, "00");
		}
		return new LoanAuthResponse(request.getType(), "YES", null, "00");
	}

	private void setResponseAndProcess(LoanAuthRequest request) {
		Map<String, String> params = new HashMap<String, String>();
		try {
			params.put("aadharNumber", request.getAadharNumber());
			params.put("custTitle", request.getCustTitle());
			params.put("custName", request.getCustName());
			params.put("dob", request.getDob());
			params.put("pannumber", request.getPannumber());
			params.put("type", request.getType().toString());
			
			AutoAssignRequest
			.builder()
			.id(UUID.randomUUID().toString())
			.params(params)
			.build();
			autoAssignService.callAutoAssignService(AutoAssignRequest
					.builder()
					.id(UUID.randomUUID().toString())
					.params(params)
					.build());
		} catch (Exception e) {
			log.error("Unknown Exception : ", e);
		}
		
	}
}
