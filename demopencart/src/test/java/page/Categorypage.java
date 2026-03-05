package page;

import java.awt.Desktop.Action;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Categorypage {

    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    public Categorypage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    // Sort dropdown
    @FindBy(id = "input-sort")
    private WebElement sortDropdown;

    // Show limit dropdown
    @FindBy(id = "input-limit")
    private WebElement showLimitDropdown;
    
    @FindBy(xpath = "//*[@id='content']/div[4]/div[10]/div/div[1]/a/img")
    private WebElement productImage;
    
    



    // ACTIONS 

    public void sortByPriceHighToLow() {
        wait.until(ExpectedConditions.visibilityOf(sortDropdown));
        new Select(sortDropdown).selectByVisibleText("Price (High > Low)");
    }

    public void setShowLimitTo100() {
        wait.until(ExpectedConditions.visibilityOf(showLimitDropdown));
        new Select(showLimitDropdown).selectByVisibleText("100");
    }
    
  
  
    public void clickProductImage() {
        wait.until(ExpectedConditions.elementToBeClickable(productImage)).click();
    }

    	}

