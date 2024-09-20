package com.example.location;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PushcodeGithub1Application {
	@Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
	public static void main(String[] args) {
		SpringApplication.run(PushcodeGithub1Application.class, args);
	}

}
