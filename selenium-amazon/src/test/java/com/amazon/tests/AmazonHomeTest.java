package com.amazon.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class AmazonHomeTest extends BaseTest {

    @Test(priority = 1)
    public void openAmazonHome() {
        driver.get("https://www.amazon.in");
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Amazon"), "Title does not contain 'Amazon'");
    }

    @Test(priority = 2)
    public void searchProduct() {
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("laptop");
        searchBox.submit();

        // Wait for the result text element
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement resultText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.a-color-state")));

        Assert.assertTrue(resultText.getText().toLowerCase().contains("laptop"));
    }

    @Test(priority = 3)
    public void clickFirstProduct() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Scroll a bit to trigger lazy loading
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 600);");

        // Wait until the first search result link is visible
        WebElement firstProduct = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("div[data-component-type='s-search-result'] h2 a")
        ));

        // Scroll the element into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", firstProduct);

        // Log the product name (optional for debug)
        System.out.println("Clicking on product: " + firstProduct.getText());

        // Click the first product
        firstProduct.click();
    }


}
