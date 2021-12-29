package com.projectZeroPractice.entity;

import java.time.LocalTime;

public class TimelineEntity {
	
	private String sender;
	private String timeOfMessage;
	private String Message;
	private String reciever;
	public String getReciever() {
		return reciever;
	}
	public void setReciever(String reciever) {
		this.reciever = reciever;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String  getTimeOfMessage() {
		return timeOfMessage;
	}
	public void setTimeOfMessage(String timeOfMessage) {
		this.timeOfMessage = timeOfMessage;
	}
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
	

}
