package com.ch.occ.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;

public class AllUseing

{
    static WebDriver driver;

    public static void lunch()
    {
        driver.get("https://cashkaro.iamsavings.co.uk/");
    }

    public static void frame(String frame) throws Exception
    {
        WebElement iframeElement = driver.findElement(By.className(frame));
        driver.switchTo().frame(iframeElement);

    }

    public void waiting() throws Exception
    {
        Timeouts wait = driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
    }

}
