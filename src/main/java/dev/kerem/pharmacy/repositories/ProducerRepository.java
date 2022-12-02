package dev.kerem.pharmacy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.kerem.pharmacy.models.Producer;

public interface ProducerRepository extends JpaRepository<Producer, Long>{

}
