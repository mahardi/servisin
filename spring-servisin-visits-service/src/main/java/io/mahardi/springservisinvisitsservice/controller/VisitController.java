package io.mahardi.springservisinvisitsservice.controller;

import io.micrometer.core.annotation.Timed;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.mahardi.springservisinvisitsservice.model.Visit;
import io.mahardi.springservisinvisitsservice.repository.VisitRepository;

@RestController
@Timed("servisin.visit")
@RequiredArgsConstructor
@Slf4j
public class VisitController {
    @Autowired VisitRepository visitRepository;

    @PostMapping("owners/*/cars/{carId}/visits")
    @ResponseStatus(HttpStatus.CREATED)
    public Visit create(
        @Valid @RequestBody Visit visit,
        @PathVariable("carId") @Min(1) int carId) {

        visit.setCarId(carId);
        log.info("Saving visit {}", visit);
        return visitRepository.save(visit);
    }

    @GetMapping("owners/*/cars/{carId}/visits")
    public List<Visit> visits(@PathVariable("carId") @Min(1) int carId) {
        return visitRepository.findByCarId(carId);
    }

    @GetMapping("cars/visits")
    public Visits visitsMultiGet(@RequestParam("carId") List<Integer> carIds) {
        final List<Visit> byCarIdIn = visitRepository.findByCarIdIn(carIds);
        return new Visits(byCarIdIn);
    }

    @Value
    static class Visits {
        List<Visit> items;
    }
}
