package com.ch.occ.pages;

import com.ch.ExcelUtils.ExcelProperty;
import com.ch.occ.utils.PropertyUtil;
import com.ch.occ.utils.SeleniumUtils;
import com.ch.occ.utils.constants.FileConstants;
import com.ch.occ.utils.constants.ModuleNames;

public class MyAccountPage implements FileConstants, ModuleNames
{

    public static void VerifyMyDetails() throws Exception
    {
        SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_DETAILS));
    }
    
    public static void clickSortByDate() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_ACCOUNT_SORT_DATE));
    }
    public static void clicksort() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_ACCOUNT_SORT_TEXT_BOX));
    }
    
    public static void clickSortByNumber() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_ACCOUNT_SORT_ID));
    }
    
    public static void clickSortByPrice() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_ACCOUNT_SORT_BY_PRICE));
    }

    public static boolean iSVerifyMyDetails() throws Exception
    {
        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_DETAILS));

    }

    public static String iSVerifyErrorHeader() throws Exception
    {
        return SeleniumUtils.getText(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, ACC_REG_CONFORMATION_MSG));

    }

    public static String iSVerifyErrorlastname() throws Exception
    {
        return SeleniumUtils.getText(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_ACCOUNT_LNAME_ERROR));

    }

    public static String iSVerifyErrorfirstname() throws Exception
    {
        return SeleniumUtils.getText(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_ACCOUNT_FNAME_ERROR));

    }

    public static void VerifyMyPassword() throws Exception
    {
        SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_PASSWORD));
    }

    public static boolean iSVerifyMyPassword() throws Exception
    {
        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_PASSWORD));

    }

    public static void ValidMyPassword() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_PASSWORD_EDIT));
    }

    public static String iSMypwsdErrorMsg() throws Exception
    {
        return SeleniumUtils.getText(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_PASSWORD_CURRENT_ERROR_MSG));

    }

    public static String iSCurrentPswdError() throws Exception
    {
        return SeleniumUtils.getText(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_PASSWORD_CURRENT_ERROR));

    }

    public static String iSMypwsdNewErrorMsg() throws Exception
    {
        return SeleniumUtils.getText(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_PASSWORD_NEW_ERROR_MSG));

    }

    public static String iSMypwsdConfirmNewErrorMsg() throws Exception
    {
        return SeleniumUtils.getText(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_PASSWORD_CONFIRM_NEW_ERROR_MSG));

    }

    public static boolean iSVerifyAddressFirstName() throws Exception
    {
        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_ADDRESS_BOOK_FNAME));

    }

    public static boolean iSVerifyAddressLastName() throws Exception
    {
        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_ADDRESS_BOOK_LNAME));

    }

    public static boolean iSVerifyAddressCountry() throws Exception
    {
        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_ADDRESS_BOOK_COUNTRY));

    }

    public static boolean iSVerifyAddressAddressFields1() throws Exception
    {
        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_ADDRESS_BOOK_ADD_LINE1));

    }

    public static boolean iSVerifyAddressAddressFields2() throws Exception
    {
        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_ADDRESS_BOOK_ADD_LINE2));

    }

    public static boolean iSVerifyAddressCity() throws Exception
    {
        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_ADDRESS_BOOK_CITY));

    }

    public static boolean iSVerifyAddressState() throws Exception
    {
        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_ADDRESS_BOOK_STATE));

    }

    public static boolean iSVerifyAddressZipcode() throws Exception
    {
        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_ADDRESS_BOOK_ZIP));

    }

    public static boolean iSVerifyAddressPhone() throws Exception
    {
        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_ADDRESS_BOOK_PHONE));

    }

    public static String iSVerifyAddressFirstNameError() throws Exception
    {
        return SeleniumUtils.getText(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_ADDRESS_BOOK_FNAME_ERROR));

    }

    public static String iSVerifyAddressLastNameError() throws Exception
    {
        return SeleniumUtils.getText(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_ADDRESS_BOOK_LNAME_ERROR));

    }

    public static boolean iSVerifyAddressCountryError() throws Exception
    {
        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_ADDRESS_BOOK_COUNTRY_ERROR));

    }

    public static String iSVerifyAddressAddressFields1Error() throws Exception
    {
        return SeleniumUtils.getText(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_ADDRESS_BOOK_ADD_LINE1_ERROR));

    }

    public static String iSVerifyAddressAddressFields2Error() throws Exception
    {
        return SeleniumUtils.getText(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_ADDRESS_BOOK_ADD_LINE2_ERROR));

    }

    public static String iSVerifyAddressCityError() throws Exception
    {
        return SeleniumUtils.getText(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_ADDRESS_BOOK_CITY_ERROR));

    }

    public static String iSVerifyAddressStateError() throws Exception
    {
        return SeleniumUtils.getText(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_ADDRESS_BOOK_STATE_ERROR));

    }

    public static String iSVerifyAddressZipcodeError() throws Exception
    {
        return SeleniumUtils.getText(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_ADDRESS_BOOK_ZIP_ERROR));

    }

    public static String iSVerifyAddressPhoneError() throws Exception
    {
        return SeleniumUtils.getText(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_ADDRESS_BOOK_PHONE_ERROR));

    }

    public static boolean iSVerifyAddressDefaultDisplay() throws Exception
    {
        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_ADDRESS_BOOK_DEFAULT_DISPLAY));

    }

    public static boolean iSVerifyMyAddressTitleDisplay() throws Exception
    {
        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_ADDRESS_BOOK_TITLE));

    }

    public static boolean myAccountLabels() throws Exception
    {
        String element = PropertyUtil.getStaticText(MY_ACC_PROFILE);
        String element1 = PropertyUtil.getStaticText(MY_ACC_ADDRESS_BOOK);
        String element2 = PropertyUtil.getStaticText(MY_ACC_MY_PWD);
        boolean flag = false;
        try
        {
            flag = SeleniumUtils.pageSourceContains(element);
            flag = SeleniumUtils.pageSourceContains(element1);
            flag = SeleniumUtils.pageSourceContains(element2);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return flag;
    }

    public static void editProfileDetails() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_ACC_PROFILE_EDIT));
    }

    public static void updateProfileDetails() throws Exception
    {
        SeleniumUtils.clear(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_ACC_EDIT_FNAME));
        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_ACC_EDIT_FNAME), "XYZ");
        SeleniumUtils.clear(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_ACC_EDIT_PHONE));
        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_ACC_EDIT_PHONE), "9740099112");
        SeleniumUtils.click(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_ACCOUNT_SAVE));
    }
    
    public static void enterInValidDataEditProfile() throws Exception{
    	   SeleniumUtils.clear(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_ACC_EDIT_FNAME));
    	   SeleniumUtils.clear(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_ACC_EDIT_LNAME));
    	   SeleniumUtils.clear(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_ACC_EDIT_PHONE));
           SeleniumUtils.sendKeys(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_ACC_EDIT_PHONE), "97400991123dfgdfgsf2");
    }

    public static void cancelEditProfileDetails() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_ACCOUNT_CANCEL));
    }

    public static void errorProfileDetails() throws Exception
    {
        SeleniumUtils.clear(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_ACC_EDIT_FNAME));
        SeleniumUtils.clear(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_ACC_EDIT_LNAME));
        SeleniumUtils.clear(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_ACC_EDIT_PHONE));
        SeleniumUtils.click(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_ACCOUNT_SAVE));
    }

    public static void addNewAddressLink() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_AC_NEW_ADDRESS_ADD));
    }

    public static void addNewAddressDetails() throws Exception
    {
        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_AC_NEW_F_NAME), "ABCD");
        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_AC_NEW_L_NAME), "XYZ");
