package com.demo.seleniumTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Checkout {

    WebDriver auto;

    @BeforeMethod
    public void login() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\kerol\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        auto = new ChromeDriver();
        auto.manage().window().maximize();
        auto.get("https://www.saucedemo.com");

        auto.findElement(By.id("user-name")).sendKeys("standard_user");
        auto.findElement(By.id("password")).sendKeys("secret_sauce");
        auto.findElement(By.id("login-button")).click();

        auto.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        auto.findElement(By.className("shopping_cart_link")).click();
        auto.findElement(By.id("checkout")).click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void checkoutWithValidData() {
        auto.findElement(By.id("first-name")).sendKeys("Samah");
        auto.findElement(By.id("last-name")).sendKeys("Sherbeny");
        auto.findElement(By.id("postal-code")).sendKeys("12345");
        auto.findElement(By.id("continue")).click();

        String currentUrl = auto.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("checkout-step-two"), "User did not reach overview page.");
    }


    @Test
    public void checkoutWithSpecialCharLastName() {
        auto.findElement(By.id("first-name")).sendKeys("Samah");
        auto.findElement(By.id("last-name")).sendKeys("@#$#%$%");
        auto.findElement(By.id("postal-code")).sendKeys("ME5594");
        auto.findElement(By.id("continue")).click();

        WebElement error = auto.findElement(By.cssSelector("h3[data-test='error']"));
        Assert.assertTrue(error.isDisplayed(), "Error message not displayed for invalid last name.");
    }

    @Test
    public void checkoutWithNumberFirstName() {
        auto.findElement(By.id("first-name")).sendKeys("649554");
        auto.findElement(By.id("last-name")).sendKeys("Sherbeny");
        auto.findElement(By.id("postal-code")).sendKeys("ME5594");
        auto.findElement(By.id("continue")).click();


        WebElement error = auto.findElement(By.cssSelector("h3[data-test='error']"));
        Assert.assertTrue(error.isDisplayed(), "Error message not displayed for numeric first name.");
    }

    @Test
    public void checkoutWithSymbolsEverywhere() {
        auto.findElement(By.id("first-name")).sendKeys("#@$%#$#%#");
        auto.findElement(By.id("last-name")).sendKeys("@$#@%#^^");
        auto.findElement(By.id("postal-code")).sendKeys("ME5594");
        auto.findElement(By.id("continue")).click();

        WebElement error = auto.findElement(By.cssSelector("h3[data-test='error']"));
        Assert.assertTrue(error.isDisplayed(), "Error message not displayed for symbols in names.");
    }

    @AfterMethod
    public void teardown() {
        if (auto != null) {
            auto.quit();
        }
    }
}

