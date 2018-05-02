package com.hemoglobin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hemoglobin.entities.Assignment;
import com.hemoglobin.entities.BloodRequest;
import com.hemoglobin.entities.Status;
import com.hemoglobin.exceptions.AssignmentException;
import com.hemoglobin.respository.AssignmentRepository;
import com.hemoglobin.respository.BloodRequestRepository;
import com.hemoglobin.service.AssignmentService;

@Service
public class AssignmentServiceImpl implements AssignmentService {

	@Autowired
	private AssignmentRepository assignmentRepository;

	@Autowired
	private BloodRequestRepository bloodRequestRepository;

	public List<Assignment> findAll() throws AssignmentException {
		List<Assignment> assignments = (List<Assignment>) assignmentRepository.findAll();
		if (assignments != null && assignments.size() > 0)
			return assignments;
		else
			throw new AssignmentException("No Assignments found ");
	}

	@Override
	public List<Assignment> findByDonorId(int donorId) throws AssignmentException {
		List<Assignment> assignments = assignmentRepository.findByDonorId(donorId);
		if (assignments != null && assignments.size() > 0)
			return assignments;
		else
			throw new AssignmentException("No Assignments found ");
	}

	public Assignment findById(int id) throws AssignmentException {
		Assignment assignment = assignmentRepository.findById(id).get();
		if (assignment == null) {
			throw new AssignmentException("Assignment with id:" + id + " not found");
		}
		return assignment;
	}

	public Assignment create(Assignment assignment) throws AssignmentException {
		Assignment assignmentInDB = assignmentRepository.save(assignment);
		BloodRequest bloodRequestFromDB = bloodRequestRepository.findById(assignment.getBloodRequest().getRequestId()).get();
		bloodRequestFromDB.setStatus(new Status(2));
		bloodRequestFromDB = bloodRequestRepository.save(bloodRequestFromDB);
		if (assignmentInDB == null || bloodRequestFromDB == null) {
			throw new AssignmentException("Unable to create assignment");
		}
		return assignmentInDB;
	}

	public Assignment update(int id, Assignment state) throws AssignmentException {
		Assignment assignmentInDB = assignmentRepository.findById(id).get();
		if (assignmentInDB == null) {
			throw new AssignmentException("Assignment with id:" + id + " not found");
		}
		return assignmentRepository.save(state);
	}

	public void delete(int id) throws AssignmentException {
		Assignment assignmentInDB = assignmentRepository.findById(id).get();
		if (assignmentInDB == null) {
			throw new AssignmentException("Assignment with id:" + id + " not found");
		}
		assignmentRepository.delete(assignmentInDB);
	}

}
