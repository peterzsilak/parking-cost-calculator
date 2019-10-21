package com.liferay.uiautomation.helper;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {
    private Properties properties = new Properties();
    private InputStream inputStream = null;

    public PropertyReader() { loadProperties(); }

    private void loadProperties() {
        try {
            inputStream = new FileInputStream("src/main/resources/config.properties");
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readProperty(String key) {
        return properties.getProperty(key);
    }
}
