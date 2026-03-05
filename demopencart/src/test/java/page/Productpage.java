package page;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

public class Productpage {

    WebDriver driver;
    WebDriverWait wait;

    public Productpage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    //  ELEMENTS 

  

    // Quantity
    @FindBy(id = "input-quantity")
    private WebElement quantityBox;

    // Add to Cart
    @FindBy(id = "button-cart")
    private WebElement addToCartBtn;
    
    @FindBy(xpath="//*[@id=\"cart\"]/button")
    WebElement addtocarttbutton;
    
    @FindBy(xpath="//*[@id=\"cart\"]/ul/li[2]/div/p/a[2]/strong")
    WebElement checkoutbutton;
    

    // ACTIONS 

  

    public void setQuantity(String qty) {
        wait.until(ExpectedConditions.visibilityOf(quantityBox));
        quantityBox.clear();
        quantityBox.sendKeys(qty);
    }

    public void clickAddToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn)).click();
    }
    
    public void cartbutton() {
    	wait.until(ExpectedConditions.elementToBeClickable(addtocarttbutton)).click();
    	wait.until(ExpectedConditions.elementToBeClickable(checkoutbutton)).click();
    	
    }
}
