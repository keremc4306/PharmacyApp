package dev.kerem.pharmacy.services;

import java.util.List;

import dev.kerem.pharmacy.models.Producer;

public interface ProducerService {
	List<Producer> getAll();
	List<Producer> search(String keyword);
	Long count();
}
