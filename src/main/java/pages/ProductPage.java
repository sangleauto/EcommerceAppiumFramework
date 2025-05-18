package pages;

import commonPage.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductPage extends BasePage {

    public ProductPage(AndroidDriver driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Products']")
    private WebElement lbl_products;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/productAddCart")
    private List<WebElement> lnk_addToCartList;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/productPrice")
    private List<WebElement> txt_productPriceList;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")
    private WebElement btn_cart;

    public boolean isProductPagePresent() {
        return lbl_products.isDisplayed();
    }

    public ProductPage addAllItemsToCart() {
        for (WebElement lnk_addToCart : lnk_addToCartList) {
            lnk_addToCart.click();
        }
        return this;
    }

    public double getTotalAmountOfAddedItems() {
        double totalPrice = 0;
        for (WebElement txt_productPrice : txt_productPriceList) {
            totalPrice += Double.parseDouble(txt_productPrice.getText().replaceAll("[^\\d.]", ""));
        }
        return totalPrice;
    }

    public CartPage clickOpenCart() {
        btn_cart.click();
        return new CartPage(driver);
    }
}
