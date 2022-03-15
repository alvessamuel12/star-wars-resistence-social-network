package com.projectgroup.projectv1;

import com.projectgroup.projectv1.model.DBRebel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Projectv1Application {
	public static DBRebel dbRebel = new DBRebel();
	public static void main(String[] args) {
		SpringApplication.run(Projectv1Application.class, args);
	}

}
