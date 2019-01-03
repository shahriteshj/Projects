package com.jp.hr.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.jp.hr.daos,com.jp.hr.services,com.jp.hr.controller")
@EntityScan("com.jp.hr.entities")
public class ApplStart {

	public static void main(String[] args) {
		SpringApplication.run(ApplStart.class, args);

	}

}
