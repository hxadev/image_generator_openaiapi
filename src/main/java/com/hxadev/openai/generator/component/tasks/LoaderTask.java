package com.hxadev.openai.generator.component.tasks;

/**
 * @author hxa.dev
 *         This class implements Runnable and its method run() prints a message
 *         and
 *         sleeps for 500 milliseconds in a loop until
 *         Thread.currentThread().isInterrupted() is true
 */

public class LoaderTask implements Runnable {

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println("Generando las imagenes...");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

    }

}
