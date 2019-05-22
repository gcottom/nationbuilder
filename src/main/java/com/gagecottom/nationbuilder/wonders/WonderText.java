package com.gagecottom.nationbuilder.wonders;

public class WonderText {
private String text;
private int cost;
private String benefits;
private String maintenance;
private String link;
public WonderText(String text, int cost, String benefits, String maintenance, String link) {
	this.text= text;
	this.cost=cost;
	this.benefits=benefits;
	this.maintenance=maintenance;
	this.link= link;
}

public String getLink() {
	return link;
}

public void setLink(String link) {
	this.link = link;
}

public String getText() {
	return text;
}
public void setText(String text) {
	this.text = text;
}
public int getCost() {
	return cost;
}
public void setCost(int cost) {
	this.cost = cost;
}
public String getBenefits() {
	return benefits;
}
public void setBenefits(String benefits) {
	this.benefits = benefits;
}
public String getMaintenance() {
	return maintenance;
}
public void setMaintenance(String maintenance) {
	this.maintenance = maintenance;
}

}
