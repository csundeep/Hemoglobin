package com.hemoglobin.respository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.hemoglobin.entities.Assignment;

public interface AssignmentRepository extends CrudRepository<Assignment, Integer> {

	@Query("SELECT a FROM Assignment a WHERE a.donor.donorId=:donorIdAttr")
	List<Assignment> findByDonorId(@Param(value = "donorIdAttr")Integer donorId);

}
