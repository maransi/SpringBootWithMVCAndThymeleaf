package com.msilva.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.msilva.model.Greeting;

@Controller
public class GreetingController {

//  @GetMapping("/greeting")
//  public String greetingForm(Model model) {
//    model.addAttribute("greeting", new Greeting());
//    return "greeting";
//  }

	@PostMapping("/greeting")
	public String greeting(@RequestParam(name = "content", required = false, defaultValue = "World") String content,
							@RequestParam(name= "id", required = true, defaultValue = "0" ) Long id,
			Model model) {
		
		Greeting greeting = new Greeting();
		
		greeting.setContent(content);
		greeting.setId(id);
		
		model.addAttribute("greeting", greeting);
		return "result";
	}

	@GetMapping("/greeting")
	public String greetingSubmit(Greeting greeting) {
		return "greeting";
	}

}