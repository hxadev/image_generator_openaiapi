package com.hxadev.openai.generator.exception.openai;

public class OpenAIRateLimitReached extends RuntimeException {
    public OpenAIRateLimitReached(String message) {
        super(message);
    }

    public OpenAIRateLimitReached(String message, Throwable err) {
        super(message, err);
    }
}
