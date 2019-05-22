package com.gagecottom.nationbuilder.improvements.level6;

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
public class Level6ImprovementController {
	@Autowired
	private UserService userService;
	@Autowired
	private NationService nationService;
	@GetMapping("/buildIndustryArea")
	public String buildIndustryArea(Model model) {
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
    	ImprovementText text = new ImprovementText("Industry Area", "/buildIndustryArea-gc23", "Production");
    	if(nation.getMoney()>=50000&&nation.getProduction()>=50000&&nation.getTechnology()>=10000&&nation.isIndustryArea()==false) {
    		canBuild.setCanBuild(true);
    	}
    	model.addAttribute("text", text);
    	model.addAttribute("canBuild", canBuild);
    	return "buildLevel6Improvement";
	}
	
	@GetMapping ("/buildIndustryArea-gc23")
	public String buildIndustryArea(@ModelAttribute("nation") Nation nNation) {
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
		nation.setIndustryArea(true);
		nation.setProduction(nation.getProduction()-50000);
		nation.setMoney(nation.getMoney()-50000);
		nation.setTechnology(nation.getTechnology()-10000);
		nationService.createNation(nation);
		return "redirect:/user";
	}
	@GetMapping("/buildAgricultureArea")
	public String buildAgricultureArea(Model model) {
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
    	if(nation.getMoney()>=50000&&nation.getProduction()>=50000&&nation.getTechnology()>=10000&&nation.isAgricultureArea()==false) {
    		canBuild.setCanBuild(true);
    	}
    	ImprovementText text = new ImprovementText("Agriculture Area", "/buildAgricultureArea-gc23", "Population");
    	model.addAttribute("text", text);
    	
    	model.addAttribute("canBuild", canBuild);
    	return "buildLevel6Improvement";
	}
	
	@GetMapping ("/buildAgricultureArea-gc23")
	public String buttonAgricultureArea(@ModelAttribute("nation") Nation nNation) {
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
		nation.setAgricultureArea(true);
		nation.setProduction(nation.getProduction()-50000);
		nation.setMoney(nation.getMoney()-50000);
		nation.setTechnology(nation.getTechnology()-10000);
		nationService.createNation(nation);
		return "redirect:/user";
	}
	@GetMapping("/buildCampusArea")
	public String buildCampusArea(Model model) {
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
    	if(nation.getMoney()>=50000&&nation.getProduction()>=50000&&nation.getTechnology()>=10000&&nation.isCampusArea()==false) {
    		canBuild.setCanBuild(true);
    	}
    	ImprovementText text = new ImprovementText("Campus Area", "/buildCampusArea-gc23", "Technology");
    	model.addAttribute("text", text);
    	
    	model.addAttribute("canBuild", canBuild);
    	return "buildLevel6Improvement";
	}
	
	@GetMapping ("/buildCampusArea-gc23")
	public String buildCampusArea(@ModelAttribute("nation") Nation nNation) {
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
		nation.setCampusArea(true);
		nation.setProduction(nation.getProduction()-50000);
		nation.setMoney(nation.getMoney()-50000);
		nation.setTechnology(nation.getTechnology()-10000);
		nationService.createNation(nation);
		return "redirect:/user";
	}
	@GetMapping("/buildCommercialArea")
	public String buildCommercialArea(Model model) {
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
    	if(nation.getMoney()>=50000&&nation.getProduction()>=50000&&nation.getTechnology()>=10000&&nation.isCommercialArea()==false) {
    		canBuild.setCanBuild(true);
    	}
    	ImprovementText text = new ImprovementText("Commercial Area", "/buildCommercialArea-gc23", "Money");
    	model.addAttribute("text", text);
    	
    	model.addAttribute("canBuild", canBuild);
    	return "buildLevel6Improvement";
	}
	
	@GetMapping ("/buildCommercialArea-gc23")
	public String buildCommercialArea(@ModelAttribute("nation") Nation nNation) {
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
		nation.setCommercialArea(true);
		nation.setProduction(nation.getProduction()-50000);
		nation.setMoney(nation.getMoney()-50000);
		nation.setTechnology(nation.getTechnology()-10000);
		nationService.createNation(nation);
		return "redirect:/user";
	}
}

