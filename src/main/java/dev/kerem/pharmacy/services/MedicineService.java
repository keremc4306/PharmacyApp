package dev.kerem.pharmacy.services;

import java.util.List;

import dev.kerem.pharmacy.models.Medicine;

public interface MedicineService {
	List<Medicine> getAll();
	Long count();
}
