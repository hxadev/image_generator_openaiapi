package com.hxadev.openai.generator;

import com.hxadev.openai.generator.component.DalleStarter;
import com.hxadev.openai.generator.service.impl.DalleImagenGenerationServiceImpl;

/**
 * @author hxa.dev
 *         This is the main class of the application, responsible for starting
 *         the generation of images using the DalleStarter class.
 */
public class App {
    public static void main(String[] args) {
        DalleStarter dalleStarter = new DalleStarter(
                new DalleImagenGenerationServiceImpl());

        dalleStarter.init();
    }
}
