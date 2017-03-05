package com.ch.occ.utils;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Parameters;

import com.ch.occ.utils.constants.FileConstants;

public class DriverFactory extends PropertyUtil implements FileConstants
{
    public static final String            USERNAME     = "sathishnaiduling1";
    public static final String            AUTOMATE_KEY = "CVUoRZjK2nVCakrpusKM";
    public static final String            URL          = "https://" + USERNAME + ":" + AUTOMATE_KEY
            + "@hub-cloud.browserstack.com/wd/hub";
    public static String                  browserN;

    private static ThreadLocal<WebDriver> webDriver    = new ThreadLocal<>();

    public static String                  browserName  = "";
    // public void browseInitialize(String browser)
    // {
    // browserN=browser;os
    // System.out.println(browserN);
    // }

    public static WebDriver getDriver()
    {
        return webDriver.get();
    }

    public static void setWebDriver(WebDriver driver)
    {
        webDriver.set(driver);
    }

    @Parameters("browser")
    public static void initBrowser()
    {
        String browser = null;
        browserName = browser;
    }

    public static WebDriver webInstance()
    {
        initBrowser();
        WebDriver driver = null;
        System.out.println(browserName);

        if (browserName.equalsIgnoreCase("IE"))
        {
            System.setProperty("webdriver.ie.driver", I_E);
            driver = new InternetExplorerDriver();
        }
        if (browserName.equalsIgnoreCase("safari"))
        {
            driver = new SafariDriver();
        }
        if (browserName.equalsIgnoreCase("opera"))
        {
            System.setProperty("webdriver.opera.driver", OPERA);
            driver = new OperaDriver();
        }
        if (browserName.equalsIgnoreCase("chrome"))
        {
            System.setProperty("webdriver.chrome.driver", CHROME);
            driver = new ChromeDriver();
        }
        if (browserName.equalsIgnoreCase("phantomjsWin"))
        {
            System.setProperty("phantomjs.binary.path", PHANTOMJS_WIN);
            driver = new PhantomJSDriver();
        }

        if (browserName.equalsIgnoreCase("firefox"))
        {
            ProfilesIni profile = new ProfilesIni();
            FirefoxProfile myprofile = profile.getProfile("default");
            driver = new FirefoxDriver(myprofile);
        }

        return driver;
    }

    public static WebDriver getmobileDriver() throws Exception
    {
        // DesiredCapabilities caps = new DesiredCapabilities();
        // caps.setCapability("platformName", getConfigValue(PLATFORM_NAME));
        // caps.setCapability("app", getConfigValue(APP_NAME));
        // caps.setCapability("platformVersion",
        // getConfigValue(PLATFORM_VERSION));
        // caps.setCapability("deviceName", getConfigValue(DEVICE_NAME));
        // caps.setCapability(CapabilityType.BROWSER_NAME,
        // getConfigValue(BROWSE_NAME));
        // caps.setCapability(CapabilityType.PLATFORM, PLATFORMEXE);
        // return new RemoteWebDriver(getURL(), caps);
        DesiredCapabilities caps = new DesiredCapabilities();
         caps.setCapability("browserName", "IPhone");
         caps.setPlatform(Platform.MAC);
         caps.setCapability("device", "iPhone 6s");

//        caps.setCapability("browserName", "android");
//        caps.setCapability("platform", "ANDROID");
//        caps.setCapability("device", "Google Nexus 5");
        caps.setCapability("browserstack.debug", true);
        WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
        return driver;
    }

    public static URL getURL()
    {
        try
        {
            return new URL(getConfigValue(DEVICE_URL));
        } catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}