package com.wlazrad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.time.ZoneId;
import java.util.TimeZone;

@SpringBootApplication
@EnableConfigurationProperties({LiquibaseProperties.class})
public class SpringBootEngCardApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootEngCardApplication.class, args);
		TimeZone.setDefault(TimeZone.getTimeZone(ZoneId.of("Europe/Warsaw")));
	}
}
