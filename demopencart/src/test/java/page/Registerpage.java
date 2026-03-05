package page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Registerpage {

    WebDriver driver;
    WebDriverWait wait;


    public Registerpage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      
        PageFactory.initElements(driver, this);
    }

    // -------- ELEMENTS --------

    @FindBy(id = "input-firstname")
    private WebElement firstName;

    @FindBy(id = "input-lastname")
    private WebElement lastName;

    @FindBy(id = "input-email")
    private WebElement email;

    @FindBy(id = "input-telephone")
    private WebElement telephone;

    @FindBy(id = "input-password")
    private WebElement password;

    @FindBy(id = "input-confirm")
    private WebElement confirmPassword;

    @FindBy(xpath = "//input[@name='newsletter' and @value='1']")
    private WebElement newsletterYes;

    @FindBy(name = "agree")
    private WebElement privacyPolicy;

    @FindBy(xpath = "//input[@value='Continue']")
    private WebElement continueBtn;

    //  ACTIONS 

    public void enterFirstName(String fname) {
        wait.until(ExpectedConditions.visibilityOf(firstName)).sendKeys(fname);
    }

    public void enterLastName(String lname) {
        wait.until(ExpectedConditions.visibilityOf(lastName)).sendKeys(lname);
    }

    public void enterEmail(String mail) {
        wait.until(ExpectedConditions.visibilityOf(email)).sendKeys(mail);
    }

    public void enterTelephone(String phone) {
        wait.until(ExpectedConditions.visibilityOf(telephone)).sendKeys(phone);
    }

    public void enterPassword(String pwd) {
        wait.until(ExpectedConditions.visibilityOf(password)).sendKeys(pwd);
    }

    public void enterConfirmPassword(String cpwd) {
        wait.until(ExpectedConditions.visibilityOf(confirmPassword)).sendKeys(cpwd);
    }

    public void selectNewsletterYes() {
        wait.until(ExpectedConditions.elementToBeClickable(newsletterYes)).click();
    }

    public void acceptPrivacyPolicy() {
        wait.until(ExpectedConditions.elementToBeClickable(privacyPolicy)).click();
    }

    public void clickContinue() {
        wait.until(ExpectedConditions.elementToBeClickable(continueBtn)).click();

        // 🔑 WAIT FOR SUCCESS PAGE
        wait.until(ExpectedConditions.titleContains("Your Account Has Been Created"));

        // 🔑 RE-INITIALIZE ELEMENTS FOR NEW PAGE
        //PageFactory.initElements(driver, this);
    }

    // DESKTOP MENU 

    @FindBy(xpath = "//li[@class='dropdown'][.//a[text()='Desktops']]")
    private WebElement desktopsMenu;

  
    @FindBy(linkText = "Show All Desktops")
    private WebElement showAllDesktops;


}
