package com.tekcard.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

//@ComponentScan("com.tekcard")
@SpringBootApplication(scanBasePackages = "com.tekcard")
@EnableJpaRepositories("com.tekcard.dao")
public class AccountingApiApplication {


	@Bean
	public DataSource getDataSource() {
		DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
		try (InputStream input = new FileInputStream("src/main/resources/application.properties")) {
			Properties prop = new Properties();
			prop.load(input);
			System.out.println(prop.getProperty("jdbc.url"));
			dataSourceBuilder.url(prop.getProperty("jdbc.url"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return dataSourceBuilder.build();
	}
	public static void main(String[] args) {
		SpringApplication.run(AccountingApiApplication.class, args);
	}

}
