package com.ms.loan.service;

import com.ms.loan.beans.AadharVaultRequestDTO;
import com.ms.loan.beans.AadharVaultResponseDTO;
import com.ms.loan.beans.CreditScoreRequestDTO;
import com.ms.loan.beans.CreditScoreResponseDTO;
import com.ms.loan.beans.PanStatusRequestDTO;
import com.ms.loan.beans.PanStatusResponseDTO;

public interface AuthService {

	public PanStatusResponseDTO panStatusApi(PanStatusRequestDTO request);
	
	public AadharVaultRequestDTO aadharStatusApi(AadharVaultResponseDTO request);
	
	public CreditScoreResponseDTO creditScoreCheckApi(CreditScoreRequestDTO request);
	
}
