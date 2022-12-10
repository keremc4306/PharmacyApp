package dev.kerem.pharmacy.services;

import java.util.List;

import dev.kerem.pharmacy.api.entity.AddMedicineDto;
import dev.kerem.pharmacy.models.Medicine;
import dev.kerem.pharmacy.models.Producer;

public interface MedicineService {
	void store(Producer producer, Medicine medicine);
	Medicine getById(Long id);
	void delete(Long id);
	List<Medicine> search(String keyword);
	List<Medicine> getAll();
	Long count();
	
	Medicine getByIdAndProducerId(Long medicineId, Long producerId);
	
	void store(AddMedicineDto medicineDto, Producer producer);
	
	boolean existById(Long id);
}
