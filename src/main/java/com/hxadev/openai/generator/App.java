package com.hxadev.openai.generator;

import com.hxadev.openai.generator.component.DalleStarter;
import com.hxadev.openai.generator.service.impl.DalleImagenGenerationServiceImpl;


public class App {
    public static void main(String[] args) {
        DalleStarter dalleStarter = new DalleStarter(
                new DalleImagenGenerationServiceImpl());

        dalleStarter.init();
    }
}
