package com.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.employee.dto.User;
import com.employee.exception.EmployeeNotFoundException;
import com.employee.repo.UserRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepo;

	@Autowired
	AuthenticationManager authManager;

	@Override
	public User registerUser(User user) {
		// TODO Auto-generated method stub
		// if(user.getUserName().equals(userRepo.))
		return userRepo.save(user);
	}

	@Override
	public User getUserByUserName(String userName) {

		log.info("In service implementation layer, getUserByUserName method is stared");

		return userRepo.findByUserName(userName).orElseThrow(
				() -> new EmployeeNotFoundException(HttpStatus.NOT_FOUND.value(), "User Name is Not present In DB"));
	}

	@Override
	public List<User> getAllUsers(User user) {

		log.info("In service implementation layer, getAllUsers method is started");

		return userRepo.findAll();

	}

	@Override
	public void deleteAllUser() {

		log.info("In service implementation layer, deleteAllUser method is stared");

		userRepo.deleteAll();
	}

	@Override
	public void deleteByUserName(String userName) {

		log.info("In service implementation layer,deleteByUserName method is stared ");

		userRepo.deleteByUserName(userName);

	}

	@Override
	public User updateUserByUserName(User user) {
		// TODO Auto-generated method stub
		log.info("In service implementation layer,updateUserByUserName method is stared ");

		User usr = userRepo.findByUserName(user.getUserName()).orElseThrow(
				() -> new UserNotFoundException(HttpStatus.NOT_FOUND.value(), "User Name is not present In DB"));

		usr.setUserName(user.getUserName());
		usr.setUserPassword(user.getUserPassword());
		usr.setMobileNo(user.getMobileNo());
		usr.setEmailId(user.getEmailId());
		usr.setRole(user.getRole());

		log.info("Saving updated details in the database" + usr.toString());

		return userRepo.save(usr);

	}

	public void authenticate(String userName, String userPassword) throws Exception {
		// TODO Auto-generated method stub
		try {
			authManager.authenticate(new UsernamePasswordAuthenticationToken(userName, userPassword));
		} catch (DisabledException d) {
			throw new Exception("USER_DISABLED", d);
		} catch (BadCredentialsException b) {
			throw new Exception("INVALID_CREDENTIALS", b);
		}
	}
}
