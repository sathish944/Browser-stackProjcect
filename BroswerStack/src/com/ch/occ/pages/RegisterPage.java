package com.ch.occ.pages;

import com.ch.ExcelUtils.ExcelProperty;
import com.ch.occ.utils.SeleniumUtils;
import com.ch.occ.utils.Type;
import com.ch.occ.utils.constants.FileConstants;

public class RegisterPage implements FileConstants

{
    public static void enterFirstName(String fname) throws Exception
    {
        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, REG_FNAME), fname);
    }

    public static void enterLastName(String lname) throws Exception
    {
        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, REG_LNAME), lname);
    }

    public static void registerModal() throws Exception
    {
        SeleniumUtils.iSDisplayed(Type.ID, "CC-LoginRegistrationModal");
    }

    public static boolean verifyRegisterModal() throws Exception
    {

        return SeleniumUtils.iSDisplayed(Type.ID, "CC-LoginRegistrationModal");
    }

    public static void enterEmail(String email) throws Exception
    {

        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, REG_EMAIL), email);
    }

    public static void enterPassword(String password) throws Exception
    {
        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, REG_PASSWORD), password);

    }

    public static void enterCPassword(String cPassword) throws Exception
    {

        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, REG_CPASSWORD), cPassword);
    }

    public static void clickSubmit() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, REG_SUBMIT));
    }

    public static void clickRegisterCheckBox() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, REG_EMAIL_CHECKBOX));
    }

    public static void accRegConMsg() throws Exception
    {
        SeleniumUtils.getText(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, ACC_REG_CONFORMATION_MSG));
    }

    public static void emailErrorMsg() throws Exception
    {
        SeleniumUtils.getText(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, EMAIL_ERROR_MSG));
    }

    public static void invaliddata() throws Exception
    {
        SeleniumUtils.getText(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, PASSWORD_ERROR_MSG));
    }

    public static void clickCancel() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, CREATE_ACCOUNT_OVERLAY_CANCEL));
    }
}
