package com.gagecottom.nationbuilder.nationupgrades;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.stereotype.Controller;
import com.gagecottom.nationbuilder.improvements.CanBuild;
import com.gagecottom.nationbuilder.model.User;
import com.gagecottom.nationbuilder.nation.Nation;
import com.gagecottom.nationbuilder.service.NationService;
import com.gagecottom.nationbuilder.service.UserService;
@Controller
public class UpgradeToLevel4 {
	@Autowired
	private UserService userService;
	@Autowired
	private NationService nationService;
	@GetMapping("/upgradeToLevel4")
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
    	if(nation.getMoney()>=5000&&nation.getProduction()>=5000&&nation.getTechnology()>=2500&&nation.getPopulation()>=10000&&nation.getNationLevel()==3&&nation.isCollege()&&nation.isBank()&&nation.isCropRotation()&&nation.isAdvancedWorkshop()) {
    		canBuild.setCanBuild(true);
    	}
    	model.addAttribute("canBuild", canBuild);
    	return "upgradeToNationLevel4";
	}
	
	@GetMapping ("upgradeToNationLevel4-gc23")
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
		nation.setNationLevel(4);
		nation.setLevel3(false);
		nation.setLevel4(true);
		nation.setProduction(nation.getProduction()-1000);
		nation.setMoney(nation.getMoney()-1000);
		nation.setTechnology(nation.getTechnology()-250);
		nationService.createNation(nation);
		return "redirect:/user";
	}
}
