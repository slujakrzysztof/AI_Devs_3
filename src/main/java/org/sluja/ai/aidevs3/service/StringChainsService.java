package org.sluja.ai.aidevs3.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class StringChainsService {

    private final RestClient aiDevs3RestClient;
    public List<String> getChains() {
        final String codes = aiDevs3RestClient.get()
                .uri("/dane.txt")
                .retrieve()
                .body(String.class);
        if(Objects.isNull(codes)) return Collections.emptyList();
        return Arrays.stream(codes.split("\n")).toList();
    }
}
