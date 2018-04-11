package com.financ.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.financ.model.User;
import com.financ.repository.generic.UserRepository;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;

@RestController
@RequestMapping("/user")
@SwaggerDefinition(tags = { @Tag(name = "User", description = "Operations about user") })
public class UserController {

	@Autowired
	UserRepository userRepository;

	@Autowired
	public void setService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@ApiOperation(value = "View a list of available user", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })

	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
	public List<User> list() {
		List<User> list = userRepository.findAll(sort(true,"id"));
		return list;
	}

	@ApiOperation(value = "Add a user")
	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<String> saveProduct(@RequestBody User user) {
		userRepository.saveAndFlush(user);
		return new ResponseEntity<String>("Product saved successfully", HttpStatus.OK);
	}

	@ApiOperation(value = "Update a product")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<String> updateProduct(@PathVariable Long id, @RequestBody User user) {
		userRepository.save(user);
		return new ResponseEntity<String>("Product updated successfully", HttpStatus.OK);
	}

	@ApiOperation(value = "Delete a product")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		userRepository.deleteById(id);
		return new ResponseEntity<String>("Product deleted successfully", HttpStatus.OK);
	}

	private Sort sort(boolean asc, String field) {
		return new Sort(asc ? Sort.Direction.ASC : Sort.Direction.DESC, field);
	}

}
