package com.generation.blogpessoal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.generation.blogpessoal.repository") 
@EntityScan("com.generation.blogpessoal.model")  
@ComponentScan("com.generation.blogpessoal")
public class BlogpessoalApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogpessoalApplication.class, args);
	}

}