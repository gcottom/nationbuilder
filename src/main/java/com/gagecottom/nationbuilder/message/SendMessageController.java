package com.gagecottom.nationbuilder.message;

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
import com.gagecottom.nationbuilder.service.MessageService;
import com.gagecottom.nationbuilder.service.UserService;

@Controller
public class SendMessageController {
	@Autowired
	private UserService userService;
	@Autowired
	private MessageService messageService;
@GetMapping("/nation/{id}/sendMessage")
public String sendMessage(@PathVariable("id") int id, Model model) {
	model.addAttribute("note", new String());
	
	return "sendMessage";
}
@PostMapping("/nation/{id}/sendMessage")
public String sendMessageSubmit(@PathVariable("id") int id, @ModelAttribute("note") String message) {
	Message newMessage = new Message();	
	newMessage.setMessage(message);
	newMessage.setReceiverId(id);
	String username;
	Object principal =SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	if (principal instanceof UserDetails) {
		   username = ((UserDetails)principal).getUsername();
		} else {
		   username = principal.toString();
		}
	
	User user=userService.findByUsername(username);
	newMessage.setSenderId(user.getId());
	messageService.saveMessage(newMessage);
	return "redirect:/user";
}
}
