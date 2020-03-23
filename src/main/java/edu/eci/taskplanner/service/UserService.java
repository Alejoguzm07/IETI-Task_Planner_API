package edu.eci.taskplanner.service;

import edu.eci.taskplanner.model.User;

import java.util.List;

public interface UserService {
	List<User> getAll();

	User getById(String userId);

	User getByEmail(String email);

	User create(User user);

	User update(User user);

	void remove(String userId);
}