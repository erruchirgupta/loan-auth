package com.ms.loan.service;

import com.ms.loan.beans.AutoAssignRequestDTO;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AutoAssignService {

	@POST("auto-assign")
	Call<String> callAutoAssignService(@Body AutoAssignRequestDTO request);

}
