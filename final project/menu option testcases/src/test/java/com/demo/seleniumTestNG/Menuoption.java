package com.demo.seleniumTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Menuoption {

    WebDriver auto;

    @BeforeMethod
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\kerol\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        auto = new ChromeDriver();
        auto.manage().window().maximize();
        auto.get("https://www.saucedemo.com");

        WebElement username = auto.findElement(By.id("user-name"));
        username.sendKeys("standard_user");

        WebElement password = auto.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        auto.findElement(By.id("login-button")).click();


        auto.findElement(By.id("react-burger-menu-btn")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void allitem() {
        auto.findElement(By.id("inventory_sidebar_link")).click();
        Assert.assertTrue(auto.getCurrentUrl().contains("inventory.html"));
    }

    @Test
    public void about() {
        auto.findElement(By.id("about_sidebar_link")).click();
        Assert.assertTrue(auto.getCurrentUrl().contains("https://saucelabs.com/"));
    }

    @Test
    public void logout1() {
        auto.findElement(By.id("logout_sidebar_link")).click();
        Assert.assertTrue(auto.getCurrentUrl().contains("https://www.saucedemo.com"), "Logout failed or did not redirect to login page.");
        WebElement loginButton = auto.findElement(By.id("login-button"));
        Assert.assertTrue(loginButton.isDisplayed());
    }

    @Test
    public void restapp() {
        auto.findElement(By.id("reset_sidebar_link")).click();
        WebElement addToCartButton = auto.findElement(By.cssSelector("[data-test='add-to-cart-sauce-labs-backpack']"));
        Assert.assertTrue(addToCartButton.isDisplayed());
    }

    @AfterMethod
    public void closeBrowser() {
        if (auto != null) {
            auto.quit();
        }
    }

    }


