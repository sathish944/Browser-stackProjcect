package com.ch.occ.pages;

import com.ch.ExcelUtils.ExcelProperty;
import com.ch.occ.utils.SeleniumUtils;
import com.ch.occ.utils.constants.FileConstants;
import com.ch.occ.utils.constants.ModuleNames;

public class CreateAccountPage implements FileConstants, ModuleNames
{

    public static void CreateAccountSubmit() throws Exception
    {

        SeleniumUtils.click(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, REG_SUBMIT));
    }

    public static void loginCreateAccount() throws Exception
    {

        SeleniumUtils.click(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, LOGIN_CREATE_ACC));
    }

    public static void CreateAccountSuggestedAddress() throws Exception
    {

        SeleniumUtils.click(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, REG_SUGGESTED_ADD));
    }

    public static void createAccountEditAdd() throws Exception
    {

        SeleniumUtils.click(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, REG_TYPED_EDIT));
    }

    public static void createAccountTypedAdd() throws Exception
    {

        SeleniumUtils.click(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, REG_TYPED_ADD));
    }

    public static void clickAddCart() throws Exception
    {

        SeleniumUtils.click(ExcelProperty.getElementValue(CART, ADD_TO_CART_SKULIST));
    }

    public static void clickCheckoutCreateAcc() throws Exception
    {

        SeleniumUtils.click(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, CHECKOUT_CHECK_BOX_CREATE));
    }

    public static void paymentDetails() throws Exception
    {
        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_NAME_CARD), "ABCD");
        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_CARD_TYPE), "Visa");
        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_CARD_NUM), "4111 1111 1111 1111");
        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_CARD_CVV), "123");
        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_CARD_ENDYEAR), "01 - January");
        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_CARD_ENDMONTH), "2020");
    }

    public static void createAccountCancel() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, CREATE_ACCOUNT_OVERLAY_CANCEL));
    }

}
