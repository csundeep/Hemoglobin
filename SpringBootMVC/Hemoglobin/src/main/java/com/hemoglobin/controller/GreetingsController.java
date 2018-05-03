package com.hemoglobin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GreetingsController {

	@RequestMapping(value = "/greeting", method = RequestMethod.GET)
	public ModelAndView greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name) {
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("name", name);
		modelAndView.setViewName("greeting");
		return modelAndView;
	}

}