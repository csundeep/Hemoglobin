package com.hemoglobin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hemoglobin.entities.State;
import com.hemoglobin.exceptions.StateException;
import com.hemoglobin.respository.StateRepository;
import com.hemoglobin.service.StateService;

@Service
public class StateServiceImpl implements StateService {

	@Autowired
	private StateRepository repository;

	public List<State> findAll() throws StateException {
		List<State> states = (List<State>) repository.findAll();
		if (states != null && states.size() > 0)
			return states;
		else
			throw new StateException("No states found ");
	}

	public State findById(int id) throws StateException {
		State state = repository.findById(id).get();
		if (state == null) {
			throw new StateException("State with id:" + id + " not found");
		}
		return state;
	}

	public State create(State state) throws StateException {
		State stateInDB = repository.findByCode(state.getCode());
		if (stateInDB != null) {
			throw new StateException("State with code " + state.getCode() + " is already in use");
		}
		return repository.save(state);
	}

	public State update(int id, State state) throws StateException {
		State stateInDB = repository.findById(id).get();
		if (stateInDB == null) {
			throw new StateException("State with id:" + id + " not found");
		}
		return repository.save(state);
	}

	public void delete(int id) throws StateException {
		State stateInDB = repository.findById(id).get();
		if (stateInDB == null) {
			throw new StateException("State with id:" + id + " not found");
		}
		repository.delete(stateInDB);
	}

}
