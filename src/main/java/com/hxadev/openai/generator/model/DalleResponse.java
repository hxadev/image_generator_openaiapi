package com.hxadev.openai.generator.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class DalleResponse {
    private long created;
    private List<DataDalle> data;
}
