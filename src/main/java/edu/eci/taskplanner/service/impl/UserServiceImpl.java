package edu.eci.taskplanner.service.impl;

import edu.eci.taskplanner.model.Status;
import edu.eci.taskplanner.model.Task;
import edu.eci.taskplanner.model.User;
import edu.eci.taskplanner.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

	private Map<String, User> users;

	public UserServiceImpl() {
		users = new HashMap<>();
		User user1 = User.builder()
						.id("1")
						.email("admin")
						.fullname("administrador")
						.password("admin")
						.build();
		User user2 = User.builder()
						 .id("2")
						 .email("user")
						 .fullname("usuario")
						 .password("user")
						 .build();
		users.put(user1.getId(),user1);
		users.put(user2.getId(),user2);
	}

	@Override public List<User> getAll() {

		return new ArrayList<>(users.values());
	}

	@Override public User getById(String userId) {

		return users.get(userId);
	}

	@Override public User getByEmail(String email) {

		return User.builder()
				   .id("1")
				   .email("admin")
				   .fullname("administrador")
				   .password("admin")
				   .build();
	}

	@Override public User create(User user) {
		user.setId(Integer.toString(users.size() + 1));
		users.put(user.getId(),user);
		return user;
	}

	@Override public User update(User user) {

		return null;
	}

	@Override public void remove(String userId) {

	}
}
