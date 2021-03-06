package com.gagecottom.nationbuilder.message;

import javax.persistence.Column;
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
@Column(name="note", length = 2500)
private String note;
private Boolean newMessage=true;
public Message() {
	
}

public Boolean getNewMessage() {
	return newMessage;
}

public void setNewMessage(Boolean newMessage) {
	this.newMessage = newMessage;
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
