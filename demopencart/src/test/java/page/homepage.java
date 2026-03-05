package page;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class homepage {

    WebDriver driver;
    WebDriverWait wait;

    public homepage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    // LOGO 
    @FindBy(id = "logo")
    public WebElement logo;

    // TOP MENU 
    @FindBy(linkText = "Desktops")
    public WebElement desktops;

    @FindBy(linkText = "Laptops & Notebooks")
    public WebElement laptops;

    @FindBy(linkText = "Components")
    public WebElement components;

    @FindBy(linkText = "Tablets")
    public WebElement tablets;

    @FindBy(linkText = "Software")
    public WebElement software;

    @FindBy(linkText = "Phones & PDAs")
    public WebElement phones;

    @FindBy(linkText = "Cameras")
    public WebElement cameras;

    @FindBy(linkText = "MP3 Players")
    public WebElement mp3Players;

    // HEADER LINKS 
    @FindBy(linkText = "My Account")
    public WebElement myAccount;

    @FindBy(linkText = "Wish List (0)")
    public WebElement wishList;

    @FindBy(linkText = "Shopping Cart")
    public WebElement shoppingCart;

    @FindBy(linkText = "Checkout")
    public WebElement checkout;

    // MY ACCOUNT DROPDOWN 
    @FindBy(linkText = "Register")
    public WebElement register;

    // METHODS
    public String getPageTitle() {
        return driver.getTitle();
    }

    public boolean isLogoDisplayed() {
        return logo.isDisplayed();
    }

    public boolean isElementClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return true;
    }

  
    public void clickRegisterFromMyAccount() {

        Actions actions = new Actions(driver);
        actions.moveToElement(myAccount).click().perform();

        wait.until(ExpectedConditions.elementToBeClickable(register));
        register.click();

    }
}
