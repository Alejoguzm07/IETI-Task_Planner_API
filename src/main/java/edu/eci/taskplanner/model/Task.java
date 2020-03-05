package edu.eci.taskplanner.model;

public class Task {

	private String description;
	private String name;
	private String email;
	private String status;

	public Task(String description, String name, String email, String status) {

		this.description = description;
		this.name = name;
		this.email = email;
		this.status = status;
	}

	public Task() {
	}

	public String getDescription() {

		return description;
	}

	public void setDescription(String description) {

		this.description = description;
	}

	public String getName() {

		return name;
	}

	public void setName(String name) {

		this.name = name;
	}

	public String getEmail() {

		return email;
	}

	public void setEmail(String email) {

		this.email = email;
	}

	public String getStatus() {

		return status;
	}

	public void setStatus(String status) {

		this.status = status;
	}
}
