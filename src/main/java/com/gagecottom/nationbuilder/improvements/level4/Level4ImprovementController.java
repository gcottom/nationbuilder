package com.gagecottom.nationbuilder.improvements.level4;

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
public class Level4ImprovementController {
	@Autowired
	private UserService userService;
	@Autowired
	private NationService nationService;
	@GetMapping("/buildAdvancedForge")
	public String buildAdvancedForge(Model model) {
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
    	ImprovementText text = new ImprovementText("Advanced Forge", "/buildAdvancedForge-gc23", "Production");
    	if(nation.getMoney()>=5000&&nation.getProduction()>=1000&&nation.getTechnology()>=500&&nation.isAdvancedForge()==false) {
    		canBuild.setCanBuild(true);
    	}
    	model.addAttribute("text", text);
    	model.addAttribute("canBuild", canBuild);
    	return "buildLevel4Improvement";
	}
	
	@GetMapping ("/buildAdvancedForge-gc23")
	public String buildAdvancedForge(@ModelAttribute("nation") Nation nNation) {
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
		nation.setAdvancedForge(true);
		nation.setProduction(nation.getProduction()-1000);
		nation.setMoney(nation.getMoney()-5000);
		nation.setTechnology(nation.getTechnology()-500);
		nationService.createNation(nation);
		return "redirect:/user";
	}
	@GetMapping("/buildAdvancedFarming")
	public String buildAdvancedFarming(Model model) {
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
    	if(nation.getMoney()>=5000&&nation.getProduction()>=1000&&nation.getTechnology()>=500&&nation.isAdvancedFarming()==false) {
    		canBuild.setCanBuild(true);
    	}
    	ImprovementText text = new ImprovementText("Advanced Farming", "/buildAdvancedFarming-gc23", "Population");
    	model.addAttribute("text", text);
    	
    	model.addAttribute("canBuild", canBuild);
    	return "buildLevel4Improvement";
	}
	
	@GetMapping ("/buildAdvancedFarming-gc23")
	public String buttonAdvancedFarming(@ModelAttribute("nation") Nation nNation) {
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
		nation.setAdvancedFarming(true);
		nation.setProduction(nation.getProduction()-1000);
		nation.setMoney(nation.getMoney()-5000);
		nation.setTechnology(nation.getTechnology()-500);
		nationService.createNation(nation);
		return "redirect:/user";
	}
	@GetMapping("/buildResearchLab")
	public String buildResearchLab(Model model) {
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
    	if(nation.getMoney()>=5000&&nation.getProduction()>=1000&&nation.getTechnology()>=500&&nation.isResearchLab()==false) {
    		canBuild.setCanBuild(true);
    	}
    	ImprovementText text = new ImprovementText("Research Lab", "/buildResearchLab-gc23", "Technology");
    	model.addAttribute("text", text);
    	
    	model.addAttribute("canBuild", canBuild);
    	return "buildLevel4Improvement";
	}
	
	@GetMapping ("/buildResearchLab-gc23")
	public String buildResearchLab(@ModelAttribute("nation") Nation nNation) {
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
		nation.setResearchLab(true);
		nation.setProduction(nation.getProduction()-1000);
		nation.setMoney(nation.getMoney()-5000);
		nation.setTechnology(nation.getTechnology()-500);
		nationService.createNation(nation);
		return "redirect:/user";
	}
	@GetMapping("/buildHarbor")
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
    	if(nation.getMoney()>=5000&&nation.getProduction()>=1000&&nation.getTechnology()>=500&&nation.isHarbor()==false) {
    		canBuild.setCanBuild(true);
    	}
    	ImprovementText text = new ImprovementText("Harbor", "/buildHarbor-gc23", "Money");
    	model.addAttribute("text", text);
    	
    	model.addAttribute("canBuild", canBuild);
    	return "buildLevel4Improvement";
	}
	
	@GetMapping ("/buildHarbor-gc23")
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
		nation.setHarbor(true);
		nation.setProduction(nation.getProduction()-1000);
		nation.setMoney(nation.getMoney()-5000);
		nation.setTechnology(nation.getTechnology()-500);
		nationService.createNation(nation);
		return "redirect:/user";
	}
}
