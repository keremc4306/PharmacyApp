package dev.kerem.pharmacy.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.kerem.pharmacy.api.entity.SearchResult;
import dev.kerem.pharmacy.models.Medicine;
import dev.kerem.pharmacy.models.Producer;
import dev.kerem.pharmacy.services.MedicineService;
import dev.kerem.pharmacy.services.ProducerService;

@RestController
public class SearchRestController {

	@Autowired
	private ProducerService producerService;
	
	@Autowired
	private MedicineService medicineService;
	
	@GetMapping(path = "/api/search")
	public ResponseEntity<SearchResult> search(@Param("key") String key) {
		List<Producer> producers = producerService.search(key);
		List<Medicine> medicines = medicineService.search(key);
		return ResponseEntity.ok(new SearchResult(producers, medicines));
	}
}
