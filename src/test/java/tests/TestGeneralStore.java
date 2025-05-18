package tests;

import commonTest.BaseTest;
import commonTest.DataHelper;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;

public class TestGeneralStore extends BaseTest {
    @Test(priority = 1)
    public void testFillFormToStartShopping() {
        homePage.fillName(DataHelper.generateRandomName())
                .selectCountry("Belgium")
                .checkGender(DataHelper.generateRandomGender());

        ProductPage productPage = homePage.clickLetsShop();
        Assert.assertTrue(productPage.isProductPagePresent(), "Product page is not present as expected");
        productPage.addAllItemsToCart();
        double expectedAmount = productPage.getTotalAmountOfAddedItems();
        CartPage cartPage = productPage.clickOpenCart();
        Assert.assertTrue(cartPage.isTotalAmountCorrect(expectedAmount), "Total Purchase Amount is not correct");
    }
}
