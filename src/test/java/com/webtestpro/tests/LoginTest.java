package com.webtestpro.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.webtestpro.base.BaseTest;
import com.webtestpro.pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void validLogin() {
        driver.get(baseUrl);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"),
                "Should land on inventory page");
    }

    @Test
    public void invalidLogin() {
        driver.get(baseUrl);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("wrong_user", "wrong_pass");

        String error = loginPage.getErrorMessage();
        Assert.assertTrue(error.contains("Username and password do not match"));
    }
}