package io.mahardi.springservisinapigateway.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import io.mahardi.springservisinapigateway.dto.Visits;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import static java.util.stream.Collectors.joining;


@Component
@RequiredArgsConstructor
public class VisitsServiceClient {
    @Autowired WebClient.Builder webClientBuilder;

    private String hostName = "http://visits-service";


    public Mono<Visits> getVisitsForCars(final List<Integer> carIds){
        return webClientBuilder.build()
            .get()
            .uri(hostName + "pets/visits?carIds={carId}", joinIds(carIds))
            .retrieve()
            .bodyToMono(Visits.class);
    }

    private String joinIds(List<Integer> carIds) {
        return carIds.stream().map(Object::toString).collect(joining(","));
    }

    void setHostname(String hostName) {
        this.hostName = hostName;
    }
}
