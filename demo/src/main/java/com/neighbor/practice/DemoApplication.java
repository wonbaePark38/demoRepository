package com.neighbor.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.neighbor.practice.controller.ProcessController;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		//ProcessController controller = new ProcessController();
		//controller.startProcess();
	}

}
