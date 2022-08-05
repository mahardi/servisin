package io.mahardi.springservisinapigateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.ReactiveCircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.ReactiveCircuitBreakerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.mahardi.springservisinapigateway.dto.OwnerDetails;
import io.mahardi.springservisinapigateway.dto.Visits;
import io.mahardi.springservisinapigateway.service.CustomerServiceClient;
import io.mahardi.springservisinapigateway.service.VisitsServiceClient;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/gateway")
public class SpringServisinApiGatewayController {
    @Autowired CustomerServiceClient customersServiceClient;

    @Autowired VisitsServiceClient visitsServiceClient;

    @Autowired ReactiveCircuitBreakerFactory cbFactory;

    @GetMapping(value = "owners/{ownerId}")
    public Mono<OwnerDetails> getOwnerDetails(final @PathVariable int ownerId) {
        return customersServiceClient.getOwner(ownerId)
            .flatMap(owner ->
                visitsServiceClient.getVisitsForCars(owner.getCarIds())
                    .transform(it -> {
                        ReactiveCircuitBreaker cb = cbFactory.create("getOwnerDetails");
                        return cb.run(it, throwable -> emptyVisitsForCars());
                    })
                    .map(addVisitsToOwner(owner))
            );

    }

    private Function<Visits, OwnerDetails> addVisitsToOwner(OwnerDetails owner) {
        return visits -> {
            owner.getCars()
                .forEach(car -> car.getVisits()
                    .addAll(visits.getItems().stream()
                        .filter(v -> v.getCarId() == car.getId())
                        .collect(Collectors.toList()))
                );
            return owner;
        };
    }

    private Mono<Visits> emptyVisitsForCars() {
        return Mono.just(new Visits());
    }
}
