package com.employee.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee.dto.User;
import com.employee.dto.response.JwtResponse;
import com.employee.service.UserService;
import com.employee.util.JwtTokenUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequestMapping("/user")
@Api(description = "User related operations")
public class UserCntrl {

	@Autowired
	UserService userSvc;

	@Autowired
	UserDetailsService userDetailsService;

	@Autowired
	JwtTokenUtil jwtTokenUtil;

	@PostMapping("/registerUser")
	@ApiOperation(value = "Register the user", notes = "Registering the user details api")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "User registered successfully"),
			@ApiResponse(code = 400, message = "Bad Request") })
	public ResponseEntity<String> registerUser(@Valid @RequestBody User user) {

		log.info("Method registerUser started.{} ", user.toString());

		userSvc.registerUser(user);

		return ResponseEntity.ok("User registered successfully");

	}

	@GetMapping("/getUserByUserName")
	@ApiOperation(value = "Get user by user name", notes = "Getting user by it's user name")
	public User getUserByUserName(@ApiParam(value = "User Name", required = true) @RequestParam String userName) {

		log.info("Method getUserByUserName started", userName.toString());

		return userSvc.getUserByUserName(userName);

	}

	@GetMapping("/getAllUsers")
	@ApiOperation(value = "Get All Users", notes = "Getting all users details")
	public List<User> getAllUsers(User user) {

		log.info("Method getAllUsers Started", user.toString());

		return userSvc.getAllUsers(user);
	}

	@GetMapping("/deleteAllUser")
	@ApiOperation(value = "Delete All Users", notes = "Deleting all users records")
	public ResponseEntity<String> deleteAllUser() {

		log.info("Method deleteAllUser Started");

		userSvc.deleteAllUser();

		return ResponseEntity.ok("All users deleted successfully");

	}

	@GetMapping("/deleteByUserName")
	@ApiOperation(value = "Delete user by User Name", notes = "User is deleted by the given User Name ")
	public ResponseEntity<String> deleteByUserName(
			@ApiParam(value = "User Name", required = true) @RequestParam String userName) {

		log.info("Method deleteByUserName Started");

		userSvc.deleteByUserName(userName);

		return ResponseEntity.ok("User by User Name : " + userName + " is deleted successfully.");

	}

	@PostMapping("/updateUserByUserName")
	@ApiOperation(value = "Update user by User Name", notes = "Update user details by the given User Name ")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "User registered successfully"),
			@ApiResponse(code = 400, message = "Bad Request") })
	public ResponseEntity<String> updateUserByUserName(@RequestBody User user) {

		log.info("Method updateUserByUserName is started");

		userSvc.updateUserByUserName(user);

		return ResponseEntity.ok("User with user Name :" + user.getUserName() + "is updated succefully");

	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody User authReq) throws Exception {

		log.info("Method login is started");

		// Authentication
		userSvc.authenticate(authReq.getUserName(), authReq.getUserPassword());

		// Loading User Details from database
		UserDetails userDetails = userDetailsService.loadUserByUsername(authReq.getUserName());

		// Generating the jwt token
		final String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new JwtResponse(token));

	}

}
