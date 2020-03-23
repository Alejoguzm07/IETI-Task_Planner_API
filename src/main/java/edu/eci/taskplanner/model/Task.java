package edu.eci.taskplanner.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Task {

	private String id;
	private String description;
	private User user;
	private Status status;
	private Date dueDate;

}
