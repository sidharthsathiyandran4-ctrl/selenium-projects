package pagepkg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class sdcheckoutpagecls {

    WebDriver driver;

    By firstNameField = By.id("first-name");
    By lastNameField = By.id("last-name");
    By postalCodeField = By.id("postal-code");
    By continueButton = By.id("continue");

    public sdcheckoutpagecls(WebDriver driver) {
        this.driver = driver;
    }

    public void enterCheckoutInfo(String firstName, String lastName, String postalCode) {
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(postalCodeField).sendKeys(postalCode);
    }

    public void clickContinue() {
        driver.findElement(continueButton).click();
    }

    public void fillCheckoutAndContinue(String firstName, String lastName, String postalCode) {
        enterCheckoutInfo(firstName, lastName, postalCode);
        clickContinue();
    }
}
