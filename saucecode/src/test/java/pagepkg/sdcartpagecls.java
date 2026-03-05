package pagepkg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class sdcartpagecls {

    WebDriver driver;

    By cartText = By.xpath("//span[text()='Your Cart']");
    By checkoutButton = By.xpath("//*[@id='checkout']");  // Added locator

    public sdcartpagecls(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isYourCartTextPresent() {
        return driver.findElement(cartText).isDisplayed();
    }

    public void clickCheckout() {
        driver.findElement(checkoutButton).click();
    }
}
