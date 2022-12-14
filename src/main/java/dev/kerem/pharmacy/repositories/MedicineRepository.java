package dev.kerem.pharmacy.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import dev.kerem.pharmacy.models.Medicine;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Long>{
	@Query("SELECT m FROM Medicine m where m.name like %?1%")
	public List<Medicine> search(String keyword);
	
	@Query("SELECT m FROM Medicine m where m.id = :medicineId AND producer_id = :producerId")
	Medicine getByIdAndProducerId(
			@Param("medicineId") Long medicineId, 
			@Param("producerId") Long producerId);
}
