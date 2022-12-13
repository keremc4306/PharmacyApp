package dev.kerem.pharmacy.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.kerem.pharmacy.models.Medicine;
import dev.kerem.pharmacy.services.MedicineService;

@RestController
@RequestMapping(path = "/api/medicines")
public class MedicineRestController {
	
	@Autowired
	private MedicineService medicineService;
	
	@GetMapping(path = {"","/"})
	public ResponseEntity<List<Medicine>> index() {
		List<Medicine> medicines = medicineService.getAll();
		return ResponseEntity.ok(medicines);
	}
}
