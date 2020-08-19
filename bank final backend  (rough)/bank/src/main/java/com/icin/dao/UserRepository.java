package com.icin.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.icin.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	User findByMailid(String mailid);

	User findByFullname(String name);
	User findByUsername(String name);
}
