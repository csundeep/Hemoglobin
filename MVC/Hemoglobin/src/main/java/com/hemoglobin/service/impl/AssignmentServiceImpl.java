package com.hemoglobin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hemoglobin.entities.Assignment;
import com.hemoglobin.exceptions.AssignmentException;
import com.hemoglobin.respository.AssignmentRepository;
import com.hemoglobin.service.AssignmentService;

@Service
public class AssignmentServiceImpl implements AssignmentService {

	@Autowired
	private AssignmentRepository repository;

	public List<Assignment> findAll() throws AssignmentException {
		List<Assignment> assignments = repository.findAll();
		if (assignments != null && assignments.size() > 0)
			return assignments;
		else
			throw new AssignmentException("No Assignments found ");
	}

	public Assignment findById(int id) throws AssignmentException {
		Assignment assignment = repository.findById(id);
		if (assignment == null) {
			throw new AssignmentException("Assignment with id:" + id + " not found");
		}
		return assignment;
	}

	@Transactional
	public Assignment create(Assignment assignment) throws AssignmentException {
		Assignment assignmentInDB = repository.create(assignment);
		if (assignmentInDB == null) {
			throw new AssignmentException("Unable to create assignment");
		}
		return assignmentInDB;
	}

	@Transactional
	public Assignment update(int id, Assignment state) throws AssignmentException {
		Assignment assignmentInDB = repository.findById(id);
		if (assignmentInDB == null) {
			throw new AssignmentException("Assignment with id:" + id + " not found");
		}
		return repository.update(state);
	}

	@Transactional
	public void delete(int id) throws AssignmentException {
		Assignment assignmentInDB = repository.findById(id);
		if (assignmentInDB == null) {
			throw new AssignmentException("Assignment with id:" + id + " not found");
		}
		repository.delete(assignmentInDB);
	}

}
