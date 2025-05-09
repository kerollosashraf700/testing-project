package com.demo.seleniumTestNG;

import net.bytebuddy.build.Plugin;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class IntegrationTestFor10 {
    WebDriver auto;



    @BeforeTest
    public void Openbrowser() {


        System.setProperty("webdriver.chrome.driver", "C:\\Users\\kerol\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        auto = new ChromeDriver();
        auto.get("https://www.saucedemo.com");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void Login(){
        WebElement Username = auto.findElement(By.id("user-name"));
        Username.sendKeys("standard_user");

        WebElement password = auto.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        auto.findElement(By.id("login-button")).click();
    }
    @Test
            public void add1() {
        auto.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    }
    @Test
    public void add2() {
        auto.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
    }
    @Test
    public void add3() {
        auto.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
    }
    @Test
    public void add4() {
        auto.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
    }
    @Test
    public void add5() {
        auto.findElement(By.id("add-to-cart-sauce-labs-onesie")).click();
    }
    @Test
    public void clickoncart() {
        auto.findElement(By.className("shopping_cart_link")).click();
    }

    @Test
    public void clickoncheckout() {
        auto.findElement(By.id("checkout")).click();
    }


}
