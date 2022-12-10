package dev.kerem.pharmacy.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.kerem.pharmacy.api.entity.AddMedicineDto;
import dev.kerem.pharmacy.models.Medicine;
import dev.kerem.pharmacy.models.Producer;
import dev.kerem.pharmacy.repositories.MedicineRepository;

@Service
public class MedicineServiceImpl implements MedicineService {
	
	@Autowired
	private MedicineRepository medicineRepository;

	@Override
	public void store(Producer producer, Medicine medicine) {
		medicine.setProducer(producer);
		medicineRepository.save(medicine);
	}

	@Override
	public Medicine getById(Long id) {
		return medicineRepository.findById(id).get();
	}

	@Override
	public void delete(Long id) {
		medicineRepository.delete(medicineRepository.findById(id).get());
	}

	@Override
	public List<Medicine> search(String keyword) {
		if (keyword != null && keyword.length() > 3) {
			return medicineRepository.search(keyword);
		}
		return null;
	}

	@Override
	public List<Medicine> getAll() {
		return medicineRepository.findAll();
	}

	@Override
	public Long count() {
		return medicineRepository.count();
	}

	@Override
	public Medicine getByIdAndProducerId(Long medicineId, Long producerId) {
		return medicineRepository.getByIdAndProducerId(medicineId, producerId);
	}

	@Override
	public void store(AddMedicineDto medicineDto, Producer producer) {
		Medicine medicine = Medicine.from(medicineDto);
		this.store(producer, medicine);
	}

	@Override
	public boolean existById(Long id) {
		return medicineRepository.existsById(id);
	}

}
