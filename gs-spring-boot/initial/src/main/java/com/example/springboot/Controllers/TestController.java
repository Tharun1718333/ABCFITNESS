package com.example.springboot.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@GetMapping("/")
	public String index() {
		return "Greetings from ABC Fitness project by Tharun, if you are seeeing this the server is probably working fine";
	}

}
