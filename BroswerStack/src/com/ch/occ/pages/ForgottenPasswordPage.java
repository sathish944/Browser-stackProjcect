package com.ch.occ.pages;

import com.ch.ExcelUtils.ExcelProperty;
import com.ch.occ.utils.SeleniumUtils;
import com.ch.occ.utils.constants.FileConstants;
import com.ch.occ.utils.constants.ModuleNames;

public class ForgottenPasswordPage implements FileConstants, ModuleNames
{

    public static void clickForgotPassword() throws Exception
    {

        SeleniumUtils.click(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, FORGOT_PASSWORD));
    }

    public static void clickForgotPassword(String email) throws Exception
    {

        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, FORGOT_PASSWORD_EMAIL_INPUT), email);
    }

    public static void clickForgotPasswordSubmit() throws Exception
    {

        SeleniumUtils.click(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, EMAIL_PASSWORD_SUBMIT));
    }

    public static void clickForgotPasswordClose() throws Exception
    {

        SeleniumUtils.click(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, FORGOT_PWD_CLOSE));
    }

    public static void forgottenPasswordCancel() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, FORGOT_PWD_OVERLAY_CANCEL));
    }

}
