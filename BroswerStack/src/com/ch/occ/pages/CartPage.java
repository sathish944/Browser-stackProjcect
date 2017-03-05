/**
 * user
 */
package com.ch.occ.pages;

import org.openqa.selenium.Keys;

import com.ch.ExcelUtils.ExcelProperty;
import com.ch.occ.utils.SeleniumUtils;
import com.ch.occ.utils.constants.FileConstants;

/**
 * @author Prasanna Kumar Reddy 9:44:43 pm
 */
public class CartPage implements FileConstants
{

    public static void clickcart() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(CART,CART_CLICK));

    }

    public static void selectcountry() throws Exception
    {
    	SeleniumUtils.dropDownByValue(ExcelProperty.getElementValue(CART, SELECT_COUNTRY), "US");
//        SeleniumUtils.click(ExcelProperty.getElementValue(CART,SELECT_COUNTRY));
//        SeleniumUtils.click(ExcelProperty.getElementValue(CART,US_COUNTRY_VALUE));
    }

    public static void  state() throws Exception {
    	SeleniumUtils.dropDownByVisibleText(ExcelProperty.getElementValue(CART,SELECT_STATE), "Alaska");
	}
    
    public static void selectState() throws Exception
    {
    
        try
        {
            
            SeleniumUtils.click(ExcelProperty.getElementValue(CART,SELECT_STATE));
        } catch (Exception e)
        {
            
            SeleniumUtils.click(ExcelProperty.getElementValue(CART,SELECT_STATE));
        }
        try
        {
            
            SeleniumUtils.click(ExcelProperty.getElementValue(CART,CAL_STATE_VALUE));
        } catch (Exception e)
        {
            
            SeleniumUtils.click(ExcelProperty.getElementValue(CART,CAL_STATE_VALUE));
        }
    }

    public static void itemAddToWhishList() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(CART,CART_ADDWISHLIST));
    }

    public static void enterzipcode() throws Exception
    {
//        ExcelBean elementValue = ExcelProperty.getElementValue(CART,CAL_ZIPCODE_VALUE);
        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(CART,SELECT_ZIPCODE),"90006" + Keys.ENTER);
    }

    public static String isShoppingcartTextVerify() throws Exception
    {
        return SeleniumUtils.getText(ExcelProperty.getElementValue(CART,SHOPPINGCART_TITLE));
    }

    public static boolean isremovedisplayed() throws Exception
    {
        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(CART,CART_REMOVE));

    }
    public static void clickFirstProduct() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(CART, F_PRODUCT));
        		}

    
    
    public static void addgiftwrap() throws Exception
    
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(CART,CART_ADDGIFTWRAP));

    }

    public static void minicartcheckout() throws Exception

    {
        SeleniumUtils.click(ExcelProperty.getElementValue(CART,MINICART_CHECKOUT));

    }
    public static void cartGifts() throws Exception

    {
        SeleniumUtils.click(ExcelProperty.getElementValue(CART,CART_CLICKBABYGIFTS));

    }


    public static void selectcountryerror() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(CART,SELECT_COUNTRY));
        SeleniumUtils.click(ExcelProperty.getElementValue(CART,COUNTRY_LABEL));

    }
    
    public static void selectStateError() throws Exception
    {
        SeleniumUtils.javaScriptClick( ExcelProperty.getElementValue(CART,SELECT_STATE),190);
        SeleniumUtils.javaScriptClick( ExcelProperty.getElementValue(CART,STATE_LABEL),190);
//        try
//        {
//            SeleniumUtils.click(ExcelProperty.getElementValue(CART,STATE_LABEL));
//        } catch (Exception e)
//        {
//            SeleniumUtils.pageup();
//            SeleniumUtils.click(ExcelProperty.getElementValue(CART,STATE_LABEL));
//        }

    }
  
    }
