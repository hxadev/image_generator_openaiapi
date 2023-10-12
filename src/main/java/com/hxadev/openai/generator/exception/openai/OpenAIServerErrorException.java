package com.hxadev.openai.generator.exception.openai;

public class OpenAIServerErrorException extends RuntimeException {
    public OpenAIServerErrorException(String message) {
        super(message);
    }

    public OpenAIServerErrorException(String message, Throwable err) {
        super(message, err);
    }
}
