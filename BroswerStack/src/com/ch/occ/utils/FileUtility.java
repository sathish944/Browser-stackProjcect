package com.ch.occ.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import com.ch.occ.bean.CheckoutBean;
import com.ch.occ.bean.CheckoutInvalidBillingBean;
import com.ch.occ.bean.CheckoutInvalidShippingBean;
import com.ch.occ.bean.CheckoutRegInvalidBillingBean;
import com.ch.occ.bean.CheckoutRegInvalidshippingBean;
import com.ch.occ.bean.Databean;
import com.ch.occ.bean.ImageTextBean;
import com.ch.occ.bean.InvalidAndValidSearchResults;
import com.ch.occ.bean.InvalidSignIn;
import com.ch.occ.bean.InvalidSignUp;
import com.ch.occ.bean.IsDisplayedBean;
import com.ch.occ.bean.User;
import com.ch.occ.utils.constants.FileConstants;
import com.lenox.api.bean.AddressBean;

/**
 * @author 10:09:42 PM Prasanna Kumar Reddy Feb 17, 2016
 */

public class FileUtility implements FileConstants
{
    public static String readContent(String file) throws Exception
    {
        StringBuilder content = new StringBuilder();
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = reader.readLine();
        while (null != line)
        { 
            content.append(line);
            line = reader.readLine();
        }
        reader.close();

        return content.toString();
    }

    public static ArrayList<AddressBean> addressdata() throws Exception
    {
        BufferedReader reader = new BufferedReader(new FileReader(ADDRESS_API));
        ArrayList<AddressBean> data = new ArrayList<AddressBean>();
        String headerline = reader.readLine();
        String line = reader.readLine();
        while (null != line)
        {
            String[] records = line.split(",");
            if (records.length >= 6)
            {
                data.add(new AddressBean(records, headerline));
            }
            line = reader.readLine();
        }
        reader.close();
        return data;
    }

    public static void writeHTMLContent(String file, String content) throws Exception
    {
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.write(content);
        writer.close();
    }

    public static ArrayList<InvalidAndValidSearchResults> readAllSearchData() throws Exception
    {
        BufferedReader reader = new BufferedReader(new FileReader(INVALID_SEARCH));
        ArrayList<InvalidAndValidSearchResults> data = new ArrayList<InvalidAndValidSearchResults>();
        String line = reader.readLine();
        line = reader.readLine();
        while (null != line)
        {
            String[] records = line.split(",");
            if (records.length >= 2)
            {
                data.add(new InvalidAndValidSearchResults(records));
            }
            line = reader.readLine();
        }
        reader.close();

        return data;
    }

    public static ArrayList<Databean> readAllLoginData() throws Exception
    {
        BufferedReader reader = new BufferedReader(new FileReader(LOGIN_DATA_FILE));
        ArrayList<Databean> data = new ArrayList<Databean>();
        String line = reader.readLine();
        line = reader.readLine();
        while (null != line)
        {
            String[] records = line.split(",");
            if (records.length >= 2)
            {
                data.add(new Databean(records[0], records[1]));
            }
            line = reader.readLine();
        }
        reader.close();

        return data;
    }

    public static ArrayList<User> readAllUserData() throws Exception
    {
        BufferedReader reader = new BufferedReader(new FileReader(USER_DATA_FILE));
        ArrayList<User> data = new ArrayList<User>();
        String line = reader.readLine();
        line = reader.readLine();
        while (null != line)
        {
            String[] records = line.split(",");
            if (records.length >= 20)
            {
                data.add(new User(records));
            }
            line = reader.readLine();
        }
        reader.close();

        return data;
    }

    public static ArrayList<InvalidSignUp> readSignUp() throws Exception
    {
        BufferedReader reader = new BufferedReader(new FileReader(INVALID_SIGNUP_DATA_FILE));
        ArrayList<InvalidSignUp> data = new ArrayList<InvalidSignUp>();
        String line = reader.readLine();
        line = reader.readLine();
        while (null != line)
        {
            String[] records = line.split(",");
            if (records.length >= 2)
            {
                data.add(new InvalidSignUp(records));
            }
            line = reader.readLine();
        }
        reader.close();

        return data;
    }

    
    public static ArrayList<InvalidSignIn> readInvalidCheckOutSign() throws Exception
    {
        BufferedReader reader = new BufferedReader(new FileReader(INVALID_CHECKOUT_SIGNIN));
        ArrayList<InvalidSignIn> data = new ArrayList<InvalidSignIn>();
        String line = reader.readLine();
        line = reader.readLine();
        while (null != line)
        {
            String[] records = line.split(",");
            if (records.length >= 2)
            {
                data.add(new InvalidSignIn(records));
            }
            line = reader.readLine();
        }
        reader.close();

        return data;
    }

