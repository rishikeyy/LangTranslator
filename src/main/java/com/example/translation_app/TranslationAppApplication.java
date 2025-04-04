package com.example.translation_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class TranslationAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(TranslationAppApplication.class, args);
	}

}
