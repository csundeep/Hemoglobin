package com.hemoglobin.respository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.hemoglobin.entities.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	List<User> findAll();

	User findById(int id);

	User findByEmail(String email);

	User create(User emp);

	User update(User emp);

	void delete(User existing);
}
