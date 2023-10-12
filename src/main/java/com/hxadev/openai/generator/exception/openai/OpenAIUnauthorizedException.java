package com.hxadev.openai.generator.exception.openai;

public class OpenAIUnauthorizedException extends RuntimeException {
    public OpenAIUnauthorizedException(String message) {
        super(message);
    }

    public OpenAIUnauthorizedException(String message, Throwable err) {
        super(message, err);
    }
}
