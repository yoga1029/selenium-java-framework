package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage 
{
	private WebDriver driver;
	private By cartIcon = By.id("shopping_cart_container");
	private By checkoutButton = By.id("checkout");
	
	public CartPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void openCart()
	{
		driver.findElement(cartIcon).click();
	}
	
	public void clickCheckout()
	{
		driver.findElement(checkoutButton).click();
	}

}
