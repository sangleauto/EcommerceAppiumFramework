package commonTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private final Properties deviceProperties;
    private final Properties appProperties;
    private final String CONFIG_PATH = "src/test/resources/config/";

    public ConfigReader(String deviceName) {
        deviceProperties = new Properties();
        appProperties = new Properties();
        String deviceConfigPath = CONFIG_PATH + getConfigPath(deviceName);
        String appConfigPath = CONFIG_PATH + "generalStore.properties";
        try {
            FileInputStream fisDevice = new FileInputStream(deviceConfigPath);
            FileInputStream fisApp = new FileInputStream(appConfigPath);
            deviceProperties.load(fisDevice);
            appProperties.load(fisApp);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config file", e);
        }
    }

    private String getConfigPath(String deviceName){
        return switch (deviceName) {
            case "Pixel_6a" -> "pixel_6a.properties";
            case "Pixel_8" -> "pixel_8.properties";
            default -> throw new RuntimeException("Device name is not valid: " + deviceName);
        };
    }

    public String getURL() {
        return deviceProperties.getProperty("url");
    }

    public int getPort() {
        return Integer.parseInt(deviceProperties.getProperty("port"));
    }

    public String getDeviceName() {
        return deviceProperties.getProperty("deviceName");
    }

    public String getUDID() {
        return deviceProperties.getProperty("udid");
    }

    public String getAppPackage() {
        return appProperties.getProperty("appPackage");
    }

    public String getAppActivity() {
        return appProperties.getProperty("appActivity");
    }
}
