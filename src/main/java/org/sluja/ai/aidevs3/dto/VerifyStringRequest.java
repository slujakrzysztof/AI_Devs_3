package org.sluja.ai.aidevs3.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
public class VerifyStringRequest implements Serializable {

    private String task;
    private String apikey;
    private List<String> answer;
}
