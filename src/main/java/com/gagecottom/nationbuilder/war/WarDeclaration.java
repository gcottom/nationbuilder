package com.gagecottom.nationbuilder.war;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class WarDeclaration {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int id;
private int initiatorId;
private int targetId;
private int startTurn;
private int endTurn;
private boolean active = true;
public WarDeclaration() {
	
}

public boolean isActive() {
	return active;
}

public void setActive(boolean active) {
	this.active = active;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public int getInitiatorId() {
	return initiatorId;
}
public void setInitiatorId(int initiatorId) {
	this.initiatorId = initiatorId;
}
public int getTargetId() {
	return targetId;
}
public void setTargetId(int targetId) {
	this.targetId = targetId;
}
public int getStartTurn() {
	return startTurn;
}
public void setStartTurn(int startTurn) {
	this.startTurn = startTurn;
	endTurn = startTurn + 500;
}
public int getEndTurn() {
	return endTurn;
}
public void setEndTurn(int endTurn) {
	this.endTurn = endTurn;
}

}
