package com.ch.occ.test;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ch.ExcelUtils.ExcelProperty;
import com.ch.occ.pages.CheckOutPage;
import com.ch.occ.report.utils.AbstractTestCaseReport;
import com.ch.occ.reports.TestCaseDetail;
import com.ch.occ.reports.TestCaseFactory;
import com.ch.occ.utils.SeleniumUtils;
import com.ch.occ.utils.Type;
import com.ch.occ.utils.constants.FileConstants;

/**
 * @author sathish naidu lingutla
 */
@Listeners(com.ch.occ.utils.ParallelFactory.class)
public class CheckoutWithOurFrameWork extends AbstractTestCaseReport implements FileConstants
{
    public static final String USERNAME     = "sathishnaiduling1";
    public static final String AUTOMATE_KEY = "CVUoRZjK2nVCakrpusKM";
    public static final String URL          = "https://" + USERNAME + ":" + AUTOMATE_KEY
            + "@hub-cloud.browserstack.com/wd/hub";
    public WebDriver           driver;

    @BeforeMethod
    public void OCCUrl() throws Exception
    {
        SeleniumUtils.getURL("https://ccstore-test-z3na.oracleoutsourcing.com");
//        SeleniumUtils.wait(60);
        try
        {
            SeleniumUtils.click(Type.XPATH, "//div[@id='occ-email-subscription-template']/div/div[2]/div/div[3]/div");
            System.out.println("Try");
//            SeleniumUtils.wait(10);
        } catch (Exception e)
        {

            e.getMessage();
        }
    }

    private void precondition() throws Exception, InterruptedException
    {
        SeleniumUtils.wait(10);
        SeleniumUtils.click(Type.XPATH, "//div[@id='sophisticated-search-wi1900069']/div/a/div");
        System.out.println("Search has cliked");
        SeleniumUtils.sendKeys(Type.XPATH, "(//input[@type='text'])[2]", "rings" + Keys.ENTER);
        SeleniumUtils.wait(10);
        SeleniumUtils.click(Type.LINKTEXT, "ADD TO CART");
        SeleniumUtils.wait(02);
        SeleniumUtils.click(Type.XPATH, "//span[@id='wi1900069-cart-mobile-element-id']/div/div/a/div/div");
        SeleniumUtils.wait(02);
        SeleniumUtils.click(Type.XPATH, "//div[@id='LenoxShoppingCart_v4-wi1900133']/div/div/div/div[2]/a");
        SeleniumUtils.wait(02);
    }

