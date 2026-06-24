package tests;

import org.testng.annotations.Test;

import org.testng.Assert;

import base.BaseTest;
import pages.CartPage;
import pages.CheckoutPage;
import pages.CompleteOrderPage;
import pages.InventoryPage;
import pages.LoginPage;
import pages.OverviewPage;

public class EndToEndTest extends BaseTest 
{

    @Test
    public void verifyEndToEndPurchaseFlow() 
    {
    	//Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        System.out.println(" [INFO] Login successful");
        test.pass("Login successful");
        
        //Move to Inventory Page
        InventoryPage inventoryPage = new InventoryPage(driver);
        Assert.assertTrue(inventoryPage.isProductsDisplayed(), "Inventory Page is not displayed");
        System.out.println("[INFO] Inventory page displayed");
        test.pass("Inventory page displayed");

        
        //Add Product to Cart
        inventoryPage.addBackpackToCart();
        System.out.println(" [INFO] Backpack added to cart");
        test.pass("Backpack added to cart");


        //Assert that remove button is displayed
        Assert.assertTrue(inventoryPage.isRemoveButtonDisplayed(), "Product was not added to the Cart");
        System.out.println("[INFO] Remove button displayed");

        //Cart Page
        CartPage cartPage = new CartPage(driver);

        cartPage.openCart();

        System.out.println("[INFO] Cart page opened");
        test.pass("Cart page opened");


        cartPage.clickCheckout();

        System.out.println("[INFO] Checkout clicked");
        test.pass("Checkout clicked");

        
        //Checkout Page
        CheckoutPage checkoutPage =
                new CheckoutPage(driver);

        checkoutPage.enterCheckoutDetails(
                "Yoga",
                "Subramanian",
                "600001");

        System.out.println("[INFO] Checkout details entered");
        test.pass("Checkout details entered");

        
        //Overview Page 
        OverviewPage overviewPage =
                new OverviewPage(driver);

        overviewPage.clickFinish();

        System.out.println("[INFO] Finish button clicked");
        test.pass("Finish button clicked");

        
        //Complete Order Page
        CompleteOrderPage completeOrderPage =
                new CompleteOrderPage(driver);

        Assert.assertTrue(
                completeOrderPage.isOrderSuccessful(),
                "Order was not completed");

        System.out.println("[INFO] Order completed successfully");
        test.pass("Order completed successfully");
    }
}