package pagepkg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class prptyinfopage {
    WebDriver driver;

    @FindBy(id = "proplabel")
    WebElement prptylabel;

    @FindBy(id = "propcategory")
    WebElement catogry;

    @FindBy(id = "propcost")
    WebElement expprice;

    @FindBy(id = "propbeds")
    WebElement beds;

    @FindBy(id = "district")
    WebElement district;

    // Removed @FindBy here to handle with explicit wait
    // @FindBy(id = "proplocation")
    // WebElement location;

    @FindBy(id = "propaddress")
    WebElement address;

    public prptyinfopage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setPropertyLabel(String labelText) {
        prptylabel.sendKeys(labelText);
    }

    public void selectCategory(String categoryName) {
        new Select(catogry).selectByVisibleText(categoryName);
    }

    public void setExpectedPrice(String price) {
        expprice.sendKeys(price);
    }

    public void selectDistrict(String districtName) {
        new Select(district).selectByVisibleText(districtName);
    }

    public void setLocation(String loc) {
        // Explicit wait to ensure element is visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement location = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("proplocation")));
        location.sendKeys(loc);
    }

    public void setnoofbed(String bed) {
        beds.sendKeys(bed);
    }

    public void setAddress(String add) {
        address.sendKeys(add);
    }
}
