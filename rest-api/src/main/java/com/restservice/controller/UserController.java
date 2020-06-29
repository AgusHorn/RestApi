package com.restservice.controller;

import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restservice.dao.IUserDAO;
import com.restservice.entity.User;


@RestController
public class UserController {
		
	@Autowired
	private IUserDAO userDAO;
	private static final AtomicInteger counter = new AtomicInteger();
	
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUser(@PathVariable Integer id){
		User user = userDAO.findUserById(id);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@PostMapping("/user")
	public ResponseEntity<User> addUser(@RequestBody User user) {
		Integer id = UserController.nextValue();
		user.setId(id);
		userDAO.saveUser(user);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@PutMapping("/users/{id}")
	public ResponseEntity<String> updateUser(@PathVariable Integer id, @RequestBody User user) {
		Integer modifiedId = userDAO.modifyUser(id, user);
		if (modifiedId == -1) {
			return new ResponseEntity<>("The id is not valid", HttpStatus.BAD_REQUEST);
		}
		if (modifiedId == null) {
			return new ResponseEntity<>("There was an error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>("The user with id:" + Integer.toString(modifiedId) + " was modified", HttpStatus.OK);
	}
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<String> deteteUser(@PathVariable Integer id) {
		Integer deletedId = userDAO.deleteUserById(id);
		if (deletedId != -1) {
			return new ResponseEntity<>("The user with id:" + Integer.toString(deletedId) + " was deleted", HttpStatus.OK);
		}
		return new ResponseEntity<>("The id is not valid", HttpStatus.BAD_REQUEST);
	}
	
	private static int nextValue() {
	    return counter.getAndIncrement();
	}
	
}
