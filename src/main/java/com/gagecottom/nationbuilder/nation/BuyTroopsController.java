package com.gagecottom.nationbuilder.nation;

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
import com.gagecottom.nationbuilder.service.NationService;
import com.gagecottom.nationbuilder.service.UserService;

@Controller
public class BuyTroopsController {
	@Autowired
	private UserService userService;
	@Autowired
	private NationService nationService;
	@GetMapping("/buyTroops")
	public String buyTroops(Model model) {
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
    	int maxTroops = (int) (nation.getPopulation()*.5)-troops;
    	model.addAttribute("maxTroops", maxTroops);
		model.addAttribute("troops", troops);
		model.addAttribute("nation", nation);
		return "buyTroops";
	}
	@PostMapping("/buyTroopsCheck")
	public String buyTroopsCheck(@ModelAttribute("troops") int troops, Model model){
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
    	if(troops>nation.getMoney()) {
    		message="Not enough money";
    		}
    	else {
    		message="<a href=\"buyTroops-gc23-"+troops+"\">Confirm Purchase</a>";
    	}
    	if(troops+nation.getTroops()>nation.getPopulation()*.50) {
    		message="You can not have more than 1/2 of your population as military";
    	}
    	if(troops-nation.getTroops()<0) {
    		message="You can not have negative troops";
    	}
    	model.addAttribute("message", message);
		model.addAttribute("nation", nation);
	
		return "buyTroopsCheck";
		
	}
	@GetMapping("buyTroops-gc23-{id}")
	public String buyTroopsConfirmed(@PathVariable("id") int id) {
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
    	nation.setTroops(nation.getTroops()+id);
    	nation.setMoney(nation.getMoney()-id);
    	nationService.createNation(nation);
		return "redirect:/user";
		
	}
	

}
