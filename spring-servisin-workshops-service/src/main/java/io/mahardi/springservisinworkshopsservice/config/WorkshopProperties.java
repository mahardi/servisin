package io.mahardi.springservisinworkshopsservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties(prefix = "workshops")
public class WorkshopProperties {
    private Cache cache;

    @Data
    public static class Cache {

        private int ttl;

        private int heapSize;
    }
}
