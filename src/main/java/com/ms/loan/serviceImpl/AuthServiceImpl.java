package com.ms.loan.serviceImpl;

import org.springframework.stereotype.Service;

import com.ms.loan.dto.AadharVaultRequest;
import com.ms.loan.dto.AadharVaultResponse;
import com.ms.loan.dto.CreditScoreRequest;
import com.ms.loan.dto.CreditScoreResponse;
import com.ms.loan.dto.PanStatusRequest;
import com.ms.loan.dto.PanStatusResponse;
import com.ms.loan.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

	@Override
	public PanStatusResponse panStatusApi(PanStatusRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AadharVaultRequest aadharStatusApi(AadharVaultResponse request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CreditScoreResponse creditScoreCheckApi(CreditScoreRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

}
