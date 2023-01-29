package com.hxadev.openai.generator.component;

import static java.lang.System.out;

import java.util.Scanner;

import com.hxadev.openai.generator.model.dto.GenerationInfo;
import com.hxadev.openai.generator.service.DalleImageGenerationService;

public class DalleStarter {
    private DalleImageGenerationService generationService;

    public DalleStarter(DalleImageGenerationService generationService) {
        this.generationService = generationService;
    }

    public void init() {
        try {
            this.banner();
            this.generationService
                    .generate(GenerationInfo.builder().prompt(this.inputPrompt()).build());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void banner() {
        out.println("\n\n+++ Generador de imagenes utilizando openai api +++");
        out.println(">>");
        out.println(">> Que imagen quieres generar? ");
        out.print(">> ");
    }

    private String inputPrompt() {
        return new Scanner(System.in).nextLine();
    }

}
