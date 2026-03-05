package base;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import utils.ConfigReader;
import page.Categorypage;
import page.Checkoutpage;
import page.Productpage;
import page.Registerpage;
import page.Successpage;
import page.homepage;


public class opencartbase {

    public static WebDriver driver;

    public static homepage home;
    public static Registerpage register;
    public static Successpage desktop;
    public static Categorypage category;
    public static Productpage product;
    public static Checkoutpage checkout;

    public static ExtentReports extent;
    public static ExtentSparkReporter reporter;
    public static ExtentTest test;

    @BeforeTest
    public void setup() {

        reporter = new ExtentSparkReporter("./Report/myreport1.html");
        reporter.config().setDocumentTitle("Automation Report");
        reporter.config().setReportName("Functional Test");
        reporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Host", "localhost");
        extent.setSystemInfo("OS", "Windows");
        extent.setSystemInfo("Tester", "abc");
        extent.setSystemInfo("Browser", "Chrome");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get( ConfigReader.getProperty("url"));
    }

    @BeforeMethod
    public void startTest(Method method) {
        test = extent.createTest(method.getName());
    }

    @BeforeMethod
    public void initializePageObjects() {
        home = new homepage(driver);
        register = new Registerpage(driver);
        desktop = new Successpage(driver);
        category = new Categorypage(driver);
        product = new Productpage(driver);
        checkout = new Checkoutpage(driver);
    }

    @AfterMethod
    public void captureResult(ITestResult result) throws IOException {

        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, "Test Failed: " + result.getName());
            test.log(Status.FAIL, result.getThrowable());

            String screenshotPath = screenshotMethod(driver, result.getName());
            test.addScreenCaptureFromPath(screenshotPath);
        }

        else if (result.getStatus() == ITestResult.SKIP) {
            test.log(Status.SKIP, "Test Skipped: " + result.getName());
        }

        else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, "Test Passed: " + result.getName());
        }
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        extent.flush();
    }

    public static String screenshotMethod(WebDriver driver, String screenshotname) throws IOException {

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String destination = "./Screenshot/" + screenshotname + ".jpeg";
        File finaldestination = new File(destination);
        FileHandler.copy(src, finaldestination);

        return destination;
    }
}
