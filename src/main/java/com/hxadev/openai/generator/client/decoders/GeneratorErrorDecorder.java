package com.hxadev.openai.generator.client.decoders;

import feign.Response;
import feign.codec.Decoder;
import feign.codec.ErrorDecoder;

public class GeneratorErrorDecorder implements feign.codec.ErrorDecoder {

    final Decoder decoder;
    final ErrorDecoder defaultDecoder = new ErrorDecoder.Default();

    public GeneratorErrorDecorder(Decoder decoder) {
        this.decoder = decoder;
    }

    @Override
    public Exception decode(String methodKey, Response response) {
        try {
            // TODO Code for decode feign error
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
