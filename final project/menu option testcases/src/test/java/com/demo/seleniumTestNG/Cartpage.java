package com.demo.seleniumTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Cartpage {
    WebDriver auto;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\kerol\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        auto = new ChromeDriver();
        auto.manage().window().maximize();
        auto.navigate().to("https://www.saucedemo.com");

        auto.findElement(By.id("user-name")).sendKeys("standard_user");
        auto.findElement(By.id("password")).sendKeys("secret_sauce");
        auto.findElement(By.id("login-button")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void addFirstTwoProductCheckoutProcess()  {
        auto.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        auto.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
        auto.findElement(By.className("shopping_cart_link")).click();
        auto.findElement(By.id("checkout")).click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement checkoutTitle = auto.findElement(By.className("title"));
        Assert.assertEquals(checkoutTitle.getText(), "Checkout: Your Information", "Checkout page not opened correctly.");
    }

    @Test
    public void addFirstProduct() {
        auto.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        auto.findElement(By.className("shopping_cart_link")).click();
        auto.findElement(By.id("continue-shopping")).click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement title = auto.findElement(By.className("title"));
        Assert.assertEquals(title.getText(), "Products", "Did not return to products page.");
    }

    @Test
    public void addAndRemoveFirstProductandcontinueshopping() throws InterruptedException {
        auto.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        auto.findElement(By.className("shopping_cart_link")).click();
        auto.findElement(By.id("remove-sauce-labs-backpack")).click();
        auto.findElement(By.id("continue-shopping")).click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement title = auto.findElement(By.className("title"));
        Assert.assertEquals(title.getText(), "Products", "Continue shopping did not return to product page.");
    }

    @Test
    public void addAndRemoveFirstTwoProductsandcontinueshopping() throws InterruptedException {
        auto.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        auto.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
        auto.findElement(By.className("shopping_cart_link")).click();
        auto.findElement(By.id("remove-sauce-labs-backpack")).click();
        auto.findElement(By.id("remove-sauce-labs-bike-light")).click();
        auto.findElement(By.id("continue-shopping")).click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement title = auto.findElement(By.className("title"));
        Assert.assertEquals(title.getText(), "Products", "Did not return to products page after removing items.");
    }

    @AfterMethod
    public void teardown() {
        if (auto != null) {
            auto.quit();
        }
    }
}




