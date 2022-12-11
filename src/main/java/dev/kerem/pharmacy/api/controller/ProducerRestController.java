package dev.kerem.pharmacy.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import dev.kerem.pharmacy.api.entity.Message;
import dev.kerem.pharmacy.models.Producer;
import dev.kerem.pharmacy.services.ProducerService;

@RestController
@RequestMapping(path = "/api/producers")
public class ProducerRestController {

	@Autowired
	private ProducerService producerService;
	
	@GetMapping(path = {"", "/"})
	public ResponseEntity<List<Producer>> getAll() {
		List<Producer> producers = producerService.getAll();
		return ResponseEntity.ok(producers);
	}
	
	@PostMapping(path = {"","/"})
	public ResponseEntity<Message> create(@RequestBody Producer producer) {
		producerService.store(producer);
		return ResponseEntity.ok(new Message("İlaç üreticisi kaydedildi!"));
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Producer> getById(@PathVariable("id") Long id) {
		if (!producerService.existById(id))
			return ResponseEntity.notFound().build();
		
		Producer producer = producerService.getById(id);
		return ResponseEntity.ok(producer);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Message> delete(@PathVariable("id") Long id) {
		if (!producerService.existById(id))
			return ResponseEntity.notFound().build();
		
		producerService.delete(id);
		return ResponseEntity.ok(new Message("İlaç Üretici Bilgisi Listeden Silindi!"));
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<Message> edit(@PathVariable("id") Long id, @RequestBody Producer producer) {
		if (!producerService.existById(id))
			return ResponseEntity.notFound().build();
		
		producer.setId(id);
		producerService.store(producer);
		return ResponseEntity.ok(new Message("İlaç Üretici Bilgisi Güncellendi!"));
	}
	
}
