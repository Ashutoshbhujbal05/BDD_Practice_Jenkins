package utils;

import java.util.Properties;

import java.io.FileInputStream;
import java.io.IOException;

public class ConfigReader 
{
	private static Properties properties = new Properties();

    public static void loadProperties() {
        try (FileInputStream fis = new FileInputStream("src/test/resources/CucumberConfig.properties")) {
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Override browser property if passed from Jenkins
        String browserFromJenkins = System.getProperty("Browser");
        if (browserFromJenkins != null && !browserFromJenkins.isEmpty()) {
            properties.setProperty("browser", browserFromJenkins);
        }
    }
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

}
