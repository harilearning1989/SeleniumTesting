package com.fb.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class FacebookTest {
    //Locator strategies
    //id,name,xpath,linkText,partialLinkText,css,classname,tagName

    protected WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    //@Test
    public void openFacebook() {
        driver.get("https://www.facebook.com/");
        System.out.println("Open Facebook URL::" + driver.getCurrentUrl());
        String title = driver.getTitle();
        System.out.println("Title::" + title);

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/");
        Assert.assertEquals(driver.getTitle(), "Facebook – log in or sign up");

        driver.findElement(By.id("email")).sendKeys("test@facebook.com");
        driver.findElement(By.id("pass")).sendKeys("test");
        driver.findElement(By.name("login")).click();

        // Wait for the result text element
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    //@Test
    public void testLinkText() {
        driver.get("https://www.facebook.com/");
        driver.findElement(By.linkText("Forgotten password?")).click();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //@Test
    public void testPartialLinkTextTmp() {
        driver.get("https://www.facebook.com/");
        driver.findElement(By.partialLinkText("Forgotten password?")).click();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testPartialLinkText() {
        driver.get("https://www.facebook.com/");
        driver.findElement(By.partialLinkText("Create new account")).click();
        driver.findElement(By.name("firstname")).sendKeys("Duddukunta");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * this method is for click on new button and click on Privacy
     */
    @Test
    public void testCreateNewAccount() {
        driver.get("https://www.facebook.com/");
        driver.findElement(By.partialLinkText("Create new account")).click();

        driver.findElement(By.id("privacy-link")).click();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
