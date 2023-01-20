package isa.project.blood.transfusion.system.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/test")
public class TestController {
	
	@GetMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

}
