package pagepkg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class sdhomepagecls {

    WebDriver driver;
    By swagLabText = By.className("app_logo");
    By sortDropdown = By.className("product_sort_container");
    By productAddButtons = By.xpath("//button[contains(text(),'Add to cart')]");
    By cartButton = By.id("shopping_cart_container");

    public sdhomepagecls(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isSwagLabTextPresent() {
        return driver.findElement(swagLabText).isDisplayed();
    }

    public void sortLowToHigh() {
        Select dropdown = new Select(driver.findElement(sortDropdown));
        dropdown.selectByVisibleText("Price (low to high)");
    }

    public void addAllProductsToCart() {
        driver.findElements(productAddButtons).forEach(btn -> btn.click());
    }

    public void clickCart() {
        driver.findElement(cartButton).click();
    }
}
