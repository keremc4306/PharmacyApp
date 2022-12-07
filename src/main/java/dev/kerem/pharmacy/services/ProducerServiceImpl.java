package dev.kerem.pharmacy.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.kerem.pharmacy.models.Producer;
import dev.kerem.pharmacy.repositories.ProducerRepository;

@Service
public class ProducerServiceImpl implements ProducerService {
	
	@Autowired
	private ProducerRepository producerRepository;

	@Override
	public List<Producer> getAll() {
		return producerRepository.findAll();
	}

	@Override
	public Long count() {
		return producerRepository.count();
	}

	@Override
	public List<Producer> search(String keyword) {
		if (keyword != null && keyword.length() > 3) {
			return producerRepository.search(keyword);
		}
		return null;
	}

	
}
