package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CompleteOrderPage {

    private WebDriver driver;

    private By successMessage =
            By.xpath("//h2[text()='Thank you for your order!']");

    public CompleteOrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isOrderSuccessful() 
    {

        return driver.findElement(successMessage)
                     .isDisplayed();
    }
}