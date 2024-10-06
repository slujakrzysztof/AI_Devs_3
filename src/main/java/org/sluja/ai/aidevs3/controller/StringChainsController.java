package org.sluja.ai.aidevs3.controller;

import lombok.RequiredArgsConstructor;
import org.sluja.ai.aidevs3.dto.ApiResponse;
import org.sluja.ai.aidevs3.dto.VerifyStringRequest;
import org.sluja.ai.aidevs3.service.StringChainsService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
public class StringChainsController {

    private final RestClient aiDevs3RestClient;
    private final StringChainsService stringChainsService;
    @Value("${aidevs.api.key}")
    private String apiKey;

    @PostMapping("/verify")
    public @ResponseBody String verifyString() {

        final VerifyStringRequest verifyStringRequest = VerifyStringRequest.builder()
                .task("POLIGON")
                .apikey(apiKey)
                .answer(stringChainsService.getChains())
                .build();
        return aiDevs3RestClient.post()
                .uri("/verify")
                .contentType(MediaType.APPLICATION_JSON)
                .body(verifyStringRequest)
                .retrieve()
                .body(String.class);
    }
}
