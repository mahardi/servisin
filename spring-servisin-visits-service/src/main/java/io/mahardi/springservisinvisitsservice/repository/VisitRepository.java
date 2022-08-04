package io.mahardi.springservisinvisitsservice.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.mahardi.springservisinvisitsservice.model.Visit;

public interface VisitRepository extends JpaRepository<Visit, Integer>{
    
    List<Visit> findByCarId(int carId);

    List<Visit> findByCarIdIn(Collection<Integer> carIds);
}
