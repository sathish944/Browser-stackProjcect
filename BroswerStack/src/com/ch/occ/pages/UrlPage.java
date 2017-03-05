package com.ch.occ.pages;

import org.testng.annotations.Listeners;

import com.ch.occ.utils.PropertyUtil;
import com.ch.occ.utils.SeleniumUtils;
import com.ch.occ.utils.constants.FileConstants;

@Listeners(com.ch.occ.utils.ParallelFactory.class)

public class UrlPage implements FileConstants
{
//    public static void launchURL() throws Exception
//    {
//        getURL();
//    }

    public static void getURL() throws Exception
    {

        String url = PropertyUtil.getPropertyValue(URL, SERVER_PROPERTY_FILE);
        SeleniumUtils.getURL(url);
        Thread.sleep(5000);
    }
}
