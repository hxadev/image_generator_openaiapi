package com.hxadev.openai.generator.exception.core;

public class GenerationInfoEmptyException extends Exception {
    public GenerationInfoEmptyException(String message) {
        super(message);
    }

    public GenerationInfoEmptyException(String message, Throwable err) {
        super(message, err);
    }
}
