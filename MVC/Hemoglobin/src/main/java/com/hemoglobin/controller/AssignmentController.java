package com.hemoglobin.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hemoglobin.entities.Assignment;

@Controller
@RequestMapping(path="assignments")
public class AssignmentController {

	
	@ResponseBody
	@RequestMapping(consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.POST)
	public Assignment search(@RequestBody Assignment assignment) {
		System.out.println(assignment.toString());
		return assignment;
	}
}
