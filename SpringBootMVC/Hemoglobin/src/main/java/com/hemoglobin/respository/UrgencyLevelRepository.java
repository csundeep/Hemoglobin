package com.hemoglobin.respository;

import org.springframework.data.repository.CrudRepository;

import com.hemoglobin.entities.UrgencyLevel;

public interface UrgencyLevelRepository extends CrudRepository<UrgencyLevel, Integer> {



	UrgencyLevel findByUrgency(String urgency);



}
