package com.hxadev.openai.generator.service.impl;

import com.hxadev.openai.generator.component.tasks.ImageGenerationTask;
import com.hxadev.openai.generator.component.tasks.LoaderTask;
import com.hxadev.openai.generator.model.dto.GenerationInfo;
import com.hxadev.openai.generator.service.DalleImageGenerationService;

/**
 * @author hxa.dev
 *         This code implements a DalleImagenGenerationService which will
 *         generate an
 *         image based on the GenerationInfo provided. It creates two Threads,
 *         one for
 *         the LoaderTask, and one for the ImageGenerationTask. When the
 *         ImageGenerationTask is complete, it interrupts the LoaderTask.
 */
public class DalleImagenGenerationServiceImpl implements DalleImageGenerationService {

    @Override
    public void generate(GenerationInfo info) throws Exception {

        // Loader Thread
        Thread loader = new Thread(new LoaderTask());
        loader.start();

        // Task Image Generation Thread
        Thread imageGenerationThread = new Thread(new ImageGenerationTask(info));
        imageGenerationThread.start();

        // When image generation thread is ended, then interrupt loader thread.
        loader.interrupt();
    }

}
