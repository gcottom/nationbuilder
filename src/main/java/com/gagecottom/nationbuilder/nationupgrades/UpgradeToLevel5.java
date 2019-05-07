package com.gagecottom.nationbuilder.nationupgrades;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.stereotype.Controller;
import com.gagecottom.nationbuilder.improvements.CanBuild;
import com.gagecottom.nationbuilder.message.Message;
import com.gagecottom.nationbuilder.model.User;
import com.gagecottom.nationbuilder.nation.Nation;
import com.gagecottom.nationbuilder.service.MessageService;
import com.gagecottom.nationbuilder.service.NationService;
import com.gagecottom.nationbuilder.service.UserService;
@Controller
public class UpgradeToLevel5 {
	@Autowired
	private UserService userService;
	@Autowired
	private MessageService messageService;
	@Autowired
	private NationService nationService;
	@GetMapping("/upgradeToLevel5")
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
    	if(nation.getMoney()>=10000&&nation.getProduction()>=10000&&nation.getTechnology()>=10000&&nation.getPopulation()>=50000&&nation.getNationLevel()==4&&nation.isResearchLab()&&nation.isHarbor()&&nation.isAdvancedFarming()&&nation.isAdvancedForge()) {
    		canBuild.setCanBuild(true);
    	}
    	model.addAttribute("canBuild", canBuild);
    	return "upgradeToNationLevel5";
	}
	
	@GetMapping ("upgradeToNationLevel5-gc23")
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
		nation.setNationLevel(5);
		nation.setLevel4(false);
		nation.setLevel5(true);
		nation.setProduction(nation.getProduction()-1000);
		nation.setMoney(nation.getMoney()-1000);
		nation.setTechnology(nation.getTechnology()-250);
		nationService.createNation(nation);
		Message message = new Message();
		message.setReceiverId(nation.getId());
		message.setSenderId(0);
		message.setMessage("You have upgraded your nation to level 5. You have unlocked new improvements. Build all level 5 improvements to upgrade your nation to level 6.");
		messageService.saveMessage(message);
		
		return "redirect:/user";
	}
}
