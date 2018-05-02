package com.hemoglobin.respository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.hemoglobin.entities.Status;

public interface StatusRepository extends CrudRepository<Status, Integer> {

	List<Status> findAll();

	Status findById(int id);

	Status findByDescription(String code);

	Status create(Status state);

	Status update(Status state);

	void delete(Status existing);

}
