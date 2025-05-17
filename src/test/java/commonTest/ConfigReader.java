package commonTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;
    private static final String CONFIG_PATH = "src/test/resources/config/generalStoreApp.properties";

    static {
        properties = new Properties();
        try {
            FileInputStream fis = new FileInputStream(CONFIG_PATH);
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load file: " + CONFIG_PATH);
        }
    }

    public static String getProperty(String propertyKey) {
        return properties.getProperty(propertyKey);
    }

    public static String getURL() {
        return getProperty("url");
    }

    public static int getPort() {
        return Integer.parseInt(getProperty("port"));
    }

    public static String getDeviceName() {
        return getProperty("deviceName");
    }

    public static String getAppPackage() {
        return getProperty("appPackage");
    }

    public static String getAppActivity() {
        return getProperty("appActivity");
    }
}
