package com.ranjit.harmony.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties prop;

    public static Properties loadConfig() {
        if (prop == null) {
            prop = new Properties();
            String env = System.getProperty("env", "qa");

            try {
                FileInputStream fis =
                        new FileInputStream("src/test/resources/config/" + env + ".properties");
                prop.load(fis);
            } catch (Exception e) {
                throw new RuntimeException("Failed to load config for env: " + env);
            }
        }
        return prop;
    }

    public static String get(String key) {
        return loadConfig().getProperty(key);
    }
}