package page;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Successpage {

    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    public Successpage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    // Desktops main menu
    @FindBy(xpath = "//*[@id='menu']/div[2]/ul/li[1]/a")
    private WebElement desktopsMenu;

    // Show All Desktops (inside dropdown)
    @FindBy(xpath = "//*[@id='menu']/div[2]/ul/li[1]/div/a")
    private WebElement showAllDesktops;

    public void clickShowAllDesktops() {

        // Hover on Desktops
        wait.until(ExpectedConditions.visibilityOf(desktopsMenu));
        actions.moveToElement(desktopsMenu).perform();

        // Now submenu becomes present
        wait.until(ExpectedConditions.visibilityOf(showAllDesktops));
        showAllDesktops.click();
    }
}
