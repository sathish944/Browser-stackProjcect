
package com.ch.occ.pages;

import com.ch.ExcelUtils.ExcelProperty;
import com.ch.occ.utils.PropertyUtil;
import com.ch.occ.utils.SeleniumUtils;
import com.ch.occ.utils.Type;
import com.ch.occ.utils.constants.FileConstants;
import com.ch.occ.utils.constants.ModuleNames;

public class LoginPage implements FileConstants, ModuleNames
{

    public static void enterEmail(String email) throws Exception
    {
        Thread.sleep(9000);
        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, LOGIN_EMAIL), email);
    }

    public static void cancelbutton() throws Exception
    {
        SeleniumUtils.click(Type.ID, "CC-userLoginCancel");
    }

    public static void enterLoginEmail() throws Exception
    {
        Thread.sleep(9000);
        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, LOGIN_EMAIL),
                PropertyUtil.getPropertyValue(LOGIN_MAIL, SERVER_PROPERTY_FILE));
    }

    public static void enterLoginPassword() throws Exception
    {
        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, LOGIN_PASSWORD), SERVER_PROPERTY_FILE);
    }

    public static void enterLoginPassword(String pass) throws Exception
    {
        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, LOGIN_PASSWORD), pass);
    }

    public static void clickLoginButton() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, LOGIN_BUTTON));
    }

    public static void clickLogoutButton() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(HOMEPAGE, HOME_LOGOUT));
    }

    public static void invalidEmailId() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, LOGIN_ERROR));
    }

    public static void forgotPassword() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, FORGOT_PASSWORD));
    }

    public static boolean isforgotPassword()
    {
        return SeleniumUtils.iSDisplayed(Type.ID, "CC-linkForgotPasswd");
    }

    public static void forgotPasswordPage() throws Exception
    {
        SeleniumUtils.getText(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, FORGOT_PASSWORD_PAGE));
    }

    public static void logInCancel() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, LOGIN_CANCEL));
    }
}
