package com.jp.greeting.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class GreetingController {

	@Value("${config.greet.message}")
	private String greetTemplate;
	@GetMapping("/v1/greet/{name}")
	public String greet(@PathVariable String name) {
		return String.format(greetTemplate, name);
	}
}
