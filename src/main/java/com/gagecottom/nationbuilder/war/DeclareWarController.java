package com.gagecottom.nationbuilder.war;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.gagecottom.nationbuilder.ScheduledTasks;
import com.gagecottom.nationbuilder.model.User;
import com.gagecottom.nationbuilder.nation.Nation;
import com.gagecottom.nationbuilder.service.NationService;
import com.gagecottom.nationbuilder.service.UserService;
import com.gagecottom.nationbuilder.service.WarService;

@Controller
public class DeclareWarController {
@Autowired
private UserService userService;
@Autowired
private WarService warService;
@Autowired
private NationService nationService;

@GetMapping("/nation/{id}/declareWar")
public String declareWar(@PathVariable("id") int id, Model model) {
	WarDeclaration war = new WarDeclaration();
	war.setTargetId(id);
	model.addAttribute("war", war);
	return "declareWar";
	
}
@GetMapping("/nation/{id}/declareWar-gc23")
public String declareWarAction(@PathVariable("id") int id, Model model) {
	String username;
	Object principal =SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	if (principal instanceof UserDetails) {
		   username = ((UserDetails)principal).getUsername();
		} else {
		   username = principal.toString();
		}
	
	User user=userService.findByUsername(username);
	WarDeclaration war = new WarDeclaration();
	war.setInitiatorId(user.getId());
	war.setTargetId(id);
	war.setStartTurn(ScheduledTasks.turn);
	warService.saveWar(war);
	Nation nation = new Nation();
	nation = nationService.findNationById(war.getInitiatorId());
	nation.setAtWar(true);
	nation.setAtWarWith(war.getTargetId());
	nationService.createNation(nation);
	nation = nationService.findNationById(war.getTargetId());
	nation.setAtWar(true);
	nation.setAtWarWith(war.getInitiatorId());
	nationService.createNation(nation);
	return "redirect:/user";
	
}
}
