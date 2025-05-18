package commonTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;

import java.time.Duration;

public class BaseTest {
    protected AndroidDriver driver;
    private AppiumDriverLocalService service;
    protected HomePage homePage;

    @BeforeMethod
    public void setup() {
        service = new AppiumServiceBuilder().withArgument(() -> "--allow-insecure", "chromedriver_autodownload")
                .withIPAddress(ConfigReader.getURL()).usingPort(ConfigReader.getPort()).build();
        service.start();

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName(ConfigReader.getDeviceName())
                .setAppPackage(ConfigReader.getAppPackage())
                .setAppActivity(ConfigReader.getAppActivity());

        driver = new AndroidDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        homePage = new HomePage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
        service.stop();
    }
}
