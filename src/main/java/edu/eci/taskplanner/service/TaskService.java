package edu.eci.taskplanner.service;

import edu.eci.taskplanner.model.Task;
import edu.eci.taskplanner.model.User;

import java.util.List;

public interface TaskService {
	List<Task> getAll();

	Task getById(String id);

	List<Task> getByUserId(String userId);

	Task assignTaskToUser(String taskId, User user);

	void remove(String taskId);

	Task update(Task task);
}
