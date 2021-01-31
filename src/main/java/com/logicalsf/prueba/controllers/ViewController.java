package com.logicalsf.prueba.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

	
	@GetMapping("/")
	public String viewClient() {
		return "index.html";
	}
	
	@GetMapping(value = "/**/{[path:[^\\.]*}")
    public String redirect() {
        return "forward:/";
    }
	
}
