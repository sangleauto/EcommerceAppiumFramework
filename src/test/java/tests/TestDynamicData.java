package tests;

import commonTest.BaseTest;
import dataProvider.DataProviders;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductPage;

public class TestDynamicData extends BaseTest {
    @Test(dataProvider = "fillFormData", dataProviderClass = DataProviders.class)
    public void testShoppingWithDynamicData(String name, String country, String gender) {
        homePage.fillName(name)
                .selectCountry(country)
                .checkGender(gender);

        ProductPage productPage = homePage.clickLetsShop();
        Assert.assertTrue(productPage.isProductPagePresent(), "Product page is not present as expected");
//        productPage.addAllItemsToCart();
//        double expectedAmount = productPage.getTotalAmountOfAddedItems();
//        CartPage cartPage = productPage.clickOpenCart();
//        Assert.assertTrue(cartPage.isTotalAmountCorrect(expectedAmount), "Total Purchase Amount is not correct");
    }
}
