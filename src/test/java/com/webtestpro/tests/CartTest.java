package com.webtestpro.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.webtestpro.base.BaseTest;
import com.webtestpro.pages.InventoryPage;
import com.webtestpro.pages.LoginPage;

public class CartTest extends BaseTest {

    @Test
    public void addItemToCart() {
        driver.get(baseUrl);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addFirstItemToCart();

        String count = inventoryPage.getCartCount();
        System.out.println("Cart count: " + count);
        Assert.assertEquals(count, "1", "Cart should have 1 item");
    }
}