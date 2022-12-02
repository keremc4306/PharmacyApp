package dev.kerem.pharmacy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import dev.kerem.pharmacy.services.MedicineService;
import dev.kerem.pharmacy.services.ProducerService;

@Controller
public class WelcomeController {

	@Autowired
	private MedicineService medicineService;
	
	@Autowired
	private ProducerService producerService;
	
	@GetMapping("/")
	public String welcome(Model model) {
		model.addAttribute("producerCount", producerService.count());
		model.addAttribute("medicineCount", medicineService.count());
		return "welcome";
	}
}
