package com.ms.loan.controller;

import com.ms.loan.dto.*;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.loan.service.ApplicationAgentControllerService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/v1/app-agent")
@Slf4j
@SuppressWarnings("rawtypes")
public class ApplicationAgentController {
	
	@Autowired
	private ApplicationAgentControllerService controllerService;
	
    /*@PostMapping(value = "/application-status", consumes="application/json", produces = "application/json; charset=UTF-8")
    public ResponseEntity<GenericResponse> submit(@RequestBody LoanApplicationStatus request) {
        log.debug("LoanApplicationStatus : {}", request);
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
    }*/
    
    @GetMapping(value = "/fetchTask/{type}", produces = "application/json; charset=UTF-8")
    public ResponseEntity<GenericResponse> fetchTask(@PathVariable LoanType type) {
//        LoanType Ltype = LoanType.valueOf(type);
        log.info("LoanType Req : {}", type);
        try {
//            log.info("LoanType Res : {}", controllerService.callAutoAssignService(type));
            AutoAssignMapResp temp = controllerService.callAutoAssignService(type);
            if(temp.getId() == null) {
                temp = null;
            }
            return new ResponseEntity<GenericResponse>(
                    new GenericResponse<TaskResponse>(true,  new TaskResponse(temp), null), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<GenericResponse>(
                    new GenericResponse<String>(false, ExceptionUtils.getStackTrace(e)
                            , null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
