package dev.kerem.pharmacy.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.kerem.pharmacy.models.Medicine;
import dev.kerem.pharmacy.repositories.MedicineRepository;

@Service
public class MedicineServiceImpl implements MedicineService {
	
	@Autowired
	private MedicineRepository medicineRepository;

	@Override
	public List<Medicine> getAll() {
		return medicineRepository.findAll();
	}

	@Override
	public Long count() {
		return medicineRepository.count();
	}

	@Override
	public List<Medicine> search(String keyword) {
		if (keyword != null && keyword.length() > 3) {
			return medicineRepository.search(keyword);
		}
		return null;
	}

}
