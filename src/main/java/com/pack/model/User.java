package com.pack.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {
	@Id
	private String id;
	private String name;
	@Indexed(unique = true)
	private String username;
	@Indexed(unique = true)
	private String mailId;
	private String password;
	private String type;
	private boolean activation;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isActivation() {
		return activation;
	}
	public void setActivation(boolean activation) {
		this.activation = activation;
	}
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public User(String id, String name, String username, String mailId, String password, String type, boolean activation) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.mailId = mailId;
		this.password = password;
		this.type = type;
		this.activation = activation;
	}
	
	public User(String id) {
		super();
		this.id = id;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", username=" + username + ", mailId=" + mailId + ", password="
				+ password + ", type=" + type + ", activation=" + activation + "]";
	}
	
}
