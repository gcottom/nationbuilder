package com.gagecottom.nationbuilder.nation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import com.gagecottom.nationbuilder.service.NationService;

@Controller
public class ViewAllNationsController {
	@Autowired
	private NationService nationService;
	@GetMapping("/nation/viewAll")
	public String showNation( Model model) {
		List<Nation> nations = new ArrayList<Nation>();
		nationService.listAllNations().forEach(nations::add);
		model.addAttribute("nations", nations);
		return "viewAllNations";
	}
}
