package org.kolmanfreecss.kfimapinotificationservice.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * WebClientConfig
 *
 * @version 1.0
 * @uthor Kolman-Freecss
 */
@Configuration
public class WebClientConfig {
    
    @Bean
    public WebClient.Builder webClient() {
        return WebClient.builder();
    }
    
}
