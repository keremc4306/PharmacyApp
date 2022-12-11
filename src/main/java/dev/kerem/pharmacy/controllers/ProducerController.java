package dev.kerem.pharmacy.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import dev.kerem.pharmacy.models.Medicine;
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

	@GetMapping("/create")
	public String create(Model model) {
		model.addAttribute("producer", new Producer());
		return "producers/create";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Long id, Model model) {
		Producer producer = producerService.getById(id);
		model.addAttribute("producer", producer);
		return "producers/edit";
	}
	
	@GetMapping("/show/{id}")
	public String show(@PathVariable Long id, Model model) {
		Producer producer = producerService.getById(id);
		List<Medicine> medicines = producer.getMedicines();
		model.addAttribute("producer", producer);
		model.addAttribute("medicines", medicines);
		return "producers/show";
	}
	
	@PostMapping("/create")
	public String store(@Valid Producer producer, final BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("createProducerForm", producer);
			return "producers/create";
		}
		
		producerService.store(producer);
		model.addAttribute("message", "Yeni ilaç üreticisi başarıyla eklendi.");
		return "redirect:/producers/";
	}
	
	@PostMapping("/edit/{id}")
	public String update(@PathVariable Long id, @Valid Producer producer, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("editProducerForm", producer);
			return "producers/edit";
		}
		producerService.store(producer);
		model.addAttribute("message", "Kayıt güncellendi!");
		return "redirect:/producers/";
	}
}
