package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;

public class SmokeTest extends BaseTest {

    @Test
    public void verifySauceDemoHomePage() {

        String actualTitle = driver.getTitle();

        System.out.println("Page Title: " + actualTitle);

        Assert.assertEquals(
                actualTitle,
                "Swag Labs",
                "Page title does not match!");
    }
}