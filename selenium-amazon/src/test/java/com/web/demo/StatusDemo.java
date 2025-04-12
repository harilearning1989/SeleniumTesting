package com.web.demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class StatusDemo {

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
        driver.get("https://www.google.com/");
        WebElement webElement = driver.findElement(By.xpath("//img[@class='lnXdpd']"));
        boolean flag = webElement.isDisplayed();
        boolean flag1 = webElement.isEnabled();
        boolean flag2 = webElement.isSelected();

        System.out.println(flag+"==="+flag1+"==="+flag2);

        WebElement searchBox = driver.findElement(By.cssSelector("textarea#APjFqb"));
        searchBox.sendKeys("Duddukunta");

        TimeUnit.SECONDS.sleep(2);
    }
}
