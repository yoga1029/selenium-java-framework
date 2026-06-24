package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.lang.reflect.Method;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import reports.ExtentManager;
import utils.ConfigReader;

public class BaseTest {

    protected WebDriver driver;

    protected ExtentReports extent;
    protected ExtentTest test;

    @BeforeMethod
    public void setUp(Method method) 
    {

        extent = ExtentManager.getInstance();
        
        test = extent.createTest(method.getName());

        driver = DriverFactory.getDriver();

        driver.get(ConfigReader.getProperty("url"));
    }

    @AfterMethod
    public void tearDown() 
    {

        DriverFactory.quitDriver();

        extent.flush();
    }
}