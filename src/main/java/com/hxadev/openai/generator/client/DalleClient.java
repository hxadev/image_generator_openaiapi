package com.hxadev.openai.generator.client;

import com.hxadev.openai.generator.model.DalleResponse;
import com.hxadev.openai.generator.model.dto.DalleRequest;

import feign.Headers;
import feign.RequestLine;

/**
 * @author hxa.dev
 * This is an interface for the Dalle Client which is used to generate images by
 * prompt. It uses the RequestLine and Headers to make a POST request to the
 * API.
 */
@Headers({ "Content-Type: application/json" })
public interface DalleClient {

    @RequestLine("POST /v1/images/generations")
    public DalleResponse generateImagesDalleByPrompt(DalleRequest request);

}
