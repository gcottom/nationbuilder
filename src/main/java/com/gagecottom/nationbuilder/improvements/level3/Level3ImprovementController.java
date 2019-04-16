package com.gagecottom.nationbuilder.improvements.level3;

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
public class Level3ImprovementController {
	@Autowired
	private UserService userService;
	@Autowired
	private NationService nationService;
	@GetMapping("/buildAdvancedWorkshop")
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
    	ImprovementText text = new ImprovementText("Advanced Workshop", "/buildAdvancedWorkshop-gc23", "Production");
    	if(nation.getMoney()>=2500&&nation.getProduction()>=500&&nation.getTechnology()>=200&&nation.isAdvancedWorkshop()==false) {
    		canBuild.setCanBuild(true);
    	}
    	model.addAttribute("text", text);
    	model.addAttribute("canBuild", canBuild);
    	return "buildLevel3Improvement";
	}
	
	@GetMapping ("/buildAdvancedWorkshop-gc23")
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
		nation.setAdvancedWorkshop(true);
		nation.setProduction(nation.getProduction()-500);
		nation.setMoney(nation.getMoney()-2500);
		nation.setTechnology(nation.getTechnology()-200);
		nationService.createNation(nation);
		return "redirect:/user";
	}
	@GetMapping("/buildCropRotation")
	public String buildCropRotation(Model model) {
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
    	if(nation.getMoney()>=2500&&nation.getProduction()>=500&&nation.getTechnology()>=200&&nation.isCropRotation()==false) {
    		canBuild.setCanBuild(true);
    	}
    	ImprovementText text = new ImprovementText("Crop Rotation", "/buildCropRotation-gc23", "Population");
    	model.addAttribute("text", text);
    	
    	model.addAttribute("canBuild", canBuild);
    	return "buildLevel3Improvement";
	}
	
	@GetMapping ("/buildCropRotation-gc23")
	public String buttonCropRotation(@ModelAttribute("nation") Nation nNation) {
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
		nation.setCropRotation(true);
		nation.setProduction(nation.getProduction()-500);
		nation.setMoney(nation.getMoney()-2500);
		nation.setTechnology(nation.getTechnology()-200);
		nationService.createNation(nation);
		return "redirect:/user";
	}
	@GetMapping("/buildCollege")
	public String buildCollege(Model model) {
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
    	if(nation.getMoney()>=2500&&nation.getProduction()>=500&&nation.getTechnology()>=200&&nation.isCollege()==false) {
    		canBuild.setCanBuild(true);
    	}
    	ImprovementText text = new ImprovementText("College", "/buildCollege-gc23", "Technology");
    	model.addAttribute("text", text);
    	
    	model.addAttribute("canBuild", canBuild);
    	return "buildLevel3Improvement";
	}
	
	@GetMapping ("/buildCollege-gc23")
	public String buildCollege(@ModelAttribute("nation") Nation nNation) {
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
		nation.setCollege(true);
		nation.setProduction(nation.getProduction()-500);
		nation.setMoney(nation.getMoney()-2500);
		nation.setTechnology(nation.getTechnology()-200);
		nationService.createNation(nation);
		return "redirect:/user";
	}
	@GetMapping("/buildBank")
	public String buildBank(Model model) {
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
    	if(nation.getMoney()>=2500&&nation.getProduction()>=500&&nation.getTechnology()>=200&&nation.isBank()==false) {
    		canBuild.setCanBuild(true);
    	}
    	ImprovementText text = new ImprovementText("Bank", "/buildBank-gc23", "Money");
    	model.addAttribute("text", text);
    	
    	model.addAttribute("canBuild", canBuild);
    	return "buildLevel3Improvement";
	}
	
	@GetMapping ("/buildBank-gc23")
	public String buildBank(@ModelAttribute("nation") Nation nNation) {
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
		nation.setBank(true);
		nation.setProduction(nation.getProduction()-500);
		nation.setMoney(nation.getMoney()-2500);
		nation.setTechnology(nation.getTechnology()-200);
		nationService.createNation(nation);
		return "redirect:/user";
	}
}
