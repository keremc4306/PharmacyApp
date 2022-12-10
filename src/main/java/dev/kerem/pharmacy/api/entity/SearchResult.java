package dev.kerem.pharmacy.api.entity;

import java.util.List;

import dev.kerem.pharmacy.models.Medicine;
import dev.kerem.pharmacy.models.Producer;

public class SearchResult {
	private List<Producer> producersFound;
	private List<Medicine> medicinesFound;
	
	public SearchResult(List<Producer> producersFound, List<Medicine> medicinesFound) {
		this.producersFound = producersFound;
		this.medicinesFound = medicinesFound;
	}

	public List<Producer> getProducersFound() {
		return producersFound;
	}

	public void setProducersFound(List<Producer> producersFound) {
		this.producersFound = producersFound;
	}

	public List<Medicine> getMedicinesFound() {
		return medicinesFound;
	}

	public void setMedicinesFound(List<Medicine> medicinesFound) {
		this.medicinesFound = medicinesFound;
	}	
	
}
