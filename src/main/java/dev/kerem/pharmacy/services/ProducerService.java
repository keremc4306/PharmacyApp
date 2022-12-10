package dev.kerem.pharmacy.services;

import java.util.List;

import dev.kerem.pharmacy.models.Medicine;
import dev.kerem.pharmacy.models.Producer;

public interface ProducerService {
	void store(Producer producer);
	List<Producer> getAll();
	Producer getById(Long id);
	List<Medicine> getProducerMedicines(Producer producer);
	void delete(Long id);
	List<Producer> search(String keyword);
	Long count();
	boolean existById(Long id);
}
