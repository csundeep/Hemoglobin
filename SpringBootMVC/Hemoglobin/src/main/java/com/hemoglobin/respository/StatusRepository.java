package com.hemoglobin.respository;

import org.springframework.data.repository.CrudRepository;

import com.hemoglobin.entities.Status;

public interface StatusRepository extends CrudRepository<Status, Integer> {

	Status findByDescription(String description);

}
