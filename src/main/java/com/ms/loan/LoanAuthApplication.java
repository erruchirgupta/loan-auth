package com.ms.loan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
@ComponentScan({"com.ms.loan"})
public class LoanAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoanAuthApplication.class, args);

	}

}
