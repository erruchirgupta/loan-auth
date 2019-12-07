package com.ms.loan.serviceImpl;

import org.springframework.stereotype.Service;

import com.ms.loan.beans.AadharVaultRequestDTO;
import com.ms.loan.beans.AadharVaultResponseDTO;
import com.ms.loan.beans.CreditScoreRequestDTO;
import com.ms.loan.beans.CreditScoreResponseDTO;
import com.ms.loan.beans.PanStatusRequestDTO;
import com.ms.loan.beans.PanStatusResponseDTO;
import com.ms.loan.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

	@Override
	public PanStatusResponseDTO panStatusApi(PanStatusRequestDTO request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AadharVaultRequestDTO aadharStatusApi(AadharVaultResponseDTO request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CreditScoreResponseDTO creditScoreCheckApi(CreditScoreRequestDTO request) {
		// TODO Auto-generated method stub
		return null;
	}

}
