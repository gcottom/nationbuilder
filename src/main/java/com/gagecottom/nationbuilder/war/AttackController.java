package com.gagecottom.nationbuilder.war;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AttackController {
@GetMapping("/attack-{id}")
public String attack(@PathVariable ("id") int id) {
	return "attack";
}
}
