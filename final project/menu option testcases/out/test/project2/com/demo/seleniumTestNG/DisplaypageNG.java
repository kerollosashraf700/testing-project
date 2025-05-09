package com.demo.seleniumTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DisplaypageNG {

    WebDriver auto;

    @BeforeTest
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\YourUser\\Downloads\\chromedriver.exe");
        auto = new ChromeDriver();
        auto.manage().window().maximize();
        auto.get("https://www.saucedemo.com");


        WebElement Username = auto.findElement(By.id("user-name"));
        Username.sendKeys("standard_user");

        WebElement password = auto.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        auto.findElement(By.id("login-button")).click();


    }

    @Test
    public void HSLogin1() {
        auto.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        auto.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
        auto.findElement(By.className("shopping_cart_link")).click();

    }

    @Test
    public void HSLogin2() {
        auto.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        auto.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
        auto.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
        auto.findElement(By.className("shopping_cart_link")).click();
    }

    @Test
    public void HSLogin3() {
        auto.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        auto.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
        auto.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
        auto.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
        auto.findElement(By.className("shopping_cart_link")).click();
    }

    @Test
    public void HSLogin4() {
        auto.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        auto.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
        auto.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
        auto.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
        auto.findElement(By.id("add-to-cart-sauce-labs-onesie")).click();
        auto.findElement(By.className("shopping_cart_link")).click();
    }
}
