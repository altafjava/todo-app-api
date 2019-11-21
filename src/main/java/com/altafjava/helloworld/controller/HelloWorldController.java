package com.altafjava.helloworld.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.altafjava.helloworld.dto.HelloWorldBean;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class HelloWorldController {

	@GetMapping("/hello-world")
	public String helloWorld() {
		return "Welcome to Spring Boot API";
	}

	@GetMapping("/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World Bean");
	}

	@GetMapping("/hello-world-path-variable/{param}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String param) {
		return new HelloWorldBean("Hello World Path Variable Output=" + param);
	}

	@GetMapping("/err")
	public String error() {
		throw new RuntimeException("Something went wrong");
	}
}
