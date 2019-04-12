package com.gagecottom.nationbuilder.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gagecottom.nationbuilder.nation.Nation;
import com.gagecottom.nationbuilder.repository.NationRepository;

@Service
public class NationService {
@Autowired
private NationRepository nationRepository;
public void createNation(Nation nation) {
	nationRepository.save(nation);
}
public Nation findNationById(int id) {
	Nation newNation = new Nation();
	
	Optional<Nation> nation = nationRepository.findById(id);
	Optional<Integer> nationId = nation.map(Nation::getId);
	Optional<Integer> money = nation.map(Nation::getMoney);
	Optional<Integer> technology = nation.map(Nation::getTechnology);
	Optional<String> nationName = nation.map(Nation::getNationName);
	Optional<String> nationCapitol = nation.map(Nation::getNationCapitol);
	Optional<String> government = nation.map(Nation::getGovernment);
	Optional<String> resource1 = nation.map(Nation::getResource1);
	Optional<String> resource2 = nation.map(Nation::getResource2);
	Optional<String> resource3 = nation.map(Nation::getResource3);
	Optional<String> resource4 = nation.map(Nation::getResource4);
	Optional<Integer> population = nation.map(Nation::getPopulation);
	Optional<Integer> production = nation.map(Nation::getProduction);
	Optional<Boolean> hasLibrary= nation.map(Nation::isHasLibrary);
	Optional<Integer> populationLimit = nation.map(Nation::getPopulationLimit);
	Optional<Boolean> hasMarket = nation.map(Nation::isHasMarket);
	Optional<Boolean> hasBasicFarm = nation.map(Nation::isHasBasicFarm);
	Optional<Boolean> hasWorkshop = nation.map(Nation::isHasWorkshop);
	Optional<Integer> nationLevel = nation.map(Nation::getNationLevel);
	Optional<Boolean> level1 = nation.map(Nation::isLevel1);
	Optional<Boolean> level2 = nation.map(Nation::isLevel2);
	Optional<Boolean> level3 = nation.map(Nation::isLevel3);
	Optional<Boolean> level4 = nation.map(Nation::isLevel4);
	Optional<Boolean> level5 = nation.map(Nation::isLevel5);
	Optional<Boolean> level6 = nation.map(Nation::isLevel6);
	Optional<Integer> productionTurn = nation.map(Nation::getProductionTurn);
	Optional<Integer> populationTurn = nation.map(Nation::getPopulationTurn);
	Optional<Integer> technologyTurn = nation.map(Nation::getTechnologyTurn);
	Optional<Integer> moneyTurn = nation.map(Nation::getMoneyTurn);
	Optional<Boolean> forge= nation.map(Nation::isForge);
	Optional<Boolean> largeMarket = nation.map(Nation::isLargeMarket);
	Optional<Boolean> plantation = nation.map(Nation::isPlantation);
	Optional<Boolean> greatLibrary = nation.map(Nation::isGreatLibrary);
	boolean hasForge = forge.get();
	boolean hasLargeMarket = largeMarket.get();
	boolean hasPlantation = plantation.get();
	boolean hasGreatLibrary = greatLibrary.get();
	int newProdTurn = productionTurn.get();
	int newTechTurn = technologyTurn.get();
	int newPopTurn = populationTurn.get();
	int newMoneyTurn = moneyTurn.get();
	boolean newLevel1 = level1.get();
	boolean newLevel2 = level2.get();
	boolean newLevel3 = level3.get();
	boolean newLevel4 = level4.get();
	boolean newLevel5 = level5.get();
	boolean newLevel6 = level6.get();
	int newNationLevel = nationLevel.get();
	boolean newHasBasicFarm = hasBasicFarm.get();
	boolean newHasWorkshop = hasWorkshop.get();
	boolean newHasMarket= hasMarket.get();
	int newPopulationLimit = populationLimit.get();
	boolean newHasLibrary = hasLibrary.get();
	int newProduction = production.get();
	String newNationName = nationName.get();
	int NewNationId= nationId.get();
	int newTechnology = technology.get();
	int newMoney = money.get();
	int newPopulation = population.get();
	String newNationCapitol = nationCapitol.get();
	String newGovernment = government.get();
	String newResource1 = resource1.get();
	String newResource2 = resource2.get();
	String newResource3 = resource3.get();
	String newResource4 = resource4.get();
	newNation.setPopulationLimit(newPopulationLimit);
	newNation.setProduction(newProduction);
	newNation.setId(NewNationId);
	newNation.setMoney(newMoney);
	newNation.setPopulation(newPopulation);
	newNation.setTechnology(newTechnology);
	newNation.setNationName(newNationName);
	newNation.setNationCapitol(newNationCapitol);
	newNation.setGovernment(newGovernment);
	newNation.setResource1(newResource1);
	newNation.setResource2(newResource2);
	newNation.setResource3(newResource3);
	newNation.setResource4(newResource4);
	newNation.setHasLibrary(newHasLibrary);
	newNation.setHasMarket(newHasMarket);
	newNation.setHasBasicFarm(newHasBasicFarm);
	newNation.setHasWorkshop(newHasWorkshop);
	newNation.setNationLevel(newNationLevel);
	newNation.setLevel1(newLevel1);
	newNation.setLevel2(newLevel2);
	newNation.setLevel3(newLevel3);
	newNation.setLevel4(newLevel4);
	newNation.setLevel5(newLevel5);
	newNation.setLevel6(newLevel6);
	newNation.setPopulationTurn(newPopTurn);
	newNation.setTechnologyTurn(newTechTurn);
	newNation.setMoneyTurn(newMoneyTurn);
	newNation.setProductionTurn(newProdTurn);
	newNation.setForge(hasForge);
	newNation.setGreatLibrary(hasGreatLibrary);
	newNation.setLargeMarket(hasLargeMarket);
	newNation.setPlantation(hasPlantation);
	return newNation;
}
public void deleteNation(Nation nation) {
	nationRepository.delete(nation);
}
public List<Nation> listAllNations(){
	List<Nation> nations = new ArrayList<>();	
	nationRepository.findAll().forEach(nations::add);
			return nations;
}
}
