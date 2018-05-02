package com.hemoglobin.respository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.hemoglobin.entities.Assignment;

public interface AssignmentRepository extends CrudRepository<Assignment, Integer> {

	List<Assignment> findByDonorId(Integer donorId);

}
