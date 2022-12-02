package dev.kerem.pharmacy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.kerem.pharmacy.models.Medicine;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Long>{

}
