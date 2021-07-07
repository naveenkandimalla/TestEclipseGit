package com.sais.cashoffice.CashOfficeTest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(scanBasePackages = "com.sais.cashoffice")
public class CashOfficeTestApplication {

	private static final Logger LOGGER = LogManager.getLogger(CashOfficeTestApplication.class);

	public static void main(String[] args) {
		// testing reset 
		SpringApplication.run(CashOfficeTestApplication.class, args);		
	}
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}