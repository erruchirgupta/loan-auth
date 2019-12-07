package com.ms.loan.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
@Builder
@JsonInclude(Include.NON_NULL)
public class GenericResponse<T> implements Serializable {
	
	private static final long serialVersionUID = -5248750778374765445L;
	
	private boolean result;
	private T data;
	private String reason;
	
}
