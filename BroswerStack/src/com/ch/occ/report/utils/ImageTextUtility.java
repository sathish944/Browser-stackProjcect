package com.ch.occ.report.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebElement;

import com.ch.occ.bean.ImageTextBean;
import com.ch.occ.utils.PropertyUtil;
import com.ch.occ.utils.SeleniumUtils;
import com.ch.occ.utils.constants.FileConstants;

/**
 * @author 9:49:48 PM Prasanna Kumar Reddy Feb 18, 2016
 */
public class ImageTextUtility implements FileConstants
{
    public static void testCSSEntitiesOfImage(ImageTextBean bean)
    {
        WebElement ele = SeleniumUtils.findByElement(bean.getEleidentity(), PropertyUtil.getObjectValue(bean.getKey()));
        HashMap<String, String> entities = bean.getCSSEntities();
        Set<String> keySet = entities.keySet();
        boolean flag = true;
        for (Iterator<String> iterator = keySet.iterator(); iterator.hasNext();)
        {
            String entity = (String) iterator.next();
            String expectedValue = entities.get(entity);
            if ("-".equalsIgnoreCase(expectedValue))
            {
                bean.setResult(entity, "<font color=black>" + expectedValue);
                continue;
            }

            String actualValue = ele.getCssValue(entity);
            if (expectedValue.equalsIgnoreCase(actualValue))
            {
                bean.setResult(entity, "<font color = green>Expected : " + expectedValue + "</br>Actual : "
                        + actualValue);
            } else
            {
                flag = false;
                bean.setResult(entity, "<font color = red>Expected : " + expectedValue + "</br>Actual : " + actualValue);
            }
        }
        if (true == flag)
        {
            bean.setFinalResult("<font color=green>PASS");
        } else
        {
            bean.setFinalResult("<font color=red>FAIL");
        }
    }
}
