package io.mahardi.springservisinapigateway.service;

import java.security.acl.Owner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import io.mahardi.springservisinapigateway.dto.OwnerDetails;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class CustomerServiceClient {
    
    @Autowired WebClient.Builder webClientBuilder;

    public Mono<OwnerDetails> getOwner(final int ownerId){
        return webClientBuilder.build().get()
            .uri("http://costumers-service/owners/{ownerId}", ownerId)
            .retrieve()
            .bodyToMono(OwnerDetails.class);
    }
}
