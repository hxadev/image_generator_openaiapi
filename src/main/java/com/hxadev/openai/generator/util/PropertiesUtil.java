package com.hxadev.openai.generator.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.hxadev.openai.generator.exception.properties.PropertyNotFoundException;

public class PropertiesUtil {

    private static String getProperty(String property, String propFile) {
        Properties properties = new Properties();
        try (InputStream st = PropertiesUtil.class.getClassLoader().getResourceAsStream(propFile + ".properties")) {
            properties.load(st);
        } catch (IOException ex) {
        }
        return properties.getProperty(property);
    }

    public static String getPropertyCore(String property) {
        return PropertiesUtil.getProperty(property, "application");
    }

    public static String getPropertyMessages(String property) {
        return PropertiesUtil.getProperty(property, "errorMessages");
    }

}
