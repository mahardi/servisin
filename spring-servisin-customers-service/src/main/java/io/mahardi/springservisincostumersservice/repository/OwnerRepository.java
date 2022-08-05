package io.mahardi.springservisincustomersservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.mahardi.springservisincustomersservice.model.Owner;

public interface OwnerRepository extends JpaRepository<Owner, Integer>{
    
}
