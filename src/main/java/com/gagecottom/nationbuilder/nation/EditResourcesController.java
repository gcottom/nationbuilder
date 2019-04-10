package com.gagecottom.nationbuilder.nation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.gagecottom.nationbuilder.model.User;
import com.gagecottom.nationbuilder.service.NationService;
import com.gagecottom.nationbuilder.service.UserService;

@Controller
public class EditResourcesController {
	@Autowired
	private UserService userService;
	@Autowired
	private NationService nationService;
	@GetMapping("/editResources")
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
    	initModelList(model);
    	return "editResources";
	}
	@PostMapping ("/editResources")
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
		nation.setResource1(nNation.getResource1());
		nation.setResource2(nNation.getResource2());
		nation.setResource3(nNation.getResource3());
		nation.setResource4(nNation.getResource4());
		nationService.createNation(nation);
		return "redirect:/user";
		
	}
	private void initModelList(Model model) {
		List<String> resourcesList = new ArrayList<String>();
		resourcesList.add("Gold");
		resourcesList.add("Water");
		resourcesList.add("Wheat");
		resourcesList.add("Coal");
		resourcesList.add("Oil");
		resourcesList.add("Uranium");
		resourcesList.add("Meat");
		resourcesList.add("Silver");
		resourcesList.add("Cotton");
		resourcesList.add("Wood");
		model.addAttribute("resources", resourcesList);
		
		
	}
}
