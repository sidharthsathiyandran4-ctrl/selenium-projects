package testpkg;

import basepkg.sdbasecls;
import org.testng.Assert;
import org.testng.annotations.Test;
import pagepkg.LoginPage;
import pagepkg.overviewpage;
import pagepkg.sdhomepagecls;
import pagepkg.sdcartpagecls;
import pagepkg.sdcheckoutpagecls;

public class sdtestcls extends sdbasecls {

    @Test
    public void testSwagLabsFlow() {

        // login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        //home page
        sdhomepagecls homePage = new sdhomepagecls(driver);
        Assert.assertTrue(homePage.isSwagLabTextPresent(), "Swag Labs text is not displayed");

        //low to high
        homePage.sortLowToHigh();
        Assert.assertEquals(driver.getTitle(), "Swag Labs", "Title mismatch after sorting");

        //prod to cart
        homePage.addAllProductsToCart();

        //go to cart
        homePage.clickCart();

        //cart page
        sdcartpagecls cartPage = new sdcartpagecls(driver);
        Assert.assertTrue(cartPage.isYourCartTextPresent(), "'Your Cart' text is not displayed");

        // checkout button
        cartPage.clickCheckout();

        // checkout page
        sdcheckoutpagecls checkoutPage = new sdcheckoutpagecls(driver);
        checkoutPage.fillCheckoutAndContinue("rahul", "hhj", "12345");

        // checkout Overview page
        overviewpage overviewPage = new overviewpage(driver);
        overviewPage.clickFinish();
    }
}
