package com.cnipr.dev.cl.japdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JapDemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(JapDemoApplication.class, args);
	}

	private TestService testService;

	@Autowired
	public void setTestService(TestService testService) {
		this.testService = testService;
	}

	@Override
	public void run(String... args) throws Exception {
		testService.test();
	}
}
