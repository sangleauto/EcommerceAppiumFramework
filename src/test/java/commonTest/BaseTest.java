package commonTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import pages.HomePage;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {
    protected AndroidDriver driver;
    private AppiumDriverLocalService service;
    protected HomePage homePage;

    @BeforeMethod
    @Parameters("deviceName")
    public void setup(String deviceName){
        ConfigReader config = new ConfigReader(deviceName);
        service = new AppiumServiceBuilder()
                .withIPAddress(config.getURL()).usingPort(config.getPort()).build();
        service.start();

        UiAutomator2Options options = new UiAutomator2Options()
                .setUdid(config.getUDID())
                .setDeviceName(config.getDeviceName())
                .setAppPackage(config.getAppPackage())
                .setAppActivity(config.getAppActivity());

        try {
            URL serverURL = new URI("http://" + config.getURL() + ":" + config.getPort()).toURL();
            driver = new AndroidDriver(serverURL, options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            homePage = new HomePage(driver);
        }
        catch (URISyntaxException | MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
        if (service != null && service.isRunning()) {
            service.stop();
        }
    }
}
