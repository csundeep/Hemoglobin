package com.hemoglobin.respository;

import org.springframework.data.repository.CrudRepository;

import com.hemoglobin.entities.User;

public interface UserRepository extends CrudRepository<User, Integer> {


	User findByEmail(String email);



}
