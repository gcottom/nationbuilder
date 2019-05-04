package com.gagecottom.nationbuilder.war;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.gagecottom.nationbuilder.model.User;
import com.gagecottom.nationbuilder.nation.Nation;
import com.gagecottom.nationbuilder.service.NationService;
import com.gagecottom.nationbuilder.service.UserService;

@Controller
public class AttackController {
	@Autowired
	UserService userService;
	@Autowired
	NationService nationService;
@GetMapping("/attack-{id}")
public String attack(@PathVariable ("id") int id, Model model) {
	int troops = 0;
	Nation nation = new Nation();
	String username;
	Object principal =SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	if (principal instanceof UserDetails) {
		   username = ((UserDetails)principal).getUsername();
		} else {
		   username = principal.toString();
		}
	
	User user=userService.findByUsername(username);
	nation =nationService.findNationById(user.getId());
	troops = nation.getTroops();
	int deployTroops= (int) (troops*.9);
	model.addAttribute("nation", nation);
	model.addAttribute("troops", troops);
	model.addAttribute("recTroops", deployTroops);
	return "attack";
}
@PostMapping("attackCheck")
	public String attackCheck(@ModelAttribute ("troops") Integer troops, Model model) {
	Nation nation = new Nation();
	String username;
	Object principal =SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	if (principal instanceof UserDetails) {
		   username = ((UserDetails)principal).getUsername();
		} else {
		   username = principal.toString();
		}
	User user=userService.findByUsername(username);
	nation =nationService.findNationById(user.getId());
	String message;
	if(nation.isAtWar()&& troops<=nation.getTroops()&&troops>0) {
		message="<a href=\"/attack-gc23-"+troops+"\">Confirm</a>";
		}
	else {
		message="Not enough troops, not at war, or negative troops selected";
	}
	model.addAttribute("troops", troops);
	model.addAttribute("nation", nation);

	model.addAttribute("message", message);
	return "attackCheck";
	
}
@GetMapping("attack-gc23-{id}")
public String attackApproved(@PathVariable("id") int id, Model model) {
	Nation nation = new Nation();
	String username;
	Object principal =SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	if (principal instanceof UserDetails) {
		   username = ((UserDetails)principal).getUsername();
		} else {
		   username = principal.toString();
		}
	User user=userService.findByUsername(username);
	nation =nationService.findNationById(user.getId());
	
	Nation enemy = nationService.findNationById(nation.getAtWarWith());
	String message;
	if(enemy.getTroops()==0) {
		nation.setMoney(enemy.getMoney()+nation.getMoney());
		nation.setProduction(enemy.getProduction()+nation.getProduction());
		nation.setTechnology(enemy.getTechnology()+nation.getTechnology());
		message = "You gained: Money: "+enemy.getMoney()+"<br>Production:"+enemy.getProduction()+"<br>Technology:"+enemy.getTechnology(); 
		enemy.setTechnology(0);
		enemy.setProduction(0);
		enemy.setMoney(0);
		enemy.setPopulation(100);
		
		model.addAttribute("message", message);
	}
	
	else if(enemy.getTroops()>0) {
		double random = Math.random();
			int troopLoss=(int) (nation.getTroops()-(nation.getTroops()*random));
			nation.setTroops((int) (nation.getTroops()-troopLoss));
			random = Math.random();
			int enemyLoss = (int) (enemy.getTroops()-(enemy.getTroops()*random));
			enemy.setTroops((int) (enemy.getTroops()-enemyLoss));
			
			message="You lost:"+troopLoss+" troops.<br>Enemy lost:"+enemyLoss+" troops";
			model.addAttribute("message", message);
		
	}
	nationService.createNation(nation);
	nationService.createNation(enemy);
	return "attackResult";
}
}
