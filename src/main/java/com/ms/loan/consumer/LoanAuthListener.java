package com.ms.loan.consumer;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ms.loan.dto.AutoAssignMapResp;
import com.ms.loan.dto.LoanType;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class LoanAuthListener {

	private static final String NULL = "NULL";

	@Autowired
	private ConcurrentHashMap<LoanType, AutoAssignMapResp> task;
	
	@Autowired
	private ObjectMapper jsonMapper;

	@KafkaListener(topics = "${kafka.homeloan}", groupId = "${kafka.groupId}")
	public void listenHomeLoan(String message) throws Exception {
		while (true) {
			try {
				task.entrySet().forEach(entry -> log.info(": {}", entry.getKey() + " " + entry.getValue()));
				if (task.get(LoanType.HOMELOAN) == null)
					Thread.sleep(10);
				else {
					log.info("Received Messasge for HOMELOAN: {}", message);
					task.put(LoanType.HOMELOAN, jsonMapper.readValue(message, new TypeReference<AutoAssignMapResp>(){}));
					break;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@KafkaListener(topics = "${kafka.carloan}", groupId = "${kafka.groupId}")
	public void listenCarLoan(String message) throws Exception {
		while (true) {
			try {
				if (task.get(LoanType.CARLOAN) == null)
					Thread.sleep(10);
				else {
					log.info("Received Messasge for CARLOAN: {}", message);
					task.put(LoanType.CARLOAN, jsonMapper.readValue(message, new TypeReference<AutoAssignMapResp>() {}));
					break;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@KafkaListener(topics = "${kafka.educationloan}", groupId = "${kafka.groupId}")
	public void listenEducationLoan(String message) throws Exception {
		while (true) {
			try {
				if (task.get(LoanType.EDUCATIONLOAN) == null)
					Thread.sleep(10);
				else{
					log.info("Received Messasge for EDUCATIONLOAN: {}", message);
					task.put(LoanType.EDUCATIONLOAN, jsonMapper.readValue(message, new TypeReference<AutoAssignMapResp>(){}));
					break;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