//        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_AC_NEW_COUNTRY), "United States");
        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_AC_NEW_ADD_ONE), "1140 E FOWLER AVE");
        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_AC_NEW_ADD_TWO), "FOOWLER");
        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_AC_NEW_CITY), "TAMPA");
        SeleniumUtils.dropDownByVisibleText(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_AC_NEW_STATE), "Florida");
        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_AC_NEW_ZIPCODE), "33612");
        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_AC_NEW_PHONE), "9902515541");
        SeleniumUtils.click(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_ACCOUNT_SAVE));
    }
    
    public static void addOurAddressDetails() throws Exception
    {
        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_AC_NEW_F_NAME), "ABCDEFGH");
        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_AC_NEW_L_NAME), "XYZWWWW");
//        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_AC_NEW_COUNTRY), "United States");
        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_AC_NEW_ADD_ONE), "1140 FOWLER AVE");
        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_AC_NEW_ADD_TWO), "FOOWLER");
        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_AC_NEW_CITY), "Tampa");
        SeleniumUtils.dropDownByVisibleText(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_AC_NEW_STATE), "Florida");
        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_AC_NEW_ZIPCODE), "33614");
        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_AC_NEW_PHONE), "9902515541");
        SeleniumUtils.click(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_ACCOUNT_SAVE));
    }

    public static void saveAddress() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_ACCOUNT_SAVE));
    }

    public static void editNewAddressLink() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_ACC_ADDRESS_EDIT));
    }

    public static void cancelAddress() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_ACCOUNT_CANCEL));
    }

    public static void addInvalidAddressDetails() throws Exception
    {
        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_AC_NEW_F_NAME), "1234");
        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_AC_NEW_L_NAME), "5678");
