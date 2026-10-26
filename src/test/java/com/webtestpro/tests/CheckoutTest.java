package com.webtestpro.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.webtestpro.base.BaseTest;
import com.webtestpro.pages.CheckoutPage;
import com.webtestpro.pages.InventoryPage;
import com.webtestpro.pages.LoginPage;

public class CheckoutTest extends BaseTest {

    @Test
    public void completeCheckoutFlow() {
        driver.get(baseUrl);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addFirstItemToCart();
        inventoryPage.openCart();

        driver.findElement(org.openqa.selenium.By.id("checkout")).click();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.fillDetails("John", "Doe", "12345");
        checkoutPage.finishOrder();

        String message = checkoutPage.getThankYouMessage();
        System.out.println("Final message: " + message);
        Assert.assertTrue(message.contains("Thank you for your order"));
    }
}