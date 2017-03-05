package com.ch.occ.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MultiBrowserTest 
{

    private WebDriver driver;

    // Configure for multi browser drivers
    @Parameters("browser")
    @BeforeClass
    public void beforeTest(String browser) throws Exception
    {
        if (browser.equalsIgnoreCase("firefox"))
        {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("chrome"))
        {
            // Set Path for the executable file
            System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
            driver = new ChromeDriver();
            // } else if (browser.equalsIgnoreCase("ie")) {
            // // Set Path for the executable file
            // System.setProperty("webdriver.ie.driver",
            // "D:\\IEDriverServer.exe");
            // driver = new InternetExplorerDriver();
        } else
        {
            throw new IllegalArgumentException("The Browser Type is Undefined");
        }
        // Open App

        driver.get("https://ccstore-test-z3na.oracleoutsourcing.com");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        try
        {
            driver.findElement(By.xpath("//div[@id='occ-email-subscription-template']/div/div[2]/div/div[3]/div")).click();
            System.out.println("Try");
        } catch (Exception e)
        {
            e.getMessage();
        }

    }

    @Test
    public void check() throws Exception
    {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("input.form-control")).sendKeys("rings");
        System.out.println("Sending rings in search");
        driver.findElement(By.cssSelector("input.form-control")).sendKeys(Keys.ENTER);
        System.out.println("enter the search");
        driver.findElement(By.linkText("ADD TO CART")).click();
        System.out.println("click the add to cart button");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("CC-headerCheckout")).click();
        System.out.println("item is add to cart");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.quit();
    }

    @AfterClass
    public void afterTest()
    {
        try
        {
            driver.quit();
        } catch (Exception e)
        {
            driver = null;
        }
    }
}