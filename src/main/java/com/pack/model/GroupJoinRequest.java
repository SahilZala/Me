package com.pack.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.pack.util.GroupJoinRequestStatus;

@Document
public class GroupJoinRequest {
	@Id
	private String id;
	@DBRef
	private User from;
	@DBRef
	private User to;
	@DBRef
	private Group gid;
	private String status;
	private String date;
	private String time;
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
	public User getTo() {
		return to;
	}
	public void setTo(User to) {
		this.to = to;
	}
	public Group getGid() {
		return gid;
	}
	public void setGid(Group gid) {
		this.gid = gid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	public GroupJoinRequest(String id, User from, User to, Group gid, String status, String date, String time) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.gid = gid;
		this.status = status;
		this.date = date;
		this.time = time;
	}
	@Override
	public String toString() {
		return "GroupJoinRequest [id=" + id + ", from=" + from + ", to=" + to + ", gid=" + gid + ", status=" + status
				+ ", date=" + date + ", time=" + time + "]";
	}
	public GroupJoinRequest() {
		super();
	}
	
	public void approve()
	{
		this.setStatus(GroupJoinRequestStatus.APPROVE);
	}
	public void cancel() {
		this.setStatus(GroupJoinRequestStatus.CANCEL);
	}
	
}
