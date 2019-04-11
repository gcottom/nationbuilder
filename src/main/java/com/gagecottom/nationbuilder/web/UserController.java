package com.gagecottom.nationbuilder.web;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.gagecottom.nationbuilder.model.User;
import com.gagecottom.nationbuilder.nation.Nation;
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
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

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
        nation.setPopulation(100);
        nation.setPopulationLimit(1000);
        nation.setProduction(25);
        nation.setHasLibrary(false);
        nationService.createNation(nation);
        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());

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
    	return "user";
    }
}
