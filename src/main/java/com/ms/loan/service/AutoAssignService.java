package com.ms.loan.service;

import org.springframework.scheduling.annotation.Async;

import com.ms.loan.dto.AutoAssignApiResponse;
import com.ms.loan.dto.AutoAssignRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AutoAssignService {

	//@Async
	@POST("auto-assign")
	Call<AutoAssignApiResponse> callAutoAssignService(@Body AutoAssignRequest request);

}
