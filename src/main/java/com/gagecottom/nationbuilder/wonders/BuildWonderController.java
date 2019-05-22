package com.gagecottom.nationbuilder.wonders;

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
public class BuildWonderController {
	@Autowired
	private NationService nationService;
	@Autowired
	private UserService userService;
	
	@GetMapping("/buildIRS")
	public String buildIRS(Model model) {
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
    	if(nation.getMoney()>=5000&&nation.getProduction()>=5000&&nation.getTechnology()>=5000&&nation.isIrs()==false) {
    		canBuild.setCanBuild(true);
    	}
    	model.addAttribute("canBuild", canBuild);
    	WonderText text = new WonderText("IRS", 5000, "+10 money", "0", "buildIRS-gc23");
    	model.addAttribute("text", text);
    	return "buildWonder";
	}
	
	@GetMapping ("/buildIRS-gc23")
	public String buildIRS(@ModelAttribute("nation") Nation nNation) {
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
		nation.setIrs(true);
		nation.setProduction(nation.getProduction()-5000);
		nation.setMoney(nation.getMoney()-5000);
		nation.setTechnology(nation.getTechnology()-5000);
		nationService.createNation(nation);
		return "redirect:/user";
	}
	
	@GetMapping("/buildFederalReserve")
	public String buildFederalReserve(Model model) {
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
    	if(nation.getMoney()>=10000&&nation.getProduction()>=10000&&nation.getTechnology()>=10000&&nation.isFederalReserve()==false) {
    		canBuild.setCanBuild(true);
    	}
    	model.addAttribute("canBuild", canBuild);
    	WonderText text = new WonderText("Federal Reserve", 10000, "+10 money", "0", "buildFederalReserve-gc23");
    	model.addAttribute("text", text);
    	
    	return "buildWonder";
	}
	
	@GetMapping ("/buildFederalReserve-gc23")
	public String buildFederalReserve(@ModelAttribute("nation") Nation nNation) {
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
		nation.setFederalReserve(true);
		nation.setProduction(nation.getProduction()-10000);
		nation.setMoney(nation.getMoney()-10000);
		nation.setTechnology(nation.getTechnology()-10000);
		nationService.createNation(nation);
		return "redirect:/user";
	}
	@GetMapping("/buildEducationGrants")
	public String buildEducationGrants(Model model) {
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
    	if(nation.getMoney()>=50000&&nation.getProduction()>=50000&&nation.getTechnology()>=50000&&nation.isEducationGrants()==false) {
    		canBuild.setCanBuild(true);
    	}
    	model.addAttribute("canBuild", canBuild);
    	WonderText text = new WonderText("Education Grants", 50000, "+5 technology", "-5 money", "buildEducationGrants-gc23");
    	model.addAttribute("text", text);
    	
    	return "buildWonder";
	}
	
	@GetMapping ("/buildEducationGrants-gc23")
	public String buildEducationGrants(@ModelAttribute("nation") Nation nNation) {
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
		nation.setEducationGrants(true);
		nation.setProduction(nation.getProduction()-50000);
		nation.setMoney(nation.getMoney()-50000);
		nation.setTechnology(nation.getTechnology()-50000);
		nationService.createNation(nation);
		return "redirect:/user";
	}
	@GetMapping("/buildFoodStamps")
	public String buildFoodStamps(Model model) {
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
    	if(nation.getMoney()>=100000&&nation.getProduction()>=100000&&nation.getTechnology()>=100000&&nation.isFoodStamps()==false) {
    		canBuild.setCanBuild(true);
    	}
    	model.addAttribute("canBuild", canBuild);
    	WonderText text = new WonderText("Food Stamps", 100000, "+5 population", "-7 money", "buildFoodStamps-gc23");
    	model.addAttribute("text", text);
    	
    	return "buildWonder";
	}
	
	@GetMapping ("/buildFoodStamps-gc23")
	public String buildFoodStamps(@ModelAttribute("nation") Nation nNation) {
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
		nation.setFoodStamps(true);
		nation.setProduction(nation.getProduction()-100000);
		nation.setMoney(nation.getMoney()-100000);
		nation.setTechnology(nation.getTechnology()-100000);
		nationService.createNation(nation);
		return "redirect:/user";
	}
	@GetMapping("/buildGovernmentCenter")
	public String buildGovernmentCenter(Model model) {
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
    	if(nation.getMoney()>=1000&&nation.getProduction()>=1000&&nation.getTechnology()>=1000&&nation.isGovernmentCenter()==false) {
    		canBuild.setCanBuild(true);
    	}
    	model.addAttribute("canBuild", canBuild);
    	WonderText text = new WonderText("Government Center", 1000, "+1 technology<br>+1 money<br>+1 population<br>+1 production", "0", "buildGovernmentCenter-gc23");
    	model.addAttribute("text", text);
    	
    	return "buildWonder";
	}
	
	@GetMapping ("/buildGovernmentCenter-gc23")
	public String buildGovernmentCenter(@ModelAttribute("nation") Nation nNation) {
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
		nation.setGovernmentCenter(true);
		nation.setProduction(nation.getProduction()-1000);
		nation.setMoney(nation.getMoney()-1000);
		nation.setTechnology(nation.getTechnology()-1000);
		nationService.createNation(nation);
		return "redirect:/user";
	}
	@GetMapping("/buildMilitaryIndustrialComplex")
	public String buildMilitaryIndustrialComplex(Model model) {
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
    	if(nation.getMoney()>=1000000&&nation.getProduction()>=1000000&&nation.getTechnology()>=1000000&&nation.isGovernmentCenter()==false) {
    		canBuild.setCanBuild(true);
    	}
    	model.addAttribute("canBuild", canBuild);
    	WonderText text = new WonderText("Military Industrial Complex", 1000000, "+6 technology<br>+6 money<br>+6 production", "0", "buildMilitaryIndustrialComplex-gc23");
    	model.addAttribute("text", text);
    	
    	return "buildWonder";
	}
	
	@GetMapping ("/buildMilitaryIndustrialComplex-gc23")
	public String buildMilitaryIndustrialComplex(@ModelAttribute("nation") Nation nNation) {
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
		nation.setMilitaryIndustrialComplex(true);
		nation.setProduction(nation.getProduction()-1000000);
		nation.setMoney(nation.getMoney()-1000000);
		nation.setTechnology(nation.getTechnology()-1000000);
		nationService.createNation(nation);
		return "redirect:/user";
	}
}
