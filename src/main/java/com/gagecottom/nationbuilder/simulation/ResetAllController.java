package com.gagecottom.nationbuilder.simulation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.gagecottom.nationbuilder.service.MessageService;
import com.gagecottom.nationbuilder.service.NationService;
import com.gagecottom.nationbuilder.service.TurnService;
import com.gagecottom.nationbuilder.service.UserService;
import com.gagecottom.nationbuilder.service.WarService;

@Controller
public class ResetAllController {
	@Autowired
	private MessageService messageService;
	@Autowired
	private NationService nationService;
	@Autowired
	private TurnService turnService;
	@Autowired
	private UserService userService;
	@Autowired
	private WarService warService;
@GetMapping("/resetAll-gc23")
	public String resetAll() {
		messageService.deleteAll();
		nationService.deleteAll();
		Turn turn = new Turn();
		turn.setId(1);
		turn.setTurn(-1);
		turnService.saveTurn(turn);
		userService.deleteAll();
		warService.deleteAll();
		return"redirect:/login";
	}

}
