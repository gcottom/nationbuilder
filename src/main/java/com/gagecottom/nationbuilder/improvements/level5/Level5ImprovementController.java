package com.gagecottom.nationbuilder.improvements.level5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.gagecottom.nationbuilder.improvements.CanBuild;
import com.gagecottom.nationbuilder.improvements.ImprovementText;
import com.gagecottom.nationbuilder.model.User;
import com.gagecottom.nationbuilder.nation.Nation;
import com.gagecottom.nationbuilder.service.NationService;
import com.gagecottom.nationbuilder.service.UserService;

@Controller
public class Level5ImprovementController {
	@Autowired
	private UserService userService;
	@Autowired
	private NationService nationService;
	@GetMapping("/buildFactory")
	public String buildFactory(Model model) {
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
    	ImprovementText text = new ImprovementText("Factory", "/buildFactory-gc23", "Production");
    	if(nation.getMoney()>=10000&&nation.getProduction()>=5000&&nation.getTechnology()>=1000&&nation.isFactory()==false) {
    		canBuild.setCanBuild(true);
    	}
    	model.addAttribute("text", text);
    	model.addAttribute("canBuild", canBuild);
    	return "buildLevel5Improvement";
	}
	
	@GetMapping ("/buildFactory-gc23")
	public String buildFactory(@ModelAttribute("nation") Nation nNation) {
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
		nation.setFactory(true);
		nation.setProduction(nation.getProduction()-5000);
		nation.setMoney(nation.getMoney()-10000);
		nation.setTechnology(nation.getTechnology()-1000);
		nationService.createNation(nation);
		return "redirect:/user";
	}
	@GetMapping("/buildAdvancedPlantation")
	public String buildAdvancedPlantation(Model model) {
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
    	if(nation.getMoney()>=10000&&nation.getProduction()>=5000&&nation.getTechnology()>=1000&&nation.isAdvancedPlantation()==false) {
    		canBuild.setCanBuild(true);
    	}
    	ImprovementText text = new ImprovementText("Advanced Plantation", "/buildAdvancedPlantation-gc23", "Population");
    	model.addAttribute("text", text);
    	
    	model.addAttribute("canBuild", canBuild);
    	return "buildLevel5Improvement";
	}
	
	@GetMapping ("/buildAdvancedPlantation-gc23")
	public String buttonAdvancedPlantation(@ModelAttribute("nation") Nation nNation) {
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
		nation.setAdvancedPlantation(true);
		nation.setProduction(nation.getProduction()-5000);
		nation.setMoney(nation.getMoney()-10000);
		nation.setTechnology(nation.getTechnology()-1000);
		nationService.createNation(nation);
		return "redirect:/user";
	}
	@GetMapping("/buildUniversity")
	public String buildUniversity(Model model) {
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
    	if(nation.getMoney()>=10000&&nation.getProduction()>=5000&&nation.getTechnology()>=1000&&nation.isUniversity()==false) {
    		canBuild.setCanBuild(true);
    	}
    	ImprovementText text = new ImprovementText("University", "/buildUniversity-gc23", "Technology");
    	model.addAttribute("text", text);
    	
    	model.addAttribute("canBuild", canBuild);
    	return "buildLevel5Improvement";
	}
	
	@GetMapping ("/buildUniversity-gc23")
	public String buildUniversity(@ModelAttribute("nation") Nation nNation) {
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
		nation.setUniversity(true);
		nation.setProduction(nation.getProduction()-5000);
		nation.setMoney(nation.getMoney()-10000);
		nation.setTechnology(nation.getTechnology()-1000);
		nationService.createNation(nation);
		return "redirect:/user";
	}
	@GetMapping("/buildStockExchange")
	public String buildHarbor(Model model) {
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
    	if(nation.getMoney()>=10000&&nation.getProduction()>=5000&&nation.getTechnology()>=1000&&nation.isStockExchange()==false) {
    		canBuild.setCanBuild(true);
    	}
    	ImprovementText text = new ImprovementText("Stock Exchange", "/buildStockExchange-gc23", "Money");
    	model.addAttribute("text", text);
    	
    	model.addAttribute("canBuild", canBuild);
    	return "buildLevel5Improvement";
	}
	
	@GetMapping ("/buildStockExchange-gc23")
	public String buildHarbor(@ModelAttribute("nation") Nation nNation) {
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
		nation.setStockExchange(true);
		nation.setProduction(nation.getProduction()-5000);
		nation.setMoney(nation.getMoney()-10000);
		nation.setTechnology(nation.getTechnology()-1000);
		nationService.createNation(nation);
		return "redirect:/user";
	}
}