//        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_AC_NEW_COUNTRY), "United States");
        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_AC_NEW_ADD_ONE), "1817 Birmingham");
        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_AC_NEW_ADD_TWO), "FOOWLER");
        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_AC_NEW_CITY), "Alabama");
        SeleniumUtils.dropDownByVisibleText(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_AC_NEW_STATE), "Florida");
        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_AC_NEW_ZIPCODE), "35203");
        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_AC_NEW_PHONE), "hjvhjj");
    }

    public static void removeAddress() throws Exception
    {
        try
        {
            SeleniumUtils.javaScriptExecutorDown("150");
            SeleniumUtils.click(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_ACC_REMOVE_ADD)); 
        } catch (Exception e)
        {
            SeleniumUtils.javaScriptExecutorUp("150");
            SeleniumUtils.javaScriptClick(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_ACC_REMOVE_ADD), 200);
        }
       
    }

    public static void removePrimaryAddress() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_ACC_REMOVE_PRI_ADD));
    }

    public static void editChangePwdLink() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_ACC_CHANGE_PWD_EDIT));
    }

    public static void myAccountChangePassword() throws Exception
    {
        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_ACC_OLD_PWD), "timepass@123");
        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_ACC_NEW_PWD), "timepass@123");
        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_ACC_CONFIRM_PWD), "timepass@123");
    }

    public static void myAccountPasswordMismatch() throws Exception
    {
        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_ACC_OLD_PWD), "timepass@123");
        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_ACC_NEW_PWD), "timepass@123");
        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_ACC_CONFIRM_PWD), "12345abcd");
    }

    public static void myAccountPasswordError() throws Exception
    {
        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_ACC_OLD_PWD), "1234abcd");
        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_ACC_NEW_PWD), "timepass@123");
        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_ACC_CONFIRM_PWD), "timepass@123");
    }

    public static void myAccountInvalidPasswordError() throws Exception
    {
        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_ACC_OLD_PWD), "timepass@123");
        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_ACC_NEW_PWD), "timep");
        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_ACC_CONFIRM_PWD), "timep");
    }

    public static void myAccountOrderHistory() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_ACC_ORDER_HISTORY));
    }

    public static boolean myAccountOrderHistoryStatic() throws Exception
    {
        String element = PropertyUtil.getStaticText(MY_ACC_ORDER_HISTORY_DATE);
        String element1 = PropertyUtil.getStaticText(MY_ACC_ORDER_HISTORY_NUMBER);
        String element2 = PropertyUtil.getStaticText(MY_ACC_ORDER_HISTORY_TOTAL);
        boolean flag = false;
        try
        {
            flag = SeleniumUtils.pageSourceContains(element);
            flag = SeleniumUtils.pageSourceContains(element1);
            flag = SeleniumUtils.pageSourceContains(element2);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return flag;
    }

    public static void myAccountOrderDetails() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_ACC_ORDER_DETAILS_BACK));
    }

    public static void myAccountOrderDetailsBack() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_ACC_ORDER_DETAILS_BACK));
    }

    public static void myAccountEmailSubscribe() throws Exception
    {
        try
        {
            SeleniumUtils.javaScriptExecutorDown("150");
            SeleniumUtils.click(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_AC_NEW_DEFAULT_ADD_CHECK_BOX));
        } catch (Exception e)
        {
//            SeleniumUtils.javaScriptExecutorUp("150");
            SeleniumUtils.javaScriptClick(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_AC_NEW_DEFAULT_ADD_CHECK_BOX),200);
        }
        
    }
    
    public static void myAccountTrackYourOrder() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, MY_ACC_TRACK_ORDER));
    }
    
    public static void footerTrackOrder() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, FOOTER_TRACK_ORDERS));
    }
    
    public static void clickTrackOrder() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, TRACK_ORDER_BUTTON));
    }
    
    public static void enterTrackOrderData() throws Exception
    {
        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, TRACK_ORDER_NUMBER_OVERLAY), "gggggg");
        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, TRACK_ORDER_ZIP), "gggggg");
    }
}
