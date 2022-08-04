package io.mahardi.springservisincostumersservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import io.mahardi.springservisincostumersservice.model.CarType;
import io.mahardi.springservisincostumersservice.model.Cars;

public interface CarRepository extends JpaRepository<Cars, Integer> {
    
    @Query("SELECT ctype FROM CarType ctype ORDER BY ctype.name")
    List<CarType> findCarType();

    @Query("FROM CarType ctype WHERE ctype.id = :typeId")
    Optional<CarType> findCarTypeById(@Param("typeId") int typeId);
}
