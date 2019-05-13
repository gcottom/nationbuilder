package com.gagecottom.nationbuilder.nation;

import java.net.URL;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Nation {
	@Id
	private int id;
	private String rulerName;
	private URL link;
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
	private boolean bank= false;
	private boolean college = false;
	private boolean cropRotation = false;
	private boolean advancedWorkshop = false;
	private boolean researchLab = false;
	private boolean harbor = false;
	private boolean advancedFarming=false;
	private boolean advancedForge = false;
	private boolean factory = false;
	private boolean advancedPlantation = false;
	private boolean university = false;
	private boolean stockExchange = false;
	private boolean industryArea = false;
	private boolean agricultureArea = false;
	private boolean campusArea = false;
	private boolean commercialArea =false;
	private boolean warehouse = false;
	private boolean corporateFarming = false;
	private boolean governmentGrants =false;
	private boolean federalReserve = false;
	private boolean atWar= false;
	private int atWarWith = 0;
	private int troops = 0;
	private boolean beer = false;
	private boolean fastFood = false;
	private boolean fossilFuels = false;
	private boolean nuclearPower = false;
	private boolean preciousMetals = false;
	private boolean cashCrops = false;
	private boolean nuclearReactor = false;
	
	
	
	public boolean isNuclearReactor() {
		return nuclearReactor;
	}
	public void setNuclearReactor(boolean nuclearReactor) {
		this.nuclearReactor = nuclearReactor;
	}
	public boolean isBeer() {
		return beer;
	}
	public void setBeer(boolean beer) {
		this.beer = beer;
	}
	public boolean isFastFood() {
		return fastFood;
	}
	public void setFastFood(boolean fastFood) {
		this.fastFood = fastFood;
	}
	public boolean isFossilFuels() {
		return fossilFuels;
	}
	public void setFossilFuels(boolean fossilFuels) {
		this.fossilFuels = fossilFuels;
	}
	public boolean isNuclearPower() {
		return nuclearPower;
	}
	public void setNuclearPower(boolean nuclearPower) {
		this.nuclearPower = nuclearPower;
	}
	public boolean isPreciousMetals() {
		return preciousMetals;
	}
	public void setPreciousMetals(boolean preciousMetals) {
		this.preciousMetals = preciousMetals;
	}
	public boolean isCashCrops() {
		return cashCrops;
	}
	public void setCashCrops(boolean cashCrops) {
		this.cashCrops = cashCrops;
	}
	public int getTroops() {
		return troops;
	}
	public void setTroops(int troops) {
		this.troops = troops;
	}
	public boolean isAtWar() {
		return atWar;
	}
	public void setAtWar(boolean atWar) {
		this.atWar = atWar;
	}
	public int getAtWarWith() {
		return atWarWith;
	}
	public void setAtWarWith(int atWarWith) {
		this.atWarWith = atWarWith;
	}
	public boolean isFactory() {
		return factory;
	}
	public void setFactory(boolean factory) {
		this.factory = factory;
	}
	public boolean isAdvancedPlantation() {
		return advancedPlantation;
	}
	public void setAdvancedPlantation(boolean advancedPlantation) {
		this.advancedPlantation = advancedPlantation;
	}
	public boolean isUniversity() {
		return university;
	}
	public void setUniversity(boolean university) {
		this.university = university;
	}
	public boolean isStockExchange() {
		return stockExchange;
	}
	public void setStockExchange(boolean stockExchange) {
		this.stockExchange = stockExchange;
	}
	public boolean isIndustryArea() {
		return industryArea;
	}
	public void setIndustryArea(boolean industryArea) {
		this.industryArea = industryArea;
	}
	public boolean isAgricultureArea() {
		return agricultureArea;
	}
	public void setAgricultureArea(boolean agricultureArea) {
		this.agricultureArea = agricultureArea;
	}
	public boolean isCampusArea() {
		return campusArea;
	}
	public void setCampusArea(boolean campusArea) {
		this.campusArea = campusArea;
	}
	public boolean isCommercialArea() {
		return commercialArea;
	}
	public void setCommercialArea(boolean commercialArea) {
		this.commercialArea = commercialArea;
	}
	public boolean isWarehouse() {
		return warehouse;
	}
	public void setWarehouse(boolean warehouse) {
		this.warehouse = warehouse;
	}
	public boolean isCorporateFarming() {
		return corporateFarming;
	}
	public void setCorporateFarming(boolean corporateFarming) {
		this.corporateFarming = corporateFarming;
	}
	public boolean isGovernmentGrants() {
		return governmentGrants;
	}
	public void setGovernmentGrants(boolean governmentGrants) {
		this.governmentGrants = governmentGrants;
	}
	public boolean isFederalReserve() {
		return federalReserve;
	}
	public void setFederalReserve(boolean federalReserve) {
		this.federalReserve = federalReserve;
	}
	public boolean isBank() {
		return bank;
	}
	public void setBank(boolean bank) {
		this.bank = bank;
	}
	public boolean isCollege() {
		return college;
	}
	public void setCollege(boolean college) {
		this.college = college;
	}
	public boolean isCropRotation() {
		return cropRotation;
	}
	public void setCropRotation(boolean cropRotation) {
		this.cropRotation = cropRotation;
	}
	public boolean isAdvancedWorkshop() {
		return advancedWorkshop;
	}
	public void setAdvancedWorkshop(boolean advancedWorkshop) {
		this.advancedWorkshop = advancedWorkshop;
	}
	public boolean isResearchLab() {
		return researchLab;
	}
	public void setResearchLab(boolean researchLab) {
		this.researchLab = researchLab;
	}
	public boolean isHarbor() {
		return harbor;
	}
	public void setHarbor(boolean harbor) {
		this.harbor = harbor;
	}
	public boolean isAdvancedFarming() {
		return advancedFarming;
	}
	public void setAdvancedFarming(boolean advancedFarming) {
		this.advancedFarming = advancedFarming;
	}
	public boolean isAdvancedForge() {
		return advancedForge;
	}
	public void setAdvancedForge(boolean advancedForge) {
		this.advancedForge = advancedForge;
	}
	public String getRulerName() {
		return rulerName;
	}
	public void setRulerName(String rulerName) {
		this.rulerName = rulerName;
	}
	public URL getLink() {
		return link;
	}
	public void setLink(URL link) {
		this.link = link;
	}
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
