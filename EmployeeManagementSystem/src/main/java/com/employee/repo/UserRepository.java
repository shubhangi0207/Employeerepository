package com.employee.repo;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.employee.dto.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

	Optional<User> findByUserName(String userName);

	void deleteByUserName(String userName);

}
