package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {

    private WebDriver driver;

    private By productsTitle =
            By.xpath("//span[text()='Products']");
    
    private By addBackpackButton =
            By.id("add-to-cart-sauce-labs-backpack");
    
    private By removeBackpackButton =
            By.id("remove-sauce-labs-backpack");


    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isProductsDisplayed() {

        return driver.findElement(productsTitle)
                     .isDisplayed();
    }
    
    public void addBackpackToCart() {

        driver.findElement(addBackpackButton)
              .click();
    }
    
    public boolean isRemoveButtonDisplayed() {

        return driver.findElement(removeBackpackButton)
                     .isDisplayed();
    }
}