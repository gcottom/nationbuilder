package com.gagecottom.nationbuilder.nation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;

import com.gagecottom.nationbuilder.service.NationService;

@Controller
public class ViewNationController {
	@Autowired
	private NationService nationService;
	@GetMapping("/nation/{id}")
	public String showNation(@PathVariable("id") int id, Model model) {
		Nation nation = new Nation();
		nation = nationService.findNationById(id);
		model.addAttribute("nation", nation);
		return "viewNation";
		
	}
}
