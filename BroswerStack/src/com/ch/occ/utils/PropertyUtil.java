package com.ch.occ.utils;

import java.io.FileInputStream;
import java.util.Properties;

import com.ch.occ.utils.constants.FileConstants;

/**
 * @author 10:09:42 PM Prasanna Kumar Reddy Feb 17, 2016
 */
public class PropertyUtil implements FileConstants
{

    private static Properties readPropertyFile(String fileName)
    {
        Properties properties = new Properties();
        try
        {   
            properties.load(new FileInputStream(fileName));
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return properties;
    }
    

    public static String getPropertyValue(String key, String file)
    {
        Properties properties = readPropertyFile(file);

        return properties.getProperty(key);
    }

    // object property file
    public static String getObjectValue(String key)
    {
        Properties properties = readPropertyFile(OBJECT_PROPERTY_FILE);

        return properties.getProperty(key);
    }

    // testconfig file
    public static String getConfigValue(String key)
    {
        Properties properties = readPropertyFile(TEST_PROPERTY_FILE);
        return properties.getProperty(key);
    }

    // static text
    public static String getStaticText(String key)
    {
        Properties properties = readPropertyFile(STATIC_TEXT_PROPERTY);
        return properties.getProperty(key);
    }
}