    // 1, 2, 3
    // Title:To verify the Essential elements in the "Checkout' page.
    @Test
    public void verifyFieldsInCheckoutPage() throws Exception
    {
        String name = new Object()
        {}.getClass().getEnclosingMethod().getName();
        TestCaseDetail testcase = TestCaseFactory.createTestCaseDetail(this.getClass(), name);
        try
        {
            precondition();
            SeleniumUtils.wait(10);
            CheckOutPage.occcheckoutcreateaccount();
            testcase.assertTrue(CheckOutPage.isCheckOutRegFname(), "System observe the first name in register account",
                    "system not observed the first name in register account");

            testcase.assertTrue(CheckOutPage.isCheckOutReglname(),
                    "system should observe the last name in register account",
                    "system not able to observer the last name in register account ");

            testcase.assertTrue(CheckOutPage.isCheckOutRegPassword(),
                    "system should observe the password in register account",
                    "system not able to observer the password in register account ");

            testcase.assertTrue(CheckOutPage.isCheckOutRegCPassword(),
                    "system should observe the Confirm Password in register account",
                    "system not able to observer the Confirm Password in register account ");
            testcase.pass("observe all fields which are need to create new account.");

            String attributesXpath = SeleniumUtils
                    .getAttributes(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_GUEST), "class");
            boolean flag = attributesXpath.endsWith("selected");

            testcase.assertTrue(flag, "System should check the Option By default",
                    "System is not check the Option By default");

            testcase.assertTrue(CheckOutPage.isCheckOutFirstName(), "System should display the FirstName",
                    "System is not displaying the FirstName");

            testcase.assertTrue(CheckOutPage.isCheckOutGuestEmail(), "System should display the register mail",
                    "System is not displaying the Register mail");

            testcase.assertTrue(CheckOutPage.isOccplaceOrder(), "System should display the place order",
                    "System is not displaying the place order");

            SeleniumUtils.wait(5);

            testcase.assertTrue(CheckOutPage.iSoccCheckoutGuest(), "System should display the guest user radio button",
                    "System is not displaying the Guest user radio button");

            testcase.assertTrue(CheckOutPage.iSCheckOutShipping(), "System should display the Shipping address",
                    "System is not dispalying the shipping address");

            testcase.assertTrue(CheckOutPage.ischeckOutPaymentDetails(), "System should display the payment details",
                    "System is not displaying the payment details");

            testcase.assertTrue(CheckOutPage.isCheckOutFirstName(), "System should display the Shipping first name ",
                    "System is not displaying the Shipping first name ");

            testcase.assertTrue(CheckOutPage.isCheckOutLastName(), "System should display the Shipping last e",
                    "System is not displaying the Shipping last name ");

            testcase.assertTrue(CheckOutPage.isCheckOutCountry(), "System should display the Shipping country",
                    "System is not displaying the Shipping country");

            testcase.assertTrue(CheckOutPage.isCheckAddresslane1(), "System should display the Shipping Address lane1",
                    "System is not displaying the Shipping Address lane1");
            testcase.assertTrue(CheckOutPage.isCheckAddresslane2(), "System should display the Shipping Address lane2",
                    "System is not displaying the Shipping Addres lane2");

            testcase.assertTrue(CheckOutPage.isCheckOutCity(), "System should display the Shipping city",
                    "System is not displaying the Shipping city ");

            testcase.assertTrue(CheckOutPage.isCheckSelectStateRegion(), "System should display the Shipping state",
                    "System is not displaying the Shipping state ");

            testcase.assertTrue(CheckOutPage.isCheckOutZipcode(), "System should display the Shipping zipcode",
                    "System is not displaying the Shipping zipcode ");

            testcase.assertTrue(CheckOutPage.isCheckOutPhoneNumber(), "System should display the Shipping phone number",
                    "System is not displaying the Shipping firs");

            SeleniumUtils.wait(3);
            // CheckOutPage.clickBillingAddress();

            testcase.assertTrue(CheckOutPage.isCheckOutBAFirstName(), "verify the billing address firstname",
                    "not verified the billing address first name ");

            testcase.assertTrue(CheckOutPage.isCheckOutBALastName(), "verify the billing address last name",
                    "not verified the billing address last name ");

            testcase.assertTrue(CheckOutPage.isCheckOutBACountry(), "verify the billing address country",
                    "not verified the billing address country");

            testcase.assertTrue(CheckOutPage.isCheckBAAddressLane1(), "verify the billing address address lane1",
                    "not verified the billing address address lane1 ");

            testcase.assertTrue(CheckOutPage.isCheckBAAddressLane2(), "verify the billing address address lane2",
                    "not verified the billing address address lane 2");

            testcase.assertTrue(CheckOutPage.isCheckOutBACity(), "verify the billing address city",
                    "not verified the billing address city");

            testcase.assertTrue(CheckOutPage.isSelectBAStateRegion(), "verify the billing address state region",
                    "not verified the billing address state region");

            testcase.assertTrue(CheckOutPage.isCheckOutBAZipcode(), "verify the billing address zipcode",
                    "not verified the billing address zipcode");

            testcase.assertTrue(CheckOutPage.isCheckOutPayNameCard(), "check payment card name ",
                    "not able to verify the payment card name");

            testcase.assertTrue(CheckOutPage.isCheckOutCardType(), "Card Type", "Card type");

            testcase.assertTrue(CheckOutPage.ischeckOutPaymentMonth(), "Payment details month",
                    "payment details month");

            testcase.assertTrue(SeleniumUtils.iSDisplayed(Type.ID, "CC-checkoutPaymentDetails-endYear"),
                    "payment details card year", "Payment details card year");
            // CheckOutPage.ischeckOutPaymentYear(),

            testcase.assertTrue(CheckOutPage.ischeckOutPaymentDetails(), "check payment fields verify",
                    "not able to check payment fields");

            testcase.assertTrue(CheckOutPage.isCheckoutProductNameSummary(), "Product name in checkout Page",
                    "Product name in checkout page");

            testcase.assertTrue(CheckOutPage.isCheckoutOrderSummaryText(), "Checkout page order summary text",
                    "Checkout page order summary text");

            testcase.assertTrue(CheckOutPage.isCheckoutOrderPrice(), "Checkout page order summary Price text",
                    "Checkout page order Price");

            testcase.assertTrue(CheckOutPage.isCheckoutOrderQuantity(), "Checkout page order Quantity",
                    "Checkout page order Quantity");

            testcase.assertTrue(CheckOutPage.isCheckoutOrderEditButton(), "Checkout page order Edit button verified",
                    "Checkout page order Edit button verified");

            testcase.pass("Verifying tha checkout page elements.");
        } catch (Exception e)
        {
            testcase.error(
                    "1.System should navigate the customer to Checkout page. 2. Following  elements should be displayed in the Checkout page. a. Checkout as guest section b. Login section c. Enter Email ID d. Shipping address e. Payment details f. Promocode g. Place order button",
                    e);
            e.printStackTrace();
        }

    }

    @Test
    public void allFieldsBlankInCheckByLoguser() throws Exception
    {
        String name = new Object()
        {}.getClass().getEnclosingMethod().getName();
        TestCaseDetail testcase = TestCaseFactory.createTestCaseDetail(this.getClass(), name);
        try
        {
            precondition();
            SeleniumUtils.wait(10);
            CheckOutPage.checkLoggedUser();
            SeleniumUtils.wait(05);
            testcase.assertTrue(CheckOutPage.ischeckOutDefaultAddress(), "observe the Default address",
                    "Observe the Default address");
            testcase.assertTrue(CheckOutPage.ischeckoutNewAddressButtonClick(),
                    "In checkout page after logged user can enter the new address",
                    "In checkout page after logged user can't able enter the new address");
            SeleniumUtils.wait(5);
            CheckOutPage.checkoutNewAddressButtonClick();
            SeleniumUtils.wait(3);
            CheckOutPage.occplaceOrder();
            SeleniumUtils.wait(3);
            testcase.assertEquals(SeleniumUtils.getText(Type.XPATH, "//div[@id='cc-notification-inline-0']/div"),
                    "Please ensure you have completed all mandatory fields and corrected any invalid entries.");

            testcase.pass("System should not able place order with empty fields in shipping and billing.");
        } catch (Exception e)
        {
            testcase.error("System should not able place order with empty fields in shipping and billing.", e);
            e.printStackTrace();
        }
    }

    @Test
    public void checkEntVaildDataShipAddFieldsAndAllMantFields() throws Exception
    {
        String name = new Object()
        {}.getClass().getEnclosingMethod().getName();
        TestCaseDetail testcase = TestCaseFactory.createTestCaseDetail(this.getClass(), name);
        try
        {
            precondition();
            SeleniumUtils.wait(7);
            CheckOutPage.checkOutGuestEmail(CheckOutPage.email);
            testcase.assertEquals(
                    SeleniumUtils.getAttributes(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_GUEST_EMAIL), "value"),
                    CheckOutPage.email);
            CheckOutPage.checkOutFirstName(CheckOutPage.name1);
            testcase.assertEquals(
                    SeleniumUtils.getAttributes(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_FNAME), "value"),
                    CheckOutPage.name1);
            CheckOutPage.checkOutLastName(CheckOutPage.lastname);
            testcase.assertEquals(
                    SeleniumUtils.getAttributes(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_LNAME), "value"),
                    CheckOutPage.lastname);
            // CheckOutPage.clickCountry(CheckOutPage.country);
            //
            SeleniumUtils.dropDownByIndex(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_COUNTRY), 1);
            testcase.assertEquals(
                    SeleniumUtils.getAttributes(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_COUNTRY), "value"),
                    "US");

            CheckOutPage.addresslane1(CheckOutPage.lane1);
            testcase.assertEquals(SeleniumUtils.getAttributes(
                    ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_ADDRESS_LANE1), "value"), CheckOutPage.lane1);

            CheckOutPage.addresslane2(CheckOutPage.lane2);
            testcase.assertEquals(SeleniumUtils.getAttributes(
                    ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_ADDRESS_LANE2), "value"), CheckOutPage.lane2);

            CheckOutPage.checkOutCity(CheckOutPage.city);
            testcase.assertEquals(
                    SeleniumUtils.getAttributes(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_CITY), "value"),
                    CheckOutPage.city);

            SeleniumUtils.dropDownByIndex(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_REGION_STATE), 2);
            testcase.assertEquals(SeleniumUtils
                    .getAttributes(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_REGION_STATE), "value"), "AK");

            CheckOutPage.checkOutZipcode(CheckOutPage.zipcode);
            testcase.assertEquals(
                    SeleniumUtils.getAttributes(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_ZIPCODE), "value"),
                    CheckOutPage.zipcode);

            CheckOutPage.checkOutPhoneNumber(CheckOutPage.phone);
            testcase.assertEquals(
                    SeleniumUtils.getAttributes(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_PHONE_NUM), "value"),
                    CheckOutPage.phone);

            CheckOutPage.checkOutPayNameCard(CheckOutPage.name1);
            testcase.assertEquals(
                    SeleniumUtils.getAttributes(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_NAME_CARD), "value"),
                    CheckOutPage.name1);
            testcase.pass("System should allow the customer to enter data in all the shipping fields by guest user.");
        } catch (Exception e)
        {
            testcase.error("System should allow the customer to enter data in all the shipping fields by guest user.",
                    e);
            e.printStackTrace();
        }
    }

    @Test
    public void billAddressFilledAllFieldsToCheckout() throws Exception
    {
        String name = new Object()
        {}.getClass().getEnclosingMethod().getName();
        TestCaseDetail testcase = TestCaseFactory.createTestCaseDetail(this.getClass(), name);
        try
        {
            precondition();

            CheckOutPage.checkOutGuestEmail(CheckOutPage.email);
            CheckOutPage.shippAddrValidData();
            CheckOutPage.checkOutBAFirstName(CheckOutPage.name1);
            testcase.assertEquals(
                    SeleniumUtils.getAttributes(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_BILL_FNAME), "value"),
                    CheckOutPage.name1);
            CheckOutPage.checkOutBALastName(CheckOutPage.lastname);
            testcase.assertEquals(
                    SeleniumUtils.getAttributes(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_BILL_LNAME), "value"),
                    CheckOutPage.lastname);
            CheckOutPage.clickBillCountry(CheckOutPage.country);
            testcase.assertEquals(SeleniumUtils
                    .getAttributes(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_BILL_COUNTRY), "value"), "US");
            CheckOutPage.addressBAlane1(CheckOutPage.lane1);
            testcase.assertEquals(SeleniumUtils.getAttributes(
                    ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_BILL_ADDRESSLANE1), "value"), CheckOutPage.lane1);
            CheckOutPage.addressBAlane2(CheckOutPage.lane2);
            testcase.assertEquals(SeleniumUtils.getAttributes(
                    ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_BILL_ADDRESSLANE2), "value"), CheckOutPage.lane2);
            CheckOutPage.checkOutBACity(CheckOutPage.city);
            testcase.assertEquals(
                    SeleniumUtils.getAttributes(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_BILL_CITY), "value"),
                    CheckOutPage.city);
            CheckOutPage.checkOutBAZipcode(CheckOutPage.zipcode);
            testcase.assertEquals(SeleniumUtils.getAttributes(
                    ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_BILL_ZIPCODE), "value"), CheckOutPage.zipcode);
            testcase.pass(
                    "System should allow the customer to enter the data in all the fields of Billing address section in Checkout page.");
        } catch (Exception e)
        {
            testcase.error(
                    "System should allow the customer to enter the data in all the fields of Billing address section in Checkout page.",
                    e);
            e.printStackTrace();
        }
    }

}
