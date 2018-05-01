package com.hemoglobin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hemoglobin.entities.Assignment;
import com.hemoglobin.exceptions.AssignmentException;
import com.hemoglobin.service.AssignmentService;

@Controller
@RequestMapping(path = "assignments")
public class AssignmentController {

	@Autowired
	private AssignmentService assignmentService;

	@ResponseBody
	@RequestMapping(consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.POST)
	public Assignment search(@RequestBody Assignment assignment) {
		Assignment assignmentFromDB = null;
		System.out.println(assignment.toString());
		try {
			assignmentFromDB = assignmentService.create(assignment);
		} catch (AssignmentException e) {
			e.printStackTrace();
		}
		return assignmentFromDB;
	}
}
