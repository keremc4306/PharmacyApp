package dev.kerem.pharmacy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.kerem.pharmacy.models.Producer;

@Repository
public interface ProducerRepository extends JpaRepository<Producer, Long>{

}
