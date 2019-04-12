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
	private int populationLimit;
	private int production;
	private boolean hasLibrary = false;
	private boolean hasMarket = false;
	private boolean hasWorkshop = false;
	private boolean hasBasicFarm = false;
	private int nationLevel = 1;
	private boolean level1 =true;
	private boolean level2 =false;
	private boolean level3 = false;
	private boolean level4 = false;
	private boolean level5 =false;
	private boolean level6 = false;
	private boolean level7 = false;
	private int productionTurn=0;
	private int populationTurn=0;
	private int technologyTurn=0;
	private int moneyTurn=0;
	private boolean forge=false;
	private boolean plantation= false;
	private boolean greatLibrary = false;
	private boolean largeMarket = false;
	
	
	public boolean isForge() {
		return forge;
	}
	public void setForge(boolean forge) {
		this.forge = forge;
	}
	public boolean isPlantation() {
		return plantation;
	}
	public void setPlantation(boolean plantation) {
		this.plantation = plantation;
	}
	public boolean isGreatLibrary() {
		return greatLibrary;
	}
	public void setGreatLibrary(boolean greatLibrary) {
		this.greatLibrary = greatLibrary;
	}
	public boolean isLargeMarket() {
		return largeMarket;
	}
	public void setLargeMarket(boolean largeMarket) {
		this.largeMarket = largeMarket;
	}
	public int getProductionTurn() {
		return productionTurn;
	}
	public void setProductionTurn(int productionTurn) {
		this.productionTurn = productionTurn;
	}
	public int getPopulationTurn() {
		return populationTurn;
	}
	public void setPopulationTurn(int populationTurn) {
		this.populationTurn = populationTurn;
	}
	public int getTechnologyTurn() {
		return technologyTurn;
	}
	public void setTechnologyTurn(int technologyTurn) {
		this.technologyTurn = technologyTurn;
	}
	public int getMoneyTurn() {
		return moneyTurn;
	}
	public void setMoneyTurn(int moneyTurn) {
		this.moneyTurn = moneyTurn;
	}
	public boolean isLevel3() {
		return level3;
	}
	public void setLevel3(boolean level3) {
		this.level3 = level3;
	}
	public boolean isLevel4() {
		return level4;
	}
	public void setLevel4(boolean level4) {
		this.level4 = level4;
	}
	public boolean isLevel5() {
		return level5;
	}
	public void setLevel5(boolean level5) {
		this.level5 = level5;
	}
	public boolean isLevel6() {
		return level6;
	}
	public void setLevel6(boolean level6) {
		this.level6 = level6;
	}
	public boolean isLevel7() {
		return level7;
	}
	public void setLevel7(boolean level7) {
		this.level7 = level7;
	}
	public boolean isLevel1() {
		return level1;
	}
	public void setLevel1(boolean level1) {
		this.level1 = level1;
	}
	public boolean isLevel2() {
		return level2;
	}
	public void setLevel2(boolean level2) {
		this.level2 = level2;
	}
	public int getNationLevel() {
		return nationLevel;
	}
	public void setNationLevel(int nationLevel) {
		this.nationLevel = nationLevel;
	}
	public boolean isHasWorkshop() {
		return hasWorkshop;
	}
	public void setHasWorkshop(boolean hasWorkshop) {
		this.hasWorkshop = hasWorkshop;
	}
	public boolean isHasBasicFarm() {
		return hasBasicFarm;
	}
	public void setHasBasicFarm(boolean hasBasicFarm) {
		this.hasBasicFarm = hasBasicFarm;
	}
	public boolean isHasMarket() {
		return hasMarket;
	}
	public void setHasMarket(boolean hasMarket) {
		this.hasMarket = hasMarket;
	}
	public int getPopulationLimit() {
		return populationLimit;
	}
	public void setPopulationLimit(int populationLimit) {
		this.populationLimit = populationLimit;
	}
	public boolean isHasLibrary() {
		return hasLibrary;
	}
	public void setHasLibrary(boolean hasLibrary) {
		this.hasLibrary = hasLibrary;
	}
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
		if(population<=populationLimit) {
			this.population = population;
		}
		else {
			this.population = populationLimit;
		}
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
