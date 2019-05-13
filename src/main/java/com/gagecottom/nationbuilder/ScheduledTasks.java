package com.gagecottom.nationbuilder;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.gagecottom.nationbuilder.nation.Nation;
import com.gagecottom.nationbuilder.service.NationService;
import com.gagecottom.nationbuilder.service.TurnService;
import com.gagecottom.nationbuilder.service.WarService;
import com.gagecottom.nationbuilder.simulation.ResourceSet;
import com.gagecottom.nationbuilder.simulation.Turn;
import com.gagecottom.nationbuilder.war.WarDeclaration;

import java.util.ArrayList;
import java.util.List;

@Component
public class ScheduledTasks {
	@Autowired
	TurnService turnService;
	public static int turn =0;
	@Autowired
	WarService warService;
	@Autowired
	NationService nationService;
    @Scheduled(fixedRate =5000)
    public void Simulate() {
    	if(turnService.existsById(1)==false) {
    		System.out.print("Turn Not Found In DB");
    	Turn nTurn = new Turn();
    	nTurn.setTurn(turn);
    	nTurn.setId(1);
    	turnService.saveTurn(nTurn);
    	}
    	else {
    		turn = turnService.findById(1).getTurn();
    	}
    	List<Nation> nations = new ArrayList<Nation>();
		Nation currentNation= new Nation();
		
		nationService.listAllNations().forEach(nations::add);
		for(int i=0; i<nations.size(); i++) {
			ResourceSet resources = new ResourceSet();
			currentNation=nations.get(i);
			//add regular turn incentives
			resources.setMoney(resources.getMoney()+1);
			resources.setTechnology(resources.getTechnology()+1);
			resources.setPopulation(resources.getPopulation()+1);
			resources.setProduction(resources.getProduction()+1);
		
			
			//Government Bonus
			if(currentNation.getGovernment().equals("Democracy")) {
				resources.setMoney(resources.getMoney()+4);
				resources.setPopulation(resources.getPopulation()+1);
				resources.setProduction(resources.getProduction()+1);
			}
			if(currentNation.getGovernment().equals("Monarchy")) {
				resources.setMoney(resources.getMoney()+3);
				resources.setPopulation(resources.getPopulation()+2);
				resources.setProduction(resources.getProduction()+1);
			}
			if(currentNation.getGovernment().equals("Communism")) {
				resources.setMoney(resources.getMoney()+2);
				resources.setPopulation(resources.getPopulation()+2);
				resources.setProduction(resources.getProduction()+2);
			}
			if(currentNation.getGovernment().equals("Republic")) {
				resources.setMoney(resources.getMoney()+3);
				resources.setPopulation(resources.getPopulation()+1);
				resources.setProduction(resources.getProduction()+2);
			}
			
			
			//improvement yields
			if(currentNation.isHasLibrary()) {
				resources.setTechnology(resources.getTechnology()+3);
			}
			if(currentNation.isHasMarket()) {
				resources.setMoney(resources.getMoney()+3);
			}
			if(currentNation.isHasBasicFarm()) {
				resources.setPopulation(resources.getPopulation()+3);
			}
			if(currentNation.isHasWorkshop()) {
				resources.setProduction(resources.getProduction()+3);
			}
			//improvement yields level 2
			if(currentNation.isGreatLibrary()) {
				resources.setTechnology(resources.getTechnology()+5);
			}
			if(currentNation.isLargeMarket()) {
				resources.setMoney(resources.getMoney()+5);
			}
			if(currentNation.isPlantation()) {
				resources.setPopulation(resources.getPopulation()+5);
			}
			if(currentNation.isForge()) {
				resources.setProduction(resources.getProduction()+5);
			}
			//improvement yields level 3
			if(currentNation.isCollege()) {
				resources.setTechnology(resources.getTechnology()+5);
			}
			if(currentNation.isBank()) {
				resources.setMoney(resources.getMoney()+5);
			}
			if(currentNation.isCropRotation()) {
				resources.setPopulation(resources.getPopulation()+5);
			}
			if(currentNation.isAdvancedWorkshop()) {
				resources.setProduction(resources.getProduction()+5);
			}
			//improvement yields level 4
			if(currentNation.isResearchLab()) {
				resources.setTechnology(resources.getTechnology()+7);
			}
			if(currentNation.isHarbor()) {
				resources.setMoney(resources.getMoney()+7);
			}
			if(currentNation.isAdvancedFarming()) {
				resources.setPopulation(resources.getPopulation()+7);
			}
			if(currentNation.isAdvancedForge()) {
				resources.setProduction(resources.getProduction()+7);
			}
			//resource yields
			if(currentNation.getResource1().equals("Gold")) {
				resources.setMoney(resources.getMoney()+5);
			}
			if(currentNation.getResource2().equals("Gold")) {
				resources.setMoney(resources.getMoney()+5);
			}
			if(currentNation.getResource3().equals("Gold")) {
				resources.setMoney(resources.getMoney()+5);
			}
			if(currentNation.getResource4().equals("Gold")) {
				resources.setMoney(resources.getMoney()+5);
			}
			
			
			if(currentNation.getResource1().equals("Water")) {
				resources.setPopulation(resources.getPopulation()+3);
			}
			if(currentNation.getResource2().equals("Water")) {
				resources.setPopulation(resources.getPopulation()+3);
			}
			if(currentNation.getResource3().equals("Water")) {
				resources.setPopulation(resources.getPopulation()+3);
			}
			if(currentNation.getResource4().equals("Water")) {
				resources.setPopulation(resources.getPopulation()+3);
			}
			
			
			if(currentNation.getResource1().equals("Wheat")) {
				resources.setPopulation(resources.getPopulation()+2);
			}
			if(currentNation.getResource2().equals("Wheat")) {
				resources.setPopulation(resources.getPopulation()+2);
			}
			if(currentNation.getResource3().equals("Wheat")) {
				resources.setPopulation(resources.getPopulation()+2);
			}
			if(currentNation.getResource4().equals("Wheat")) {
				resources.setPopulation(resources.getPopulation()+2);
			}
			
			
			if(currentNation.getResource1().equals("Coal")) {
				resources.setProduction(resources.getProduction()+2);
			}
			if(currentNation.getResource2().equals("Coal")) {
				resources.setProduction(resources.getProduction()+2);
			}
			if(currentNation.getResource3().equals("Coal")) {
				resources.setProduction(resources.getProduction()+2);
			}
			if(currentNation.getResource4().equals("Coal")) {
				resources.setProduction(resources.getProduction()+2);
			}
			
			if(currentNation.getResource1().equals("Oil")) {
				resources.setProduction(resources.getProduction()+2);
			}
			if(currentNation.getResource2().equals("Oil")) {
				resources.setProduction(resources.getProduction()+2);
			}
			if(currentNation.getResource3().equals("Oil")) {
				resources.setProduction(resources.getProduction()+2);
			}
			if(currentNation.getResource4().equals("Oil")) {
				resources.setProduction(resources.getProduction()+2);
			}
			
			if(currentNation.getResource1().equals("Uranium")) {
				resources.setProduction(resources.getProduction()+1);
			}
			if(currentNation.getResource2().equals("Uranium")) {
				resources.setProduction(resources.getProduction()+1);
			}
			if(currentNation.getResource3().equals("Uranium")) {
				resources.setProduction(resources.getProduction()+1);
			}
			if(currentNation.getResource4().equals("Uranium")) {
				resources.setProduction(resources.getProduction()+1);
			}
			
			if(currentNation.getResource1().equals("Meat")) {
				resources.setPopulation(resources.getPopulation()+2);
			}
			if(currentNation.getResource2().equals("Meat")) {
				resources.setPopulation(resources.getPopulation()+2);
			}
			if(currentNation.getResource3().equals("Meat")) {
				resources.setPopulation(resources.getPopulation()+2);
			}
			if(currentNation.getResource4().equals("Meat")) {
				resources.setPopulation(resources.getPopulation()+2);
			}
			if(currentNation.getResource1().equals("Silver")) {
				resources.setMoney(resources.getMoney()+3);
			}
			if(currentNation.getResource2().equals("Silver")) {
				resources.setMoney(resources.getMoney()+3);
			}
			if(currentNation.getResource3().equals("Silver")) {
				resources.setMoney(resources.getMoney()+3);
			}
			if(currentNation.getResource4().equals("Silver")) {
				resources.setMoney(resources.getMoney()+3);
			}
			if(currentNation.getResource1().equals("Cotton")) {
				resources.setProduction(resources.getProduction()+2);
			}
			if(currentNation.getResource2().equals("Cotton")) {
				resources.setProduction(resources.getProduction()+2);
			}
			if(currentNation.getResource3().equals("Cotton")) {
				resources.setProduction(resources.getProduction()+2);
			}
			if(currentNation.getResource4().equals("Cotton")) {
				resources.setProduction(resources.getProduction()+2);
			}
			if(currentNation.getResource1().equals("Wood")) {
				resources.setProduction(resources.getProduction()+3);
			}
			if(currentNation.getResource2().equals("Wood")) {
				resources.setProduction(resources.getProduction()+3);
			}
			if(currentNation.getResource3().equals("Wood")) {
				resources.setProduction(resources.getProduction()+3);
			}
			if(currentNation.getResource4().equals("Wood")) {
				resources.setProduction(resources.getProduction()+3);
			}
			
			//calculate bonus resources
			if((currentNation.getResource1().equals("Water")||currentNation.getResource2().equals("Water")||currentNation.getResource3().equals("Water")||currentNation.getResource4().equals("Water"))&&(currentNation.getResource1().equals("Wheat")||currentNation.getResource2().equals("Wheat")||currentNation.getResource3().equals("Wheat")||currentNation.getResource4().equals("Wheat"))){
				currentNation.setBeer(true);
				}
			else {
				currentNation.setBeer(false);
			}
			if((currentNation.getResource1().equals("Water")||currentNation.getResource2().equals("Water")||currentNation.getResource3().equals("Water")||currentNation.getResource4().equals("Water"))&&(currentNation.getResource1().equals("Wheat")||currentNation.getResource2().equals("Wheat")||currentNation.getResource3().equals("Wheat")||currentNation.getResource4().equals("Wheat"))&&(currentNation.getResource1().equals("Meat")||currentNation.getResource2().equals("Meat")||currentNation.getResource3().equals("Meat")||currentNation.getResource4().equals("Meat"))){
				currentNation.setFastFood(true);
				}
			else {
				currentNation.setFastFood(false);
			}
			if((currentNation.getResource1().equals("Coal")||currentNation.getResource2().equals("Coal")||currentNation.getResource3().equals("Coal")||currentNation.getResource4().equals("Coal"))&&(currentNation.getResource1().equals("Oil")||currentNation.getResource2().equals("Oil")||currentNation.getResource3().equals("Oil")||currentNation.getResource4().equals("Oil"))){
				currentNation.setFossilFuels(true);
				}
			else {
				currentNation.setFossilFuels(false);
			}
			if((currentNation.getResource1().equals("Gold")||currentNation.getResource2().equals("Gold")||currentNation.getResource3().equals("Gold")||currentNation.getResource4().equals("Gold"))&&(currentNation.getResource1().equals("Silver")||currentNation.getResource2().equals("Silver")||currentNation.getResource3().equals("Silver")||currentNation.getResource4().equals("Silver"))){
				currentNation.setPreciousMetals(true);
				}
			else {
				currentNation.setPreciousMetals(false);
			}
			if((currentNation.getResource1().equals("Wheat")||currentNation.getResource2().equals("Wheat")||currentNation.getResource3().equals("Wheat")||currentNation.getResource4().equals("Wheat"))&&(currentNation.getResource1().equals("Cotton")||currentNation.getResource2().equals("Cotton")||currentNation.getResource3().equals("Cotton")||currentNation.getResource4().equals("Cotton"))&&(currentNation.getResource1().equals("Wood")||currentNation.getResource2().equals("Wood")||currentNation.getResource3().equals("Wood")||currentNation.getResource4().equals("Wood"))){
				currentNation.setCashCrops(true);
				}
			else {
				currentNation.setCashCrops(false);
			}
			if((currentNation.getResource1().equals("Uranium")||currentNation.getResource2().equals("Uranium")||currentNation.getResource3().equals("Uranium")||currentNation.getResource4().equals("Uranium"))&&currentNation.isNuclearReactor()) {
				currentNation.setNuclearPower(true);
			}
			else {
				currentNation.setNuclearPower(false);
			}
			if(currentNation.isBeer()) {
				resources.setMoney(resources.getMoney()+4);
				resources.setProduction(resources.getProduction()+2);
				resources.setPopulation(resources.getPopulation()+2);
			}
			if(currentNation.isFastFood()) {
				resources.setMoney(resources.getMoney()+6);
				resources.setProduction(resources.getProduction()+3);
				resources.setPopulation(resources.getPopulation()+3);
			}
			if(currentNation.isFossilFuels()) {
				resources.setMoney(resources.getMoney()+5);
				resources.setProduction(resources.getProduction()+5);
			}
			if(currentNation.isPreciousMetals()) {
				resources.setMoney(resources.getMoney()+7);
				resources.setProduction(resources.getProduction()+3);
			}
			if(currentNation.isCashCrops()) {
				resources.setMoney(resources.getMoney()+5);
				resources.setProduction(resources.getProduction()+3);
				resources.setPopulation(resources.getPopulation()+2);
			}
			if(currentNation.isNuclearPower()) {
				resources.setMoney(resources.getMoney()+10);
				resources.setProduction(resources.getProduction()+5);
				resources.setTechnology(resources.getTechnology()+1);
			}
			currentNation.setMoney(currentNation.getMoney()+resources.getMoney());
			currentNation.setTechnology(currentNation.getTechnology()+resources.getTechnology());
			currentNation.setPopulation(currentNation.getPopulation()+resources.getPopulation());
			currentNation.setProduction(currentNation.getProduction()+resources.getProduction());
			currentNation.setMoneyTurn(resources.getMoney());
			currentNation.setTechnologyTurn(resources.getTechnology());
			currentNation.setPopulationTurn(resources.getPopulation());
			currentNation.setProductionTurn(resources.getProduction());
			nationService.createNation(currentNation);
			if(warService.getWarByNationId(currentNation.getId()).getEndTurn()==turn){
				WarDeclaration war = new WarDeclaration();
				war =warService.getWarByNationId(currentNation.getId());
				Nation otherNation = new Nation();
				if(war.getId()!=0) {
					war.setActive(false);
					otherNation = nationService.findNationById(war.getInitiatorId());
					otherNation.setAtWar(false);
					otherNation.setAtWarWith(0);
					nationService.createNation(otherNation);
					otherNation = nationService.findNationById(war.getTargetId());
					otherNation.setAtWar(false);
					otherNation.setAtWarWith(0);
					nationService.createNation(otherNation);	
					}}
				}
		turn++;
		Turn mTurn = new Turn();
		mTurn.setId(1);
		mTurn.setTurn(turn);
		turnService.saveTurn(mTurn);
    }
}