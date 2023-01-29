package com.hxadev.openai.generator.exception.core;

public class ResponseDataIsEmptyException extends Exception {

    public ResponseDataIsEmptyException(String message) {
        super(message);
    }

    public ResponseDataIsEmptyException(String message, Throwable err) {
        super(message, err);
    }

}
