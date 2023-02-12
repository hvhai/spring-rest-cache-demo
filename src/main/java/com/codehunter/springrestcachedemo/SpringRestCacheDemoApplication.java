package com.codehunter.springrestcachedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringRestCacheDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestCacheDemoApplication.class, args);
	}

}
