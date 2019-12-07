package com.ms.loan.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class LoanAuthListener {

	@KafkaListener(topics = "${kafka.topic}", groupId = "${kafka.groupId}")
	public void listen(String message) {
	    System.out.println("Received Messasge in group foo: " + message);
	}

}
