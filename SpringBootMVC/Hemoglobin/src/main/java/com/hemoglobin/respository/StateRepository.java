package com.hemoglobin.respository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.hemoglobin.entities.State;

public interface StateRepository extends CrudRepository<State, Integer> {

	List<State> findAll();

	State findById(int id);

	State findByCode(String code);

	State create(State state);

	State update(State state);

	void delete(State existing);

}
