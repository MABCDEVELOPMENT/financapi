package com.financ.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.financ.controller.util.CustomErrorType;
import com.financ.model.Login;
import com.financ.model.User;
import com.financ.repository.generic.UserRepository;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;

@RestController
@CrossOrigin
@RequestMapping("/login")
@SwaggerDefinition(tags = { @Tag(name = "Login", description = "Operations about login") })
public class LoginController {

	@Autowired
	UserRepository userRepository;

	@Autowired
	public void setService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@ApiOperation(value = "Login of user")
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<?> login(@RequestBody Login login) {

		User user = userRepository.findLogin(login.getUserName());

		if (user == null) {
			return new ResponseEntity<CustomErrorType>(new CustomErrorType("User invalid!"), HttpStatus.CONFLICT);
		} else {
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}

	}

}
