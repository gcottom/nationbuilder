package com.gagecottom.nationbuilder.improvements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.gagecottom.nationbuilder.model.User;
import com.gagecottom.nationbuilder.nation.Nation;
import com.gagecottom.nationbuilder.service.NationService;
import com.gagecottom.nationbuilder.service.UserService;
@Controller
public class BuildMarketController {
@Autowired
private UserService userService;
@Autowired
private NationService nationService;
@GetMapping("/buildMarket")
public String editResources(Model model) {
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
	model.addAttribute("nation", nation);
	CanBuild canBuild = new CanBuild();
	if(nation.getMoney()>=500&&nation.getProduction()>=50&&nation.getTechnology()>=25&&nation.isHasMarket()==false) {
		canBuild.setCanBuild(true);
	}
	model.addAttribute("canBuild", canBuild);
	return "buildMarket";
}

@GetMapping ("/buildMarket-gc23")
public String editResources(@ModelAttribute("nation") Nation nNation) {
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
	nation.setHasMarket(true);
	nation.setProduction(nation.getProduction()-50);
	nation.setMoney(nation.getMoney()-500);
	nation.setTechnology(nation.getTechnology()-25);
	nationService.createNation(nation);
	return "redirect:/user";
}
}