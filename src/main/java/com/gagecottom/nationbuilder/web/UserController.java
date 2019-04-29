package com.gagecottom.nationbuilder.web;

import java.net.MalformedURLException;
import java.net.URL;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.gagecottom.nationbuilder.ScheduledTasks;
import com.gagecottom.nationbuilder.model.User;
import com.gagecottom.nationbuilder.nation.Nation;
import com.gagecottom.nationbuilder.service.MessageService;
import com.gagecottom.nationbuilder.service.NationService;
import com.gagecottom.nationbuilder.service.SecurityService;
import com.gagecottom.nationbuilder.service.UserService;
import com.gagecottom.nationbuilder.validator.UserValidator;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private NationService nationService;
    @Autowired
    private MessageService messageService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;
    private boolean newMessage;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);
        Nation nation = new Nation();
        nation.setNationCapitol("NONE");
        nation.setNationName("NONE");
        nation.setId(userForm.getId());
        nation.setMoney(1000);
        nation.setTechnology(0);
        nation.setGovernment("Democracy");
        nation.setResource1("Gold");
        nation.setResource2("Wheat");
        nation.setResource3("Cotton");
        nation.setResource4("Wood");
        nation.setPopulationLimit(1000);
        nation.setPopulation(100);
        nation.setProduction(25);
        nation.setHasLibrary(false);
        nation.setHasMarket(false);
        nation.setHasBasicFarm(false);
        nation.setHasWorkshop(false);
        nation.setNationLevel(1);
        nation.setLevel1(true);
        String protocol = "http";
        String host = "localhost";
        int port = 8080;
        String path = "/nation/" +userForm.getId();
        try {
			URL url = new URL (protocol, host, port, path);
			nation.setLink(url);
			nation.setRulerName(userForm.getUsername());
			nationService.createNation(nation);
	        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());

        } catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return "redirect:/welcome";
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @GetMapping({"/", "/welcome"})
    public String welcome(Model model) {
        return "welcome";
    }
    @GetMapping("/user")
    public String user(Model model) {
    	newMessage = false;
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
    	messageService.findMessagesByNationId(user.getId()).forEach(
    			message -> {
    				if(message.getNewMessage()==true) {
    					newMessage = true;
    				}
    			});
    	model.addAttribute("message", newMessage);
    	model.addAttribute("turn",ScheduledTasks.turn );
    	return "user";
    }
}
