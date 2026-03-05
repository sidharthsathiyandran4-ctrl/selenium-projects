package basepkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import pagepkg.kpaddprpty;
import pagepkg.kphomepage;
import pagepkg.kploginpage;
import pagepkg.prptyinfopage;

public class kpbaseclass {
	
	public static WebDriver driver;
	public static kploginpage login;
	public static kphomepage homepage;
	public static kpaddprpty addprptypage;
	public static prptyinfopage info;
	@BeforeTest
	public void setup() {
		driver=new ChromeDriver();
				driver.get("https://keralaproperty.in/member/login/");
	}
	@BeforeMethod
	public void bfrmthd() {
		
	login=new kploginpage(driver);
	homepage=new kphomepage(driver);
	addprptypage=new kpaddprpty(driver);
	info=new prptyinfopage(driver);
	}
	

}
