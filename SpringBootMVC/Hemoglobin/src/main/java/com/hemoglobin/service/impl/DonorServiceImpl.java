package com.hemoglobin.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hemoglobin.entities.Donor;
import com.hemoglobin.entities.DonorSearch;
import com.hemoglobin.entities.Status;
import com.hemoglobin.entities.User;
import com.hemoglobin.exceptions.DonorException;
import com.hemoglobin.respository.DonorRepository;
import com.hemoglobin.respository.UserRepository;
import com.hemoglobin.service.DonorService;

@Service
public class DonorServiceImpl implements DonorService {

	@Autowired
	private DonorRepository donorRespository;

	@Autowired
	private UserRepository userRespository;

	public Donor register(Donor donor) throws DonorException {
		Donor donorFromDB = donorRespository.save(donor);
		if (donorFromDB == null) {
			throw new DonorException("Unable to create Donor");
		}
		User user = userRespository.save(donorFromDB.getUser());
		if (user == null) {
			throw new DonorException("Unable to update User status");
		}
		return donorFromDB;
	}

	public void deregister(Donor donor) throws DonorException {
		User user = donor.getUser();
		user.getUserrole().setRoleId(1);
		userRespository.save(user);

	}

	public Donor getDonarById(int id) throws DonorException {
		Donor donor = donorRespository.findById(id).get();
		if (donor == null) {
			throw new DonorException("Donor with id:" + id + " not found");
		}
		return donor;
	}

	public List<Donor> getDonars() throws DonorException {
		List<Donor> donors = (List<Donor>) donorRespository.findAll();
		if (donors == null || donors.size() <= 0) {
			throw new DonorException("No Donors found");
		}
		return donors;
	}

	public Donor getDonarByUserId(int userId) {
		return donorRespository.findByUserId(userId);
	}

	public Donor updateDonor(int id, Donor donor) throws DonorException {
		Donor donorInDB = donorRespository.findById(id).get();
		if (donorInDB == null) {
			throw new DonorException("Donor with id:" + id + " not found");
		}
		return donorRespository.save(donor);

	}

	public List<Donor> getDonarsByStatus(int statusId) throws DonorException {
		List<Donor> donors = donorRespository.findByStatusId(statusId);
		if (donors == null || donors.size() <= 0) {
			throw new DonorException("No Donors found");
		}
		return donors;
	}

	public Donor delete(int id) throws DonorException {
		Donor donorInDB = donorRespository.findById(id).get();
		if (donorInDB == null) {
			throw new DonorException("Donor with id:" + id + " not found");
		}
		donorInDB.setStatus(new Status(4));
		return donorRespository.save(donorInDB);

	}

	public List<Donor> getDonorsBySearchCriteria(DonorSearch donorSearch) throws DonorException {
		System.out.println(donorSearch.toString());
		List<Donor> result = new ArrayList<>();
		List<Donor> donors = (List<Donor>) donorRespository.findAll();
		if (donors == null || donors.size() <= 0) {
			throw new DonorException("No Donors found");
		}
		if (donorSearch.isEmpty())
			return donors;
		for (Donor donor : donors)
			if (donorSearch.search(donor))
				result.add(donor);
		return result;
	}

}
