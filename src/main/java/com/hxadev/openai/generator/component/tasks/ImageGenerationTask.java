package com.hxadev.openai.generator.component.tasks;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import com.hxadev.openai.generator.client.DalleClient;
import com.hxadev.openai.generator.client.decoders.GeneratorErrorDecorder;
import com.hxadev.openai.generator.exception.core.GenerationInfoEmptyException;
import com.hxadev.openai.generator.exception.core.ResponseDataIsEmptyException;
import com.hxadev.openai.generator.model.DalleResponse;
import com.hxadev.openai.generator.model.DataDalle;
import com.hxadev.openai.generator.model.dto.DalleRequest;
import com.hxadev.openai.generator.model.dto.GenerationInfo;
import com.hxadev.openai.generator.util.FilesUtil;
import com.hxadev.openai.generator.util.PropertiesUtil;

import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;

/**
 * @author hxa.dev
 *         This class is responsible for generating images from a prompt and
 *         saving them to a file.
 *         It implements the Runnable interface, which allows it to be used in a
 *         threadpool.
 *         It first checks if the GenerationInfo object is empty or if the
 *         prompt is empty.
 *         It then uses the DalleClient to generate images from the prompt, and
 *         saves the images to a folder.
 **/
public class ImageGenerationTask implements Runnable {

    private GenerationInfo info;

    public ImageGenerationTask(GenerationInfo info) {
        this.info = info;
    }

    // This code is a run method which checks whether the info object is empty and
    // if the prompt is empty. It then calls the generateClient method and generates
    // the imagesDalle by prompt. If the response data is empty, it throws an
    // exception. Finally, it saves the imagesDalle.
    @Override
    public void run() {
        try {
            if (Optional.ofNullable(info).isEmpty() || info.getPrompt().isEmpty()) {
                throw new GenerationInfoEmptyException(
                        PropertiesUtil.getPropertyMessages("exception.generationInfoEmpty"));
            }

            DalleResponse response = generateClient()
                    .generateImagesDalleByPrompt(generateRequest(info.getPrompt()));

            if (Optional.of(response.getData()).isEmpty()
                    || !Optional.of(response.getCreated()).isPresent()) {
                throw new ResponseDataIsEmptyException("exception.responseDataIsEmpty");

            }

            saveImagesDalle(response.getData(), info.getPrompt());
        } catch (GenerationInfoEmptyException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (ResponseDataIsEmptyException e) {
            e.printStackTrace();
        }
    }

    // This method saves images from a given list of data (DataDalle) to a file
    // directory based on the given prompt. The directory is created if it does not
    // already exist. The images are named based on the prompt.
    private void saveImagesDalle(List<DataDalle> data, String prompt) {
        File directory = new File(FilesUtil.parsePromptToFolderName(prompt));
        data
                .stream()
                .filter(result -> Optional.of(result).isPresent())
                .map(image -> image.getUrl())
                .forEach(urlImage -> {
                    try (InputStream is = new URL(urlImage).openStream()) {
                        if (!directory.exists()) {
                            directory.mkdirs();
                        }
                        Files.copy(is, Paths
                                .get(directory.getPath() + File.separator
                                        + FilesUtil.parsePromptToImageName(prompt)));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                });
    }

    // This method creates a DalleRequest object using the prompt and properties
    // specified in the PropertiesUtil class.
    private DalleRequest generateRequest(String prompt) throws NumberFormatException {
        return DalleRequest.builder()
                .prompt(prompt)
                .size(PropertiesUtil.getPropertyCore("openapi.dalle.sizeimage"))
                .n(Short.parseShort(PropertiesUtil.getPropertyCore("openapi.dalle.numberimage")))
                .build();
    }

    // This method creates and returns a DalleClient object. It uses Feign and Gson
    // libraries to build the client and sets an authorization header.
    private DalleClient generateClient() {
        return Feign
                .builder()
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .errorDecoder(new GeneratorErrorDecorder(new GsonDecoder()))
                .requestInterceptor(template -> {
                    template.header("Authorization",
                            "Bearer " + PropertiesUtil.getPropertyCore("openapi.dalle.apikey"));
                })
                .target(DalleClient.class, PropertiesUtil.getPropertyCore("openapi.dalle.baseurl"));
    }

}
