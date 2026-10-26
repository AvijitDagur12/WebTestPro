package com.webtestpro.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

    private WebDriver driver;

    private By firstName    = By.id("first-name");
    private By lastName     = By.id("last-name");
    private By postalCode   = By.id("postal-code");
    private By continueBtn  = By.id("continue");
    private By finishBtn    = By.id("finish");
    private By thankYouText = By.className("complete-header");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillDetails(String first, String last, String zip) {
        driver.findElement(firstName).sendKeys(first);
        driver.findElement(lastName).sendKeys(last);
        driver.findElement(postalCode).sendKeys(zip);
        driver.findElement(continueBtn).click();
    }

    public void finishOrder() {
        driver.findElement(finishBtn).click();
    }

    public String getThankYouMessage() {
        return driver.findElement(thankYouText).getText();
    }
}