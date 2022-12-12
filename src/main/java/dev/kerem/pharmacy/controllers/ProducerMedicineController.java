package dev.kerem.pharmacy.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import dev.kerem.pharmacy.models.Medicine;
import dev.kerem.pharmacy.models.Producer;
import dev.kerem.pharmacy.services.MedicineService;
import dev.kerem.pharmacy.services.ProducerService;

@Controller
@RequestMapping("/producers/{producerId}/medicines")
public class ProducerMedicineController {

	@Autowired
	private MedicineService medicineService;
	
	@Autowired
	private ProducerService producerService;
	
	@GetMapping("/create")
	public String create(@PathVariable Long producerId, Model model) {
		Producer producer = producerService.getById(producerId);
		model.addAttribute("producer", producer);
		model.addAttribute("medicine", new Medicine());
		return "medicines/create";
	}
	
	@GetMapping("/edit/{petId}")
	public String edit(@PathVariable Long producerId, @PathVariable Long medicineId, Model model) {
		Producer producer = producerService.getById(producerId);
		Medicine medicine = medicineService.getById(medicineId);
		model.addAttribute("producer", producer);
		model.addAttribute("medicine", medicine);
		return "medicines/edit";
	}
	
	@GetMapping("/show/{petId}")
	public String show(@PathVariable Long producerId, @PathVariable Long medicineId, Model model) {
		Producer producer = producerService.getById(producerId);
		Medicine medicine = medicineService.getById(medicineId);
		model.addAttribute("producer", producer);
		model.addAttribute("medicine", medicine);
		return "medicines/show";
	}
	
	@PostMapping("/create")
	public String store(@PathVariable Long producerId, Model model, @Valid Medicine medicine, BindingResult bindingResult) {
		Producer producer = producerService.getById(producerId);
		model.addAttribute("producer", producer);
		
		if (bindingResult.hasErrors()) {
			model.addAttribute("createMedicineForm", medicine);
			return "medicines/create";
		}
		
		medicineService.store(producer, medicine);
		
		model.addAttribute("message", "İlaç " + producer.getFirstName() + " için kaydedildi");
		return "redirect:/producers/show/" + producer.getId();
	}
}
