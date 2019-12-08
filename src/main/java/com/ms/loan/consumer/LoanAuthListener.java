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
		log.debug("Received Messasge for HOMELOAN: {}", message);
		while (true) {
			try {
				if (Optional.ofNullable(task.get(LoanType.HOMELOAN).getId()).isPresent())
					Thread.sleep(10);
				else {
					task.put(LoanType.HOMELOAN, jsonMapper.readValue(message, new TypeReference<AutoAssignMapResp>(){}));
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@KafkaListener(topics = "${kafka.carloan}", groupId = "${kafka.groupId}")
	public void listenCarLoan(String message) throws Exception {
		log.debug("Received Messasge for CARLOAN: {}", message);
		while (true) {
			try {
				if (Optional.ofNullable(task.get(LoanType.CARLOAN).getId()).isPresent())
					Thread.sleep(10);
				else
					task.put(LoanType.CARLOAN, jsonMapper.readValue(message, new TypeReference<AutoAssignMapResp>(){}));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@KafkaListener(topics = "${kafka.educationloan}", groupId = "${kafka.groupId}")
	public void listenEducationLoan(String message) throws Exception {
		log.debug("Received Messasge for CARLOAN: {}", message);
		while (true) {
			try {
				if (Optional.ofNullable(task.get(LoanType.EDUCATIONLOAN).getId()).isPresent())
					Thread.sleep(10);
				else
					task.put(LoanType.EDUCATIONLOAN, jsonMapper.readValue(message, new TypeReference<AutoAssignMapResp>(){}));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
