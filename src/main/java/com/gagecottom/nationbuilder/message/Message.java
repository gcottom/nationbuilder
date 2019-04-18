package com.gagecottom.nationbuilder.message;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Message {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int id;
private int receiverId;
private int senderId;
private String note;
public Message() {
	
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getReceiverId() {
	return receiverId;
}
public void setReceiverId(int receiverId) {
	this.receiverId = receiverId;
}
public int getSenderId() {
	return senderId;
}
public void setSenderId(int senderId) {
	this.senderId = senderId;
}
public String getMessage() {
	return note;
}
public void setMessage(String message) {
	this.note = message;
}

}
