package com.gagecottom.nationbuilder.simulation;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Turn {
@Id
private int id;
private int turn;
public Turn() {
	
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getTurn() {
	return turn;
}
public void setTurn(int turn) {
	this.turn = turn;
}

}
