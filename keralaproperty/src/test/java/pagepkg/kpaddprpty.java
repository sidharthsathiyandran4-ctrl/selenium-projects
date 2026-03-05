package pagepkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class kpaddprpty {

    WebDriver driver;

    @FindBy(xpath="/html/body/div[3]/div/div/div[1]/div/ul/li[3]/a")
    WebElement addprpty;  // ✔ correct

    public kpaddprpty(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // ✔ initialize page elements
    }

    public void clickAddProperty() {
        addprpty.click();  // ✔ correct place to click
    }
}
