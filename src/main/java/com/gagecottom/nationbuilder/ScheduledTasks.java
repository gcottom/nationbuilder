package com.gagecottom.nationbuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.gagecottom.nationbuilder.nation.Nation;
import com.gagecottom.nationbuilder.service.NationService;
import com.gagecottom.nationbuilder.simulation.ResourceSet;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
public class ScheduledTasks {
	@Autowired
	NationService nationService = new NationService();
    private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    @Scheduled(fixedRate =30000)
    public void Simulate() {
    	List<Nation> nations = new ArrayList<Nation>();
		Nation currentNation= new Nation();
		
		nationService.listAllNations().forEach(nations::add);
		for(int i=0; i<nations.size(); i++) {
			currentNation=nations.get(i);
			//add regular turn incentives
			currentNation.setMoney(currentNation.getMoney()+1);
			currentNation.setTechnology(currentNation.getTechnology()+1);
			currentNation.setPopulation(currentNation.getPopulation()+1);
			currentNation.setProduction(currentNation.getProduction()+1);
		
			ResourceSet resources = new ResourceSet();
			
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
				resources.setPopulation(resources.getPopulation()+2);
			}
			if(currentNation.getResource2().equals("Water")) {
				resources.setPopulation(resources.getPopulation()+2);
			}
			if(currentNation.getResource3().equals("Water")) {
				resources.setPopulation(resources.getPopulation()+2);
			}
			if(currentNation.getResource4().equals("Water")) {
				resources.setPopulation(resources.getPopulation()+2);
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
			currentNation.setMoney(currentNation.getMoney()+resources.getMoney());
			currentNation.setTechnology(currentNation.getTechnology()+resources.getTechnology());
			currentNation.setPopulation(currentNation.getPopulation()+resources.getPopulation());
			currentNation.setProduction(currentNation.getProduction()+resources.getProduction());
			nationService.createNation(currentNation);
		}
		
    }
    public void scheduleTaskWithFixedRate() {}

    public void scheduleTaskWithFixedDelay() {}

    public void scheduleTaskWithInitialDelay() {}

    public void scheduleTaskWithCronExpression() {}
}