package org.sluja.ai.aidevs3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfig {

    @Bean
    public RestClient aiDevs3RestClient() {
        return RestClient.create("https://poligon.aidevs.pl");
    }

}
