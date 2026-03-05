package pagepkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class kploginpage {

    WebDriver driver;

    @FindBy(id="ulogin")
    WebElement username;

    @FindBy(id="upass")
    WebElement password;

    @FindBy(id="sub_logbtn")
    WebElement loginbutton;

    public kploginpage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Set username & password
    public void setvalues(String uname, String pwd) {
        username.sendKeys(uname);
        password.sendKeys(pwd);
    }

    // Click login button
    public void logicClick() throws Exception {
        loginbutton.click();
        Thread.sleep(3000);
    }

}
