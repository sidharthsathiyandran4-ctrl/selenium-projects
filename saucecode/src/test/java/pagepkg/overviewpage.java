package pagepkg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class overviewpage {

    WebDriver driver;

    By finishButton = By.id("finish");

    public overviewpage(WebDriver driver) {
        this.driver = driver;
    }

    // finish 
    public void clickFinish() {
        driver.findElement(finishButton).click();
    }
}
