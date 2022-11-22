package com.example.demo;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/user/{userId}")
	public String getEmailsFormGetAPI(@PathVariable String userId){
		HttpHeaders headers = new HttpHeaders();
		headers.add("user-agent", "Application");
		HttpEntity<String> entity = new HttpEntity<>(headers);
		Response response = restTemplate.exchange("https://reqres.in/api/users/"+userId, HttpMethod.GET, entity, Response.class).getBody();
		return response.getData().getEmail();
	}

}
