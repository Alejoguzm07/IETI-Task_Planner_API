package edu.eci.taskplanner.service.impl;

import edu.eci.taskplanner.model.Task;
import edu.eci.taskplanner.model.User;
import edu.eci.taskplanner.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

	@Override public List<Task> getAll() {

		return null;
	}

	@Override public Task getById(String id) {

		return null;
	}

	@Override public List<Task> getByUserId(String userId) {

		return null;
	}

	@Override public Task assignTaskToUser(String taskId, User user) {

		return null;
	}

	@Override public void remove(String taskId) {

	}

	@Override public Task update(Task task) {

		return null;
	}
}
