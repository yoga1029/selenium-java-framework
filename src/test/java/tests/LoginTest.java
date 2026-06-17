package tests;

import org.testng.annotations.Test;

import org.testng.Assert;

import base.BaseTest;
import pages.InventoryPage;
import pages.LoginPage;

public class LoginTest extends BaseTest 
{

    @Test
    public void verifyValidLogin() 
    {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("standard_user", "secret_sauce");
        
        InventoryPage inventoryPage = new InventoryPage(driver);

        Assert.assertTrue(inventoryPage.isProductsDisplayed(), "Products title is not displayed");
    }
}