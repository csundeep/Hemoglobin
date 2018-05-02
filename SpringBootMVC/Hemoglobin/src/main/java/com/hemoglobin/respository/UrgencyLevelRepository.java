package com.hemoglobin.respository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.hemoglobin.entities.UrgencyLevel;

public interface UrgencyLevelRepository extends CrudRepository<UrgencyLevel, Integer> {

	List<UrgencyLevel> findAll();

	UrgencyLevel findById(int id);

	UrgencyLevel findByUrgency(String urgency);

	UrgencyLevel create(UrgencyLevel state);

	UrgencyLevel update(UrgencyLevel state);

	void delete(UrgencyLevel existing);

}
