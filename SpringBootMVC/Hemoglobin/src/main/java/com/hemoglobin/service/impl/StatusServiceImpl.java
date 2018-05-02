package com.hemoglobin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hemoglobin.entities.Status;
import com.hemoglobin.exceptions.StatusException;
import com.hemoglobin.respository.StatusRepository;
import com.hemoglobin.service.StatusService;

@Service
public class StatusServiceImpl implements StatusService {

	@Autowired
	private StatusRepository repository;

	public List<Status> findAll() throws StatusException {
		List<Status> statusces = (List<Status>) repository.findAll();
		if (statusces != null && statusces.size() > 0)
			return statusces;
		else
			throw new StatusException("No status found ");
	}

	public Status findById(int id) throws StatusException {
		Status status = repository.findById(id).get();
		if (status == null) {
			throw new StatusException("Status with id:" + id + " not found");
		}
		return status;
	}

	public Status create(Status status) throws StatusException {
		Status statusInDB = repository.findByDescription(status.getDescription());
		if (statusInDB != null) {
			throw new StatusException("Status with code " + status.getDescription() + " is already in use");
		}
		return repository.save(status);
	}

	public Status update(int id, Status status) throws StatusException {
		Status statusInDB = repository.findById(id).get();
		if (statusInDB == null) {
			throw new StatusException("Status with id:" + id + " not found");
		}
		return repository.save(status);
	}

	public void delete(int id) throws StatusException {
		Status statusInDB = repository.findById(id).get();
		if (statusInDB == null) {
			throw new StatusException("Status with id:" + id + " not found");
		}
		repository.delete(statusInDB);
	}

}
