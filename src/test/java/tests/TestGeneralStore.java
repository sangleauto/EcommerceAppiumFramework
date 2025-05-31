package tests;

import commonPage.DataHelper;
import commonTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.ProductPage;

public class TestGeneralStore extends BaseTest {
    @Test(priority = 1)
    public void testVerifyToastMessage() {
        homePage.clickLetsShop();
        Assert.assertEquals(homePage.getToastMessage(), "Please enter your name");
    }

    @Test(priority = 2)
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
