package com.ch.occ.test;

/**

**/
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrowserStack
{
    public static final String USERNAME     = "sathishnaiduling1";
    public static final String AUTOMATE_KEY = "CVUoRZjK2nVCakrpusKM";
    public static final String URL          = "https://" + USERNAME + ":" + AUTOMATE_KEY
            + "@hub-cloud.browserstack.com/wd/hub";

    public WebDriver           driver;

    @BeforeMethod
    public WebDriver extracted() throws MalformedURLException
    {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browserName", "IPhone");
        caps.setPlatform(Platform.MAC);
        caps.setCapability("device", "IPhone 6S");
        // caps.setCapability("browserName", "android");
        // caps.setCapability("platform", "ANDROID");
        // caps.setCapability("device", "Samsung Galaxy S5");
        // caps.setCapability("browserstack.debug", true);
        // WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
        WebDriver driver = new RemoteWebDriver(new java.net.URL(URL), caps);
        driver.get("https://ccstore-test-z3na.oracleoutsourcing.com");
        System.out.println("URL Launch");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        try
        {
            driver.findElement(By.xpath("//div[@id='occ-email-subscription-template']/div/div[2]/div/div[3]/div")).click();
        } catch (Exception e)
        {
            System.out.println("not there");
        }
        return driver;
    }

    @Test
    public void loginVerfiy() throws Exception
    {
        WebDriver driver = extracted();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//span[@id='wi1900069-account-mobile-element-id']/div/div/a/div")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("CC-login-input")).sendKeys("abcd1234@gmail.com");
        System.out.println("Enter mail");
        driver.findElement(By.id("CC-login-password-input")).sendKeys("timepass@123");
        System.out.println("Password entered");
        driver.findElement(By.id("CC-userLoginSubmit")).click();
        System.out.println("Submit button is cliked");
        driver.quit();
    }
    


    // @Test
    // public void check() throws Exception
    // {
    // WebDriver driver = extracted();
    // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    // driver.findElement(By.cssSelector("input.form-control")).sendKeys("rings");
    // System.out.println("Sending rings in search");
    // driver.findElement(By.cssSelector("input.form-control")).sendKeys(Keys.ENTER);
    // System.out.println("enter the search");
    // driver.findElement(By.linkText("ADD TO CART")).click();
    // System.out.println("click the add to cart button");
    // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    // driver.findElement(By.id("CC-headerCheckout")).click();
    // System.out.println("item is add to cart");
    // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    // driver.quit();
    // }

}
