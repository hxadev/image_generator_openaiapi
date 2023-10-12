package com.hxadev.openai.generator.client.decoders;

import com.hxadev.openai.generator.exception.openai.OpenAICoreException;
import com.hxadev.openai.generator.exception.openai.OpenAIRateLimitReached;
import com.hxadev.openai.generator.exception.openai.OpenAIServerErrorException;
import com.hxadev.openai.generator.exception.openai.OpenAIUnauthorizedException;

import feign.Response;
import feign.codec.Decoder;
import feign.codec.ErrorDecoder;

/**
 * @author hxa.dev
 *         This Decoder class is used to throw specific Exceptions when the
 *         OpenAI API
 *         returns an error code. It determines the status code and throws an
 *         appropriate OpenAI Exception such as OpenAIUnauthorizedException,
 *         OpenAIRateLimitReached, or OpenAIServerErrorException.
 **
 */
public class GeneratorErrorDecorder implements feign.codec.ErrorDecoder {

    final Decoder decoder;
    final ErrorDecoder defaultDecoder = new ErrorDecoder.Default();

    public GeneratorErrorDecorder(Decoder decoder) {
        this.decoder = decoder;
    }

    @Override
    public Exception decode(String methodKey, Response response) {
        try {
            switch (response.status()) {
                case 401:
                    throw new OpenAIUnauthorizedException(response.reason() + " - "
                            + "La apikey expiro o tu suscripcion es invalida, revisa la configuracion desde la consola.");
                case 429:
                    throw new OpenAIRateLimitReached(
                            response.reason() + " - " + "El limite de peticiones permitido fue superado.");
                case 500:
                    throw new OpenAIServerErrorException(response.reason() + " - "
                            + "Ocurrio un problema al procesar la peticion en OpenAI, intenta de nuevo en un momento.");
            }
        } catch (Exception e) {
            throw new OpenAICoreException(e.getMessage(), e);
        }
        return null;
    }

}
