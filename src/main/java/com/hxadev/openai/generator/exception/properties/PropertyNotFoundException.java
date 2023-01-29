package com.hxadev.openai.generator.exception.properties;

public class PropertyNotFoundException extends Exception {
    public PropertyNotFoundException(String message) {
        super(message);

    }

    public PropertyNotFoundException(String message, Throwable err) {
        super(message, err);
    }
}
