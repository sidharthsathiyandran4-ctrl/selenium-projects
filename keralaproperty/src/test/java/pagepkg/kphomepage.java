package pagepkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class kphomepage {
	
	WebDriver driver;
	@FindBy(xpath="/html/body/div[3]/div/div/div[2]/div/div[1]/h2")
    WebElement property;
	
public kphomepage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

public boolean propertydisplay() {
	return property.isDisplayed();
	
}


}
