package com.hemoglobin.respository;

import org.springframework.data.repository.CrudRepository;

import com.hemoglobin.entities.State;

public interface StateRepository extends CrudRepository<State, Integer> {

	State findByCode(String code);

}
