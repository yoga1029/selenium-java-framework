package base;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ConfigReader;

public class DriverFactory {

    private static WebDriver driver;

    public static WebDriver getDriver() {

        if (driver == null) {

            String browser = ConfigReader.getProperty("browser");

            if (browser.equalsIgnoreCase("chrome")) {

                WebDriverManager.chromedriver().setup();

                ChromeOptions options = new ChromeOptions();

                //options.addArguments("--incognito");
                //options.addArguments("--disable-notifications");

                Map<String, Object> prefs = new HashMap<>();

                prefs.put("credentials_enable_service", false);
                prefs.put("profile.password_manager_enabled", false);
                prefs.put("profile.password_manager_leak_detection", false);
                prefs.put("autofill.profile_enabled", false);
                prefs.put("autofill.credit_card_enabled", false);

                options.setExperimentalOption("prefs", prefs);

                driver = new ChromeDriver(options);

                driver.manage().window().maximize();
            }
        }

        return driver;
    }

    public static void quitDriver() {

        if (driver != null) {

            driver.quit();
            driver = null;
        }
    }
}





//package base;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//import utils.ConfigReader;
//
//public class DriverFactory {
//
//    private static WebDriver driver;
//
//    public static WebDriver getDriver() {
//
//        if (driver == null) {
//
//            String browser = ConfigReader.getProperty("browser");
//
//            if (browser.equalsIgnoreCase("chrome")) {
//
//                WebDriverManager.chromedriver().setup();
//
//                driver = new ChromeDriver();
//                driver.manage().window().maximize();
//            }
//        }
//
//        return driver;
//    }
//
//    public static void quitDriver() {
//
//        if (driver != null) {
//            driver.quit();
//            driver = null;
//        }
//    }
//}