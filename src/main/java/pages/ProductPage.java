package pages;

import commonPage.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class ProductPage extends BasePage {

    public ProductPage(AndroidDriver driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Products']")
    private WebElement lbl_products;

    public boolean isProductPagePresent() {
        return lbl_products.isDisplayed();
    }
}
