package edu.eci.taskplanner.service.impl;

import edu.eci.taskplanner.model.Status;
import edu.eci.taskplanner.model.Task;
import edu.eci.taskplanner.model.User;
import edu.eci.taskplanner.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TaskServiceImpl implements TaskService {

	private Map<String,Task> tasks;

	public TaskServiceImpl() {
		tasks = new HashMap<>();
		User user = User.builder()
						.id("1")
						.email("admin")
						.fullname("administrador")
						.password("admin")
						.build();
		Task task1 = Task.builder()
						 .id("1")
						 .description("Test")
						 .dueDate(new Date(Calendar.getInstance().getTime().getTime()))
						 .status(Status.IN_PROGRESS)
						 .user(user)
						 .build();
		tasks.put(task1.getId(),task1);
		Task task2 = Task.builder()
						 .id("2")
						 .description("Test2")
						 .dueDate(new Date(Calendar.getInstance().getTime().getTime()))
						 .status(Status.COMPLETED)
						 .user(user)
						 .build();
		tasks.put(task2.getId(),task2);
	}

	@Override public List<Task> getAll() {

		return new ArrayList<>(tasks.values());
	}

	@Override public Task getById(String id) {

		return tasks.get(id);
	}

	@Override public List<Task> getByUserId(String userId) {

		return null;
	}

	@Override public Task create(Task task) {
		task.setId(Integer.toString(tasks.size() + 1));
		tasks.put(task.getId(),task);
		return  task;
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
