package com.gagecottom.nationbuilder.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gagecottom.nationbuilder.repository.WarRepository;
import com.gagecottom.nationbuilder.war.WarDeclaration;

@Service
public class WarService {
@Autowired
WarRepository warRepository;
public void saveWar(WarDeclaration war) {
	warRepository.save(war);
}
public WarDeclaration getWarByNationId(int id) {
	List<WarDeclaration> wars= new ArrayList<WarDeclaration>();
	warRepository.findAll().forEach(wars::add);
	WarDeclaration war = new WarDeclaration();
	for(int i = 0; i<wars.size(); i++) {
		
		war =wars.get(i);
		if(war.getInitiatorId()==id||war.getTargetId()==id&&war.isActive()) {
			return war;
		}
	}
	war= new WarDeclaration();
	return war;
	
}
public List<WarDeclaration> getAllWars(){
	List<WarDeclaration> wars = new ArrayList<WarDeclaration>();
	warRepository.findAll().forEach(wars::add);
	
	return wars;
	
}
public void deleteAll() {
	warRepository.deleteAll();
}
}
