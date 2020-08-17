package com.wlazrad.springjwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({LiquibaseProperties.class})
public class SpringBootEngCardApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootEngCardApplication.class, args);
	}

}
