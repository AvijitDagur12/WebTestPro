package com.webtestpro.base;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.webtestpro.utilities.ScreenshotUtil;

public class BaseTest {

    protected WebDriver driver;
    protected Properties config = new Properties();
    protected String baseUrl;

    @BeforeMethod
    public void setUp(Method method) throws Exception {
        try (InputStream in = getClass().getClassLoader()
                .getResourceAsStream("config.properties")) {
            config.load(in);
        }

        baseUrl = config.getProperty("baseUrl");
        int implicitWait = Integer.parseInt(config.getProperty("implicitWait"));

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE && driver != null) {
            String path = ScreenshotUtil.capture(driver, result.getName());
            System.out.println("Screenshot saved: " + path);
        }
        if (driver != null) driver.quit();
    }
}