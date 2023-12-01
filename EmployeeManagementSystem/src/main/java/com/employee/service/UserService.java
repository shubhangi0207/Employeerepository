package com.employee.service;

import java.util.List;

import com.employee.dto.User;

public interface UserService {
	public User registerUser(User user);

	public User getUserByUserName(String userName);

	public List<User> getAllUsers(User user);

	public void deleteAllUser();

	public void deleteByUserName(String userName);

	public User updateUserByUserName(User user);

	public void authenticate(String userName, String userPassword) throws Exception;
}
