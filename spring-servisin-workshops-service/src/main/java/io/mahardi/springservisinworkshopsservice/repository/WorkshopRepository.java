package io.mahardi.springservisinworkshopsservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.mahardi.springservisinworkshopsservice.model.Workshop;

public interface WorkshopRepository extends JpaRepository<Workshop, Integer>{
    
}
