package com.gagecottom.nationbuilder.nation;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Nation {
	@Id
	private int id;
	private String nationName;
	private String nationCapitol;
	private String government;
	private String resource1;
	private String resource2;
	private String resource3;
	private String resource4;
	private int money;
	private int technology;
	private int population;
	private int production;
	
	public int getProduction() {
		return production;
	}
	public void setProduction(int production) {
		this.production = production;
	}
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}
	public String getGovernment() {
		return government;
	}
	public void setGovernment(String government) {
		this.government = government;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNationName() {
		return nationName;
	}
	public void setNationName(String nationName) {
		this.nationName = nationName;
	}
	public String getNationCapitol() {
		return nationCapitol;
	}
	public void setNationCapitol(String nationCapitol) {
		this.nationCapitol = nationCapitol;
	}
	public String getResource1() {
		return resource1;
	}
	public void setResource1(String resource1) {
		this.resource1 = resource1;
	}
	public String getResource2() {
		return resource2;
	}
	public void setResource2(String resource2) {
		this.resource2 = resource2;
	}
	public String getResource3() {
		return resource3;
	}
	public void setResource3(String resource3) {
		this.resource3 = resource3;
	}
	public String getResource4() {
		return resource4;
	}
	public void setResource4(String resource4) {
		this.resource4 = resource4;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int getTechnology() {
		return technology;
	}
	public void setTechnology(int technology) {
		this.technology = technology;
	}
}
