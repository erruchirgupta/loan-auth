package com.ms.loan.controller;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.loan.dto.GenericResponse;
import com.ms.loan.dto.LoanAuthRequest;
import com.ms.loan.dto.LoanAuthResponse;
import com.ms.loan.service.LoanAuthControllerService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/v1")
@Slf4j
@SuppressWarnings("rawtypes")
public class LoanAuthController {
	
	@Autowired
	private LoanAuthControllerService controllerService;

	@PostMapping(value = "/submit", consumes="application/json", produces = "application/json; charset=UTF-8")
	public ResponseEntity<GenericResponse> submit(@RequestBody LoanAuthRequest request) {
		log.debug("LoanAuthRequest : {}", request);
		try {
			return new ResponseEntity<GenericResponse>(
					new GenericResponse<LoanAuthResponse>(true, 
							controllerService.processApplication(request)
								, null), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<GenericResponse>(
					new GenericResponse<String>(false, ExceptionUtils.getStackTrace(e)
								, null), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
