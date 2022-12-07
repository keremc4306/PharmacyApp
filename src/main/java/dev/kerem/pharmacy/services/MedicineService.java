package dev.kerem.pharmacy.services;

import java.util.List;

import dev.kerem.pharmacy.models.Medicine;

public interface MedicineService {
	List<Medicine> getAll();
	List<Medicine> search(String keyword);
	Long count();
}
