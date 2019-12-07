package com.ms.loan.controller;

import com.ms.loan.dto.GenericResponse;
import com.ms.loan.dto.LoanApplicationStatus;
import com.ms.loan.dto.LoanAuthResponse;
import com.ms.loan.dto.LoanType;

@RestController
@RequestMapping("/v1/app-agent")
@Slf4j
@SuppressWarnings("rawtypes")
public class ApplicationAgentController {
    @PostMapping(value = "/application-status", consumes="application/json", produces = "application/json; charset=UTF-8")
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
    }



    @GetMapping(value = "/fetchTask/{type}", consumes="application/json", produces = "application/json; charset=UTF-8")
    public ResponseEntity<GenericResponse> generateToken(@PathVariable LoanType type) {
        log.debug("LoanType : {}", type);
        try {
            return new ResponseEntity<GenericResponse>(
                    new GenericResponse<LoanAuthResponse>(true,
                            autoAssignService.callAutoAssignService(AutoAssignRequest)
                            , null), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<GenericResponse>(
                    new GenericResponse<String>(false, ExceptionUtils.getStackTrace(e)
                            , null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
