package com.ms.loan;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.ms.loan.dto.LoanType;

@Configuration
@SpringBootApplication
@ComponentScan({"com.ms.loan"})
public class LoanAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoanAuthApplication.class, args);
	}
	
	@Bean
	public ConcurrentHashMap<LoanType, String> getTask() {
		return new ConcurrentHashMap<>();
	}

}
