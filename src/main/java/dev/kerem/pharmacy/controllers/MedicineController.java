package dev.kerem.pharmacy.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import dev.kerem.pharmacy.models.Medicine;
import dev.kerem.pharmacy.services.MedicineService;

@Controller
@RequestMapping("/medicines")
public class MedicineController {

	@Autowired
	private MedicineService medicineService;
	
	@GetMapping("/")
	public String index(Model model) {
		List<Medicine> medicines = medicineService.getAll();
		model.addAttribute("medicines", medicines);
		return "medicines/index";
	}
}
