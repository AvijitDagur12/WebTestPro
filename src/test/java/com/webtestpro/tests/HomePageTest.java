package com.webtestpro.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.webtestpro.base.BaseTest;

public class HomePageTest extends BaseTest {

    @Test
    public void homePageOpens() {
        driver.get("https://www.selenium.dev");
        String title = driver.getTitle();
        System.out.println("Title: " + title);
        Assert.assertTrue(title.contains("Selenium"), "Title should contain Selenium");
    }
}