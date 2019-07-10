package com.spring.shop.Musik;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@SpringBootApplication
@EntityScan(basePackages = {"com.spring.shop.Musik.model"})
public class MusikShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(MusikShopApplication.class, args);
	}
}
