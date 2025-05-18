package pages;

import commonPage.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends BasePage {

    public CartPage(AndroidDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.androidsample.generalstore:id/totalAmountLbl")
    private WebElement txt_totalAmount;

    public boolean isTotalAmountCorrect(double expectedAmount){
        double actualAmount = Double.parseDouble(txt_totalAmount.getText().replaceAll("[^\\d.]", ""));
        return expectedAmount == actualAmount;
    }
}
