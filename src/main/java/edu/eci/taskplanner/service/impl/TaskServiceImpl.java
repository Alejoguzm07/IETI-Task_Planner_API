package edu.eci.taskplanner.service.impl;

import edu.eci.taskplanner.model.Status;
import edu.eci.taskplanner.model.Task;
import edu.eci.taskplanner.model.User;
import edu.eci.taskplanner.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

	@Override public List<Task> getAll() {
		User user = User.builder()
				.email("admin")
				.fullname("administrador")
				.password("admin")
				.build();
		Task task = Task.builder()
				.description("Test")
				.dueDate(new Date(Calendar.getInstance().getTime().getTime()))
				.status(Status.IN_PROGRESS)
				.user(user)
				.build();
		ArrayList<Task> tasks = new ArrayList<>();
		tasks.add(task);
		return tasks;
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
