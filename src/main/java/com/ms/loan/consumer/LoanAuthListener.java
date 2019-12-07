package com.ms.loan.consumer;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.ms.loan.dto.LoanType;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class LoanAuthListener {

	@Autowired
	private ConcurrentHashMap<LoanType, String> task;

	@KafkaListener(topics = "${kafka.homeloan}", groupId = "${kafka.groupId}")
	public void listenHomeLoan(String message) {
		log.debug("Received Messasge for HOMELOAN: {}", message);
		while (true) {
			try {
				if (Optional.ofNullable(task.get(LoanType.HOMELOAN)).isPresent())
					Thread.sleep(10);
				else
					task.put(LoanType.HOMELOAN, message);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@KafkaListener(topics = "${kafka.carloan}", groupId = "${kafka.groupId}")
	public void listenCarLoan(String message) {
		log.debug("Received Messasge for CARLOAN: {}", message);
		while (true) {
			try {
				if (Optional.ofNullable(task.get(LoanType.CARLOAN)).isPresent())
					Thread.sleep(10);
				else
					task.put(LoanType.CARLOAN, message);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@KafkaListener(topics = "${kafka.educationloan}", groupId = "${kafka.groupId}")
	public void listenEducationLoan(String message) {
		log.debug("Received Messasge for EDUCATIONLOAN: {}", message);
		while (true) {
			try {
				if (Optional.ofNullable(task.get(LoanType.EDUCATIONLOAN)).isPresent())
					Thread.sleep(10);
				else
					task.put(LoanType.EDUCATIONLOAN, message);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
