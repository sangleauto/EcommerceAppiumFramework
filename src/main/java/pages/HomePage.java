package pages;

import commonPage.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    public HomePage(AndroidDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
    private WebElement input_name;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/spinnerCountry")
    private WebElement select_country;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
    private WebElement btn_letsShop;

    private static final String BTN_DYNAMIC_COUNTRY_XPATH = "android.widget.TextView[@text=\"%s\"]";
    private static final String CHK_DYNAMIC_GENDER_ID = "com.androidsample.generalstore:id/radio%s";

    public HomePage fillName(String name) {
        input_name.sendKeys(name);
        return this;
    }

    public HomePage selectCountry(String country) {
        select_country.click();
        scrollGesture(country);
        WebElement btn_country = findDynamicElementByXpath(BTN_DYNAMIC_COUNTRY_XPATH, country);
        btn_country.click();
        return this;
    }

    public HomePage checkGender(String gender) {
        WebElement chk_gender = findDynamicElementById(CHK_DYNAMIC_GENDER_ID, gender);
        chk_gender.click();
        return this;
    }

    public ProductPage clickLetsShop() {
        btn_letsShop.click();
        return new ProductPage(driver);
    }
}
