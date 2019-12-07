package com.ms.loan.service;

import com.ms.loan.dto.AutoAssignRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AutoAssignService {

	@POST("auto-assign")
	Call<String> callAutoAssignService(@Body AutoAssignRequest request);

}
