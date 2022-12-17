package com.tekcard.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.tekcard.*")
@EnableJpaRepositories("com.tekcard.dao")
@EntityScan("com.tekcard.entities")
public class AccountingApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountingApiApplication.class, args);
	}

}
