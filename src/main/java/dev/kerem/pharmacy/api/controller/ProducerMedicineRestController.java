package dev.kerem.pharmacy.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import dev.kerem.pharmacy.api.entity.AddMedicineDto;
import dev.kerem.pharmacy.api.entity.Message;
import dev.kerem.pharmacy.models.Medicine;
import dev.kerem.pharmacy.models.Producer;
import dev.kerem.pharmacy.services.MedicineService;
import dev.kerem.pharmacy.services.ProducerService;

@RestController
@RequestMapping(path = "/api/producers/{producerId}/medicines")
public class ProducerMedicineRestController {

	@Autowired
	private MedicineService medicineService;
	
	@Autowired
	private ProducerService producerService;
	
	@GetMapping(path = {"","/"})
	public ResponseEntity<List<Medicine>> index(@PathVariable("producerId") Long producerId) {
		if (!producerService.existById(producerId))
			return ResponseEntity.notFound().build();
		
		List<Medicine> medicines = producerService.getById(producerId).getMedicines();
		return ResponseEntity.ok(medicines);
	}
	
	@GetMapping(path = {"/{medicineId}"})
	public ResponseEntity<Medicine> getById(@PathVariable("producerId") Long producerId,
											@PathVariable("medicineId") Long medicineId) {
		if (!producerService.existById(producerId))
			return ResponseEntity.notFound().build();
		
		if (!medicineService.existById(medicineId))
			return ResponseEntity.notFound().build();
			
		Medicine medicine = medicineService.getByIdAndProducerId(medicineId, producerId);
		
		return ResponseEntity.ok(medicine);
	}
	
	@PostMapping(path = {"","/"})
	public ResponseEntity<Message> create(@PathVariable("producerId") Long producerId,
										  @RequestBody AddMedicineDto medicineDto) {
		if (!producerService.existById(producerId))
			return ResponseEntity.notFound().build();
		
		Producer producer = producerService.getById(producerId);
		medicineService.store(medicineDto, producer);
		return ResponseEntity.ok(new Message("İlaç sisteme kaydedildi"));
	}
	
	@PutMapping(path = "/{medicineId}")
	public ResponseEntity<Message> update(@PathVariable("producerId") Long producerId,
										  @PathVariable("medicineId") Long medicineId,
										  @RequestBody AddMedicineDto medicineDto) {
		if (!producerService.existById(producerId))
			return ResponseEntity.notFound().build();
		
		if (!medicineService.existById(medicineId))
			return ResponseEntity.notFound().build();
		
		Producer producer = producerService.getById(producerId);
		Medicine medicine = medicineService.getById(medicineId);
		medicine.update(medicineDto);
		medicineService.store(producer, medicine);
		return ResponseEntity.ok(new Message("İlaç bilgisi güncellendi!"));
	}
	
	@DeleteMapping(path="/{medicineId}")
	public ResponseEntity<Message> delete(@PathVariable("producerId") Long producerId,
										  @PathVariable("medicineId") Long medicineId) {
		if (!producerService.existById(producerId))
			return ResponseEntity.notFound().build();
		
		if (!medicineService.existById(medicineId))
			return ResponseEntity.notFound().build();
		
		medicineService.delete(medicineId);
		return ResponseEntity.ok(new Message("İlaç silindi!"));
	}
}
