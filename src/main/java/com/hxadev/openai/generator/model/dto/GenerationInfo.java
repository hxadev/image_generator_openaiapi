package com.hxadev.openai.generator.model.dto;

import lombok.Builder;

@lombok.Data
@Builder
public class GenerationInfo {
    private String prompt;
}
