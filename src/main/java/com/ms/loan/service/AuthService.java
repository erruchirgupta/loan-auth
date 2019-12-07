package com.ms.loan.service;

import com.ms.loan.dto.AadharVaultRequest;
import com.ms.loan.dto.AadharVaultResponse;
import com.ms.loan.dto.CreditScoreRequest;
import com.ms.loan.dto.CreditScoreResponse;
import com.ms.loan.dto.PanStatusRequest;
import com.ms.loan.dto.PanStatusResponse;

public interface AuthService {

	public PanStatusResponse panStatusApi(PanStatusRequest request);
	
	public AadharVaultRequest aadharStatusApi(AadharVaultResponse request);
	
	public CreditScoreResponse creditScoreCheckApi(CreditScoreRequest request);
	
}
