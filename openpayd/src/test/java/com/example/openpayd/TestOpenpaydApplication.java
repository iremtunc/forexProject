package com.example.openpayd;

import org.springframework.boot.SpringApplication;

public class TestOpenpaydApplication {

	public static void main(String[] args) {
		SpringApplication.from(OpenpaydApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
