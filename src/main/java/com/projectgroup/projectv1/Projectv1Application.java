package com.projectgroup.projectv1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class Projectv1Application {

	public static void main(String[] args) {
		SpringApplication.run(Projectv1Application.class, args);
	}

}
