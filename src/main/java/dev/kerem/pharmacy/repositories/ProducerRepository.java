package dev.kerem.pharmacy.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import dev.kerem.pharmacy.models.Producer;

@Repository
public interface ProducerRepository extends JpaRepository<Producer, Long>{
	@Query("SELECT p from Producer p where p.firstName like %?1%")
	public List<Producer> search(String keyword);
}
