package com.hxadev.openai.generator.model.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class DalleRequest {
    private String prompt;
    private Short n;
    private String size;
}
