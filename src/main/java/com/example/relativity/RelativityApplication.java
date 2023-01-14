package com.example.relativity;

import com.microsoft.applicationinsights.attach.ApplicationInsights;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RelativityApplication {

	public static void main(String[] args) {
		ApplicationInsights.attach();
		SpringApplication.run(RelativityApplication.class, args);
	}

}
