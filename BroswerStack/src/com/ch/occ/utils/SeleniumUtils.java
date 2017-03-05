package com.ch.occ.utils;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ch.ExcelUtils.ExcelBean;
import com.ch.occ.utils.constants.FileConstants;

/**
 * @author 11:59:11 AM Prasanna Kumar Reddy Mar 6, 2016
 */

public class SeleniumUtils extends PropertyUtil implements FileConstants
{

    public static void getURL(String url)
    {
        DriverFactory.getDriver().navigate().to(url);
        
    }

    public static void quitDriver()
    {
        DriverFactory.getDriver().close();
    }

    // getting css values
    public static String getCssValue(Type type, String element, String cssvalue) throws Exception
    {
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 15);
        WebElement element1 = elements(type, element, wait);
        return element1.getCssValue(cssvalue);
    }

    // getting css values
    public static String getCssValue(ExcelBean bean, String cssvalue) throws Exception
    {
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 15);
        WebElement element1 = elements(bean, wait);
        return element1.getCssValue(cssvalue);
    }

    // click the elements
    public static void click(Type type, String element) throws Exception
    {
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 15);
        WebElement element1 = elements(type, element, wait);
        Thread.sleep(1000);
        element1.click();
    }

    public static void click(ExcelBean bean) throws Exception
    {
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 15);
        WebElement element1 = elements(bean, wait);
        Thread.sleep(1000);
        element1.click();
    }

    // to get text
    public static String getText(Type type, String element)
    {
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 15);
        WebElement element1 = elements(type, element, wait);
        return element1.getText();
    }

    public static String getText(ExcelBean bean)
    {
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 15);
        WebElement element1 = elements(bean, wait);
        return element1.getText();
    }

    // send keys
    public static void sendKeys(Type type, String element, String data)
    {
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 15);
        WebElement element1 = elements(type, element, wait);
        element1.clear();
        element1.sendKeys(data);
    }

    public static void sendKeys(ExcelBean bean, String data)
    {
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 15);
        WebElement element1 = elements(bean, wait);
        element1.clear();
        element1.sendKeys(data);
    }

    // on hover click
    public static void onHoverAndClick(Type type, String element, Type type1, String element1) throws Exception
    {
        Actions actions = new Actions(DriverFactory.getDriver());
        WebElement ele = null;
        if (type.equals(Type.CLASSNAME))
        {
            ele = DriverFactory.getDriver().findElement(By.className(element));
        } else if (type.equals(Type.CSSSELECTOR))
        {
            ele = DriverFactory.getDriver().findElement(By.cssSelector(element));
        } else if (type.equals(Type.XPATH))
        {
            ele = DriverFactory.getDriver().findElement(By.xpath(element));
        } else if (type.equals(Type.LINKTEXT))
        {
            ele = DriverFactory.getDriver().findElement(By.linkText(element));
        } else if (type.equals(Type.ID))
        {
            ele = DriverFactory.getDriver().findElement(By.id(element));
        }
        actions.moveToElement(ele).build().perform();
        SeleniumUtils.wait(1);
        if (type1.equals(Type.CLASSNAME))
        {
            DriverFactory.getDriver().findElement(By.className(element1)).click();
        } else if (type1.equals(Type.CSSSELECTOR))
        {
            DriverFactory.getDriver().findElement(By.cssSelector(element1)).click();
        } else if (type1.equals(Type.XPATH))
        {
            DriverFactory.getDriver().findElement(By.xpath(element1)).click();
        } else if (type1.equals(Type.LINKTEXT))
        {
            DriverFactory.getDriver().findElement(By.linkText(element1)).click();
        } else if (type1.equals(Type.ID))
        {
            DriverFactory.getDriver().findElement(By.id(element1)).click();
        }
    }

    // Click Using JavaScript
    public static void javaScriptClick(Type type, int offset, String element) throws Exception
    {
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 15);
        WebElement element1 = elements(type, element, wait);
        JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getDriver();
        int yScrollPosition = element1.getLocation().getY() - offset;
        executor.executeScript("window.scroll(0, " + yScrollPosition + ");");
        element1.click();
    }

    public static void javaScriptClick(ExcelBean bean, int offset) throws Exception
    {
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 15);
        WebElement element1 = elements(bean, wait);
        JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getDriver();
        int yScrollPosition = element1.getLocation().getY() - offset;
        executor.executeScript("window.scroll(0, " + yScrollPosition + ");");
        element1.click();
    }

    // Hover Using JavaScript
    public static void javaScriptOnHover(Type type, int offset, String element)
    {
        Actions actions = new Actions(DriverFactory.getDriver());
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 15);
        WebElement element1 = elements(type, element, wait);
        JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getDriver();
        int yScrollPosition = element1.getLocation().getY() - offset;
        executor.executeScript("window.scroll(0, " + yScrollPosition + ");");
        actions.moveToElement(element1).build().perform();
    }

    public static void javaScriptOnHover(ExcelBean bean, int offset)
    {
        Actions actions = new Actions(DriverFactory.getDriver());
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 15);
        WebElement element1 = elements(bean, wait);
        JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getDriver();
        int yScrollPosition = element1.getLocation().getY() - offset;
        executor.executeScript("window.scroll(0, " + yScrollPosition + ");");
        actions.moveToElement(element1).build().perform();
    }

    // On Hover
    public static void onHover(Type type, String element)
    {
        Actions actions = new Actions(DriverFactory.getDriver());
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 15);
        WebElement element1 = elements(type, element, wait);
        actions.moveToElement(element1).build().perform();
    }

    public static void onHover(ExcelBean bean)
    {
        Actions actions = new Actions(DriverFactory.getDriver());
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 15);
        WebElement element1 = elements(bean, wait);
        actions.moveToElement(element1).build().perform();
    }

    // drop downs
    public static void dropDownByVisibleText(Type type, String element, String text)
    {
        Select sel = elementsDropDown(type, element);
        sel.selectByVisibleText(text);
    }

    public static void dropDownByVisibleText(ExcelBean bean, String text)
    {
        Select sel = elementsDropDown(bean);
        sel.selectByVisibleText(text);
    }

    public static void dropDownByValue(Type type, String element, String value)
    {
        Select sel = elementsDropDown(type, element);
        sel.selectByValue(value);
    }

    public static void dropDownByValue(ExcelBean bean, String value)
    {
        Select sel = elementsDropDown(bean);
        sel.selectByValue(value);
    }

    public static void dropDownByIndex(Type type, String element, int index)
    {
        Select sel = elementsDropDown(type, element);
        sel.selectByIndex(index);
    }

    public static void dropDownByIndex(ExcelBean bean, int index)
    {
        Select sel = elementsDropDown(bean);
        sel.selectByIndex(index);
    }

    public static List<WebElement> getAllWebElementsByTagA()
    {
        return DriverFactory.getDriver().findElements(By.tagName("a"));
    }

    // get Attributes
    public static String getAttributes(Type type, String element, String attribute)
    {
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 15);
        WebElement element1 = elements(type, element, wait);
        return element1.getAttribute(attribute);
    }

    public static String getAttributes(ExcelBean bean, String attribute)
    {
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 15);
        WebElement element1 = elements(bean, wait);
        return element1.getAttribute(attribute);
    }

    // Boolean is enabled
    public static boolean isEnabled(Type type, String element)
    {
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 15);
        WebElement element1 = elements(type, element, wait);
        return element1.isEnabled();
    }

    public static boolean isEnabled(ExcelBean bean)
    {
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 15);
        WebElement element1 = elements(bean, wait);
        return element1.isEnabled();
    }

    public static void onHoverClick(ExcelBean bean, ExcelBean bean1)
    {
        Actions actions = new Actions(DriverFactory.getDriver());
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 15);
        WebElement element1 = elements(bean, wait);
        actions.moveToElement(element1).build().perform();
        WebElement element2 = elements(bean1, wait);
        element2.click();
    }

    // Boolean is displayed
    public static boolean iSDisplayed(Type type, String element)
    {
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 15);
        WebElement element1 = elements(type, element, wait);
        return element1.isDisplayed();
    }

    public static boolean iSDisplayed(ExcelBean bean)
    {
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 15);
        WebElement element1 = elements(bean, wait);
        return element1.isDisplayed();
    }

    // Boolean is selected
    public static boolean isSelected(Type type, String element)
    {
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 15);
        WebElement element1 = elements(type, element, wait);
        return element1.isSelected();
    }

    public static boolean isSelected(ExcelBean bean)
    {
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 15);
        WebElement element1 = elements(bean, wait);
        return element1.isSelected();
    }

    public static int wait(int time) throws Exception
    {
        int i = 1000;
        time = time * i;
        Thread.sleep(time);
        return time;
    }

    // verify from page source
    public static void PageSoourcecont(String element)
    {
        DriverFactory.getDriver().getPageSource().contains(element);
    }

    // frames switching
    public static void switchingFrameById(String frameid)
    {
        DriverFactory.getDriver().switchTo().frame(frameid);
    }

    public static void switchingFrameByNumber(int framenumber)
    {
        DriverFactory.getDriver().switchTo().frame(framenumber);
    }

    public static boolean pageSourceContains(String element)
    {
        return DriverFactory.getDriver().getPageSource().contains(element);
    }

    // Alerts
    public static void acceptAlert()
    {
        Alert alert = DriverFactory.getDriver().switchTo().alert();
        alert.accept();
    }

    public static void dismissAlert()
    {
        Alert alert = DriverFactory.getDriver().switchTo().alert();
        alert.dismiss();
    }

    public static String alertGetText()
    {
        Alert alert = DriverFactory.getDriver().switchTo().alert();
        return alert.getText();
    }

    public static void refresh()
    {
        DriverFactory.getDriver().navigate().refresh();
    }

    public static void browserBack()
    {
        DriverFactory.getDriver().navigate().back();
    }

    public static void keys(Keys keys)
    {
        Keyboard board = ((HasInputDevices) DriverFactory.getDriver()).getKeyboard();
        board.pressKey(keys);

    }

    public static void javaScriptExecutorUp(String position) throws Exception
    {
        JavascriptExecutor jse = (JavascriptExecutor) DriverFactory.getDriver();
        jse.executeScript("window.scrollBy(0,-" + position + ")", "");
        Thread.sleep(5000);
    }

    public static int javascriptexecutorPosition() throws Exception
    {
        JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getDriver();
        int value = (int) executor.executeScript("return window.scrollY;");
        return value;
    }

    public static void javaScriptExecutorDown(String position) throws Exception
    {
        JavascriptExecutor jse = (JavascriptExecutor) DriverFactory.getDriver();
        jse.executeScript("window.scrollBy(0," + position + ")", "");
    }

    public static List<WebElement> getAllElements(Type type, String element)
    {
        List<WebElement> ele = null;
        if (type.equals(Type.CLASSNAME))
        {
            ele = DriverFactory.getDriver().findElements(By.className(element));
        } else if (type.equals(Type.CSSSELECTOR))
        {
            ele = DriverFactory.getDriver().findElements(By.cssSelector(element));
        } else if (type.equals(Type.LINKTEXT))
        {
            ele = DriverFactory.getDriver().findElements(By.linkText(element));
        } else if (type.equals(Type.XPATH))
        {
            ele = DriverFactory.getDriver().findElements(By.xpath(element));
        } else if (type.equals(Type.ID))
        {
            ele = DriverFactory.getDriver().findElements(By.id(element));
        } else if (type.equals(Type.PARTIALLINK))
        {
            ele = DriverFactory.getDriver().findElements(By.partialLinkText(element));
        } else if (type.equals(Type.NAME))
        {
            ele = DriverFactory.getDriver().findElements(By.name(element));
        }
        return ele;
    }

    public static List<WebElement> getAllElements(ExcelBean bean)
    {
        String type = bean.getType();
        String element = bean.getValue();
        List<WebElement> ele = null;
        if (type.equals(Type.CLASSNAME.name()))
        {
            ele = DriverFactory.getDriver().findElements(By.className(element));
        } else if (type.equals(Type.CSSSELECTOR.name()))
        {
            ele = DriverFactory.getDriver().findElements(By.cssSelector(element));
        } else if (type.equals(Type.LINKTEXT.name()))
        {
            ele = DriverFactory.getDriver().findElements(By.linkText(element));
        } else if (type.equals(Type.XPATH.name()))
        {
            ele = DriverFactory.getDriver().findElements(By.xpath(element));
        } else if (type.equals(Type.ID.name()))
        {
            ele = DriverFactory.getDriver().findElements(By.id(element));
        } else if (type.equals(Type.PARTIALLINK.name()))
        {
            ele = DriverFactory.getDriver().findElements(By.partialLinkText(element));
        } else if (type.equals(Type.NAME.name()))
        {
            ele = DriverFactory.getDriver().findElements(By.name(element));
        }
        return ele;
    }

    private static WebElement elements(Type type, String element, WebDriverWait wait)
    {
        WebElement element1 = null;
        if (type.equals(Type.CSSSELECTOR))
        {
            element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(element)));

        } else if (type.equals(Type.CLASSNAME))
        {
            element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(element)));
        } else if (type.equals(Type.ID))
        {
            element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(element)));
        } else if (type.equals(Type.LINKTEXT))
        {
            element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(element)));
        } else if (type.equals(Type.NAME))
        {
            element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(element)));
        } else if (type.equals(Type.PARTIALLINK))
        {
            element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(element)));
        } else if (type.equals(Type.XPATH))
        {
            element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
        }
        return element1;
    }

    private static WebElement elements(ExcelBean bean, WebDriverWait wait)
    {
        String type = bean.getType();
        String element = bean.getValue();

        WebElement element1 = null;
        if (type.equals(Type.CSSSELECTOR.name()))
        {
            element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(element)));
        } else if (type.equals(Type.CLASSNAME.name()))
        {
            element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(element)));
        } else if (type.equals(Type.ID.name()))
        {
            element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(element)));
        } else if (type.equals(Type.LINKTEXT.name()))
        {
            element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(element)));
        } else if (type.equals(Type.NAME.name()))
        {
            element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(element)));
        } else if (type.equals(Type.PARTIALLINK.name()))
        {
            element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(element)));
        } else if (type.equals(Type.XPATH.name()))
        {
            element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
        }
        return element1;
    }

    private static Select elementsDropDown(Type type, String element)
    {
        Select sel = null;
        if (type.equals(Type.CLASSNAME))
        {
            sel = new Select(DriverFactory.getDriver().findElement(By.className(element)));
        } else if (type.equals(Type.CSSSELECTOR))
        {
            sel = new Select(DriverFactory.getDriver().findElement(By.cssSelector(element)));
        } else if (type.equals(Type.LINKTEXT))
        {
            sel = new Select(DriverFactory.getDriver().findElement(By.linkText(element)));
        } else if (type.equals(Type.PARTIALLINK))
        {
            sel = new Select(DriverFactory.getDriver().findElement(By.partialLinkText(element)));
        } else if (type.equals(Type.NAME))
        {
            sel = new Select(DriverFactory.getDriver().findElement(By.name(element)));
        } else if (type.equals(Type.ID))
        {
            sel = new Select(DriverFactory.getDriver().findElement(By.id(element)));
        } else if (type.equals(Type.XPATH))
        {
            sel = new Select(DriverFactory.getDriver().findElement(By.xpath(element)));
        }
        return sel;
    }

    private static Select elementsDropDown(ExcelBean bean)
    {
        String type = bean.getType();
        String element = bean.getValue();
        Select sel = null;
        if (type.equals(Type.CLASSNAME.name()))
        {
            sel = new Select(DriverFactory.getDriver().findElement(By.className(element)));
        } else if (type.equals(Type.CSSSELECTOR.name()))
        {
            sel = new Select(DriverFactory.getDriver().findElement(By.cssSelector(element)));
        } else if (type.equals(Type.LINKTEXT.name()))
        {
            sel = new Select(DriverFactory.getDriver().findElement(By.linkText(element)));
        } else if (type.equals(Type.PARTIALLINK.name()))
        {
            sel = new Select(DriverFactory.getDriver().findElement(By.partialLinkText(element)));
        } else if (type.equals(Type.NAME.name()))
        {
            sel = new Select(DriverFactory.getDriver().findElement(By.name(element)));
        } else if (type.equals(Type.ID.name()))
        {
            sel = new Select(DriverFactory.getDriver().findElement(By.id(element)));
        } else if (type.equals(Type.XPATH.name()))
        {
            sel = new Select(DriverFactory.getDriver().findElement(By.xpath(element)));
        }
        return sel;
    }

    // for HTML
    public static WebElement findByElement(String key, String element)
    {
        By byElement = null;
        if (key.equalsIgnoreCase("xpath"))
        {
            byElement = By.xpath(element);
        } else if (key.equalsIgnoreCase("id"))
        {
            byElement = By.id(element);
        } else if (key.equalsIgnoreCase("className"))
        {
            byElement = By.className(element);
        } else if (key.equalsIgnoreCase("name"))
        {
            byElement = By.name(element);
        } else if (key.equalsIgnoreCase("css"))
        {
            byElement = By.cssSelector(element);
        } else if (key.equalsIgnoreCase("linkText"))
        {
            byElement = By.linkText(element);
        } else if (key.equalsIgnoreCase("partialLinkText"))
        {
            byElement = By.partialLinkText(element);
        }
        WebElement ele = DriverFactory.getDriver().findElement(byElement);
        return ele;
    }

    public static String getTextWithID(String id) throws InterruptedException
    {
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 15);
        WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
        Thread.sleep(2000);
        return element1.getText();
    }

    public static void clear(ExcelBean bean) throws Exception
    {
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 15);
        WebElement element1 = elements(bean, wait);
        element1.clear();
    }

    public static void javascriptexecutorDown250() throws Exception
    {
        JavascriptExecutor jse = (JavascriptExecutor) DriverFactory.getDriver();
        jse.executeScript("window.scrollBy(0,250)", "");
    }

    public static void tab()
    {
        Keyboard board = ((HasInputDevices) DriverFactory.getDriver()).getKeyboard();
        board.pressKey(Keys.TAB);
    }
}
