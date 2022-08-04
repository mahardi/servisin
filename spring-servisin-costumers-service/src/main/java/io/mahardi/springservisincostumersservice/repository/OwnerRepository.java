package io.mahardi.springservisincostumersservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.mahardi.springservisincostumersservice.model.Owner;

public interface OwnerRepository extends JpaRepository<Owner, Integer>{
    
}
