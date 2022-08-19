package com.example.demo;

import com.example.demo.repository.DemoRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

//	@Bean
//	public DemoRepository init (){
//		DemoRepository demoRepository = new DemoRepository() {
//		};
//		return demoRepository;
//	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
