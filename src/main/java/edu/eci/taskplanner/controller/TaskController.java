package edu.eci.taskplanner.controller;

import edu.eci.taskplanner.model.Task;
import edu.eci.taskplanner.model.User;
import edu.eci.taskplanner.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/tasks")
public class TaskController {

	@Autowired TaskService taskService;

	@GetMapping
	public ResponseEntity<?> getAll(){

		try {
			final List<Task> tasks = taskService.getAll();
			return new ResponseEntity<>(tasks, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/id/{task}")
	public ResponseEntity<?> getById(@PathVariable("task") String id){
		try {
			final Task task = taskService.getById(id);
			return new ResponseEntity<>(task, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/id/{user}")
	public ResponseEntity<?> getByUserId(@PathVariable("user") String userId){

		try {
			final List<Task> tasks = taskService.getByUserId(userId);
			return new ResponseEntity<>(tasks, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/id/{task}")
	public ResponseEntity<?> assignTaskToUser(@PathVariable("task") String taskId,@RequestBody User user){

		try {
			Task assignedTask = taskService.assignTaskToUser(taskId,user);
			return new ResponseEntity<>(assignedTask, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping
	public ResponseEntity<?> update(@RequestBody Task task){

		try {
			Task updatedTask = taskService.update(task);
			return new ResponseEntity<>(updatedTask, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/id/{task}")
	public ResponseEntity<?> remove(@PathVariable("task") String id){

		try {
			taskService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
