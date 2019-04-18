package com.gagecottom.nationbuilder.message;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gagecottom.nationbuilder.model.User;
import com.gagecottom.nationbuilder.nation.Nation;
import com.gagecottom.nationbuilder.service.MessageService;
import com.gagecottom.nationbuilder.service.NationService;
import com.gagecottom.nationbuilder.service.UserService;
@Controller
public class ViewMessagesController {
	@Autowired
	private MessageService messageService;
	@Autowired
	private UserService userService;
	@GetMapping("/user/viewMessages")
	public String showNation( Model model) {
		String username;
    	Object principal =SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	if (principal instanceof UserDetails) {
    		   username = ((UserDetails)principal).getUsername();
    		} else {
    		   username = principal.toString();
    		}
    	
    	User user=userService.findByUsername(username);
    	
		List<Message> messages = new ArrayList<Message>();
		messageService.findMessagesByNationId(user.getId()).forEach(messages::add);
		model.addAttribute("messages", messages);
		return "viewMessages";
	}
}
