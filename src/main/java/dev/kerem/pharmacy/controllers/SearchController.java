package dev.kerem.pharmacy.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import dev.kerem.pharmacy.models.Medicine;
import dev.kerem.pharmacy.models.Producer;
import dev.kerem.pharmacy.services.MedicineService;
import dev.kerem.pharmacy.services.ProducerService;

@Controller
public class SearchController {
	
	@Autowired
	private ProducerService producerService;
	
	@Autowired
	private MedicineService medicineService;
	
	@GetMapping("/search")
	public String search(Model model, @Param("keyword") String keyword) {
		List<Producer> producers = producerService.search(keyword);
		List<Medicine> medicines = medicineService.search(keyword);
		model.addAttribute("producers", producers);
		model.addAttribute("medicines", medicines);
		return "searchResult";
	}
}
