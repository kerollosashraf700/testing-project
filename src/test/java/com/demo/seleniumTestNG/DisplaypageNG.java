package com.demo.seleniumTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class DisplaypageNG {

    WebDriver auto;

    @BeforeMethod
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\kerol\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        auto = new ChromeDriver();
        auto.manage().window().maximize();
        auto.get("https://www.saucedemo.com");

        WebElement Username = auto.findElement(By.id("user-name"));
        Username.sendKeys("standard_user");

        WebElement password = auto.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        auto.findElement(By.id("login-button")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void HSL1() {
        auto.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        auto.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
        auto.findElement(By.className("shopping_cart_link")).click();

        Assert.assertTrue(auto.getCurrentUrl().contains("cart.html"), "Not redirected to cart page.");
        List<WebElement> cartItems = auto.findElements(By.className("cart_item"));
        Assert.assertEquals(cartItems.size(), 2, "Cart item count does not match (Expected 2).");
    }

    @Test
    public void HSL2() {
        auto.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        auto.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
        auto.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
        auto.findElement(By.className("shopping_cart_link")).click();

        Assert.assertTrue(auto.getCurrentUrl().contains("cart.html"), "Not redirected to cart page.");
        List<WebElement> cartItems = auto.findElements(By.className("cart_item"));
        Assert.assertEquals(cartItems.size(), 3, "Cart item count does not match (Expected 3).");
    }

    @Test
    public void HSL3() {
        auto.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        auto.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
        auto.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
        auto.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
        auto.findElement(By.className("shopping_cart_link")).click();

        Assert.assertTrue(auto.getCurrentUrl().contains("cart.html"), "Not redirected to cart page.");
        List<WebElement> cartItems = auto.findElements(By.className("cart_item"));
        Assert.assertEquals(cartItems.size(), 4, "Cart item count does not match (Expected 4).");
    }

    @Test
    public void HS4() {
        auto.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        auto.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
        auto.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
        auto.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
        auto.findElement(By.id("add-to-cart-sauce-labs-onesie")).click();
        auto.findElement(By.className("shopping_cart_link")).click();

        Assert.assertTrue(auto.getCurrentUrl().contains("cart.html"), "Not redirected to cart page.");
        List<WebElement> cartItems = auto.findElements(By.className("cart_item"));
        Assert.assertEquals(cartItems.size(), 5, "Cart item count does not match (Expected 5).");
    }

    @AfterMethod
    public void closeBrowser() {
        if (auto != null) {
            auto.quit();
        }
    }

}

