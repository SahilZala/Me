package com.pack.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.DBRef;

public class Group {
	private String id;
	private String groupName;
	private String creationDate;
	@DBRef
	private User groupCreatedById;
	private boolean activation;
	@DBRef
	private List<User> groupMemberList;
	
	public Group() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Group(String id, String groupName, String creationDate, User groupCreatedById, boolean activation) {
		super();
		this.id = id;
		this.groupName = groupName;
		this.creationDate = creationDate;
		this.groupCreatedById = groupCreatedById;
		this.activation = activation;
	}
	
	public Group(String id, String groupName, String creationDate, User groupCreatedById, boolean activation,
			List<User> groupMemberList) {
		super();
		this.id = id;
		this.groupName = groupName;
		this.creationDate = creationDate;
		this.groupCreatedById = groupCreatedById;
		this.activation = activation;
		this.groupMemberList = groupMemberList;
	}
	public List<User> getGroupMemberList() {
		return groupMemberList;
	}
	public void setGroupMemberList(List<User> groupMemberList) {
		this.groupMemberList = groupMemberList;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	public User getGroupCreatedById() {
		return groupCreatedById;
	}
	public void setGroupCreatedById(User groupCreatedById) {
		this.groupCreatedById = groupCreatedById;
	}
	public boolean isActivation() {
		return activation;
	}
	public void setActivation(boolean activation) {
		this.activation = activation;
	}
	@Override
	public String toString() {
		return "Group [id=" + id + ", groupName=" + groupName + ", creationDate=" + creationDate + ", groupCreatedById="
				+ groupCreatedById + ", activation=" + activation + "]";
	}
	
	

	
	
	
	
}
