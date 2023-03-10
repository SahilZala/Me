package com.pack.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Ticket {
	@Id
	private String id;
	
	@DBRef
	private User from;
	@DBRef
	private List<User> to;
	@DBRef
	private Group groupId;

	
	private String date;
	private String time;
	private String status;
	private int priority;
	private String title;
	private String description;
	
	public Ticket() {
		super();
	}

	
	
	public Ticket(String id, User from, List<User> to, Group groupId, String date, String time, String status,
			int priority, String title, String description) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.groupId = groupId;
		this.date = date;
		this.time = time;
		this.status = status;
		this.priority = priority;
		this.title = title;
		this.description = description;
	}



	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public User getFrom() {
		return from;
	}
	public void setFrom(User from) {
		this.from = from;
	}
	public List<User> getTo() {
		return to;
	}
	public void setTo(List<User> to) {
		this.to = to;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public Group getGroupId() {
		return groupId;
	}
	public void setGroupId(Group groupId) {
		this.groupId = groupId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}	
}
