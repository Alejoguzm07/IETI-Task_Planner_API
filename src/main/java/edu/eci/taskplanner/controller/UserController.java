package edu.eci.taskplanner.controller;

import edu.eci.taskplanner.model.User;
import edu.eci.taskplanner.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired UserService userService;

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping
	public ResponseEntity<?> getAll(){

		try {
			final List<User> users = userService.getAll();
			return new ResponseEntity<>(users, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/id/{user}")
	public ResponseEntity<?> getById(@PathVariable("user") String userId){

		try {
			final User user = userService.getById(userId);
			return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/email/{user}")
	public ResponseEntity<?> getByEmail(@PathVariable("user") String email){

		try {
			final User user = userService.getByEmail(email);
			return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping
	public ResponseEntity<?> create(@RequestBody User user){

		try {
			User createdUser = userService.create(user);
			return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PutMapping
	public ResponseEntity<?> update(@RequestBody User user){

		try {
			User updatedUser = userService.create(user);
			return new ResponseEntity<>(updatedUser, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@DeleteMapping("/id/{user}")
	public ResponseEntity<?> remove(@PathVariable("user") String userId){

		try {
			userService.remove(userId);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
