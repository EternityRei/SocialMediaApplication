package com.socialmedia.pub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.socialmedia.pub.mapper")
public class PubApplication {

	public static void main(String[] args) {
		SpringApplication.run(PubApplication.class, args);
	}

}
