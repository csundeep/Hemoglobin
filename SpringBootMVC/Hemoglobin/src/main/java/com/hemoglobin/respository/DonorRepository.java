package com.hemoglobin.respository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.hemoglobin.entities.Donor;

public interface DonorRepository extends CrudRepository<Donor, Integer> {

	List<Donor> findAll();

	Donor findById(int id);

	Donor create(Donor emp);

	Donor update(Donor emp);

	void delete(Donor existing);

	Donor findByUserId(int userId);

	List<Donor> findByStatusId(int statusId);

}
