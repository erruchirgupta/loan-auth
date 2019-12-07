package com.ms.loan.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class CreditScoreResponse implements Serializable {
	
	private static final long serialVersionUID = 7452325638252252831L;
	
	private String custTitle;
	private String custName;
	private String creditScore;
	private Summary summaries;
    
    @JsonProperty("ErrorDesc")
    private String errorDesc;
    
    @JsonProperty("ErrorCode")
    private String errorCode;
	
}
