package com.ms.loan.service;

import com.ms.loan.beans.AadharVaultRequestDTO;
import com.ms.loan.beans.AadharVaultResponseDTO;
import com.ms.loan.beans.CreditScoreRequestDTO;
import com.ms.loan.beans.CreditScoreResponseDTO;
import com.ms.loan.beans.PanStatusRequestDTO;
import com.ms.loan.beans.PanStatusResponseDTO;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {

	@POST("panStatus")
	Call<PanStatusResponseDTO> callPanStatusApi(@Body PanStatusRequestDTO request);
	
	@POST("aadharStatus")
	Call<AadharVaultRequestDTO> callAadharStatusApi(@Body AadharVaultResponseDTO request);
	
	@POST("creditScoreCheck")
	Call<CreditScoreResponseDTO> callCreditScoreCheckApi(@Body CreditScoreRequestDTO request);
	
}
