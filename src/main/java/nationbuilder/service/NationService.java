package nationbuilder.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nationbuilder.nation.Nation;
import nationbuilder.repository.NationRepository;

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
	String newNationName = nationName.get();
	int NewNationId= nationId.get();
	int newTechnology = technology.get();
	int newMoney = money.get();
	String newNationCapitol = nationCapitol.get();
	String newGovernment = government.get();
	String newResource1 = resource1.get();
	String newResource2 = resource2.get();
	String newResource3 = resource3.get();
	String newResource4 = resource4.get();
	newNation.setId(NewNationId);
	newNation.setMoney(newMoney);
	newNation.setTechnology(newTechnology);
	newNation.setNationName(newNationName);
	newNation.setNationCapitol(newNationCapitol);
	newNation.setGovernment(newGovernment);
	newNation.setResource1(newResource1);
	newNation.setResource2(newResource2);
	newNation.setResource3(newResource3);
	newNation.setResource4(newResource4);
	return newNation;
}
public void deleteNation(Nation nation) {
	nationRepository.delete(nation);
}
}
