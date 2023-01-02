package com.taorusb.awsauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
//@ComponentScan({"com.taorusb*"})
public class AwsAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(AwsAuthApplication.class, args);
	}

}
