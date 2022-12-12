package dev.kerem.pharmacy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import dev.kerem.pharmacy.services.ProducerService;

@Controller
@RequestMapping("/admin/producers")
public class AdminProducerController {

	@Autowired
	private ProducerService producerService;
	
	@PostMapping("/delete/{id}")
	public String delete(@PathVariable Long id, Model model) {
		producerService.delete(id);
		model.addAttribute("message", "Kayıt silindi!");
		return "redirect:/producers/";
	}
}
