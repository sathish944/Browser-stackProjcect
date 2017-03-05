package com.ch.occ.pages;

import com.ch.ExcelUtils.ExcelProperty;
import com.ch.occ.utils.SeleniumUtils;
import com.ch.occ.utils.constants.FileConstants;

public class ForgotPasswordPage implements FileConstants

{
    public static void clickLogin() throws Exception
    {

        SeleniumUtils.click(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, FORGOT_PASSWORD_EMAIL_INPUT));
    }
    
    public static void clickEmailPassword()throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, EMAIL_PASSWORD_SUBMIT));
    }
    
    public static void forgetPasswordButton() throws Exception 
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, EMAIL_PASSWORD_SUBMIT));
    }
    

}
