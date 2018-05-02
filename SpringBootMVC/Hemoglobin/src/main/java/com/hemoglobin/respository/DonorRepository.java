package com.hemoglobin.respository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.hemoglobin.entities.Donor;

public interface DonorRepository extends CrudRepository<Donor, Integer> {



	Donor findByUserId(int userId);

	List<Donor> findByStatusId(int statusId);

}
