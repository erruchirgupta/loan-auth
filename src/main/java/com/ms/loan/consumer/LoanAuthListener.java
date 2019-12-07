package com.ms.loan.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class LoanAuthListener {

	@KafkaListener(topics = "${kafka.homeloan}", groupId = "${kafka.groupId}")
	public void listen(String message) {
	    System.out.println("Received Messasge in group foo: " + message);
	}

	@KafkaListener(topics = "${kafka.carloan}", groupId = "${kafka.groupId}")
	public void listen(String message) {
		System.out.println("Received Messasge in group foo: " + message);
	}

	@KafkaListener(topics = "${kafka.educationloan}", groupId = "${kafka.groupId}")
	public void listen(String message) {
		System.out.println("Received Messasge in group foo: " + message);
	}
}
