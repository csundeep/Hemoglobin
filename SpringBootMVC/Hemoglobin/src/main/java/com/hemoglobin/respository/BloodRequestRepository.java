package com.hemoglobin.respository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.hemoglobin.entities.BloodRequest;

public interface BloodRequestRepository extends CrudRepository<BloodRequest, Integer> {

	List<BloodRequest> findByUserId(int userId);

}
