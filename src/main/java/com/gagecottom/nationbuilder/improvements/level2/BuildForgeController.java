package com.gagecottom.nationbuilder.improvements.level2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.gagecottom.nationbuilder.improvements.CanBuild;
import com.gagecottom.nationbuilder.model.User;
import com.gagecottom.nationbuilder.nation.Nation;
import com.gagecottom.nationbuilder.service.NationService;
import com.gagecottom.nationbuilder.service.UserService;
@Controller
public class BuildForgeController {
	@Autowired
	private UserService userService;
	@Autowired
	private NationService nationService;
	@GetMapping("/buildForge")
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
    	if(nation.getMoney()>=1000&&nation.getProduction()>=250&&nation.getTechnology()>=100&&nation.isForge()==false) {
    		canBuild.setCanBuild(true);
    	}
    	model.addAttribute("canBuild", canBuild);
    	return "buildForge";
	}
	
	@GetMapping ("/buildForge-gc23")
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
		nation.setForge(true);
		nation.setProduction(nation.getProduction()-250);
		nation.setMoney(nation.getMoney()-1000);
		nation.setTechnology(nation.getTechnology()-100);
		nationService.createNation(nation);
		return "redirect:/user";
	}
}
