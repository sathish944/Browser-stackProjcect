package com.ch.occ.utils;

import org.openqa.selenium.WebDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

import com.ch.occ.utils.constants.FileConstants;

public class ParallelFactory implements IInvokedMethodListener, FileConstants
{
    private static final String CHANGE = PropertyUtil.getConfigValue(MOBILE_PC);
   
     
    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult)
    {
        boolean beforeMethodConfiguration = method.getTestMethod().isBeforeMethodConfiguration();
        if (beforeMethodConfiguration)
        {
            if (CHANGE.equalsIgnoreCase("pc"))
            { 
                System.out.println("***************************");
//                WebDriver driver = DriverFactory.webInstance(PropertyUtil.getConfigValue(BROWSER_NAME));
                WebDriver driver = DriverFactory.webInstance();
                DriverFactory.setWebDriver(driver);
            }
            if (CHANGE.equalsIgnoreCase("mobile"))
            {
                System.out.println("***************************");
                WebDriver driver;
                try
                {
                    driver = DriverFactory.getmobileDriver();
                    DriverFactory.setWebDriver(driver);
                } catch (Exception e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                
            }
        }
    }
    

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult)
    {
        if (method.isTestMethod())
        {
            WebDriver driver = DriverFactory.getDriver();
            if (driver != null)
            {
                driver.quit();
                driver = null;
            }
        }
    }
}