    public static ArrayList<CheckoutBean> readCheckoutData() throws Exception
    {
        BufferedReader reader = new BufferedReader(new FileReader(CHECKOUT_DATA));
        ArrayList<CheckoutBean> data = new ArrayList<CheckoutBean>();
        String line = reader.readLine();
        line = reader.readLine();
        while (null != line)
        {
            String[] records = line.split(",");
            if (records.length >= 15)
            {
                data.add(new CheckoutBean(records));
            }
            line = reader.readLine();
        }
        reader.close();

        return data;
    }
    
    public static ArrayList<InvalidSignIn> readInvalidSign() throws Exception
    {
        BufferedReader reader = new BufferedReader(new FileReader(INVALID_SIGNIN));
        ArrayList<InvalidSignIn> data = new ArrayList<InvalidSignIn>();
        String line = reader.readLine();
        line = reader.readLine();
        while (null != line)
        {
            String[] records = line.split(",");
            if (records.length >= 2)
            {
                data.add(new InvalidSignIn(records));
            }
            line = reader.readLine();
        }
        reader.close();

        return data;
    }

    public static ArrayList<CheckoutInvalidShippingBean> readCheckoutInvalidShippingData() throws Exception
    {
        BufferedReader reader = new BufferedReader(new FileReader(CHECKOUT_INVALID_SHIPPING_DATA));
        ArrayList<CheckoutInvalidShippingBean> data = new ArrayList<CheckoutInvalidShippingBean>();
        String line = reader.readLine();
        line = reader.readLine();
        while (null != line)
        {
            String[] records = line.split(",");
            if (records.length >= 16)
            {
                data.add(new CheckoutInvalidShippingBean(records));
            }
            line = reader.readLine();
        }
        reader.close();

        return data;
    }

    public static ArrayList<IsDisplayedBean> readIsDisplayedData() throws Exception
    {
        BufferedReader reader = new BufferedReader(new FileReader(ISDISPLAYEDDATA));
        ArrayList<IsDisplayedBean> data = new ArrayList<IsDisplayedBean>();
        String line = reader.readLine();
        line = reader.readLine();
        while (null != line)
        {
            String[] records = line.split(",");
            if (records.length >= 4)
            {
                data.add(new IsDisplayedBean(records));
            }
            line = reader.readLine();
        }
        reader.close();

        return data;
    }
    
    
    public static ArrayList<CheckoutInvalidBillingBean> readCheckoutInvalidBillingData() throws Exception
    {
        BufferedReader reader = new BufferedReader(new FileReader(CHECKOUT_INVALID_BILLING_DATA));
        ArrayList<CheckoutInvalidBillingBean> data = new ArrayList<CheckoutInvalidBillingBean>();
        String line = reader.readLine();
        line = reader.readLine();
        while (null != line)
        {
            String[] records = line.split(",");
            if (records.length >= 28)
            {
                data.add(new CheckoutInvalidBillingBean(records));
            }
            line = reader.readLine();
        }
        reader.close();
        return data;
    }
    
    public static ArrayList<CheckoutRegInvalidBillingBean> readCheckoutRegInvalidBilingData() throws Exception
    {
        BufferedReader reader = new BufferedReader(new FileReader(CHECKOUT_REG_INVALID_BILLING_DATA));
        ArrayList<CheckoutRegInvalidBillingBean> data = new ArrayList<CheckoutRegInvalidBillingBean>();
        String line = reader.readLine();
        line = reader.readLine();
        while (null != line)
        {
            String[] records = line.split(",");
            if (records.length >= 32)
            {
                data.add(new CheckoutRegInvalidBillingBean(records));
            }
            line = reader.readLine();
        }
        reader.close();

        return data;
    }

    public static ArrayList<CheckoutRegInvalidshippingBean> readCheckoutRegInvalidShippingData() throws Exception
    {
        BufferedReader reader = new BufferedReader(new FileReader(CHECKOUT_REG_INVALID_SHIPPING_DATA));
        ArrayList<CheckoutRegInvalidshippingBean> data = new ArrayList<CheckoutRegInvalidshippingBean>();
        String line = reader.readLine();
        line = reader.readLine();
        while (null != line)
        {
            String[] records = line.split(",");
            if (records.length >= 23)
            {
                data.add(new CheckoutRegInvalidshippingBean(records));
            }
            line = reader.readLine();
        }
        reader.close();

        return data;
    }

    public static ArrayList<ImageTextBean> readAllImages(String suiteName) throws Exception
    {
        BufferedReader reader = new BufferedReader(new FileReader(IMAGE_DATA_FILE));
        ArrayList<ImageTextBean> data = new ArrayList<ImageTextBean>();
        String line = reader.readLine();
        line = reader.readLine();
        while (null != line)
        {
            String[] records = line.split(",");
            if (records.length >= 10)
            {
                if ("".equalsIgnoreCase(suiteName) || line.contains(suiteName))
                {
                    data.add(new ImageTextBean(line));
                }
            }
            line = reader.readLine();
        }
        reader.close();

        return data;
    }
}