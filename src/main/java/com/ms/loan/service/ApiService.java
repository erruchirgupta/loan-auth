package com.ms.loan.service;

import com.ms.loan.dto.AadharVaultRequest;
import com.ms.loan.dto.AadharVaultResponse;
import com.ms.loan.dto.CreditScoreRequest;
import com.ms.loan.dto.CreditScoreResponse;
import com.ms.loan.dto.PanStatusRequest;
import com.ms.loan.dto.PanStatusResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {

	@POST("panStatus")
	Call<PanStatusResponse> callPanStatusApi(@Body PanStatusRequest request);
	
	@POST("aadharStatus")
	Call<AadharVaultRequest> callAadharStatusApi(@Body AadharVaultResponse request);
	
	@POST("creditScoreCheck")
	Call<CreditScoreResponse> callCreditScoreCheckApi(@Body CreditScoreRequest request);
	
}
