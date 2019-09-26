package com.springboot.ninja;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringBootNinjaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootNinjaApplication.class, args);
	}

}
