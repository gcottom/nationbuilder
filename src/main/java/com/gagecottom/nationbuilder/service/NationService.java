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
