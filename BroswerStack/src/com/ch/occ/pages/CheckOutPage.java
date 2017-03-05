
package com.ch.occ.pages;

import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.ch.ExcelUtils.ExcelProperty;
import com.ch.occ.bean.CheckoutBean;
import com.ch.occ.report.utils.AbstractTestCaseReport;
import com.ch.occ.utils.DriverFactory;
import com.ch.occ.utils.FileUtility;
import com.ch.occ.utils.PropertyUtil;
import com.ch.occ.utils.SeleniumUtils;
import com.ch.occ.utils.Type;
import com.ch.occ.utils.constants.FileConstants;

/**
 * @author sathish naidu lingutla
 */
public class CheckOutPage extends AbstractTestCaseReport implements FileConstants
{
    public static final int HEADER_OFFSET = 190;
    public static String    email         = "lenox@lenox.com";
    public static String    Logemail      = "lenox123@gmail.com";
    public static String    password      = "123456789";
    public static String    country       = "United States";
    public static String    lane1         = "PO BOX 755040";
    public static String    lane2         = "ALASKA SEA GRANT";
    public static String    city          = "FAIRBANKS";
    public static String    state         = "Alaska";
    public static String    state1        = "florda";
    public static String    phone         = "9876543210";
    public static String    zipcode       = "99775";
    public static String    lastname      = "JADA";

    public static String    Blane1        = "480 Clinton Ave";
    public static String    Blane2        = "5th Precincts";
    public static String    Bcity         = "Newark";
    public static String    Bstate        = "New Jersey";
    public static String    Bcountry      = "United States";
    public static String    Bphone        = "9876543210";
    public static String    Bzipcode      = "07108";
    public static String    name1         = "lenox";
    public static String    name2         = "data";
    public static String    cardvisa      = "Visa";
    public static String    cardamex      = "American Express";
    public static String    cardmaster    = "Mastercard";
    public static String    carddisc      = "Discover";
    public static String    cardmonth     = "02 - February";
    public static String    cardyear      = "2019";
    public static String    cardcvv       = "123";
    public static String    cardamexcvv   = "1234";
    public static String    cardvisanum   = "4001270000000000";
    public static String    cardAmexNum   = "341111597241002";
    public static String    cardmastnum   = "5405010100000016";
    public static String    carddiscnum   = "6510000000001248";

    public static void checkout() throws Exception
    {
        ArrayList<CheckoutBean> data = FileUtility.readCheckoutData();
        for (Iterator<CheckoutBean> iterator = data.iterator(); iterator.hasNext();)
        {

            CheckoutBean checkout = (CheckoutBean) iterator.next();
            CheckOutPage.checkOutGuestEmail(checkout.getEmail());
            DriverFactory.getDriver().navigate().refresh();
            Thread.sleep(3000);
            CheckOutPage.checkOutGuestEmail(checkout.getEmail());
            CheckOutPage.checkOutFirstName(checkout.getFname());
            CheckOutPage.checkOutLastName(checkout.getLname());
            CheckOutPage.checkOutCountry(checkout.getCountry());
            CheckOutPage.addresslane1(checkout.getAddress1());
            CheckOutPage.addresslane2(checkout.getAddress2());
            CheckOutPage.checkOutCity(checkout.getCity());
            CheckOutPage.selectStateRegion(checkout.getStateregion());
            CheckOutPage.checkOutZipcode(checkout.getZipcode());
            CheckOutPage.checkOutPhoneNumber(checkout.getPhonenumber());
            if (SeleniumUtils.iSDisplayed(Type.CSSSELECTOR, "input[id*=BillAddress]") == true)
            {
                try
                {
                    SeleniumUtils.click(Type.CSSSELECTOR, "input[id*=BillAddress]");
                } catch (Exception e)
                {
                    SeleniumUtils.tab();
                    Thread.sleep(4000);
                    SeleniumUtils.javascriptexecutorDown250();
                    SeleniumUtils.click(Type.CSSSELECTOR, "input[id*=BillAddress]");
                }
            }
            CheckOutPage.checkOutBAFirstName(checkout.getFname());
            CheckOutPage.checkOutBALastName(checkout.getLname());
            CheckOutPage.checkOutBACountry(checkout.getCountry());
            CheckOutPage.addressBAlane1(checkout.getAddress1());
            CheckOutPage.addressBAlane2(checkout.getAddress2());
            CheckOutPage.checkOutBACity(checkout.getCity());
            CheckOutPage.selectBAStateRegion(checkout.getStateregion());
            CheckOutPage.checkOutBAZipcode(checkout.getZipcode());
            CheckOutPage.checkOutPayNameCard(checkout.getNamecard());
            CheckOutPage.checkOutCardType(checkout.getCardtype());
            CheckOutPage.checkOutCardNumber(checkout.getCardnumber());
            CheckOutPage.checkOutCVV(checkout.getCheckoutcvv());
            CheckOutPage.checkOutMonth(checkout.getExpiresmonth());
            CheckOutPage.checkOutYear(checkout.getExpiresyear());
            SeleniumUtils.wait(1);
            try
            {
                CheckOutPage.occplaceOrder();
            } catch (Exception e)
            {
                CheckOutPage.occplaceOrder();
            }

        }
    }

