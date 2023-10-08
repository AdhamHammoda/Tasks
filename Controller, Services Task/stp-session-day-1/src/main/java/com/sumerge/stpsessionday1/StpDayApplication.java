package com.sumerge.stpsessionday1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.sumerge"})
public class StpDayApplication {

	public static void main(String[] args) {
		SpringApplication.run(StpDayApplication.class, args);
	}

}
