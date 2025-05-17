package tests;

import commonTest.BaseTest;
import commonTest.DataHelper;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductPage;

public class TestGeneralStore extends BaseTest {
    @Test
    public void testFillFormToStartShopping() {
        HomePage homePage = new HomePage(driver);
        homePage.fillName(DataHelper.generateRandomName())
                .selectCountry("Belgium")
                .checkGender(DataHelper.generateRandomGender())
                .clickLetsShop();
        Assert.assertTrue(new ProductPage(driver).isProductPagePresent(), "Product page is not present as expected");
    }
}
