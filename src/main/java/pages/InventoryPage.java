package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {

    private WebDriver driver;

    private By productsTitle =
            By.xpath("//span[text()='Products']");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isProductsDisplayed() {

        return driver.findElement(productsTitle)
                     .isDisplayed();
    }
}