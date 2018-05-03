package com.hemoglobin.respository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.hemoglobin.entities.BloodRequest;

public interface BloodRequestRepository extends CrudRepository<BloodRequest, Integer> {
	@Query("SELECT br FROM BloodRequest br WHERE br.user.userId=:userIdAttr")
	List<BloodRequest> findByUserId(@Param(value = "userIdAttr") int userId);

}
