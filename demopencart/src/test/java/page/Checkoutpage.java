package page;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

public class Checkoutpage {

    WebDriver driver;
    WebDriverWait wait;

    public Checkoutpage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    // BILLING DETAILS 
    @FindBy(name = "firstname")
    private WebElement firstName;

    @FindBy(name = "lastname")
    private WebElement lastName;

    @FindBy(name = "address_1")
    private WebElement address1;

    @FindBy(name = "city")
    private WebElement city;

    @FindBy(name = "postcode")
    private WebElement postCode;

    @FindBy(name = "country_id")
    private WebElement countryDropdown;

    @FindBy(name = "zone_id")
    private WebElement stateDropdown;

    @FindBy(xpath = "//*[@id=\"button-payment-address\"]")
    private WebElement continueBillingBtn;
    
    @FindBy(xpath = "//*[@id=\"button-shipping-address\"]")
    private WebElement deliverydetails;


    //  DELIVERY METHOD 
    @FindBy(name = "comment")
    private WebElement deliveryComments;
    
    @FindBy(xpath = "//*[@id=\"button-shipping-method\"]")
    private WebElement deliveryCommentscontinuebutton;


    // PAYMENT METHOD
    @FindBy(xpath= "//*[@id=\"collapse-payment-method\"]/div/div[2]/div/input[1]")
    private WebElement termsCheckbox;

    @FindBy(xpath = "//*[@id=\"button-payment-method\"]")
    private WebElement continuePaymentBtn;
    
    @FindBy(xpath = "//*[@id=\"button-confirm\"]")
    private WebElement confirm;

    // ACTION METHODS 
    public void fillBillingDetails(String fn, String ln, String addr, String cityName,
                                   String pcode, String country, String state) {

        wait.until(ExpectedConditions.visibilityOf(firstName)).sendKeys(fn);
        lastName.sendKeys(ln);
        address1.sendKeys(addr);
        city.sendKeys(cityName);
        postCode.sendKeys(pcode);

        new Select(countryDropdown).selectByVisibleText(country);
        new Select(stateDropdown).selectByVisibleText(state);
    }

    public void clickContinueBilling() {
        continueBillingBtn.click();
        deliverydetails.click();
        
    }

    public void enterDeliveryComments(String comment) {
        wait.until(ExpectedConditions.visibilityOf(deliveryComments)).sendKeys(comment);
        deliveryCommentscontinuebutton.click();
    }

    public void agreeTerms() {
       termsCheckbox.click();
    }

    public void clickContinuePayment() {
        continuePaymentBtn.click();
    }
    
    public void confirmbutton() {
    	confirm.click();
    
    
}
}
