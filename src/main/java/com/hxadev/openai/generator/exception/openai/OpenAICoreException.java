package com.hxadev.openai.generator.exception.openai;

public class OpenAICoreException extends RuntimeException {
    public OpenAICoreException(String message) {
        super(message);
    }

    public OpenAICoreException(String message, Throwable err) {
        super(message, err);
    }
}