    public static String getForgotSucessMessage() throws Exception
    {
        return SeleniumUtils.getText(ExcelProperty.getElementValue(CHECKOUT, FORGOT_PASSWORD_TEXT));
    }

    public static boolean isCheckOutGuest()
    {

        boolean selectedById = false;
        try
        {
            selectedById = SeleniumUtils.isSelected(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_GUEST));
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return selectedById;
    }

    public static void clickCountry(String SCountry) throws Exception
    {
        // SeleniumUtils.javaScriptClick(Type.ID, HEADER_OFFSET,
        // "CC-checkoutAddressBook-scountry");
        SeleniumUtils.dropDownByVisibleText(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_COUNTRY), SCountry);
    }

    public static void clickState(String SState) throws Exception
    {
        // SeleniumUtils.javaScriptClick(Type.CSSSELECTOR, HEADER_OFFSET,
        // PropertyUtil.getObjectValue(CHECKOUT_REGION_STATE));
        SeleniumUtils.dropDownByVisibleText(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_REGION_STATE), SState);
    }

    public static void clickBillCountry(String BCountry) throws Exception
    {
        // SeleniumUtils.javaScriptClick(Type.CSSSELECTOR, HEADER_OFFSET,
        // PropertyUtil.getObjectValue(CHECKOUT_BILL_COUNTRY));
        SeleniumUtils.dropDownByVisibleText(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_BILL_COUNTRY), BCountry);
    }

    public static void clickBillState(String BState) throws Exception
    {
        // SeleniumUtils.javaScriptClick(Type.CSSSELECTOR, HEADER_OFFSET,
        // PropertyUtil.getObjectValue(CHECKOUT_BILL_STATE));
        SeleniumUtils.dropDownByVisibleText(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_BILL_STATE), BState);
    }

    public static void clickCardType(String CardType) throws Exception
    {

        // SeleniumUtils.javaScriptClick(ExcelProperty.getElementValue(CHECKOUT,
        // CHECKOUT_CARD_TYPE), HEADER_OFFSET);
        SeleniumUtils.dropDownByVisibleText(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_CARD_TYPE), CardType);

    }

    public static void clickCardMonth(String CardMonth) throws Exception
    {
        // SeleniumUtils.javaScriptClick(ExcelProperty.getElementValue(CHECKOUT,
        // CHECKOUT_CARD_ENDMONTH), HEADER_OFFSET);
        SeleniumUtils.dropDownByVisibleText(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_CARD_ENDMONTH), CardMonth);
    }

    public static void clickCardYear(String CardYear) throws Exception
    {
        // SeleniumUtils.javaScriptClick(ExcelProperty.getElementValue(CHECKOUT,
        // CHECKOUT_CARD_ENDYEAR), HEADER_OFFSET);
        SeleniumUtils.dropDownByVisibleText(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_CARD_ENDYEAR), CardYear);
    }

    public static void shippAddrValidData() throws Exception
    {
        CheckOutPage.checkOutFirstName(name1);
        CheckOutPage.checkOutLastName(lastname);
        CheckOutPage.addresslane1(lane1);
        CheckOutPage.addresslane2(lane2);
        CheckOutPage.checkOutCity(city);
        CheckOutPage.clickState(state);
        CheckOutPage.clickCountry(country);
        CheckOutPage.checkOutZipcode(zipcode);
        CheckOutPage.checkOutPhoneNumber(phone + Keys.TAB);
    }

    public static void billAddValidData() throws Exception
    {
        SeleniumUtils.wait(10);
        CheckOutPage.checkOutBAFirstName(name1);
        CheckOutPage.checkOutBALastName(name2);
        CheckOutPage.clickBillCountry(Bcountry);
        CheckOutPage.addressBAlane1(Blane1);
        CheckOutPage.addressBAlane2(Blane2);
        CheckOutPage.checkOutBACity(Bcity);
        CheckOutPage.clickBillState(Bstate);
        CheckOutPage.checkOutBAZipcode(Bzipcode);
        CheckOutPage.checkOutBAPhn(Bphone);
        SeleniumUtils.wait(2);

    }

    public static void clickBillingAddress() throws Exception
    {
        // SeleniumUtils.javaScriptClick(ExcelProperty.getElementValue(CHECKOUT,
        // CHECKOUT_BILL_CHECKBOX), 130);
        SeleniumUtils.javaScriptClick(Type.XPATH, HEADER_OFFSET, "//div[4]/div/div/label/occ-checkbox/div/label");
    }

    public static void paymentValidVisaPayData() throws Exception
    {
        CheckOutPage.checkOutPayNameCard(name1);
        CheckOutPage.checkOutCardType(cardvisa);
        CheckOutPage.checkOutCardNumber(cardvisanum);
        CheckOutPage.checkOutCVV(cardcvv);
        CheckOutPage.checkOutMonth(cardmonth);
        CheckOutPage.checkOutYear(cardyear);
        SeleniumUtils.wait(02);
        CheckOutPage.occplaceOrder();
    }

    public static void paymentValidMasterPayData() throws Exception
    {
        CheckOutPage.checkOutPayNameCard(name1);
        CheckOutPage.checkOutCardType(cardmaster);
        CheckOutPage.checkOutCardNumber(cardmastnum);
        CheckOutPage.checkOutCVV(cardcvv);
        CheckOutPage.checkOutMonth(cardmonth);
        CheckOutPage.checkOutYear(cardyear);
        CheckOutPage.occplaceOrder();
    }

    public static void paymentValidAmexPayData() throws Exception
    {
        CheckOutPage.checkOutPayNameCard(name1);
        CheckOutPage.checkOutCardType(cardamex);
        CheckOutPage.checkOutCardNumber(cardvisanum);
        CheckOutPage.checkOutCVV(cardcvv);
        CheckOutPage.checkOutCardNumber(cardAmexNum);
        CheckOutPage.checkOutCVV(cardamexcvv);
        CheckOutPage.checkOutMonth(cardmonth);
        CheckOutPage.checkOutYear(cardyear);
        CheckOutPage.occplaceOrder();
    }

    public static void paymentValidDiscPayData() throws Exception
    {
        CheckOutPage.checkOutPayNameCard(name1);
        CheckOutPage.checkOutCardType(carddisc);
        CheckOutPage.checkOutCardNumber(carddiscnum);
        CheckOutPage.checkOutCVV(cardcvv);
        CheckOutPage.checkOutMonth(cardmonth);
        CheckOutPage.checkOutYear(cardyear);
        CheckOutPage.occplaceOrder();
    }

    public static void paymentWithPaypalMethod() throws Exception
    {
        SeleniumUtils.wait(10);
        SeleniumUtils.javaScriptClick(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_METHOD_PAYPAL), 200);
        SeleniumUtils.wait(50);
        DriverFactory.getDriver().switchTo().frame("injectedUl");
        SeleniumUtils.sendKeys(Type.ID, "email", "shopper@lenox.com");
        SeleniumUtils.sendKeys(Type.ID, "password", "Lenox123");
        SeleniumUtils.click(Type.ID, "btnLogin");
        SeleniumUtils.wait(20);
        DriverFactory.getDriver().switchTo().defaultContent();
        SeleniumUtils.wait(50);
    }

    public static void checkRegAccount() throws Exception
    {
        SeleniumUtils.wait(10);
        CheckOutPage.occcheckoutcreateaccount();
        CheckOutPage.checkOutRegFname(name1);
        CheckOutPage.checkOutRegLname(name2);
        CheckOutPage.checkOutRegPassword(password);
        CheckOutPage.checkOutRegCPassword(password);
        SeleniumUtils.wait(4);
    }

    // public static void homeLogin() throws Exception {
    // OCCUtlis.occLogin();
    // SeleniumUtils.wait(1);
    // LoginPage.enterLoginEmail("test12@test.com");
    // LoginPage.enterLoginPassword("test@123");
    // LoginPage.clickLoginButton();
    // }

    public static void checkoutLogin() throws Exception
    {
        CheckOutPage.occCheckoutLoginToAccount();
        SeleniumUtils.wait(5);
        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, LOGIN_EMAIL), "lenox123@gmail.com");
        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, LOGIN_PASSWORD), "123456789");
        SeleniumUtils.click(ExcelProperty.getElementValue(CHECKOUT, LOGIN_BUTTON));

    }

    public static void checkLoggedUser() throws Exception
    {
        // SeleniumUtils.click(Type.XPATH,
        // "//fieldset[@id='checkoutOptions']/div/div[2]/label");
        CheckOutPage.occCheckoutLoginToAccount();
        SeleniumUtils.wait(3);
        CheckOutPage.checkOutRegLoginMail(Logemail);
        CheckOutPage.checkOutRegLoginPassword(password);
        // CheckOutPage.checkOutRegLoginButton();
        SeleniumUtils.click(Type.ID, "CC-checkoutRegistration-login-mobile-submit");
        SeleniumUtils.wait(10);
    }

    public static void clickAllRights() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(HOMEPAGE, ALL_RIGHTS_RESERVED));
    }

    public static void checkoutNewAddressButtonClick() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_NEW_ADDRESS_BUTTON));
    }

    public static void checkoutPaymentVisaImageClick() throws Exception
    {

        SeleniumUtils.click(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_PAYMENT_VISA_IMAGE));
    }

    public static boolean isCheckoutProductNameSummary() throws Exception
    {

        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_PRODUCT_NAME_SUMMARY));
    }

    public static boolean isCheckoutOrderSummaryText() throws Exception
    {

        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_ORDER_SUMMARY));
    }

    public static boolean isCheckoutOrderPrice() throws Exception
    {

        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_PRICE_TEXT));
    }

    public static boolean isCheckoutOrderQuantity() throws Exception
    {

        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_QUANTITY_TEXT));
    }

    public static boolean isCheckoutOrderEditButton() throws Exception
    {

        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_EDIT_BUTTON));
    }

    public static void CheckoutOrderEditButtonClick() throws Exception
    {

        SeleniumUtils.click(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_EDIT_BUTTON));
    }

    public static boolean isCheckoutOrderSummarySaleTax() throws Exception
    {

        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_SALE_TAX));
    }

    public static boolean isCheckoutOrderSummaryTotal() throws Exception
    {

        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_ORDER_TOTAL));
    }

    public static boolean isCheckoutOrderSummaryShippingName() throws Exception
    {

        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_ORDER_SUMMARY_SHIPPING_NAME));
    }

    public static boolean isCheckoutOrderSummarySubTotal() throws Exception
    {

        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_ORDER_SUBTOTAL_TEXT));
    }

    public static boolean isCheckOrdSummShippTypeStand() throws Exception
    {

        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(CHECKOUT, CHECK_ORD_SUMM_SHIP_TYPE_STAND));
    }

    public static boolean ischeckoutNewAddressButtonClick() throws Exception
    {

        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_NEW_ADDRESS_BUTTON));
    }

    public static boolean isCheckoutOrderSummaryShippingTypeFinalName() throws Exception
    {

        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_SHIPPING_TYPE_FINAL_NAME));
    }

    public static boolean isCheckoutbill() throws Exception
    {

        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_BILL_LNAME_ERROR));
    }

    public static boolean isCheckOrdSummShipTypeStandSignReq() throws Exception
    {

        return SeleniumUtils
                .iSDisplayed(ExcelProperty.getElementValue(CHECKOUT, CHECK_ORD_SUMM_SHIP_TYPE_STAN_SING_REQI));
    }

    public static boolean isCheckOrdSummShipTypeExped() throws Exception
    {

        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(CHECKOUT, CHECK_ORD_SUMM_SHIP_TYPE_EXPED));
    }

    public static boolean isCheckOrdSummShipTypeExpedSignReq() throws Exception
    {

        return SeleniumUtils
                .iSDisplayed(ExcelProperty.getElementValue(CHECKOUT, CHECK_ORD_SUMM_SHIP_TYPE_EXPED_SIGN_REQU));
    }

    public static boolean isCheckOrdSumShipType2ndDay() throws Exception
    {

        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(CHECKOUT, CHECK_ORD_SUMM_SHIP_TYPE_2ND_DAY));
    }

    public static boolean isCheckOrdSummShippType2ndDaySignReq() throws Exception
    {

        return SeleniumUtils
                .iSDisplayed(ExcelProperty.getElementValue(CHECKOUT, CHECK_ORD_SUMM_SHIP_TYPE_2ND_DAY_SING_REQU));
    }

    public static boolean isCheckOrdSumShipType1Day() throws Exception
    {

        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(CHECKOUT, CHECK_ORD_SUMM_SHIP_TYPE_1DAY));

    }

    public static boolean isCheckOrdSummShippType1DaySignReq() throws Exception
    {

        return SeleniumUtils
                .iSDisplayed(ExcelProperty.getElementValue(CHECKOUT, CHECK_ORD_SUMM_SHIP_TYPE_1DAY_SING_REQU));
    }

    public static void checkOrdSumShipTypeExpedSignReqClick() throws Exception
    {

        SeleniumUtils.click(ExcelProperty.getElementValue(CHECKOUT, CHECK_ORD_SUMM_SHIP_TYPE_EXPED_SIGN_REQU));
    }

    public static boolean isCheckOrdSummShippTypeFinalName() throws Exception
    {

        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_SHIPPING_TYPE_FINAL_NAME));
    }

    public static boolean isOccPaypalContinueShopping() throws Exception
    {
        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_PAYPAL_CONFIRM_BUTTON_HOME));
    }

    public static boolean isCheckoutLogoutButton() throws Exception
    {
        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_LOGOUT_BUTTON));
    }

    public static void checkoutLogoutClick() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_LOGOUT_BUTTON));
    }

    public static void checkOutRegLoginButton() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_LOGIN_BUTTON));
    }

    public static boolean ischeckoutforgotMailId() throws Exception
    {
        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_FORGOT_PASS_MAIL_INPUT));
    }

    public static void checkoutforgotMailId(String Mail) throws Exception
    {
        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_FORGOT_PASS_MAIL_INPUT), Mail);
    }

    public static void checkOutRegLoginMail(String RegMail) throws Exception
    {

        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_REGIST_LOGIN_EMAIL), RegMail);

    }

    public static void checkOutRegLoginPassword(String RegPassword) throws Exception
    {

        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_REGIST_LOGIN_PASSWORD), RegPassword);

    }

    public static boolean ischeckOutRegLoginMail() throws Exception
    {

        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_REGIST_LOGIN_EMAIL));

    }

    public static boolean ischeckOutRegLoginPassword() throws Exception
    {

        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_REGIST_LOGIN_PASSWORD));

    }

    public static void checkoutRegForgotPasswordLink() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_FORGOT_PASSWORD_LINK));
    }

    public static boolean ischeckOutDefaultAddress() throws Exception
    {
        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_DEFAULT_ADDRESS));
    }

    public static void occCheckoutLoginToAccount() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_LOGIN_ACCOUNT));
    }

    public static void checkOutFirstName(String name) throws Exception
    {
        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_FNAME), name);
    }

    public static void checkOutLastName(String lastname) throws Exception
    {
        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_LNAME), lastname);
    }

    public static void placeOrderContiuneShopping() throws Exception
    {

        SeleniumUtils.click(ExcelProperty.getElementValue(CHECKOUT, PLACE_ORDER_CONTINUE_SHOPPING));
    }

    public static boolean isplaceOrderContiuneShopping() throws Exception
    {

        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(CHECKOUT, PLACE_ORDER_CONTINUE_SHOPPING));
    }

    public static boolean isCheckOutGiftCardMessage() throws Exception
    {
        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_GIFT_TEXT));

    }

    public static boolean isDisplayGridIcon() throws Exception
    {
        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(CHECKOUT, GRID_VIEW_ICON));
    }

    // -----------
    public static boolean isOrderConfirmation() throws Exception
    {

        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(CHECKOUT, ORDER_CONFIRMATION_PLACE));

    }

    public static boolean isLoginButton() throws Exception
    {
        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_LOGIN_BUTTON));
    }

    public static boolean isCheckOutForgetPasswordCancelButton() throws Exception
    {

        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_FORGOT_PASS_CANCEL));
    }

    public static void selectquantity(String name) throws Exception
    {
        if (SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(CHECKOUT, ITEM_QUANTITY_DROP)) == true)
        {
            SeleniumUtils.sendKeys(ExcelProperty.getElementValue(CHECKOUT, ITEM_QUANTITY_DROP), name + Keys.ENTER);

        } else if (SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(CHECKOUT, ITEM_QUANTITY_ENTER)) == true)
        {
            DriverFactory.getDriver().findElement(By.cssSelector(PropertyUtil.getObjectValue(ITEM_QUANTITY_ENTER)))
                    .clear();
            SeleniumUtils.sendKeys(ExcelProperty.getElementValue(CHECKOUT, ITEM_QUANTITY_ENTER), name);
        }
    }

    public static boolean isCheckOutFirstName() throws Exception
    {
        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_FNAME));
    }

    public static boolean isCheckOutLastName() throws Exception
    {
        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_LNAME));
    }

    public static boolean isCheckOutCountry() throws Exception
    {
        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_COUNTRY));
    }

    public static boolean isCheckAddresslane1() throws Exception
    {
        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_ADDRESS_LANE1));
    }

    public static boolean isCheckAddresslane2() throws Exception
    {
        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_ADDRESS_LANE2));
    }

    public static boolean isCheckOutCity() throws Exception
    {
        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_CITY));
    }

    public static boolean isCheckSelectStateRegion() throws Exception
    {
        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_REGION_STATE));
    }

    public static boolean isCheckOutZipcode() throws Exception
    {
        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_ZIPCODE));
    }

    public static boolean isCheckOutPhoneNumber() throws Exception
    {
        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_PHONE_NUM));
    }

    public static boolean isCheckedBill() throws Exception

    {
        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_BILL_CHECKBOX));
    }

    public static boolean isCheckedBillCheckboxTextGuest() throws Exception

    {
        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_BILL_CHECKBOX_TEXT_GUEST));
    }

    public static boolean isCheckedBillCheckboxTextRegsiter() throws Exception

    {
        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_BILL_CHECKBOX_TEXT_REG));
    }

    public static boolean isCheckOutBAFirstName() throws Exception
    {
        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_BILL_FNAME));
    }

    public static boolean isCheckOutBALastName() throws Exception
    {
        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_BILL_LNAME));
    }

    public static boolean isCheckOutBACountry() throws Exception
    {
        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_BILL_COUNTRY));
    }

    public static boolean isCheckBAAddressLane1() throws Exception
    {
        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_BILL_ADDRESSLANE1));
    }

    public static boolean isCheckBAAddressLane2() throws Exception
    {
        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_BILL_ADDRESSLANE2));
    }

    public static boolean isCheckOutBACity() throws Exception
    {
        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_BILL_CITY));
    }

    public static boolean isSelectBAStateRegion() throws Exception
    {
        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_BILL_STATE));
    }

    public static boolean isCheckOutBAZipcode() throws Exception
    {
        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_BILL_ZIPCODE));
    }

    public static boolean isCheckOutGiftCardButton() throws Exception
    {
        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_APPLY_BUTTON));
    }

    public static boolean isCheckOutApplyPromoCode() throws Exception
    {
        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_APPLY_PROMO_CODE));
    }

    public static boolean isCheckOutCardType() throws Exception
    {
        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_CARD_TYPE));
    }

    public static boolean isCheckOutRegWelcome() throws Exception
    {
        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_CREATE_WELCOME));
    }

    public static boolean isCheckOutForgetPasswordEmailfieldInput() throws Exception
    {
        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_FORGOT_PASS_MAIL_INPUT));
    }

    public static boolean isCheckOutEmailForgetPasswordSubmitButton() throws Exception
    {
        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_FORGOT_MAIL_SUBMIT));
    }

    public static void selecSizeDrop(int size) throws Exception
    {

        if (SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(CHECKOUT, ITEM_DETAIL_SIZE_RC_SAND)) == true)
        {
            SeleniumUtils.dropDownByIndex(ExcelProperty.getElementValue(CHECKOUT, ITEM_DETAIL_SIZE_RC_SAND), size);

        } else if (SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(CHECKOUT, ITEM_DETAIL_SIZE_RC_SAND)) == true)
        {
            SeleniumUtils.dropDownByIndex(ExcelProperty.getElementValue(CHECKOUT, ITEM_DETAIL_SIZE_RC_SAND), size);

        } else if (SeleniumUtils.iSDisplayed(Type.CSSSELECTOR, "select[id*=CLSZ]"))
        {
            Thread.sleep(2000);
            SeleniumUtils.dropDownByIndex(Type.CSSSELECTOR, "select[id*=CLSZ]", size);
        }
    }

    public static void checkOutCountry(String country) throws Exception
    {
        SeleniumUtils.dropDownByVisibleText(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_COUNTRY), country);
    }

    public static void addresslane1(String lane1) throws Exception
    {
        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_ADDRESS_LANE1), lane1);
    }

    public static String checkOutGuestEmailError() throws Exception
    {
        return SeleniumUtils.getText(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_GUEST_EMAIL_ERROR));
    }

    public static void addresslane2(String lane2) throws Exception
    {
        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_ADDRESS_LANE2), lane2);
    }

    public static void checkOutCity(String city) throws Exception
    {
        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_CITY), city);
    }

    public static void selectStateRegion(String state) throws Exception
    {
        SeleniumUtils.dropDownByVisibleText(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_REGION_STATE), state);
    }

    public static void checkOutZipcode(String zipcode) throws Exception
    {
        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_ZIPCODE), zipcode);
    }

    public static void checkOutPhoneNumber(String phone) throws Exception
    {
        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_PHONE_NUM), phone);
    }

    public static void checkOutBAFirstName(String name) throws Exception
    {
        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_BILL_FNAME), name);
    }

    public static void checkOutBALastName(String lastname) throws Exception
    {
        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_BILL_LNAME), lastname);
    }

    public static void checkOutBACountry(String country) throws Exception
    {
        SeleniumUtils.dropDownByVisibleText(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_BILL_COUNTRY), country);
    }

    public static void addressBAlane1(String lane1) throws Exception
    {
        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_BILL_ADDRESSLANE1), lane1);
    }

    public static void addressBAlane2(String lane2) throws Exception
    {
        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_BILL_ADDRESSLANE2), lane2);
    }

    public static void checkOutBACity(String city) throws Exception
    {
        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_BILL_CITY), city);
    }

    public static void selectBAStateRegion(String state) throws Exception
    {
        SeleniumUtils.dropDownByVisibleText(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_BILL_STATE), state);
    }

    public static void checkOutBAZipcode(String zipcode) throws Exception
    {
        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_BILL_ZIPCODE), zipcode);
    }

    public static void checkOutBAPhn(String phn) throws Exception
    {
        DriverFactory.getDriver().findElement(By.name(PropertyUtil.getObjectValue(CHECKOUT_BA_PHN))).clear();
        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_BA_PHN), phn);
    }

    public static boolean ischeckOutPaymentDetails() throws Exception
    {
        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_PAYMENT_DETAILS));
    }

    public static boolean ischeckOutPaymentMonth() throws Exception
    {

        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_CARD_ENDMONTH));

    }

    public static boolean ischeckOutPaymentYear() throws Exception
    {
        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_CARD_ENDYEAR));
    }

    public static void checkOutPayNameCard(String payname) throws Exception
    {
        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_NAME_CARD), payname);
    }

    public static boolean isCheckOutPayNameCard() throws Exception
    {
        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_NAME_CARD));
    }

    public static void checkOutCardType(String card) throws Exception
    {
        // SeleniumUtils.dropDownByIndex(ExcelProperty.getElementValue(CHECKOUT,
        // CHECKOUT_CARD_TYPE), card);
        SeleniumUtils.dropDownByVisibleText(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_CARD_TYPE), card);
        // SeleniumUtils.sendKeys(ExcelProperty.getElementValue(CHECKOUT,
        // CHECKOUT_CARD_TYPE), card + Keys.ENTER);
    }

    public static void checkOutCardNumber(String cardnumber) throws Exception
    {
        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_CARD_NUM), cardnumber);
    }

    public static void checkOutCVV(String cvv) throws Exception
    {
        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_CARD_CVV), cvv);
    }

    public static void checkOutMonth(String month) throws Exception
    {
        SeleniumUtils.dropDownByVisibleText(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_CARD_ENDMONTH), month);

        // SeleniumUtils.sendKeys(ExcelProperty.getElementValue(CHECKOUT,
        // CHECKOUT_CARD_ENDMONTH), month + Keys.ENTER);
    }

    public static void checkOutYear(String year) throws Exception
    {
        SeleniumUtils.dropDownByVisibleText(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_CARD_ENDYEAR), year);
        // SeleniumUtils.sendKeys(ExcelProperty.getElementValue(CHECKOUT,
        // CHECKOUT_CARD_ENDMONTH), year + Keys.ENTER);
    }

    public static boolean ischeckOutPromo() throws Exception
    {
        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_APPLY_PROMO_CODE));
    }

    public static void checkOutPromoButton() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_APPLY_BUTTON));
    }

    public static void occplaceOrder() throws Exception
    {

        SeleniumUtils.javaScriptClick(ExcelProperty.getElementValue(CHECKOUT, PLACE_ORDER), 150);
    }

    public static boolean isOccplaceOrder() throws Exception
    {
        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(CHECKOUT, PLACE_ORDER));
    }

    public static boolean iSoccCheckoutGuest() throws Exception
    {
        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_GUEST));
    }

    public static void checkOutRegEmail(String email) throws Exception
    {
        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_GUEST_EMAIL), email);
    }

    public static boolean isCheckOutRegEmail() throws Exception
    {
        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_GUEST_EMAIL));
    }

    public static boolean iSCheckOutShipping() throws Exception
    {

        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_SHIPPING_NAME));
    }

    public static void checkOutGuestEmail(String email) throws Exception
    {
        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_GUEST_EMAIL), email);
    }

    public static boolean isCheckOutGuestEmail() throws Exception
    {
        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_GUEST_EMAIL));
    }

    public static void occcheckoutcreateaccount() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_CREATE_AC));
    }

    public static void checkoutRegForgotPasswordMailInput(String MailInput) throws Exception
    {
        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_FORGOT_PASS_MAIL_INPUT), MailInput);
    }

    public static boolean isCheckOutRegFname() throws Exception
    {
        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_REG_FNAME));
    }

    public static void checkOutRegFname(String RegFname) throws Exception
    {
        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_REG_FNAME), RegFname);
    }

    public static boolean isCheckOutReglname() throws Exception
    {
        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_REG_LNAME));
    }

    public static void checkOutRegLname(String RegLname) throws Exception
    {

        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_REG_LNAME), RegLname);

    }

    public static boolean isCheckOutRegPassword() throws Exception
    {
        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_REG_PASSWORD));
    }

    public static void checkOutRegPassword(String RegPassword) throws Exception
    {

        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_REG_PASSWORD), RegPassword);

    }

    public static boolean isCheckOutRegCPassword() throws Exception
    {
        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_REG_CONFIRMPASSWORD));
    }

    public static void checkOutRegCPassword(String RegCPassword) throws Exception
    {

        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_REG_CONFIRMPASSWORD), RegCPassword);

    }

    public static void checkoutRegForgotSubmit() throws Exception
    {

        SeleniumUtils.click(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_FORGOT_MAIL_SUBMIT));
    }

    public static void checkoutregForSubmAfterCloseButn() throws Exception
    {

        SeleniumUtils.click(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_FORGOT_PASS_SUBM_CLOSE_BUTT));
    }

    public static boolean guestChecked() throws Exception
    {
        return SeleniumUtils.isSelected(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_GUEST));
    }

    public static boolean userLoginChecked() throws Exception
    {
        return SeleniumUtils.isSelected(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_LOGIN_ACCOUNT));
    }

}
