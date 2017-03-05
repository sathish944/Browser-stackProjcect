package com.ch.occ.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import com.ch.occ.pages.LoginPage;
import com.ch.occ.utils.constants.FileConstants;
import com.ch.occ.utils.constants.ObjectConstants;

public class CommonUtils implements ObjectConstants, FileConstants {
	public static void TBCURL() {
		SeleniumUtils.getURL(PropertyUtil.getPropertyValue(URL, SERVER_PROPERTY_FILE));
	}

	public static void mobileView() {
	    DriverFactory.getDriver().manage().window().setSize(new Dimension(414 , 736));
	}

	public static void desktopView() {
		DriverFactory.getDriver().manage().window().maximize();
	}

	public static void tabletView() {
		DriverFactory.getDriver().manage().window().setSize(new Dimension(900, 668));
	}

	public static void clickLink(String link) {
		List<WebElement> aList = SeleniumUtils.getAllWebElementsByTagA();

		for (WebElement el : aList) {
			String attribute = el.getAttribute("href");
			if (null != attribute && attribute.contains(link)) {
				el.click();
				break;
			}
		}
	}

	public static void login() throws Exception {
		OCCUtlis.occLogin();
		SeleniumUtils.wait(1);
		LoginPage.enterLoginEmail();
		LoginPage.enterLoginPassword();
		LoginPage.clickLoginButton();
	}

	public static String getCurrentDate() {
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("ddMMYYhhmmss");
		String str = df.format(date);
		return str;
	}
	

    public static boolean equalLists(List<String> a, List<String> b)
    {
        if ((a.size() != b.size()) || (a == null && b != null) || (a != null && b == null))
        {
            return false;
        }

        if (a == null && b == null)
            return true;

        Collections.sort(a);
        Collections.sort(b);
        return a.equals(b);
    }

    public static float getFloatFromString(String value)
    {
        if (value.contains("$") && value.contains(",") && value.contains("."))
        {
            // $4,000.00
            String[] a = value.split(",");
            String[] b = a[0].split("\\$");
            String var = a[1] + b[1];
            return Float.parseFloat(var);

        } else if (value.startsWith("$") && value.contains("."))
        {
            // $35.00
            return Float.parseFloat(value.substring(1));
        } else if (value.contains("."))
        {
            // 35.00
            return Float.parseFloat(value);
        } else if (value.startsWith("$"))
        {
            // $35
            return Float.parseFloat(value.substring(1));
        } else if (!(value.contains("$") && value.contains(".")))
        {
            // 35
            return Float.parseFloat(value);
        }

        return 0;
    }



}
