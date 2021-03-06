package com.hemoglobin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hemoglobin.entities.UrgencyLevel;
import com.hemoglobin.exceptions.UrgencyLevelException;
import com.hemoglobin.respository.UrgencyLevelRepository;
import com.hemoglobin.service.UrgencyLevelService;

@Service
public class UrgencyServiceImpl implements UrgencyLevelService {

	@Autowired
	private UrgencyLevelRepository repository;

	public List<UrgencyLevel> findAll() throws UrgencyLevelException {
		List<UrgencyLevel> urgencyLevels = (List<UrgencyLevel>) repository.findAll();
		if (urgencyLevels != null && urgencyLevels.size() > 0)
			return urgencyLevels;
		else
			throw new UrgencyLevelException("No Urgency Levels found ");
	}

	public UrgencyLevel findById(int id) throws UrgencyLevelException {
		UrgencyLevel urgencyLevel = repository.findById(id).get();
		if (urgencyLevel == null) {
			throw new UrgencyLevelException("UrgencyLevel" + id + " not found");
		}
		return urgencyLevel;
	}

	public UrgencyLevel create(UrgencyLevel urgencyLevel) throws UrgencyLevelException {
		UrgencyLevel urgencyLevelInDB = repository.findByUrgency(urgencyLevel.getUrgency());
		if (urgencyLevelInDB != null) {
			throw new UrgencyLevelException(
					"UrgencyLevel with urgency " + urgencyLevel.getUrgency() + " is already in use");
		}
		return repository.save(urgencyLevel);
	}

	public UrgencyLevel update(int id, UrgencyLevel urgencyLevel) throws UrgencyLevelException {
		UrgencyLevel urgencyLevelInDB = repository.findById(id).get();
		if (urgencyLevelInDB == null) {
			throw new UrgencyLevelException("UrgencyLevel with id:" + id + " not found");
		}
		return repository.save(urgencyLevel);
	}

	public void delete(int id) throws UrgencyLevelException {
		UrgencyLevel urgencyLevelInDB = repository.findById(id).get();
		if (urgencyLevelInDB == null) {
			throw new UrgencyLevelException("UrgencyLevel with id:" + id + " not found");
		}
		repository.delete(urgencyLevelInDB);
	}

}
