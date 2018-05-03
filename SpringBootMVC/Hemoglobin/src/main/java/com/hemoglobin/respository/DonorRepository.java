package com.hemoglobin.respository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.hemoglobin.entities.Donor;

public interface DonorRepository extends CrudRepository<Donor, Integer> {

	@Query("SELECT d FROM Donor d WHERE d.user.userId=:userIdAttr")
	Donor findByUserId(@Param(value = "userIdAttr") int userId);

	@Query("SELECT d FROM Donor d WHERE d.status.statusId=:statusIdAttr")
	List<Donor> findByStatusId(@Param(value = "statusIdAttr") int statusId);

}
