package dev.kerem.pharmacy.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import dev.kerem.pharmacy.models.Producer;
import dev.kerem.pharmacy.services.ProducerService;

@Controller
@RequestMapping("/producers")
public class ProducerController {
	
	@Autowired
	private ProducerService producerService;
	
	@GetMapping("/")
	public String index(Model model) {
		List<Producer> producers = producerService.getAll();
		model.addAttribute("producers", producers);
		return "producers/index";
	}

}
