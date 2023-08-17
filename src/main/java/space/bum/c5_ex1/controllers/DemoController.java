package space.bum.c5_ex1.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
	@GetMapping("/demo")
	String demo() {
		return "시범!";
	}
	
	@GetMapping("/memo")
	String memo() {
		return "메모!";
	}

}
