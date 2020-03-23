package edu.eci.taskplanner.service.impl;

import edu.eci.taskplanner.model.User;
import edu.eci.taskplanner.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

	@Override public List<User> getAll() {

		return null;
	}

	@Override public User getById(String userId) {

		return User.builder()
				   .email("admin")
				   .fullname("administrador")
				   .password("admin")
				   .build();
	}

	@Override public User getByEmail(String email) {

		return User.builder()
						.email("admin")
						.fullname("administrador")
						.password("admin")
						.build();
	}

	@Override public User create(User user) {

		return null;
	}

	@Override public User update(User user) {

		return null;
	}

	@Override public void remove(String userId) {

	}
}
