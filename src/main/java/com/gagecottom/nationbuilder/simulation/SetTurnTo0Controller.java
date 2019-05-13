package com.gagecottom.nationbuilder.simulation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.gagecottom.nationbuilder.service.TurnService;

@Controller
public class SetTurnTo0Controller {
	@Autowired
	private TurnService turnService;
	@GetMapping("/setTurnTo0")
	public String setTo0() {
		Turn turn = new Turn();
		turn.setId(1);
		turn.setTurn(0);
		turnService.saveTurn(turn);
		return"redirect:/user";
	}

}
