package com.hxadev.openai.generator.client;

import com.hxadev.openai.generator.model.DalleResponse;
import com.hxadev.openai.generator.model.dto.DalleRequest;

import feign.Headers;
import feign.RequestLine;

@Headers({"Content-Type: application/json"})
public interface DalleClient {

    @RequestLine("POST /v1/images/generations")
    public DalleResponse generateImagesDalleByPrompt(DalleRequest request);

}
