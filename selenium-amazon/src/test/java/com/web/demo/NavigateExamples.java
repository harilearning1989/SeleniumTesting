package com.web.demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class NavigateExamples {

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

    @Test
    public void testNavigate() throws InterruptedException {
        driver.get("https://www.facebook.com/");
        driver.findElement(By.partialLinkText("Create new account")).click();
        TimeUnit.SECONDS.sleep(2);
        driver.navigate().back();
        TimeUnit.SECONDS.sleep(2);
        driver.navigate().forward();
        TimeUnit.SECONDS.sleep(2);
        driver.navigate().refresh();
        TimeUnit.SECONDS.sleep(2);
        driver.navigate().to("https://www.google.com/");
        TimeUnit.SECONDS.sleep(2);
    }
}
