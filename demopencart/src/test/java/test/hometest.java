package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.opencartbase;

public class hometest extends opencartbase {

 
    @Test
    public void verifyTitle() {
        Assert.assertEquals(home.getPageTitle(), "Register Account",
                "Page title mismatch");
    }

    @Test
    public void verifyLogoVisible() {
        Assert.assertTrue(home.isLogoDisplayed(), "Logo not visible");
    }

    @Test
    public void verifyTopMenuClickable() {
        Assert.assertTrue(home.isElementClickable(home.desktops));
        Assert.assertTrue(home.isElementClickable(home.laptops));
        Assert.assertTrue(home.isElementClickable(home.components));
        Assert.assertTrue(home.isElementClickable(home.tablets));
        Assert.assertTrue(home.isElementClickable(home.software));
        Assert.assertTrue(home.isElementClickable(home.phones));
        Assert.assertTrue(home.isElementClickable(home.cameras));
        Assert.assertTrue(home.isElementClickable(home.mp3Players));
    }

    @Test
    public void verifyHeaderLinksClickable() {
        Assert.assertTrue(home.isElementClickable(home.myAccount));
        Assert.assertTrue(home.isElementClickable(home.wishList));
        Assert.assertTrue(home.isElementClickable(home.shoppingCart));
        Assert.assertTrue(home.isElementClickable(home.checkout));
    }

    @Test
   public void clickregisterfromyacc() {
        home. clickRegisterFromMyAccount();    
    
    }
}
