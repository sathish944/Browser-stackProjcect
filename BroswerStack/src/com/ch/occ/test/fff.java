package com.ch.occ.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class fff
{
    static String           driverPath = "C:\\Users\\CH_Sathish\\workspaces\\Lenox\\resources\\drivers\\chromedriver.exe";
    public static WebDriver driver;

    public static void urlp(String url) throws Exception
    {
        System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to(url);
        driver.manage().window().maximize();

    }

    public static void quit()
    {
        driver.quit();
    }

    @Test
    public static void main(String[] args) throws Exception
    {
        try
        {
            urlp("https://www.google.com");
            quit();
        } catch (Exception e)
        {
            // TODO: handle exception
        }
    }

}
