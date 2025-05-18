package commonPage;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.Map;

public class BasePage {
    protected AppiumDriver driver;

    public BasePage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }

    public void longPresGesture(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "endX", 100,
                "endY", 100
        ));

    }

    public boolean flingGesture(WebElement element, int speed) {
        Map<String, Object> params = Map.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", "down",
                "speed", speed
        );
        Object result = driver.executeScript("mobile: flingGesture", params);
        return Boolean.TRUE.equals(result);
    }

    public void scrollUntilFindElement(By by) {
        Object canScrollMore;
        do {
            Map<String, Object> params = Map.of(
                    "left", 100, "top", 100, "width", 200, "height", 200,
                    "direction", "down",
                    "percent", 1.0
            );
            canScrollMore = driver.executeScript("mobile: scrollGesture", params);
        }
        while (Boolean.TRUE.equals(canScrollMore) && driver.findElements(by).isEmpty());
    }

    public WebElement scrollGesture(String text) {
        return driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().text(\"" + text + "\"));"));
    }

    public void swipeGesture(WebElement element, String direction) {
        Map<String, Object> params = Map.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", direction,
                "percent", 0.75
        );

        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", params);
    }

    public void dragAndDropGesture(WebElement element, int endX, int endY) {
        Map<String, Object> params = Map.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "endX", endX,
                "endY", endY
        );

        ((JavascriptExecutor) driver).executeScript("mobile: dragGesture", params);
    }

    public void checkToElement(WebElement element) {
        if (!element.isSelected()) {
            element.click();
        }
    }

    protected WebElement findDynamicElementById(String locatorTemplate, String value) {
        String locator = String.format(locatorTemplate, value);
        return driver.findElement(By.id(locator));
    }

    protected WebElement findDynamicElementByXpath(String locatorTemplate, String value) {
        String locator = "//" + String.format(locatorTemplate, value);
        return driver.findElement(By.xpath(locator));
    }
}
