package com.hxadev.openai.generator.util;

import java.io.File;
import java.util.UUID;

public class FilesUtil {
    public static String parsePromptToImageName(String prompt) {
        return prompt.replace(" ", "_").trim().toLowerCase() + "_" + UUID.randomUUID() + "_" + ".jpg";
    }

    public static String parsePromptToFolderName(String prompt) {
        return "result" + File.separator + prompt.replace(" ", "_").trim().toLowerCase();
    }
}
