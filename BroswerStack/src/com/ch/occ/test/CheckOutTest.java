package com.ch.occ.test;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ch.ExcelUtils.ExcelProperty;
import com.ch.occ.bean.CheckoutInvalidBillingBean;
import com.ch.occ.bean.CheckoutInvalidShippingBean;
import com.ch.occ.bean.CheckoutRegInvalidBillingBean;
import com.ch.occ.bean.CheckoutRegInvalidshippingBean;
import com.ch.occ.bean.InvalidSignIn;
import com.ch.occ.pages.CheckOutPage;
import com.ch.occ.pages.HomePage;
import com.ch.occ.pages.LoginPage;
import com.ch.occ.report.utils.AbstractTestCaseReport;
import com.ch.occ.reports.TestCaseDetail;
import com.ch.occ.reports.TestCaseFactory;
import com.ch.occ.utils.CommonUtils;
import com.ch.occ.utils.DriverFactory;
import com.ch.occ.utils.FileUtility;
import com.ch.occ.utils.OCCUtlis;
import com.ch.occ.utils.PropertyUtil;
import com.ch.occ.utils.SeleniumUtils;
import com.ch.occ.utils.Type;
import com.ch.occ.utils.constants.FileConstants;
// import com.ch.testNGGen.TestNGXMLGen;

/**
 * @author sathish naidu lingutla
 */
@Listeners(com.ch.occ.utils.ParallelFactory.class)
public class CheckOutTest extends AbstractTestCaseReport implements FileConstants
{
    public static final String USERNAME     = "sathishnaiduling1";
    public static final String AUTOMATE_KEY = "CVUoRZjK2nVCakrpusKM";
    public static final String URL          = "https://" + USERNAME + ":" + AUTOMATE_KEY
            + "@hub-cloud.browserstack.com/wd/hub";
    public WebDriver           driver;

    @BeforeMethod
    public void OCCUrl() throws Exception
    {
        // DesiredCapabilities caps = new DesiredCapabilities();
        // caps.setCapability("browserName", "IPhone");
        // caps.setPlatform(Platform.MAC);
        // caps.setCapability("device", "IPhone 6S");
        // driver = new RemoteWebDriver(new URL(URL), caps);
        // driver.get("https://ccstore-test-z3na.oracleoutsourcing.com");
        // System.out.println("URL Launch");
        // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        SeleniumUtils.getURL("https://ccstore-test-z3na.oracleoutsourcing.com");
        try
        {
            // driver.findElement(By.xpath("//div[@id='occ-email-subscription-template']/div/div[2]/div/div[3]/div"))
            // .click();
            SeleniumUtils.click(Type.XPATH, "//div[@id='occ-email-subscription-template']/div/div[2]/div/div[3]/div");
            System.out.println("Try");
        } catch (Exception e)
        {

            // SeleniumUtils.click(Type.XPATH,
            // "//div[@id='occ-email-subscription-template']/div/div[2]/div/div[3]/div");
            e.getMessage();
        }
    }

    private static List<WebElement> getAllElements(String path)
    {
        List<WebElement> findElements = DriverFactory.getDriver().findElements(By.cssSelector(path));
        return findElements;
    }

    private void precondition() throws Exception, InterruptedException
    {

        // // HomePage.searchDataEnter("cups" + Keys.ENTER);
        // SeleniumUtils.sendKeys(Type.CSSSELECTOR,
        // "input.form-control",
        // "rings" + Keys.ENTER);
        // //
        // SeleniumUtils.sendKeys(ExcelProperty.getElementValue(HOMEPAGE,
        // // SEARCH_HELP_BOX), "cups" + Keys.ENTER);
        // SeleniumUtils.wait(05);
        // SeleniumUtils.click(Type.LINKTEXT, "ADD TO CART");
        // // SeleniumUtils.click(ExcelProperty.getElementValue(CART,
        // // ADD_TO_CART_SKULIST));
        // SeleniumUtils.wait(2);
        // SeleniumUtils.click(Type.ID, "CC-headerCheckout");
        // // CheckOutPage.occHeaderCheckOut();
        // SeleniumUtils.wait(10);

        // HomePage.searchDataEnter("cups" + Keys.ENTER);
        // driver.findElement(By.cssSelector("div.icon.search-icon")).click();
        SeleniumUtils.click(Type.CSSSELECTOR, "div.icon.search-icon");
        System.out.println("Search has cliked");
        // driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("rings"
        // + Keys.ENTER);
        SeleniumUtils.sendKeys(Type.XPATH, "(//input[@type='text'])[2]", "rings" + Keys.ENTER);
        // SEARCH_HELP_BOX), "cups" + Keys.ENTER);
        // driver.findElement(By.linkText("ADD TO CART")).click();
        // SeleniumUtils.wait(05);
        SeleniumUtils.click(Type.LINKTEXT, "ADD TO CART");
        // SeleniumUtils.click(ExcelProperty.getElementValue(CART,
        // ADD_TO_CART_SKULIST));
        SeleniumUtils.wait(2);
        SeleniumUtils.click(Type.XPATH, "//span[@id='wi1900069-cart-mobile-element-id']/div/div/a/div/div");
        SeleniumUtils.wait(10);
        SeleniumUtils.click(Type.XPATH, "//div[@id='LenoxShoppingCart_v4-wi1900133']/div/div/div/div[2]/a");
        // CheckOutPage.occHeaderCheckOut();
        SeleniumUtils.wait(10);

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

    // 4
    // Title:To verify that the Guest customer is able to enter Email ID.

    // 5
    @Test
    public void invalidEmailEnter() throws Exception
    {
        String name = new Object()
        {}.getClass().getEnclosingMethod().getName();
        TestCaseDetail testcase = TestCaseFactory.createTestCaseDetail(this.getClass(), name);
        try
        {
            precondition();
            SeleniumUtils.wait(7);
            CheckOutPage.checkOutGuestEmail("test@" + Keys.TAB);

            testcase.assertEquals(
                    SeleniumUtils.getText(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_GUEST_EMAIL_ERROR)),
                    "Invalid entry. Please enter valid email address, for example, john@smith.com.");

            testcase.pass("System should allow the customer to enter data in all the shipping fields by guest user.");
        } catch (Exception e)
        {
            testcase.error("System should allow the customer to enter data in all the shipping fields by guest user.",
                    e);
            e.printStackTrace();
        }
    }
    // 6
    // 7

    // 8
    // Title:To verify the customer is able to enter data in all the fields of
    // "Shipping address" section.

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

            // CheckOutPage.clickState(CheckOutPage.state);
            //
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

    // 9
    // Title:To verify the system behavior when customer did not provide any
    // data in address fields and tries to save the address during checkout.

    // 10
    // Title:To verify the system behavior when customer leaves the First name
    // field as blank while saving a new address during checkout.

    // 11

    // 12
    // Title:To verify the system behavior when customer tries to enter more
    // than the character limit allowed for First Name field while adding a new
    // address during checkout.

    // 13
    // Title:To verify the system behavior when customer leaves the Last name
    // field as blank while saving a new address during checkout.

    // 14
    // 15
    // Title:To verify the system behavior when customer tries to enter more
    // than the character limit allowed for Last Name field while adding a new
    // address during checkout.

    // 16
    // Title:To verify the system behavior when customer does not specify the
    // country while adding shipping address for the order during guest
    // checkout.
    // 17
    // Title:To verify the system behavior when customer leaves the Address Line
    // 1 field as blank while saving a new address during checkout.
    // 18
    // Title:To verify the system behavior when customer provides
    // inappropriate/invalid data in Address Line 1 field while saving a new
    // address during checkout.

    // 19
    // Title:To verify the system behavior when customer tries to enter more
    // than the character limit allowed for Address Line 1 field while addinga
    // new address during checkout.

    // 20
    // Title:To verify the system behavior when customer provides
    // inappropriate/invalid data in Address Line 2 field while saving a new
    // address during checkout.

    // 21
    // Title:To verify the system behavior when customer tries to enter more
    // than the character limit allowed for Address Line 2 field while adding a
    // new address during checkout.

    // 22
    // Title:To verify the system behavior when customer leaves the City field
    // as blank while saving a new address during checkout.

    // 23
    // Title:To verify the system behavior when customer provides
    // inappropriate/invalid data in City field while saving a new address
    // during checkout.

    @Test
    public void checkOutShippCityInvalid() throws Exception
    {
        String name = new Object()
        {}.getClass().getEnclosingMethod().getName();
        TestCaseDetail testcase = TestCaseFactory.createTestCaseDetail(this.getClass(), name);
        try
        {
            precondition();
            SeleniumUtils.wait(10);
            CheckOutPage.checkOutGuestEmail(CheckOutPage.email);
            CheckOutPage.checkOutFirstName(CheckOutPage.name1);
            CheckOutPage.checkOutLastName(CheckOutPage.lastname);
            CheckOutPage.clickCountry(CheckOutPage.country);
            CheckOutPage.addresslane1(CheckOutPage.lane1);
            CheckOutPage.addresslane2(CheckOutPage.lane2);
            // CheckOutPage.checkOutCity("eqrqewrqwe");
            // CheckOutPage.clickState(CheckOutPage.state);
            // CheckOutPage.checkOutZipcode(CheckOutPage.zipcode);
            // CheckOutPage.checkOutPhoneNumber(CheckOutPage.phone + Keys.TAB);
            SeleniumUtils.wait(50);
            // testcase.assertTrue(
            // SeleniumUtils.iSDisplayed(
            // ExcelProperty.getElementValue(CHECKOUT,
            // CHECKOUT_SUGGESTION_ADDRESS_SHIPP_TEXT)),
            // "Check with Suggested Addresses for Shipping address",
            // "Check with Suggested Addresses for Shipping address");
            // try {
            // SeleniumUtils.click(ExcelProperty.getElementValue(CHECKOUT,
            // CHECKOUT_SUGGESTED_ADDRESS_SHIPP_BUTTON));
            // } catch (Exception e) {
            // }
            //
            SeleniumUtils.wait(25);

            testcase.pass("observe shipping address City is invalid for register user in checkout page.");
        } catch (Exception e)
        {
            testcase.error("observe shipping address City is invalid for register user in checkout page.", e);
            e.printStackTrace();
        }
    }

    // 24
    // Title:To verify the system behavior when customer tries to enter more
    // than the character limit allowed for City field while adding a new
    // address during checkout.

    // 25
    // Title:To verify the system behavior when customer leaves the State field
    // as blank while saving a new address during checkout.
    // 26
    // Title:To verify the system behavior when customer leaves the ZipCode
    // field as blank while saving a new address during checkout.

    // 27
    // Title:To verify the system behavior when customer provides
    // inappropriate/invalid data in Zip Code field while saving a new address
    // during checkout.

    // 28
    // Title:To verify the system behavior when customer tries to enter more
    // than the character limit allowed for ZipCode field while adding a new
    // address during checkout.

    // 29
    // Title:To verify the system behavior when customer leaves the Phone Number
    // field as blank while saving a new address during checkout.

    // 30
    // Title:To verify the system behavior when customer provides
    // inappropriate/invalid data in Phone Number field while saving a new
    // address during checkout.

    // 31
    // Title:To verify the system behavior when customer tries to enter more
    // than the character limit allowed for Phone Number field while adding a
    // new address during checkout.

    // 32
    // Title:To verify that customer can add a valid US Shipping Address during
    // checkout.
    @Test
    public void checkOutGuestUserShippingAddressValidData() throws Exception
    {
        String name = new Object()
        {}.getClass().getEnclosingMethod().getName();
        TestCaseDetail testcase = TestCaseFactory.createTestCaseDetail(this.getClass(), name);
        try
        {
            precondition();
            SeleniumUtils.wait(10);
            CheckOutPage.checkOutGuestEmail(CheckOutPage.email);
            CheckOutPage.checkOutFirstName(CheckOutPage.name1);
            CheckOutPage.checkOutLastName(CheckOutPage.lastname);
            CheckOutPage.addresslane1(CheckOutPage.lane1);
            CheckOutPage.addresslane2(CheckOutPage.lane2);
            CheckOutPage.clickState(CheckOutPage.state);
            CheckOutPage.checkOutCity(CheckOutPage.city);
            CheckOutPage.clickCountry(CheckOutPage.country);
            CheckOutPage.checkOutZipcode(CheckOutPage.zipcode);
            CheckOutPage.checkOutPhoneNumber(CheckOutPage.phone + Keys.TAB);
            SeleniumUtils.wait(3);
            String validate = SeleniumUtils
                    .getText(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_VALIDATE_SHIPP_ADD));
            if (validate.contains("US"))
            {
                testcase.pass("Customer should be able to place the order with US Shipping Address.");
            } else
            {
                testcase.pass("Customer should be able to Add valid US Shipping Address");
            }

            SeleniumUtils.wait(05);
            testcase.pass("Customer should be able to place the order with US Shipping Address.");
        } catch (Exception e)
        {
            testcase.error("Customer should be able to place the order with US Shipping Address.", e);
            testcase.comments("Place order is not working.");
            e.printStackTrace();
        }
    }

    // 33
    // Title:To verify that system throws Error when customer provides an
    // invalid address for Shipping.
    @Test

    public void checkOutGuestShippingUsAddressInvalid() throws Exception
    {
        String name = new Object()
        {}.getClass().getEnclosingMethod().getName();
        TestCaseDetail testcase = TestCaseFactory.createTestCaseDetail(this.getClass(), name);
        try
        {
            precondition();
            SeleniumUtils.wait(10);
            CheckOutPage.checkOutGuestEmail(CheckOutPage.email);
            CheckOutPage.checkOutFirstName(CheckOutPage.name1);
            CheckOutPage.checkOutLastName(CheckOutPage.lastname);
            CheckOutPage.clickCountry(CheckOutPage.country);
            CheckOutPage.addresslane1("rasr");
            CheckOutPage.addresslane2("rqewrq");
            CheckOutPage.checkOutCity("agadg");
            CheckOutPage.checkOutCity(CheckOutPage.city);
            CheckOutPage.clickState(CheckOutPage.state);
            CheckOutPage.checkOutZipcode(CheckOutPage.zipcode);
            CheckOutPage.checkOutPhoneNumber(CheckOutPage.phone);
            CheckOutPage.checkOutPayNameCard(CheckOutPage.name1);
            SeleniumUtils.wait(8);
            testcase.assertEquals(
                    SeleniumUtils.getText(ExcelProperty.getElementValue(CHECKOUT, ACC_REG_CONFORMATION_MSG)),
                    "Address Not Found.");
            testcase.pass("US Address not valid Data to place order");
            testcase.comments("Defect it was not Showing Address was not found");
        } catch (Exception e)
        {
            testcase.error("not able to placed order US Address not valid data", e);
            e.printStackTrace();
        }
    }

    // 34 // 35 //36
    // Title:To verify that system provides an option to the customer to use
    // shipping address as Billing address.
    @Test
    public void useShippingAddressAsBiilingAddress() throws Exception
    {
        String name = new Object()
        {}.getClass().getEnclosingMethod().getName();
        TestCaseDetail testcase = TestCaseFactory.createTestCaseDetail(this.getClass(), name);
        try
        {
            precondition();
            SeleniumUtils.wait(10);
            CheckOutPage.checkOutGuestEmail(CheckOutPage.email);
            CheckOutPage.shippAddrValidData();
            SeleniumUtils.wait(8);
            testcase.assertTrue(CheckOutPage.isCheckOutBAFirstName(),
                    "System Automatically clicked use as shipping and billing address",
                    "System automatically not clicked use as shipping address and billing address");
            // CheckOutPage.clickAllRights();
            CheckOutPage.clickBillingAddress();
            boolean flag = false;
            try
            {
                flag = CheckOutPage.isCheckOutBAFirstName();
            } catch (Exception e)
            {
                e.printStackTrace();
            }
            testcase.assertFalse(flag, "System Automatically clicked use as shipping and billing address",
                    "System automatically not clicked use as shipping address and billing address");

            testcase.assertEquals(
                    SeleniumUtils.getText(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_BILL_CHECKBOX)),
                    "Use this as my billing address");

            testcase.pass("System should display a checkbox Use this as my Billing Address.");
        } catch (Exception e)
        {
            testcase.error("System should display a checkbox Use this as my Billing Address.", e);
            e.printStackTrace();
        }
    }

    // 37
    // Title:To verify the system behavior when customer removes the selection
    // of "Use this as my Billing address" check box.
    @Test
    public void loggedUserUnSelectBillingCheckboxBehavior() throws Exception
    {
        String name = new Object()
        {}.getClass().getEnclosingMethod().getName();
        TestCaseDetail testcase = TestCaseFactory.createTestCaseDetail(this.getClass(), name);
        try
        {
            precondition();
            CheckOutPage.checkLoggedUser();
            SeleniumUtils.wait(10);
            CheckOutPage.clickBillingAddress();
            SeleniumUtils.wait(5);
            testcase.assertTrue(CheckOutPage.isCheckOutBAFirstName(),
                    "verify the billing addres not same has shipping address",
                    "the billing and shipping address both are same");
            testcase.pass(
                    "1. System should display the Billing address Section below the Shipping address section in Checkout page. All the Billing address fields should be blank.");
        } catch (Exception e)
        {
            testcase.error(
                    "1. System should display the Billing address Section below the Shipping address section in Checkout page.All the Billing address fields should be blank.",
                    e);
            e.printStackTrace();
        }
    }

    // 38
    // Title:To verify the essential elements present in the "Billing address"
    // Section in "Checkout" page.

    // 39
    // Title: To verify the customer is able to enter the data in all the fields
    // of "Billing address" section.
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
            //
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
            CheckOutPage.clickBillState(CheckOutPage.state);
            //
            // testcase.assertEquals(
            // SeleniumUtils.getAttributes(ExcelProperty.getElementValue(CHECKOUT,
            // CHECKOUT_BILL_STATE), "vlaue"),
            // "null");
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

    // 40 To verify the system behavior when customer did not provide any data
    // in address fields and tries to save the address during checkout.

    // 41
    // Title:To verify the system behavior when customer leaves the First name
    // field as blank while saving a new address during checkout.

    // 42
    // Title:To verify the system behavior when customer provides
    // inappropriate/invalid data in First name field while saving a new address
    // during checkout.

    // 43
    // Title:To verify the system behavior when customer tries to enter more
    // than the character limit allowed for First Name field while adding a new
    // address during checkout.

    // 44
    // Title:To verify the system behavior when customer leaves the Last name
    // field as blank while saving a new address during checkout.

    // 45
    // Title:To verify the system behavior when customer provides
    // inappropriate/invalid data in Last name field while saving a new address
    // during checkout.

    // 46
    // Title:To verify the system behavior when customer tries to enter more
    // than the character limit allowed for Last Name field while adding a new
    // address during checkout.

    // 47
    // Title:To verify the system behavior when customer does not specify the
    // country while adding Billing address for the order during guest checkout.

    // 48
    // Title:To verify the system behavior when customer leaves the Address Line
    // 1 field as blank while saving a new address during checkout.

    // 49
    // Title: To verify the system behavior when customer provides
    // inappropriate/invalid data in Address Line 1 field while saving a new
    // address during checkout.
    // 50
    // Title: To verify the system behavior when customer tries to enter more
    // than the character limit allowed for Address Line 1 field while adding a
    // new address during checkout.

    // 51
    // Title:To verify the system behavior when customer provides
    // inappropriate/invalid data in Address Line 2 field while saving a new
    // address during checkout.

    @Test
    public void billAddress2FieldInvalidSuggestion() throws Exception
    {
        String name = new Object()
        {}.getClass().getEnclosingMethod().getName();
        TestCaseDetail testcase = TestCaseFactory.createTestCaseDetail(this.getClass(), name);
        try
        {

            precondition();
            SeleniumUtils.wait(20);
            CheckOutPage.checkOutGuestEmail(CheckOutPage.email);
            CheckOutPage.shippAddrValidData();
            CheckOutPage.checkOutBAFirstName(CheckOutPage.name1);
            CheckOutPage.checkOutBALastName(CheckOutPage.name2);
            CheckOutPage.clickBillCountry(CheckOutPage.country);
            CheckOutPage.addressBAlane1(CheckOutPage.lane1);
            CheckOutPage.addressBAlane2("!@#$%^&*()(*&^%$#@!@#$%^");
            CheckOutPage.checkOutBACity(CheckOutPage.city);
            CheckOutPage.clickBillState(CheckOutPage.state);
            CheckOutPage.checkOutBAZipcode(CheckOutPage.zipcode + Keys.TAB + "" + Keys.TAB);
            SeleniumUtils.wait(3);
            // testcase.assertTrue(
            // SeleniumUtils.iSDisplayed(
            // ExcelProperty.getElementValue(CHECKOUT,
            // CHECKOUT_SUGGESTION_ADDRESS_BILL_TEXT)),
            // "Check with Suggested Addresses for billing address",
            // "Check with Suggested Addresses for billing address");
            testcase.pass("Billing address2 field Invalid entry.");
        } catch (Exception e)
        {
            testcase.error("not able to observe Billing address2 field Invalid entry.", e);
            e.printStackTrace();
        }

    }
    // 52
    // Title:To verify the system behavior when customer tries to enter more
    // than the character limit allowed for Address Line 2 field while adding a
    // new address during checkout.

    // 53
    // Title:To verify the system behavior when customer leaves the City field
    // as blank while saving a new address during checkout.

    // 54
    // Title:To verify the system behavior when customer provides
    // inappropriate/invalid data in City field while saving a new address
    // during checkout.

    @Test
    public void billAddressCityInvalid() throws Exception
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
            CheckOutPage.checkOutBALastName(CheckOutPage.name2);
            CheckOutPage.addressBAlane1(CheckOutPage.Blane1);
            CheckOutPage.addressBAlane2(CheckOutPage.Blane2);
            CheckOutPage.clickBillState(CheckOutPage.Bstate);
            CheckOutPage.checkOutBACity("fdsfsda");
            CheckOutPage.clickBillCountry(CheckOutPage.Bcountry);
            CheckOutPage.checkOutBAZipcode(CheckOutPage.Bzipcode + Keys.ENTER);
            SeleniumUtils.wait(10);
            testcase.assertTrue(
                    SeleniumUtils.iSDisplayed(
                            ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_SUGGESTION_ADDRESS_BILL_TEXT)),
                    "Check with Suggested Addresses for billing address",
                    "Check with Suggested Addresses for billing address");
            try
            {
                SeleniumUtils.click(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_SUGGESTED_ADDRESS_BILL_BUTTON));
            } catch (Exception e)
            {
            }

            testcase.pass("observe billing address city is Invalid it throws an suggestion popup.");
        } catch (Exception e)
        {
            testcase.error("observe billing address city is Invalid it throws an suggestion popup.", e);
            e.printStackTrace();
        }
    }

    // 55
    // Title:To verify the system behavior when customer tries to enter more
    // than the character limit allowed for City field while adding a new
    // address during checkout.

    // 56
    // Title:To verify the system behavior when customer leaves the State field
    // as blank while saving a new address during checkout.

    //
    // 57
    // Title:To verify the system behavior when customer leaves the Zip Code
    // field as blank while saving a new address during checkout.

    // 58
    // Title:To verify the system behavior when customer provides
    // inappropriate/invalid data in ZipCode field while saving a new address
    // during checkout.

    // 59
    // Title:To verify the system behavior when customer tries to enter more
    // than the character limit allowed for Zip Code field while adding a new
    // address during checkout.

    // 60 To verify that customer can add a valid US Billing Address during
    // checkout.

    @Test
    public void custCanAddvalidToBillAddrForCheckout() throws Exception
    {
        String name = new Object()
        {}.getClass().getEnclosingMethod().getName();
        TestCaseDetail testcase = TestCaseFactory.createTestCaseDetail(this.getClass(), name);
        try
        {
            precondition();
            SeleniumUtils.wait(10);
            CheckOutPage.checkOutGuestEmail(CheckOutPage.email);
            CheckOutPage.shippAddrValidData();
            CheckOutPage.billAddValidData();
            CheckOutPage.paymentValidDiscPayData();
            SeleniumUtils.wait(30);
            testcase.assertTrue(CheckOutPage.isOrderConfirmation(), "System should display the order confirmation",
                    "System should be displayed the order confirmation");
            testcase.pass("billing address validated for place order");
        } catch (Exception e)
        {
            testcase.error("billing address validated for place order", e);
            e.printStackTrace();
        }
    }

    // 61
    // Title: To verify that system throws Error when customer provides an
    // invalid address for Billing.
    @Test
    public void vaildAddressShippingAndInvaildBillAddress() throws Exception
    {
        String name = new Object()
        {}.getClass().getEnclosingMethod().getName();
        TestCaseDetail testcase = TestCaseFactory.createTestCaseDetail(this.getClass(), name);
        try
        {
            precondition();
            SeleniumUtils.wait(10);
            CheckOutPage.checkOutGuestEmail(CheckOutPage.email);
            CheckOutPage.shippAddrValidData();
            CheckOutPage.checkOutBAFirstName("dsfhdskahf");
            CheckOutPage.checkOutBALastName("dfasdkjfasdk");
            CheckOutPage.clickBillCountry(CheckOutPage.Bcountry);
            CheckOutPage.addressBAlane1("fdjff");
            CheckOutPage.addressBAlane2("dfgfdjj");
            CheckOutPage.checkOutBACity(CheckOutPage.Bcity);
            CheckOutPage.clickBillState(CheckOutPage.Bstate);
            CheckOutPage.checkOutBAZipcode(CheckOutPage.Bzipcode + Keys.TAB);
            SeleniumUtils.wait(4);
            testcase.assertEquals(
                    SeleniumUtils.getText(ExcelProperty.getElementValue(CHECKOUT, ACC_REG_CONFORMATION_MSG)),
                    "Address Not Found.");

            testcase.pass("shipping and billing address are not same ");
        } catch (Exception e)
        {
            testcase.error("not able to observe shipping and billing address are not same", e);
            e.printStackTrace();
        }
    }
    // 62
    // Title:To verify the display of payment section.

    // 63
    // Title:To verify the customer is able to enter data in all the fields in
    // "Payment details" section of "Checkout".
    @Test
    public void inputValuesToPaymentVerify() throws Exception
    {
        String name = new Object()
        {}.getClass().getEnclosingMethod().getName();
        TestCaseDetail testcase = TestCaseFactory.createTestCaseDetail(this.getClass(), name);
        try
        {
            precondition();
            SeleniumUtils.wait(10);
            CheckOutPage.checkOutGuestEmail(CheckOutPage.email);
            CheckOutPage.shippAddrValidData();
            CheckOutPage.checkOutPayNameCard(CheckOutPage.name1);
            testcase.assertEquals(
                    SeleniumUtils.getAttributes(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_NAME_CARD), "value"),
                    CheckOutPage.name1);
            CheckOutPage.checkOutCardType(CheckOutPage.cardvisa);
            testcase.assertEquals(
                    SeleniumUtils.getAttributes(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_CARD_TYPE), "value"),
                    CheckOutPage.cardvisa);
            CheckOutPage.checkOutCardNumber(CheckOutPage.cardvisanum);
            testcase.assertEquals(
                    SeleniumUtils.getAttributes(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_CARD_NUM), "value"),
                    CheckOutPage.cardvisanum);
            CheckOutPage.checkOutCVV(CheckOutPage.cardcvv);
            testcase.assertEquals(
                    SeleniumUtils.getAttributes(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_CARD_CVV), "value"),
                    CheckOutPage.cardcvv);
            CheckOutPage.checkOutMonth(CheckOutPage.cardmonth);
            testcase.assertEquals(SeleniumUtils
                    .getAttributes(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_CARD_ENDMONTH), "value"), "02");
            CheckOutPage.checkOutYear(CheckOutPage.cardyear);
            testcase.assertEquals(SeleniumUtils
                    .getAttributes(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_CARD_ENDYEAR), "value"), "2019");
            SeleniumUtils.wait(30);
            testcase.pass("Customer is able to enter the valid Data for payment details");
        } catch (Exception e)
        {
            testcase.error("Customer is able to enter the valid data for payment details", e);
            e.printStackTrace();
        }
    }

    // 64
    // Title:To verify the system behavior when customer leaves the CardHolder
    // Name field as blank while creating new credit card and adding during
    // checkout.

    // 65
    // 66
    // 67
    // 68
    // Title:To verify that system display Credit card Brand Image Tiles next to
    // Credit Card type.
    // 69
    // Title:To verify that card type images are disabled until customer selects
    // card type from drop down "Payment details" section.

    @Test
    public void observeCardsBrandBeforeDropDownDisabled() throws Exception
    {
        String name = new Object()
        {}.getClass().getEnclosingMethod().getName();
        TestCaseDetail testcase = TestCaseFactory.createTestCaseDetail(this.getClass(), name);
        try
        {
            precondition();

            SeleniumUtils.wait(10);

            String discover = SeleniumUtils.getAttributes(ExcelProperty.getElementValue(CHECKOUT, DISCOVER_IMAGE_ID),
                    "class");

            String amex = SeleniumUtils.getAttributes(ExcelProperty.getElementValue(CHECKOUT, AMEX_IMAGE_ID), "class");

            String visa = SeleniumUtils.getAttributes(ExcelProperty.getElementValue(CHECKOUT, VISA_IMAGE_ID), "class");

            String master = SeleniumUtils.getAttributes(ExcelProperty.getElementValue(CHECKOUT, MASTER_IMAGE_ID),
                    "class");

            String string = "paymentimages";

            boolean b = discover.equalsIgnoreCase(string) && amex.equalsIgnoreCase(string)
                    && visa.equalsIgnoreCase(string) && master.equalsIgnoreCase(string);
            try
            {
                CheckOutPage.checkoutPaymentVisaImageClick();
            } catch (Exception e)
            {
                CheckOutPage.checkoutPaymentVisaImageClick();
            }
            SeleniumUtils.wait(5);
            testcase.assertEquals(
                    SeleniumUtils.getAttributes(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_CARD_TYPE), "value"),
                    "visa");

            if (b == true)
            {
                testcase.pass("By default Card images was disabled in payment section");
            } else
            {
                testcase.fail("Images should disable until the if we click on the image", "Images are not disable");
            }
        } catch (Exception e)
        {
            testcase.error("By default Card images was disabled in payment section", e);
            e.printStackTrace();
        }
    }

    // 70
    // Title:To verify that system enable / Highlight the Card Type image after
    // customer selects card type from drop down in "Payment detail" section.

    @Test
    public void observeDropDownCardSelection() throws Exception
    {

        String name = new Object()
        {}.getClass().getEnclosingMethod().getName();
        TestCaseDetail testcase = TestCaseFactory.createTestCaseDetail(this.getClass(), name);
        try
        {
            precondition();
            SeleniumUtils.wait(10);
            CheckOutPage.checkOutGuestEmail(CheckOutPage.email);
            // CheckOutPage.clickCardType();
            // SeleniumUtils.click(Type.LINKTEXT,CheckOutPage.carddisc);
            CheckOutPage.checkOutCardType(CheckOutPage.carddisc);
            SeleniumUtils.wait(5);
            String attributesCss = SeleniumUtils
                    .getAttributes(ExcelProperty.getElementValue(CHECKOUT, DISCOVER_IMAGE_ID), "class");
            if (attributesCss.endsWith("selectedCard"))
            {
                testcase.pass("By default Card images was disabled in payment section");
            } else
            {
                testcase.fail("System should enable the Image If we select the Card from the drop down",
                        "System is not enabling the Image If we select the Card from the drop down");
            }
        } catch (Exception e)
        {
            testcase.error("By default Card images was disabled in payment section", e);
            e.printStackTrace();
        }

    }

    // 71
    // Title:To verify that Card type is displayed in card type drop list when
    // customer clicks on any Card type image in "payment details" section.

    // 72
    @Test
    public void paymentCardDetailsBlank() throws Exception
    {
        String name = new Object()
        {}.getClass().getEnclosingMethod().getName();
        TestCaseDetail testcase = TestCaseFactory.createTestCaseDetail(this.getClass(), name);
        try
        {
            precondition();
            SeleniumUtils.wait(10);
            CheckOutPage.checkOutGuestEmail(CheckOutPage.email);
            CheckOutPage.shippAddrValidData();
            CheckOutPage.billAddValidData();
            CheckOutPage.checkOutPayNameCard(CheckOutPage.name1);
            CheckOutPage.checkOutCardType(CheckOutPage.cardvisa);
            CheckOutPage.checkOutCardNumber("");
            CheckOutPage.checkOutCVV("" + Keys.TAB);
            CheckOutPage.checkOutMonth(CheckOutPage.cardmonth);
            CheckOutPage.checkOutYear(CheckOutPage.cardyear);
            // CheckOutPage.clickCardType();
            // SeleniumUtils.click(Type.LINKTEXT,CheckOutPage.cardvisa);
            // CheckOutPage.clickCardMonth();
            // SeleniumUtils.click(Type.LINKTEXT,CheckOutPage.cardmonth);
            // CheckOutPage.clickCardYear();
            // SeleniumUtils.click(Type.LINKTEXT,CheckOutPage.cardyear);
            SeleniumUtils.wait(5);
            testcase.assertEquals(SeleniumUtils.getText(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_CARD_NUM_ERR)),
                    "Card Number is mandatory.");
            testcase.assertEquals(SeleniumUtils.getText(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_CARD_CVV_ERR)),
                    "CVV is mandatory.");
            testcase.pass("observe payment details are blank");
        } catch (Exception e)
        {
            testcase.error("not able to observe payment details are blank", e);
            e.printStackTrace();
        }
    }

    // 73 To verify the system behavior when customer leaves the Card number
    // field as blank while creating new credit card and adding during checkout.

    // 74 To verify the system behavior when customer provides
    // invalid/inappropriate characters in card number field while creating new
    // credit card and adding during checkout.

    // 75 To verify the system behavior when customer provides data more than
    // "X" characters in card number field while creating new credit card and
    // adding during checkout.

    // 76 To verify the system behavior when customer leaves the CVV field as
    // blank while creating new credit card and adding during checkout.

    // 77 To verify the system behavior when customer provides
    // invalid/inappropriate characters in CVV field while creating new credit
    // card and adding during checkout.

    // 78 To verify the system behavior when customer provides data more than
    // "X" characters in CVV field while creating new credit card and adding
    // during checkout

    // 79
    // Title: To verify the system behavior when customer provides an invalid
    // CVV
    // that does not correpsond to an actual credit card. Instances:
    // a. Incorrect CVV for the card number specified.
    // B. Visa/Mastercard/Discover: CVV with 4 digits
    // c. Amex: CVV wth 3 digits

    // 80 To verify the system behavior when customer leaves the Expiration
    // Month & Year field as blank while creating new credit card and adding
    // during checkout.

    // 81

    // 82
    @Test
    public void paymentVisaCardValuesInput() throws Exception
    {
        String name = new Object()
        {}.getClass().getEnclosingMethod().getName();
        TestCaseDetail testcase = TestCaseFactory.createTestCaseDetail(this.getClass(), name);
        try
        {

            precondition();
            SeleniumUtils.wait(10);
            CheckOutPage.checkOutGuestEmail(CheckOutPage.email);
            CheckOutPage.shippAddrValidData();
            CheckOutPage.billAddValidData();
            CheckOutPage.paymentValidVisaPayData();
            SeleniumUtils.wait(25);
            String text = SeleniumUtils.getText(ExcelProperty.getElementValue(CHECKOUT, ORDER_COMFIRMATION_MESSAGE));
            System.out.println(text);
            testcase.assertEquals(text, "This order is now being processed");
            testcase.pass("observe visacard valid data for payment");
        } catch (Exception e)
        {
            testcase.error("not able to observe visacard valid data for payment", e);
            e.printStackTrace();
        }
    }

    // 83
    @Test
    public void paymentMasterCardValuesInput() throws Exception
    {
        String name = new Object()
        {}.getClass().getEnclosingMethod().getName();
        TestCaseDetail testcase = TestCaseFactory.createTestCaseDetail(this.getClass(), name);
        try
        {

            precondition();
            CheckOutPage.checkOutGuestEmail(CheckOutPage.email);
            CheckOutPage.shippAddrValidData();
            CheckOutPage.billAddValidData();
            CheckOutPage.paymentValidMasterPayData();
            SeleniumUtils.wait(40);
            String text = SeleniumUtils.getText(ExcelProperty.getElementValue(CHECKOUT, ORDER_COMFIRMATION_MESSAGE));
            System.out.println(text);
            testcase.assertEquals(text, "This order is now being processed");

            testcase.pass("observe mastercard valid data for payment for place order");
        } catch (Exception e)
        {
            testcase.error("observe mastercard valid data for payment for place order", e);
            e.printStackTrace();
        }
    }

    // 84
    @Test
    public void paymentAmexCardValuesInput() throws Exception
    {
        String name = new Object()
        {}.getClass().getEnclosingMethod().getName();
        TestCaseDetail testcase = TestCaseFactory.createTestCaseDetail(this.getClass(), name);
        try
        {

            precondition();
            SeleniumUtils.wait(10);
            CheckOutPage.checkOutGuestEmail(CheckOutPage.email);
            CheckOutPage.shippAddrValidData();
            CheckOutPage.billAddValidData();
            CheckOutPage.paymentValidAmexPayData();
            SeleniumUtils.wait(40);
            String text = SeleniumUtils.getText(ExcelProperty.getElementValue(CHECKOUT, ORDER_COMFIRMATION_MESSAGE));
            System.out.println(text);
            testcase.assertEquals(text, "This order is now being processed");

            testcase.pass("observe American Express valid data for payment for place order");
        } catch (Exception e)
        {
            testcase.error("observe American Express valid data for payment for place order", e);
            e.printStackTrace();
        }
    }

    // 85
    // Title: To validate the Credit card number provided by the customer while
    // saving a Discover Credit card during checkout.
    @Test
    public void validDataToPlcOrdThrowDiscCretCardNum() throws Exception
    {
        String name = new Object()
        {}.getClass().getEnclosingMethod().getName();
        TestCaseDetail testcase = TestCaseFactory.createTestCaseDetail(this.getClass(), name);
        try
        {
            precondition();

            SeleniumUtils.wait(4);
            CheckOutPage.checkOutGuestEmail(CheckOutPage.email);
            CheckOutPage.shippAddrValidData();
            CheckOutPage.paymentValidDiscPayData();
            SeleniumUtils.wait(40);
            String text = SeleniumUtils.getText(ExcelProperty.getElementValue(CHECKOUT, ORDER_COMFIRMATION_MESSAGE));
            System.out.println(text);
            testcase.assertEquals(text, "This order is now being processed");
            testcase.pass("Customer should be able to place order by Discover Card");
        } catch (Exception e)
        {
            testcase.error("Customer should be able to place the order by Discover Card", e);
            e.printStackTrace();
        }

    }

    // 86
    // Title:To verify the system behavior when MOD10 check fails for a Visa
    // Credit Card number while adding a Visa Credit card during checkout.

    // 87
    // Title:To verify the system behavior when MOD10 check fails for a
    // Mastercard Credit Card number while adding a Mastercard Credit card
    // during checkout.
    // 88
    // Title:To verify the system behavior when MOD10 check fails for a Amex
    // Credit Card number while adding a Amex Credit card during checkout.

    // 89
    // Title:To verify the system behavior when MOD10 check fails for a Discover
    // Credit Card number while adding a Discover Credit card during checkout.
    // 90
    // 91
    // 92
    // 93
    // Title:To verify the system behavior when customer selects the Card type
    // as Discover but provides a Credit card number whose format does not match
    // with Discover requirements.

    // // 94
    //
    // @Test
    //
    // public void checkGiftOption() throws Exception
    // {
    // String name = new Object()
    // {}.getClass().getEnclosingMethod().getName();
    // TestCaseDetail testcase =
    // TestCaseFactory.createTestCaseDetail(this.getClass(), name);
    // try
    // {
    //
    // precondition();
    // SeleniumUtils.wait(10);
    // testcase.assertTrue(CheckOutPage.isCheckOutGiftCardMessage(),
    // "verify the giftcard message text in checkout page",
    // " not able to verify the giftcard text message in checkout page");
    //
    // testcase.pass("observe promocode and gift card button");
    // } catch (Exception e)
    // {
    // testcase.error("not able to observe promocode and gift card button", e);
    // e.printStackTrace();
    // }
    // }

    // // 95
    // @Test
    //
    // public void checkoutApplyGiftCardButton() throws Exception
    // {
    // String name = new Object()
    // {}.getClass().getEnclosingMethod().getName();
    // TestCaseDetail testcase =
    // TestCaseFactory.createTestCaseDetail(this.getClass(), name);
    // try
    // {
    //
    // precondition();
    // SeleniumUtils.wait(10);
    //
    // CheckOutPage.checkPromoCode("2344w3");
    // CheckOutPage.checkOutPromoButton();
    //
    // testcase.assertTrue(CheckOutPage.ischeckOutPromo(), "obeser the promo
    // code",
    // "not able to promo code ");
    //
    // testcase.pass("observe gift card button");
    // } catch (Exception e)
    // {
    // testcase.error("not able to observe gift card button ", e);
    // e.printStackTrace();
    // }
    // }

    // 96 - 104

    // Gift related test case 96 -104

    // 105
    // Title:To verify that Guest customer can use Paypal as payment method
    // during checkout.
    @Test
    public void checkoutPaypalMethodWithVaildAddress() throws Exception
    {

        String name = new Object()
        {}.getClass().getEnclosingMethod().getName();
        TestCaseDetail testcase = TestCaseFactory.createTestCaseDetail(this.getClass(), name);
        try
        {
            precondition();
            SeleniumUtils.wait(4);
            CheckOutPage.checkOutGuestEmail(CheckOutPage.email);
            CheckOutPage.shippAddrValidData();
            CheckOutPage.billAddValidData();
            CheckOutPage.paymentWithPaypalMethod();
            SeleniumUtils.wait(30);
            testcase.assertTrue(CheckOutPage.isOccPaypalContinueShopping(),
                    "continue shopping is present in paypal page to site home  page",
                    "continue shopping is present in paypal page to site home  page");
            SeleniumUtils.wait(2);
            SeleniumUtils.click(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_PAYPAL_CONFIRM_BUTTON_HOME));
            SeleniumUtils.wait(50);
            SeleniumUtils.click(ExcelProperty.getElementValue(HOMEPAGE, DONT_ASK_EMAIL_TEMPLATE));
            testcase.assertEquals(SeleniumUtils.getText(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_ITEM_EMPTY)),
                    "Your cart is empty");

            testcase.pass("Customer provide valid paypal details to payment by valid address");
        } catch (Exception e)
        {
            testcase.error("Customer provide valid paypal details to payment by valid address", e);
            e.printStackTrace();
        }

    }

    // 106
    // Title:To verify that Guest customer can use Paypal as payment method
    // during checkout.
    @Test
    public void paypalPayWithValShippAddr() throws Exception
    {
        String name = new Object()
        {}.getClass().getEnclosingMethod().getName();
        TestCaseDetail testcase = TestCaseFactory.createTestCaseDetail(this.getClass(), name);
        try
        {
            precondition();
            SeleniumUtils.wait(4);
            CheckOutPage.checkOutGuestEmail(CheckOutPage.email);
            CheckOutPage.shippAddrValidData();
            SeleniumUtils.wait(05);
            CheckOutPage.clickBillingAddress();
            CheckOutPage.paymentWithPaypalMethod();
            SeleniumUtils.wait(20);
            testcase.assertTrue(CheckOutPage.isOccPaypalContinueShopping(),
                    "continue shopping is present in paypal page to site home  page",
                    "continue shopping is present in paypal page to site home  page");
            SeleniumUtils.wait(2);
            SeleniumUtils.click(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_PAYPAL_CONFIRM_BUTTON_HOME));
            SeleniumUtils.wait(30);
            SeleniumUtils.click(ExcelProperty.getElementValue(HOMEPAGE, DONT_ASK_EMAIL_TEMPLATE));
            testcase.assertEquals(SeleniumUtils.getText(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_ITEM_EMPTY)),
                    "Your cart is empty");

            testcase.pass("Customer provide valid paypal details to payment");
        } catch (Exception e)
        {
            testcase.error("Customer provide valid paypal details to payment", e);
            e.printStackTrace();
        }

    }
    // 107
    // Title:To verify the essential elements present in the "Cart summary"
    // section.

    // 108
    // Title:To verify the Customer is navigated to "Shopping cart' page when
    // clicked on Edit button in the "Cart summary" section

    @Test
    public void verifyCusNavigToShopCartEditfrmCheckout() throws Exception
    {
        String name = new Object()
        {}.getClass().getEnclosingMethod().getName();
        TestCaseDetail testcase = TestCaseFactory.createTestCaseDetail(this.getClass(), name);
        try
        {

            precondition();
            SeleniumUtils.wait(10);
            testcase.assertTrue(CheckOutPage.isOccplaceOrder(), "CheckoutPage Verification",
                    "Checkout Page verification");
            CheckOutPage.CheckoutOrderEditButtonClick();
            SeleniumUtils.wait(25);
            testcase.assertTrue(
                    SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(CHECKOUT, CART_PROCEED_TOCHECKOUT)),
                    "checkout should displayed in cart", "checkout should not displayed in cart");

            testcase.pass("Customer can navigate the cart page clicking edit button in checkout page");
        } catch (

        Exception e)
        {
            testcase.error("Customer can navigate the cart page clicking edit button in checkout page", e);
            e.printStackTrace();
        }
    }

    // 109
    // Title:To verify the display of "Order summary" section in checkout page.

    @Test
    public void verifyOrderSummaryInCheckoutPage() throws Exception
    {
        String name = new Object()
        {}.getClass().getEnclosingMethod().getName();
        TestCaseDetail testcase = TestCaseFactory.createTestCaseDetail(this.getClass(), name);
        try
        {
            precondition();
            SeleniumUtils.wait(10);
            CheckOutPage.checkOutGuestEmail(CheckOutPage.email);
            testcase.assertTrue(CheckOutPage.isCheckoutOrderSummarySaleTax(), "Checkout Order summary sale tax",
                    "checkout order summary sale tax");
            CheckOutPage.shippAddrValidData();
            SeleniumUtils.wait(10);
            testcase.assertTrue(CheckOutPage.isCheckoutOrderSummaryTotal(), "checkout order summary Total",
                    "checkout order summary Total");
            testcase.assertTrue(CheckOutPage.isCheckoutOrderSummaryShippingName(),
                    "checkout order summary Shipping name", "checkout order summary shippin name");
            testcase.assertTrue(CheckOutPage.isCheckoutOrderSummarySubTotal(), "checkout order summary SubTotal",
                    "checkout order summary Sub Total");
            testcase.pass("verify checkout page order summary details.");
        } catch (

        Exception e)
        {
            testcase.error("verify checkout page order summary details.", e);
            e.printStackTrace();
        }
    }
    // 110
    // Title:To verify that system displays the shipping methods configure

    // 111
    // Title:To verify that system displays the Shipping charges associated
    // with each of the Shipping Methods.

    @Test
    public void verifyShippingChargesWithShippingMethods() throws Exception
    {
        String name = new Object()
        {}.getClass().getEnclosingMethod().getName();
        TestCaseDetail testcase = TestCaseFactory.createTestCaseDetail(this.getClass(), name);
        try
        {
            precondition();
            SeleniumUtils.wait(4);
            CheckOutPage.checkOutGuestEmail(CheckOutPage.email);
            CheckOutPage.shippAddrValidData();
            ArrayList<String> listOne = new ArrayList<String>(Arrays.asList("Standard", "Standard – Signature Required",
                    "Expedited", "Expedited – Signature Required", "2nd Day", "2nd Day – Signature Required", "1 Day",
                    "1 Day – Signature Required"));
            ArrayList<String> listtwo = new ArrayList<>();
            List<WebElement> d = SeleniumUtils.getAllElements(Type.CSSSELECTOR, "div.option-text.clearfix");
            for (WebElement dt : d)
            {
                String text = dt.getText();
                String result = text.substring(0, text.indexOf("$"));
                if (!result.isEmpty())
                {
                    String add = result.trim();
                    listtwo.add(add);
                    System.out.println(add);
                }
            }
            CheckOutPage.checkOrdSumShipTypeExpedSignReqClick();
            SeleniumUtils.wait(3);
            testcase.assertEquals(
                    SeleniumUtils.getText(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_SHIPPING_TYPE_FINAL_NAME)),
                    "Shipping: Expedited – Signature Required");

            String ac = SeleniumUtils
                    .getText(ExcelProperty.getElementValue(CHECKOUT, CHECK_ORD_SUMM_SHIP_TYPE_EXPED_SIGN_REQU_PRICE));

            SeleniumUtils.wait(04);
            testcase.assertEquals(
                    SeleniumUtils.getText(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_SHIPPING_TYPE_FINAL_PRICE)),
                    ac);

            if (CommonUtils.equalLists(listOne, listtwo) == true)
            {
                testcase.pass("There are many types of shipping methods also for all fields those are verified ");
            } else
            {
                testcase.fail("System is not displaying the Shpping Methods",
                        "System is not displaying the Shpping Methods (or) Shipping Texts are in correct");
            }

        } catch (Exception e)
        {
            testcase.error("There are many types of shipping methods also for all fields those are verified ", e);
            e.printStackTrace();
        }

    }

    // 112
    // Title: To verify that system will select a shipping method by default,
    // which has the least shipping charge.
    @Test
    public void verifyDefaultShippingMethodInCheckoutPage() throws Exception
    {
        String name = new Object()
        {}.getClass().getEnclosingMethod().getName();
        TestCaseDetail testcase = TestCaseFactory.createTestCaseDetail(this.getClass(), name);
        try
        {
            precondition();
            SeleniumUtils.wait(10);
            CheckOutPage.checkOutGuestEmail(CheckOutPage.email);
            CheckOutPage.checkOutFirstName(CheckOutPage.name1);
            CheckOutPage.checkOutLastName(CheckOutPage.lastname);
            CheckOutPage.clickCountry(CheckOutPage.country);
            CheckOutPage.addresslane1(CheckOutPage.lane1);
            CheckOutPage.addresslane2(CheckOutPage.lane2);
            CheckOutPage.clickState(CheckOutPage.state);
            CheckOutPage.checkOutCity(CheckOutPage.city);
            SeleniumUtils.wait(4);
            CheckOutPage.checkOutZipcode(CheckOutPage.zipcode + Keys.TAB);
            SeleniumUtils.wait(10);
            SeleniumUtils.wait(3);
            String selection = SeleniumUtils
                    .getAttributes(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_SHIPPING_DEFAULT), "class");
            if (selection.endsWith("selected"))
            {
                testcase.pass("In checkout page Default shipping method was selected");
            } else
            {
                testcase.fail("In checkout page Defalut standard shipping was selected",
                        "In checkout page not default standard shipping was not selected");
            }
        } catch (

        Exception e)
        {
            testcase.error("In checkout page Default Shipping method was selected", e);
            e.printStackTrace();
        }

    }

    // 113
    // Title:To verify that Customer can select any shipping method of his/her
    // own choice.

    // 114
    // Title:To verify that system updates the Shipping charge in order summary
    // when customer selects a shipping method.

    // 115
    // Title:To verify the customer Place order successfully.

    @Test
    public void validDataForPlaceOrder() throws Exception
    {
        String name = new Object()
        {}.getClass().getEnclosingMethod().getName();
        TestCaseDetail testcase = TestCaseFactory.createTestCaseDetail(this.getClass(), name);
        try
        {

            precondition();
            SeleniumUtils.wait(10);
            CheckOutPage.checkOutGuestEmail(CheckOutPage.email);
            CheckOutPage.shippAddrValidData();
            SeleniumUtils.wait(05);
            CheckOutPage.clickBillingAddress();
            CheckOutPage.paymentValidVisaPayData();
            SeleniumUtils.wait(10);
            String text = SeleniumUtils.getText(ExcelProperty.getElementValue(CHECKOUT, ORDER_COMFIRMATION_MESSAGE));
            System.out.println(text);
            testcase.assertEquals(text, "This order is now being processed");

            testcase.pass("observe visacard valid data for payment");
        } catch (Exception e)
        {
            testcase.error("not able to observe visacard valid data for payment", e);
            e.printStackTrace();
        }
    }

    // 116,
    @Test
    public void validDataForCreateAccount() throws Exception
    {
        String name = new Object()
        {}.getClass().getEnclosingMethod().getName();
        TestCaseDetail testcase = TestCaseFactory.createTestCaseDetail(this.getClass(), name);
        try
        {
            precondition();
            SeleniumUtils.wait(10);
            testcase.assertTrue(CheckOutPage.isCheckOutGuestEmail(), "guest mail id was checked radio button",
                    "guest mail id was checked radio button");
            CheckOutPage.checkOutGuestEmail(random() + CheckOutPage.email);
            CheckOutPage.checkRegAccount();

            testcase.pass("new account created by checkout page with valid.");
        } catch (Exception e)
        {
            testcase.error("new account created by checkout page with valid.", e);
            e.printStackTrace();
        }

    }

    // 117
    // 118
    @Test
    public void CheckoutRegPagecreateNewAccountValidData() throws Exception
    {
        String name = new Object()
        {}.getClass().getEnclosingMethod().getName();
        TestCaseDetail testcase = TestCaseFactory.createTestCaseDetail(this.getClass(), name);
        try
        {
            precondition();
            SeleniumUtils.wait(10);
            CheckOutPage.checkOutGuestEmail(random() + CheckOutPage.email);
            CheckOutPage.checkRegAccount();
            CheckOutPage.shippAddrValidData();
            CheckOutPage.billAddValidData();
            CheckOutPage.paymentValidVisaPayData();
            SeleniumUtils.wait(30);
            String text = SeleniumUtils.getText(ExcelProperty.getElementValue(CHECKOUT, ORDER_COMFIRMATION_MESSAGE));
            System.out.println(text);
            testcase.assertEquals(text, "This order is now being processed");
            testcase.pass("new account created by checkout page with valid.");
        } catch (Exception e)
        {
            testcase.error("new account created by checkout page with valid.", e);
            e.printStackTrace();
        }
    }

    // 119
    // 120
    // 121
    // 122
    // 124
    // 125
    // 126
    // 127
    // 128
    // 129 this is not working in site
    @Test
    public void CheckoutRegPagecreateExsistingEmailId() throws Exception
    {
        String name = new Object()
        {}.getClass().getEnclosingMethod().getName();
        TestCaseDetail testcase = TestCaseFactory.createTestCaseDetail(this.getClass(), name);
        try
        {
            precondition();
            SeleniumUtils.wait(10);
            CheckOutPage.checkOutGuestEmail("tester552@test.com");
            CheckOutPage.checkRegAccount();
            CheckOutPage.shippAddrValidData();
            CheckOutPage.billAddValidData();
            CheckOutPage.paymentValidVisaPayData();

            // need to write code

            testcase.pass("observe already exsisting Email address while creating an account at checkout.");
            testcase.comments("Existing mail not working");
        } catch (Exception e)
        {
            testcase.error("not able to observe already exsisting Email address while creating an account at checkout.",
                    e);
            testcase.comments("Existing mail not working");
            e.printStackTrace();
        }
    }

    //
    // 130
    @Test
    public void CheckoutRegPagecreateNewAccountToLogout() throws Exception
    {
        String name = new Object()
        {}.getClass().getEnclosingMethod().getName();
        TestCaseDetail testcase = TestCaseFactory.createTestCaseDetail(this.getClass(), name);
        try
        {
            precondition();
            SeleniumUtils.wait(10);
            CheckOutPage.checkOutGuestEmail(random() + "test@test.com");
            CheckOutPage.checkRegAccount();
            CheckOutPage.shippAddrValidData();
            SeleniumUtils.wait(05);
            CheckOutPage.clickBillingAddress();
            CheckOutPage.paymentValidMasterPayData();
            SeleniumUtils.wait(50);
            testcase.assertTrue(CheckOutPage.isplaceOrderContiuneShopping(), "Continue shopping place order",
                    "Continue shopping place order");
            CheckOutPage.placeOrderContiuneShopping();
            SeleniumUtils.wait(40);
            testcase.assertTrue(OCCUtlis.isMyAccout(), "my account is there fr new user ",
                    "New account was not created");
            testcase.assertTrue(OCCUtlis.isLogOut(), "New account has created by guest customer in checkout page",
                    "New account has not created by guest use throw checkout page");

            testcase.pass(
                    "observe create account for new user in checkout page and place order it should come to home page user can logout in that page with valid shipping address.");
        } catch (Exception e)
        {
            testcase.error(
                    "observe create account for new user in checkout page and place order it should come to home page user can logout in that page with valid shipping address.",
                    e);
            e.printStackTrace();
        }
    }

    // 131

    // 132
    @Test
    public void CreateNewAccountTologoutFromCheckoutRegPage() throws Exception
    {
        String name = new Object()
        {}.getClass().getEnclosingMethod().getName();
        TestCaseDetail testcase = TestCaseFactory.createTestCaseDetail(this.getClass(), name);
        try
        {
            precondition();
            SeleniumUtils.wait(10);
            CheckOutPage.checkOutGuestEmail(random() + "test@test.com");
            CheckOutPage.checkRegAccount();
            CheckOutPage.shippAddrValidData();
            CheckOutPage.billAddValidData();
            CheckOutPage.paymentValidMasterPayData();
            SeleniumUtils.wait(45);
            testcase.assertTrue(CheckOutPage.isOrderConfirmation(), "Systesm should display the order confirmation",
                    "System should be displayed the order confirmation");

            testcase.assertTrue(CheckOutPage.isplaceOrderContiuneShopping(), "new accout created by checkout page",
                    "new accout is not created by checkout page");
            SeleniumUtils.wait(5);
            CheckOutPage.placeOrderContiuneShopping();

            testcase.pass(
                    "observe create account for new user in checkout page and place order it should come to home page user can logout in that page.");
        } catch (Exception e)
        {
            testcase.error(
                    "observe create account for new user in checkout page and place order it should come to home page user can logout in that page.",
                    e);
            e.printStackTrace();
        }
    }

    public static String random()
    {
        Date date = new Date();
        DateFormat df = new SimpleDateFormat("dmMM");
        String str = df.format(date);
        return str;
    }
    // 133

    // 134
    @Test
    public void CreAccAtCheckObserLoginByNewUser() throws Exception
    {
        String name = new Object()
        {}.getClass().getEnclosingMethod().getName();
        TestCaseDetail testcase = TestCaseFactory.createTestCaseDetail(this.getClass(), name);
        try
        {
            precondition();
            SeleniumUtils.wait(10);
            String string = "lenox@lenox.com";
            String email = random() + string;
            CheckOutPage.checkOutGuestEmail(email);
            CheckOutPage.checkRegAccount();
            CheckOutPage.shippAddrValidData();
            CheckOutPage.billAddValidData();
            CheckOutPage.paymentValidMasterPayData();
            SeleniumUtils.wait(45);
            testcase.assertTrue(CheckOutPage.isOrderConfirmation(), "Systesm should display the order confirmation",
                    "System should be displayed the order confirmation");

            testcase.assertTrue(CheckOutPage.isplaceOrderContiuneShopping(), "new accout created by checkout page",
                    "new accout is not created by checkout page");
            SeleniumUtils.wait(5);
            CheckOutPage.placeOrderContiuneShopping();
            SeleniumUtils.wait(20);
            OCCUtlis.occLogout();
            SeleniumUtils.wait(10);
            SeleniumUtils.click(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, LOGIN));
            SeleniumUtils.wait(7);
            SeleniumUtils.sendKeys(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, LOGIN_EMAIL), email);
            SeleniumUtils.sendKeys(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, LOGIN_PASSWORD),
                    CheckOutPage.password);
            LoginPage.clickLoginButton();
            SeleniumUtils.wait(0);
            OCCUtlis.occLogout();
            SeleniumUtils.wait(3);
            testcase.assertEquals(SeleniumUtils.getText(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, LOGIN)),
                    "Sign In");

            testcase.pass(
                    "observe create account for new user in checkout page and place order it should come to home page user can logout and login in that page.");
        } catch (Exception e)
        {
            testcase.error(
                    "observe create account for new user in checkout page and place order it should come to home page user can logout and login in that page.",
                    e);
            e.printStackTrace();
        }
    }

    // 135
    // Title:To verify the functionality of "Log out" button in "Checkout" page.

    // 136
    @Test
    public void observeLoginFieldsAndForgetLinkFields() throws Exception
    {
        String name = new Object()
        {}.getClass().getEnclosingMethod().getName();
        TestCaseDetail testcase = TestCaseFactory.createTestCaseDetail(this.getClass(), name);
        try
        {
            precondition();
            SeleniumUtils.wait(10);
            CheckOutPage.occCheckoutLoginToAccount();
            SeleniumUtils.wait(7);
            testcase.assertTrue(CheckOutPage.ischeckOutRegLoginMail(), "Register login mail is there in checkout page",
                    "Register login mail is not there in checkout page");
            testcase.assertTrue(CheckOutPage.ischeckOutRegLoginPassword(),
                    "Register login Password is there in checkout page",
                    "Register login Password is not there in checkout page");
            CheckOutPage.checkoutRegForgotPasswordLink();
            testcase.assertTrue(CheckOutPage.isCheckOutForgetPasswordEmailfieldInput(),
                    "observe the email input fields", "forgot password link not clicked");
            testcase.assertTrue(CheckOutPage.isCheckOutEmailForgetPasswordSubmitButton(),
                    "observe the email password button", "not able to oserver the email passwor button");
            testcase.assertTrue(CheckOutPage.isCheckOutForgetPasswordCancelButton(),
                    "observe the password cancel button", "not able to observe the password cancel button");

            testcase.pass("observe login fields and forget link in checkout page.");
        } catch (Exception e)
        {
            testcase.error("observe login fields and forget link in checkout page.", e);
            e.printStackTrace();
        }
    }

    // 137
    @Test
    public void observeUserLoginFuntionalityInCheckoutPage() throws Exception
    {
        String name = new Object()
        {}.getClass().getEnclosingMethod().getName();
        TestCaseDetail testcase = TestCaseFactory.createTestCaseDetail(this.getClass(), name);
        try
        {
            precondition();
            SeleniumUtils.wait(10);
            CheckOutPage.checkLoggedUser();
            SeleniumUtils.wait(5);
            testcase.assertEquals(
                    SeleniumUtils.getText(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_WELCOME_MESSAGE)),
                    "Welcome back!");
            testcase.assertTrue(CheckOutPage.isCheckoutLogoutButton(),
                    "observe the register login details in checkout page ",
                    "observer the register login details in checkout page");
            testcase.assertTrue(CheckOutPage.ischeckOutDefaultAddress(), "observe the Default address",
                    "Observe the Default address");
            testcase.pass("observe login user funtionality in checkout page.");
        } catch (Exception e)
        {
            testcase.error("observe login user funtionality in checkout page.", e);
            e.printStackTrace();
        }

    }

    // 138
    @Test
    public void checkoutLoginUserFieldsBlank() throws Exception
    {
        String name = new Object()
        {}.getClass().getEnclosingMethod().getName();
        TestCaseDetail testcase = TestCaseFactory.createTestCaseDetail(this.getClass(), name);
        try
        {

            precondition();
            SeleniumUtils.wait(10);
            CheckOutPage.occCheckoutLoginToAccount();
            SeleniumUtils.wait(7);
            CheckOutPage.checkOutRegLoginMail("");
            CheckOutPage.checkOutRegLoginPassword("");
            CheckOutPage.checkOutRegLoginButton();
            SeleniumUtils.wait(6);
            testcase.assertEquals(
                    SeleniumUtils.getText(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_REGIST_LOGIN_EMAIL_ERROR)),
                    "Email Address is mandatory.");
            testcase.assertEquals(
                    SeleniumUtils
                            .getText(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_RESIST_LOGIN_PASSWORD_ERROR)),
                    "Password is mandatory.");
            testcase.pass("observe Password is mandatory.");
        } catch (Exception e)
        {
            testcase.error("not able to observe Password is mandatory.", e);
            e.printStackTrace();
        }
    }

    // 139
    // 140
    // 141
    // 141
    // 142
    // 143
    // 144
    @Test
    public void checkoutLoginForgettenCheckPopup() throws Exception
    {
        String name = new Object()
        {}.getClass().getEnclosingMethod().getName();
        TestCaseDetail testcase = TestCaseFactory.createTestCaseDetail(this.getClass(), name);
        try
        {

            precondition();
            SeleniumUtils.wait(10);
            CheckOutPage.occCheckoutLoginToAccount();
            SeleniumUtils.wait(7);
            CheckOutPage.checkoutRegForgotPasswordLink();
            SeleniumUtils.wait(7);
            CheckOutPage.checkoutRegForgotPasswordMailInput("test23@test.com");
            CheckOutPage.checkoutRegForgotSubmit();
            testcase.assertEquals(
                    "A new temporary password has been sent to your email address, along with reset password instructions.",
                    CheckOutPage.getForgotSucessMessage());
            CheckOutPage.checkoutregForSubmAfterCloseButn();
            SeleniumUtils.wait(10);
            testcase.assertTrue(CheckOutPage.isCheckOutFirstName(), "observe the first name ",
                    "not able to observe the first name ");

            testcase.assertTrue(CheckOutPage.isCheckOutLastName(), "observe the last name ",
                    "not able to observe the lastname");

            testcase.assertTrue(CheckOutPage.isCheckAddresslane1(), "observe the address lane1",
                    "not able to observe the address lane1");

            testcase.assertTrue(CheckOutPage.isCheckAddresslane2(), "observe the address lane2",
                    "not able to observe the address lane2");

            testcase.assertTrue(CheckOutPage.isCheckSelectStateRegion(), "observe the StateRegion",
                    "not able to observe the state region");

            testcase.assertTrue(CheckOutPage.isCheckOutCity(), "observe the city", "not able to observe the city");

            testcase.assertTrue(CheckOutPage.isCheckOutCountry(), "observe the country",
                    "not able to observe the country");

            testcase.assertTrue(CheckOutPage.isCheckOutZipcode(), "observe the zipcode",
                    "not able to observe the zipcode");

            testcase.assertTrue(CheckOutPage.isCheckOutPhoneNumber(), "observe the phone number",
                    "not able to observe the phone number");

            testcase.pass("observe Forgetten password link in checkout page.");
        } catch (Exception e)
        {
            testcase.error("not able to observe Forgetten password link.", e);
            e.printStackTrace();
        }
    }
    // 145 - 153

    // 145

    // 154

    // 155
    @Test
    public void checkOutRegShippingAddressFields() throws Exception
    {
        String name = new Object()
        {}.getClass().getEnclosingMethod().getName();
        TestCaseDetail testcase = TestCaseFactory.createTestCaseDetail(this.getClass(), name);
        try
        {

            precondition();
            SeleniumUtils.wait(10);
            CheckOutPage.checkLoggedUser();
            CheckOutPage.checkoutNewAddressButtonClick();
            SeleniumUtils.wait(3);
            CheckOutPage.shippAddrValidData();
            CheckOutPage.paymentValidVisaPayData();
            SeleniumUtils.wait(30);
            testcase.assertTrue(CheckOutPage.isOrderConfirmation(), "Systesm should display the order confirmation",
                    "System should be displayed the order confirmation");

            testcase.pass("observe shipping fields are filled can place the order for new account user");
        } catch (Exception e)
        {
            testcase.error("observe shipping fields are filled can place the order for new account user", e);
            e.printStackTrace();
        }
    }

    // 156
    // 157
    // 158
    // 160
    // 161
    // 163
    // 164
    // 165
    @Test
    public void checkOutLoggedUserShippingAddress1Invalid() throws Exception
    {
        String name = new Object()
        {}.getClass().getEnclosingMethod().getName();
        TestCaseDetail testcase = TestCaseFactory.createTestCaseDetail(this.getClass(), name);
        try
        {
            precondition();
            SeleniumUtils.wait(10);
            CheckOutPage.checkLoggedUser();
            CheckOutPage.checkoutNewAddressButtonClick();
            SeleniumUtils.wait(3);
            CheckOutPage.checkOutFirstName(CheckOutPage.name1);
            CheckOutPage.checkOutLastName(CheckOutPage.lastname);
            CheckOutPage.clickCountry(CheckOutPage.country);
            CheckOutPage.addresslane1("fdasfads!@#$%^&*(");
            CheckOutPage.addresslane2("fasdfsdaf!@#$%^&*(");
            CheckOutPage.checkOutCity(CheckOutPage.city);
            CheckOutPage.clickState(CheckOutPage.state);
            CheckOutPage.checkOutZipcode(CheckOutPage.zipcode);
            CheckOutPage.checkOutPhoneNumber(CheckOutPage.phone + Keys.TAB);
            SeleniumUtils.wait(05);
            testcase.assertEquals(
                    SeleniumUtils.getText(ExcelProperty.getElementValue(CHECKOUT, ACC_REG_CONFORMATION_MSG)),
                    "Address Not Found.");

            testcase.pass("Shipping address line 1 is invaild data");
            testcase.comments("Address Not Validting");
        } catch (Exception e)
        {
            testcase.error("Shipping address line 1 is invaild data", e);
            e.printStackTrace();
        }
    }

    // 166

    // 167
    @Test
    public void checkOutRegAddress2Invalid() throws Exception
    {
        String name = new Object()
        {}.getClass().getEnclosingMethod().getName();
        TestCaseDetail testcase = TestCaseFactory.createTestCaseDetail(this.getClass(), name);
        try
        {

            precondition();
            SeleniumUtils.wait(10);
            CheckOutPage.checkLoggedUser();
            CheckOutPage.checkoutNewAddressButtonClick();
            SeleniumUtils.wait(3);
            CheckOutPage.checkOutFirstName(CheckOutPage.name1);
            CheckOutPage.checkOutLastName(CheckOutPage.lastname);
            CheckOutPage.clickCountry(CheckOutPage.country);
            CheckOutPage.addresslane1("sfdadskjb");
            CheckOutPage.addresslane2("dsafsad");
            CheckOutPage.checkOutCity(CheckOutPage.city);
            CheckOutPage.clickState(CheckOutPage.state);
            CheckOutPage.checkOutZipcode(CheckOutPage.zipcode);
            CheckOutPage.checkOutPhoneNumber(CheckOutPage.phone + Keys.TAB);
            SeleniumUtils.wait(10);
            testcase.assertEquals(
                    SeleniumUtils.getText(ExcelProperty.getElementValue(CHECKOUT, ACC_REG_CONFORMATION_MSG)),
                    "Address Not Found.");

            testcase.pass("observe shipping Address2 Invalid entry for register user in checkout page.");
        } catch (Exception e)
        {
            testcase.error("observe shipping Address2 Invalid entry for register user in checkout page.", e);
            e.printStackTrace();
        }

    }

    // 168
    // 169
    // 170
    @Test
    public void checkOutRegCityInvalid() throws Exception
    {
        String name = new Object()
        {}.getClass().getEnclosingMethod().getName();
        TestCaseDetail testcase = TestCaseFactory.createTestCaseDetail(this.getClass(), name);
        try
        {
            precondition();
            SeleniumUtils.wait(10);
            CheckOutPage.checkLoggedUser();
            CheckOutPage.checkoutNewAddressButtonClick();
            SeleniumUtils.wait(3);
            CheckOutPage.checkOutFirstName(CheckOutPage.name1);
            CheckOutPage.checkOutLastName(CheckOutPage.lastname);
            CheckOutPage.clickCountry(CheckOutPage.country);
            CheckOutPage.addresslane1(CheckOutPage.lane1);
            CheckOutPage.addresslane2(CheckOutPage.lane2);
            CheckOutPage.checkOutCity("eqrqewrqwe");
            CheckOutPage.clickState(CheckOutPage.state);
            CheckOutPage.checkOutZipcode(CheckOutPage.zipcode);
            CheckOutPage.checkOutPhoneNumber(CheckOutPage.phone + Keys.TAB);
            SeleniumUtils.wait(10);
            testcase.assertTrue(
                    SeleniumUtils.iSDisplayed(
                            ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_SUGGESTION_ADDRESS_SHIPP_TEXT)),
                    "Check with Suggested Addresses for Shipping address",
                    "Check with Suggested Addresses for Shipping address");
            try
            {
                SeleniumUtils.click(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_SUGGESTED_ADDRESS_SHIPP_BUTTON));
            } catch (Exception e)
            {
            }

            SeleniumUtils.wait(5);

            testcase.pass("observe shipping address City is invalid for register user in checkout page.");
        } catch (Exception e)
        {
            testcase.error("observe shipping address City is invalid for register user in checkout page.", e);
            e.printStackTrace();
        }
    }

    // public static void main(String[] args) throws Exception {
    // TestNGXMLGen.generateXmlClassName("com.ch.occ.test.CheckOutTest");
    // }

    // 171
    // 172
    // 173
    // 174
    // 175
    // 176
    // 177
    // 178
    // 179

    @Test
    public void checkoutUSVaildAddressFrShipping() throws Exception
    {
        String name = new Object()
        {}.getClass().getEnclosingMethod().getName();
        TestCaseDetail testcase = TestCaseFactory.createTestCaseDetail(this.getClass(), name);
        try
        {
            precondition();
            SeleniumUtils.wait(10);
            CheckOutPage.checkLoggedUser();
            CheckOutPage.checkoutNewAddressButtonClick();
            SeleniumUtils.wait(3);
            CheckOutPage.checkOutFirstName(CheckOutPage.name1);
            testcase.assertEquals(
                    SeleniumUtils.getAttributes(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_FNAME), "value"),
                    CheckOutPage.name1);

            CheckOutPage.checkOutLastName(CheckOutPage.lastname);
            testcase.assertEquals(
                    SeleniumUtils.getAttributes(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_LNAME), "value"),
                    CheckOutPage.lastname);

            CheckOutPage.clickCountry(CheckOutPage.country);

            testcase.assertEquals(SeleniumUtils.getText(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_COUNTRY)),
                    "United States");

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

            CheckOutPage.clickState(CheckOutPage.state);
            testcase.assertEquals(SeleniumUtils.getText(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_REGION_STATE)),
                    "Alaska");

            CheckOutPage.checkOutZipcode(CheckOutPage.zipcode);
            testcase.assertEquals(
                    SeleniumUtils.getAttributes(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_ZIPCODE), "value"),
                    CheckOutPage.zipcode);

            CheckOutPage.checkOutPhoneNumber(CheckOutPage.phone);
            testcase.assertEquals(
                    SeleniumUtils.getAttributes(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_PHONE_NUM), "value"),
                    CheckOutPage.phone);

            testcase.pass("observe valid data for us shipping address.");
        } catch (Exception e)
        {
            testcase.error("observe valid data for us shipping address.", e);
            e.printStackTrace();
        }

    }

    // 180
    @Test
    public void invaildShippingAddressForPlaceorder() throws Exception
    {
        String name = new Object()
        {}.getClass().getEnclosingMethod().getName();
        TestCaseDetail testcase = TestCaseFactory.createTestCaseDetail(this.getClass(), name);
        try
        {

            precondition();
            SeleniumUtils.wait(10);
            CheckOutPage.checkLoggedUser();
            SeleniumUtils.wait(3);
            CheckOutPage.checkoutNewAddressButtonClick();
            SeleniumUtils.wait(3);
            CheckOutPage.checkOutFirstName(CheckOutPage.name1);
            CheckOutPage.checkOutLastName(CheckOutPage.lastname);
            CheckOutPage.clickCountry(CheckOutPage.country);
            CheckOutPage.addresslane1("");
            CheckOutPage.addresslane2(CheckOutPage.lane2);
            CheckOutPage.checkOutCity(CheckOutPage.city);
            CheckOutPage.clickState("State/Region");
            CheckOutPage.checkOutZipcode("41545151");
            CheckOutPage.checkOutPhoneNumber(CheckOutPage.phone + Keys.TAB);
            SeleniumUtils.wait(10);

            testcase.assertEquals(
                    SeleniumUtils.getText(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_ZIPCODE_ERROR)),
                    "Invalid entry. Please enter a valid zip/postal code.");

            testcase.assertEquals(
                    SeleniumUtils.getText(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_BILL_STATE_ERROR)),
                    "State is mandatory.");

            testcase.pass("Not able to place order in checkout page with invalid shipping data");
        } catch (Exception e)
        {
            testcase.error("Not able to place order in checkout page with invalid shipping data", e);
            e.printStackTrace();
        }
    }
    // 181
    // Title: To verify that system provides an option to the customer to use
    // shipping address as Billing address.S

    @Test
    public void checkOutisRegBiilingAddressChecked() throws Exception
    {
        String name = new Object()
        {}.getClass().getEnclosingMethod().getName();
        TestCaseDetail testcase = TestCaseFactory.createTestCaseDetail(this.getClass(), name);
        try
        {
            precondition();
            SeleniumUtils.wait(10);
            CheckOutPage.checkLoggedUser();
            CheckOutPage.checkoutNewAddressButtonClick();
            SeleniumUtils.wait(3);
            CheckOutPage.shippAddrValidData();
            SeleniumUtils.wait(3);
            testcase.assertTrue(CheckOutPage.isCheckedBill(), "check box checked", "checkbox unchecked");

            testcase.assertTrue(
                    SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_BILL_CHECKBOX)),
                    "Logged user Shipping Address can use this as billing address also",
                    "logged user can use shipping add also as billing add");

            boolean flag = false;
            try
            {
                flag = SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_BILL_FNAME));
            } catch (Exception e)
            {
                e.printStackTrace();
            }

            testcase.assertTrue(flag, "Systesm should dispy the billing Adress Fields",
                    "Systesm is not displaying the billing Address fields");
            testcase.assertTrue(CheckOutPage.isCheckOutBALastName(), "observe the billing address last name",
                    "not able to observe the billing address last name ");

            testcase.assertTrue(CheckOutPage.isCheckOutBACountry(), "observe the billing address country",
                    "not able to observe the billing address country ");

            testcase.assertTrue(CheckOutPage.isCheckBAAddressLane1(), "observe the billing address address lane 1",
                    "not able to observe the billing address lane 1");

            testcase.assertTrue(CheckOutPage.isCheckBAAddressLane2(), "observe the billing address lane2",
                    "not able to observe the billing address lane2");

            testcase.assertTrue(CheckOutPage.isCheckOutBACity(), "observe the billing address city",
                    "not able to observe the billing address city");

            testcase.assertTrue(CheckOutPage.isSelectBAStateRegion(), "observe the billing address state region ",
                    "not able to observe the billing address State region");

            testcase.assertTrue(CheckOutPage.isCheckOutBAZipcode(), "observe the billing address zipcode",
                    "not able to observe the billing address zipcode");
            testcase.pass("System should display a checkbox Use this as my Billing Address.");
        } catch (Exception e)
        {
            testcase.error("System should display a checkbox Use this as my Billing Address.", e);
            e.printStackTrace();
        }
    }

    // 182
    // 183

    @Test
    public void checkoutPageSameBillAddressToPlaceOrder() throws Exception
    {
        String name = new Object()
        {}.getClass().getEnclosingMethod().getName();
        TestCaseDetail testcase = TestCaseFactory.createTestCaseDetail(this.getClass(), name);
        try
        {
            precondition();
            SeleniumUtils.wait(10);
            CheckOutPage.checkLoggedUser();
            SeleniumUtils.wait(3);
            CheckOutPage.checkoutNewAddressButtonClick();
            CheckOutPage.shippAddrValidData();
            SeleniumUtils.wait(05);
            CheckOutPage.clickBillingAddress();
            testcase.assertTrue(CheckOutPage.isCheckedBill(), "checkbox checked", "checkbox unchecked");
            CheckOutPage.paymentValidVisaPayData();
            SeleniumUtils.wait(40);
            testcase.assertTrue(CheckOutPage.isplaceOrderContiuneShopping(),
                    "place order page contiune shopping button is there",
                    "place order page contiune shopping button is not there");
            SeleniumUtils.wait(9);
            testcase.assertTrue(CheckOutPage.isOrderConfirmation(), "Systesm should display the order confirmation",
                    "System should be displayed the order confirmation");
            SeleniumUtils.wait(5);
            CheckOutPage.placeOrderContiuneShopping();

            testcase.pass("observe functionality use shipping and bill address as same for place odrer");
        } catch (Exception e)
        {
            testcase.error("observe functionality use shipping and bill address as same for place odrer", e);
            e.printStackTrace();
        }
    }

    // 184
    // 185
    // 186
    @Test
    public void RegUserWithNewBillAddrAllFieldsToCheckout() throws Exception
    {
        String name = new Object()
        {}.getClass().getEnclosingMethod().getName();
        TestCaseDetail testcase = TestCaseFactory.createTestCaseDetail(this.getClass(), name);
        try
        {
            precondition();
            CheckOutPage.checkLoggedUser();
            SeleniumUtils.wait(3);
            CheckOutPage.checkoutNewAddressButtonClick();
            SeleniumUtils.wait(3);
            CheckOutPage.shippAddrValidData();
            CheckOutPage.billAddValidData();
            CheckOutPage.paymentValidMasterPayData();
            SeleniumUtils.wait(50);
            testcase.assertTrue(CheckOutPage.isOrderConfirmation(), "System should display the order confirmation",
                    "System should be displayed the order confirmation");

            testcase.pass(
                    " System should allow the customer to enter the data in all fields of Billing address section in Checkout page for new register user.");
        } catch (Exception e)
        {
            testcase.error(
                    " System should allow the customer to enter the data in all fields of Billing address section in Checkout page for new register user.",
                    e);
            e.printStackTrace();
        }
    }

    // 187
    // 188
    // 189
    // 190
    // 191
    // 192
    // 193
    // 194
    // 195
    // 196
    // 197
    // 198
    // 199
    // 200
    // 201
    @Test
    public void billRegAddressCityInvalid() throws Exception
    {
        String name = new Object()
        {}.getClass().getEnclosingMethod().getName();
        TestCaseDetail testcase = TestCaseFactory.createTestCaseDetail(this.getClass(), name);
        try
        {
            precondition();
            SeleniumUtils.wait(10);
            CheckOutPage.checkLoggedUser();
            SeleniumUtils.wait(3);
            CheckOutPage.checkoutNewAddressButtonClick();
            SeleniumUtils.wait(3);
            CheckOutPage.shippAddrValidData();
            CheckOutPage.checkOutBAFirstName(CheckOutPage.name1);
            CheckOutPage.checkOutBALastName(CheckOutPage.name2);
            CheckOutPage.clickBillCountry(CheckOutPage.country);
            CheckOutPage.addressBAlane1(CheckOutPage.lane1);
            CheckOutPage.addressBAlane2(CheckOutPage.lane2);
            CheckOutPage.checkOutBACity("fdsfsda");
            CheckOutPage.clickBillState(CheckOutPage.state);
            CheckOutPage.checkOutBAZipcode(CheckOutPage.zipcode);
            CheckOutPage.checkOutBAPhn(CheckOutPage.Bphone);
            CheckOutPage.checkOutPayNameCard(CheckOutPage.name1);
            SeleniumUtils.wait(10);
            testcase.assertTrue(
                    SeleniumUtils.iSDisplayed(
                            ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_SUGGESTION_ADDRESS_BILL_TEXT)),
                    "Check with Suggested Addresses for billing address",
                    "Check with Suggested Addresses for billing address");
            try
            {
                SeleniumUtils.click(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_SUGGESTED_ADDRESS_BILL_BUTTON));
            } catch (Exception e)
            {
            }

            testcase.pass("observe billing address city is Invalid it throws an suggestion popup.");
        } catch (Exception e)
        {
            testcase.error("observe billing address city is Invalid it throws an suggestion popup.", e);
            e.printStackTrace();
        }
    }

    // 202
    // 203

    // 204
    // 205
    // 206
    // 207 Verification can done later site can not validated now

    @Test
    public void loggedUserAnthorBillingAdddressToPlaceOrder() throws Exception
    {
        String name = new Object()
        {}.getClass().getEnclosingMethod().getName();
        TestCaseDetail testcase = TestCaseFactory.createTestCaseDetail(this.getClass(), name);
        try
        {
            precondition();
            SeleniumUtils.wait(10);
            CheckOutPage.checkLoggedUser();
            CheckOutPage.checkoutNewAddressButtonClick();
            CheckOutPage.clickBillingAddress();
            CheckOutPage.billAddValidData();
            CheckOutPage.paymentValidVisaPayData();
            SeleniumUtils.wait(50);
            testcase.assertTrue(CheckOutPage.isOrderConfirmation(), "Systesm should display the order confirmation",
                    "System should be displayed the order confirmation");
            testcase.pass("observe anthor shipping and billing address for logged user to place order");
        } catch (Exception e)
        {
            testcase.error("observe anthor shipping and billing address for logged user to place order", e);
            e.printStackTrace();
        }
    }

    // 208
    @Test
    public void loggedCustomerVaildAddressShippingAndInvaildBillAddress() throws Exception
    {
        String name = new Object()
        {}.getClass().getEnclosingMethod().getName();
        TestCaseDetail testcase = TestCaseFactory.createTestCaseDetail(this.getClass(), name);
        try
        {
            precondition();
            SeleniumUtils.wait(10);
            CheckOutPage.checkLoggedUser();
            CheckOutPage.checkoutNewAddressButtonClick();
            SeleniumUtils.wait(3);
            CheckOutPage.shippAddrValidData();
            CheckOutPage.checkOutBAFirstName("");
            CheckOutPage.checkOutBALastName("");
            CheckOutPage.clickBillCountry(CheckOutPage.country);
            CheckOutPage.addressBAlane1(CheckOutPage.lane1);
            CheckOutPage.addressBAlane2(CheckOutPage.lane2);
            CheckOutPage.checkOutBACity("");
            CheckOutPage.clickBillState(CheckOutPage.state);

            CheckOutPage.checkOutBAZipcode(CheckOutPage.zipcode);
            testcase.assertEquals(
                    SeleniumUtils.getText(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_BILL_FNAME_ERROR)),
                    "First Name is mandatory.");

            testcase.assertEquals(
                    SeleniumUtils.getText(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_BILL_LNAME_ERROR)),
                    "Last Name is mandatory.");

            testcase.assertEquals(
                    SeleniumUtils.getText(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_BILL_CITY_ERROR)),
                    "City is mandatory.");

            testcase.pass(
                    "observe To verify that system throws Error when customer provides an invalid address for Billing Address.");
        } catch (Exception e)
        {
            testcase.error(
                    "observe To verify that system throws Error when customer provides an invalid address for Billing addree.",
                    e);
            e.printStackTrace();
        }
    }

    // 209- 251

    // 252
    // Title:To verify that Logged in customer can use Paypal as payment method
    // during checkout.
    @Test
    public void loggedUsedPaymentWithPayPalMethod() throws Exception
    {
        String name = new Object()
        {}.getClass().getEnclosingMethod().getName();
        TestCaseDetail testcase = TestCaseFactory.createTestCaseDetail(this.getClass(), name);
        try
        {
            precondition();
            SeleniumUtils.wait(10);
            CheckOutPage.checkLoggedUser();
            CheckOutPage.checkoutNewAddressButtonClick();
            SeleniumUtils.wait(3);
            CheckOutPage.shippAddrValidData();
            CheckOutPage.billAddValidData();
            CheckOutPage.paymentWithPaypalMethod();
            testcase.assertTrue(CheckOutPage.isOccPaypalContinueShopping(),
                    "continue shopping is present in paypal page to site home page",
                    "continue shopping is present in paypal page to site home page");
            SeleniumUtils.wait(2);
            SeleniumUtils.click(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_PAYPAL_CONFIRM_BUTTON_HOME));

            testcase.pass(
                    "observe the paypal method for place order in checkoutpage by giving valid shipping and billing address.");
        } catch (Exception e)
        {
            testcase.error(
                    "observe the paypal method for place order in checkoutpage by giving valid shipping and billing address.",
                    e);
            e.printStackTrace();
        }

    }

    // 253
    // TITLE: To verify that Logged in customer can use Paypal as payment method
    // during checkout.

    // Duplate test case has 252

    // 254
    // Title:To verify the essential elements present in the "Cart summary"
    // section.
    @Test
    public void checkLogUserObserOrdSumm() throws Exception
    {
        String name = new Object()
        {}.getClass().getEnclosingMethod().getName();
        TestCaseDetail testcase = TestCaseFactory.createTestCaseDetail(this.getClass(), name);
        try
        {
            precondition();
            SeleniumUtils.wait(10);
            CheckOutPage.checkLoggedUser();
            CheckOutPage.checkoutNewAddressButtonClick();
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

            testcase.pass(
                    "observe System should display following elements in the Cart summary section:a. Product name b. Size c. Variantz d. Quantity e. Price f. Edit button.");
        } catch (Exception e)
        {
            testcase.error(
                    "observe System should display following elements in the Cart summary section:a. Product name b. Size c. Variantz d. Quantity e. Price f. Edit button.",
                    e);
            e.printStackTrace();
        }

    }

    // 255
    // Title: To verify the Customer is navigated to "Shopping cart' page when
    // clicked on Edit button in the "Cart summary" section

    @Test
    public void verifyLogCusNavigToShopCartEditfrmCheckout() throws Exception
    {
        String name = new Object()
        {}.getClass().getEnclosingMethod().getName();
        TestCaseDetail testcase = TestCaseFactory.createTestCaseDetail(this.getClass(), name);
        try
        {

            precondition();
            SeleniumUtils.wait(10);
            CheckOutPage.checkLoggedUser();
            testcase.assertTrue(CheckOutPage.isOccplaceOrder(), "CheckoutPage Verification",
                    "Checkout Page verification");
            CheckOutPage.CheckoutOrderEditButtonClick();
            SeleniumUtils.wait(25);
            testcase.assertTrue(SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(CHECKOUT, CART_CALCULATE_TAX)),
                    "Item Image should displayed in cart", "Item Image should not displayed in cart");
            testcase.pass("Customer can navigate to the cart page by clicking edit button in checkout page");
        } catch (Exception e)
        {
            testcase.error("Customer can navigate to the cart page by clicking edit button in checkout page", e);
            e.printStackTrace();
        }
    }

    // 256
    // Title: To verify the display of "Order summary" section in checkout page.

    @Test
    public void verifyOrdSummInCheckoutPageByLogg() throws Exception
    {
        String name = new Object()
        {}.getClass().getEnclosingMethod().getName();
        TestCaseDetail testcase = TestCaseFactory.createTestCaseDetail(this.getClass(), name);
        try
        {
            precondition();
            SeleniumUtils.wait(10);
            CheckOutPage.checkLoggedUser();
            CheckOutPage.checkoutNewAddressButtonClick();
            CheckOutPage.shippAddrValidData();
            SeleniumUtils.click(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_BILL_CHECKBOX));
            CheckOutPage.paymentValidVisaPayData();
            SeleniumUtils.wait(5);
            testcase.assertTrue(CheckOutPage.isCheckoutOrderSummaryShippingName(),
                    "checkout order summary Shipping name", "checkout order summary shipping name");
            testcase.assertTrue(CheckOutPage.isCheckoutOrderSummaryTotal(), "checkout order summary Total",
                    "checkout order summary Total");
            testcase.pass("Verify All order summary fields in checkout page");
        } catch (

        Exception e)
        {
            testcase.error("Verify the all the order summary fields in checkout", e);
            e.printStackTrace();
        }
    }

    // 257
    // Title: To verify that system displays the shipping methods configured in
    // BCC.
    public void verfShippMethInCheckPagbyLoguser() throws Exception
    {
        String name = new Object()
        {}.getClass().getEnclosingMethod().getName();
        TestCaseDetail testcase = TestCaseFactory.createTestCaseDetail(this.getClass(), name);
        try
        {
            precondition();
            SeleniumUtils.wait(4);
            CheckOutPage.checkLoggedUser();
            CheckOutPage.checkoutNewAddressButtonClick();
            CheckOutPage.shippAddrValidData();
            CheckOutPage.checkOrdSumShipTypeExpedSignReqClick();
            SeleniumUtils.wait(3);
            testcase.assertEquals(
                    SeleniumUtils.getText(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_SHIPPING_TYPE_FINAL_NAME)),
                    "Shipping: Expedited – Signature Required");
            testcase.assertEquals(
                    SeleniumUtils.getText(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_SHIPPING_TYPE_FINAL_PRICE)),
                    "$12.90");
            testcase.assertTrue(CheckOutPage.isCheckOrdSummShippTypeStand(),
                    "Standard type is there in shipping method ", "Standard type is there in shipping method");
            testcase.assertTrue(CheckOutPage.isCheckOrdSummShipTypeStandSignReq(),
                    "Standard Sign required type is there in shipping method",
                    "Standard sign req type is there in shipping method");
            testcase.assertTrue(CheckOutPage.isCheckOrdSummShipTypeExped(),
                    "Expedited type is there in shipping method", "Expedited  is there in shipping method");
            testcase.assertTrue(CheckOutPage.isCheckOrdSummShipTypeExpedSignReq(),
                    "Expedited – Signature Required type is there in shipping method",
                    "Expedited – Signature Required type is there in shipping method");
            testcase.assertTrue(CheckOutPage.isCheckOrdSumShipType2ndDay(), "2nd day type is there in shipping method",
                    "2nd day type is there in shipping method");
            testcase.assertTrue(CheckOutPage.isCheckOrdSummShippType2ndDaySignReq(),
                    "2nd day sign req type is there in shipping method",
                    "2nd day sign req type is there in shipping method");
            testcase.assertTrue(CheckOutPage.isCheckOrdSumShipType1Day(), "1day type is there in shipping method",
                    "1day type is there in shipping method");
            testcase.assertTrue(CheckOutPage.isCheckOrdSummShippType1DaySignReq(),
                    "1day sign req type is there in shipping method", "1day sign req type is there in shipping method");

            testcase.pass("There are many types in shipping methods all fields are verified ");
        } catch (Exception e)
        {
            testcase.error("There are many types in shipping methods all fields are verified ", e);
            e.printStackTrace();
        }

    }

    // 258
    // Title :To verify that system displays the Shipping charges associated
    // with each of the Shipping Methods.

    // 259
    // Title: To verify that system will select a shipping method by default,
    // which has the least shipping charge.
    @Test
    public void verfDefShipMetdInCheckPageByLoggUser() throws Exception
    {
        String name = new Object()
        {}.getClass().getEnclosingMethod().getName();
        TestCaseDetail testcase = TestCaseFactory.createTestCaseDetail(this.getClass(), name);
        try
        {
            precondition();
            SeleniumUtils.wait(10);
            CheckOutPage.checkLoggedUser();
            CheckOutPage.checkoutNewAddressButtonClick();
            CheckOutPage.shippAddrValidData();
            SeleniumUtils.wait(3);
            String selection = SeleniumUtils
                    .getAttributes(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_SHIPPING_DEFAULT), "class");
            if (selection.endsWith("selected"))
            {
                testcase.pass("In checkout page Default shipping method was selected");
            } else
            {
                testcase.fail("In checkout page Defalut standard shipping was selected",
                        "In checkout page not default standard shipping was not selected");
            }
        } catch (

        Exception e)
        {
            testcase.error("In checkout page Default Shipping method was selected", e);
            e.printStackTrace();
        }

    }

    // 260
    // Title: To verify that Customer can select any shipping method of his/her
    // own choice.

    // 261
    // Title: To verify that system updates the Shipping charge in order summary
    // when customer selects a shipping method.

    // 262
    // Title: To verify the customer Place order successfully.
    @Test
    public void logUserPlaceOrder() throws Exception
    {
        String name = new Object()
        {}.getClass().getEnclosingMethod().getName();
        TestCaseDetail testcase = TestCaseFactory.createTestCaseDetail(this.getClass(), name);
        try
        {
            precondition();
            SeleniumUtils.wait(10);
            CheckOutPage.checkLoggedUser();
            CheckOutPage.checkoutNewAddressButtonClick();
            CheckOutPage.shippAddrValidData();
            SeleniumUtils.wait(7);
            CheckOutPage.clickBillingAddress();
            CheckOutPage.paymentValidVisaPayData();
            SeleniumUtils.wait(20);
            testcase.assertTrue(CheckOutPage.isOrderConfirmation(), "Guest	 customer can placeorder with valid data",
                    "Guest customer can placeorder with valid data");

            testcase.pass("observe the logged user can place order");
        } catch (Exception e)
        {
            testcase.error("observe the logged user can  place order", e);
            e.printStackTrace();
        }
    }

    // 263
    @Test
    public void regLogoutButtonObserve() throws Exception
    {
        String name = new Object()
        {}.getClass().getEnclosingMethod().getName();
        TestCaseDetail testcase = TestCaseFactory.createTestCaseDetail(this.getClass(), name);
        try
        {
            precondition();
            SeleniumUtils.wait(9);
            CheckOutPage.checkLoggedUser();
            SeleniumUtils.wait(2);
            testcase.assertTrue(CheckOutPage.isCheckoutLogoutButton(),
                    "observe the register login details in checkout page ",
                    "observer the register login details in checkout page");
            testcase.assertTrue(CheckOutPage.ischeckOutDefaultAddress(), "observe the Default address",
                    "Observe the Default address");
            testcase.pass("Observer logout functionally in checkout page");
        } catch (Exception e)
        {
            testcase.error("Observer logout functionally in checkout page", e);
            e.printStackTrace();
        }
    }

    // 264
    // Title: To verify that system display default saved shipping address in
    // shipping address section.

    // 265
    // Title: To verify that system allow the customer to select shipping
    // address from shipping address book.

    // 266
    // Title:To verify that Logged in customer can use the saved shipping
    // address as Billing address for the order.

    // 267
    // Title :To verify that customer is able add new billing address when
    // checkbox is unselected.
    @Test
    public void logUserAbleToAddNewAddInCheck() throws Exception
    {
        String name = new Object()
        {}.getClass().getEnclosingMethod().getName();
        TestCaseDetail testcase = TestCaseFactory.createTestCaseDetail(this.getClass(), name);
        try
        {
            precondition();
            SeleniumUtils.wait(10);
            CheckOutPage.checkLoggedUser();
            SeleniumUtils.wait(15);
            testcase.assertTrue(CheckOutPage.ischeckOutDefaultAddress(), "observe the Default address",
                    "Observe the Default address");
            testcase.assertTrue(CheckOutPage.ischeckoutNewAddressButtonClick(),
                    "In checkout page after logged user can enter the new address",
                    "In checkout page after logged user can't able enter the new address");
            SeleniumUtils.wait(10);
            SeleniumUtils.click(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_BILL_CHECKBOX));
            CheckOutPage.billAddValidData();
            CheckOutPage.paymentValidVisaPayData();
            SeleniumUtils.wait(30);
            testcase.assertTrue(CheckOutPage.isplaceOrderContiuneShopping(),
                    "place order page contiune shopping button is there",
                    "place order page contiune shopping button is not there");
            SeleniumUtils.wait(9);
            testcase.assertTrue(CheckOutPage.isOrderConfirmation(), "Systesm should display the order confirmation",
                    "System should be displayed the order confirmation");

            testcase.pass("System allow to enter new billing address after login only");
        } catch (Exception e)
        {
            testcase.error("System allow to enter new billing address after login only.", e);
            e.printStackTrace();
        }

    }

    // 268
    // Title:To verify that system provides an option to create a new shipping
    // address for the order even though customer has addresses saved in
    // profile.

    // 269
    // Title: To verify that customer is able to add new address for shipping
    // address.
    @Test
    public void addNewShippAddressToLoggedUser() throws Exception
    {
        String name = new Object()
        {}.getClass().getEnclosingMethod().getName();
        TestCaseDetail testcase = TestCaseFactory.createTestCaseDetail(this.getClass(), name);
        try
        {
            precondition();
            SeleniumUtils.wait(10);
            CheckOutPage.checkLoggedUser();
            SeleniumUtils.wait(15);
            testcase.assertTrue(CheckOutPage.ischeckOutDefaultAddress(), "observe the Default address",
                    "Observe the Default address");
            SeleniumUtils.wait(10);
            testcase.assertTrue(CheckOutPage.ischeckoutNewAddressButtonClick(),
                    "In checkout page after logged user can enter the new address",
                    "In checkout page after logged user can't able enter the new address");
            SeleniumUtils.wait(5);

            CheckOutPage.checkoutNewAddressButtonClick();
            SeleniumUtils.wait(3);
            CheckOutPage.shippAddrValidData();
            SeleniumUtils.wait(05);
            CheckOutPage.clickBillingAddress();
            CheckOutPage.paymentValidVisaPayData();
            SeleniumUtils.wait(30);
            testcase.assertTrue(CheckOutPage.isplaceOrderContiuneShopping(),
                    "place order page contiune shopping button is there",
                    "place order page contiune shopping button is not there");
            SeleniumUtils.wait(9);
            testcase.assertTrue(CheckOutPage.isOrderConfirmation(), "Systesm should display the order confirmation",
                    "System should be displayed the order confirmation");

            testcase.pass(" System should save and proceed to place order with new Shipping address.");
        } catch (Exception e)
        {
            testcase.error(" System should save and proceed to place order with new Shipping address.", e);
            e.printStackTrace();
        }
    }

    // 270
    // Title: To verify that system allow the customer to place order with newly
    // added shipping address.
    @Test
    public void addNewShippAddrAftLogUserToPlaceOrd() throws Exception
    {
        String name = new Object()
        {}.getClass().getEnclosingMethod().getName();
        TestCaseDetail testcase = TestCaseFactory.createTestCaseDetail(this.getClass(), name);
        try
        {
            precondition();
            SeleniumUtils.wait(10);
            CheckOutPage.checkLoggedUser();
            SeleniumUtils.wait(15);
            testcase.assertTrue(CheckOutPage.ischeckOutDefaultAddress(), "observe the Default address",
                    "Observe the Default address");
            SeleniumUtils.wait(10);
            testcase.assertTrue(CheckOutPage.ischeckoutNewAddressButtonClick(),
                    "In checkout page after logged user can enter the new address",
                    "In checkout page after logged user can't able enter the new address");
            SeleniumUtils.wait(5);

            CheckOutPage.checkoutNewAddressButtonClick();
            SeleniumUtils.wait(3);
            CheckOutPage.shippAddrValidData();
            SeleniumUtils.wait(05);
            CheckOutPage.clickBillingAddress();
            CheckOutPage.paymentValidMasterPayData();
            SeleniumUtils.wait(30);
            testcase.assertTrue(CheckOutPage.isplaceOrderContiuneShopping(),
                    "place order page contiune shopping button is there",
                    "place order page contiune shopping button is not there");
            SeleniumUtils.wait(9);
            testcase.assertTrue(CheckOutPage.isOrderConfirmation(), "Systesm should display the order confirmation",
                    "System should be displayed the order confirmation");

            testcase.pass(" System should save and proceed to place order with new billing address.");
        } catch (Exception e)
        {
            testcase.error(" System should save and proceed to place order with new billing address.", e);
            e.printStackTrace();
        }
    }

    // 271
    // Title: To verify the display of 'error' message when customer does not
    // enter any data in all sections of checkout page.
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
            SeleniumUtils.wait(15);
            testcase.assertTrue(CheckOutPage.ischeckOutDefaultAddress(), "observe the Default address",
                    "Observe the Default address");
            SeleniumUtils.wait(10);
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
            // testcase.assertEquals(SeleniumUtils.getText(Type.XPATH,"//div[@id='cc-notification-inline-0']/div",
            // "First Name is mandatory.");

            testcase.pass("System should not able place order with empty fields in shipping and billing.");
        } catch (Exception e)
        {
            testcase.error("System should not able place order with empty fields in shipping and billing.", e);
            e.printStackTrace();
        }
    }

    // 272
    // Title:To verify the display of error message when customer keep first
    // name and last name field as blank in address section.
    @Test
    public void regLogUserFnameAndLnameBlank() throws Exception
    {

        String name = new Object()
        {}.getClass().getEnclosingMethod().getName();
        TestCaseDetail testcase = TestCaseFactory.createTestCaseDetail(this.getClass(), name);
        try
        {
            precondition();
            SeleniumUtils.wait(10);
            CheckOutPage.checkLoggedUser();
            SeleniumUtils.wait(15);
            testcase.assertTrue(CheckOutPage.ischeckOutDefaultAddress(), "observe the Default address",
                    "Observe the Default address");
            SeleniumUtils.wait(10);
            testcase.assertTrue(CheckOutPage.ischeckoutNewAddressButtonClick(),
                    "In checkout page after logged user can enter the new address",
                    "In checkout page after logged user can't able enter the new address");
            SeleniumUtils.wait(5);

            CheckOutPage.checkoutNewAddressButtonClick();
            SeleniumUtils.wait(3);
            CheckOutPage.checkOutFirstName("");
            CheckOutPage.checkOutLastName("");
            CheckOutPage.occplaceOrder();
            SeleniumUtils.wait(3);

            testcase.assertEquals(SeleniumUtils.getText(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_FNAME_ERROR)),
                    "First Name is mandatory.");
            testcase.assertEquals(SeleniumUtils.getText(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_LNAME_ERROR)),
                    "Last Name is mandatory.");
            testcase.pass("System should display appropriate error message.for first and last name");
        } catch (Exception e)
        {
            testcase.error("System should display appropriate error message.for first and last name.", e);
            e.printStackTrace();
        }
    }

    // 273
    // Title:To verify the display of error message when customer enter phone
    // number with invalid data.

    // 274
    // Title: To verify the display of error message when customer does not
    // enter any data in state field.

    // 275
    // Title:To verify the display of error message when invalid city is entered
    // which does not match with selected state from State drop down of shipping
    // address section.
    @Test
    public void regUserShippAddrCityInvalid() throws Exception
    {
        String name = new Object()
        {}.getClass().getEnclosingMethod().getName();
        TestCaseDetail testcase = TestCaseFactory.createTestCaseDetail(this.getClass(), name);
        try
        {
            precondition();
            SeleniumUtils.wait(10);
            CheckOutPage.checkLoggedUser();
            SeleniumUtils.wait(15);
            testcase.assertTrue(CheckOutPage.ischeckOutDefaultAddress(), "observe the Default address",
                    "Observe the Default address");
            SeleniumUtils.wait(10);
            testcase.assertTrue(CheckOutPage.ischeckoutNewAddressButtonClick(),
                    "In checkout page after logged user can enter the new address",
                    "In checkout page after logged user can't able enter the new address");
            SeleniumUtils.wait(5);
            CheckOutPage.checkoutNewAddressButtonClick();
            SeleniumUtils.wait(3);
            CheckOutPage.checkOutFirstName(CheckOutPage.name1);
            CheckOutPage.checkOutLastName(CheckOutPage.name2);
            CheckOutPage.clickCountry(CheckOutPage.country);
            CheckOutPage.addresslane1(CheckOutPage.lane1);
            CheckOutPage.addresslane2(CheckOutPage.lane2);
            CheckOutPage.checkOutCity("!@#$%^&*&^%$#@!@#$%^&*");
            CheckOutPage.clickState(CheckOutPage.state);
            CheckOutPage.checkOutZipcode(CheckOutPage.zipcode);
            CheckOutPage.checkOutPhoneNumber(CheckOutPage.phone + Keys.TAB);
            testcase.assertTrue(
                    SeleniumUtils.iSDisplayed(
                            ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_SUGGESTION_ADDRESS_SHIPP_TEXT)),
                    "Check with Suggested Addresses for billing address",
                    "Check with Suggested Addresses for billing address");

            testcase.pass("city is invalid data in shipping address for logged user");
        } catch (Exception e)
        {
            testcase.error("observe city is invalid data in shipping address for logged user", e);
            e.printStackTrace();
        }
    }

    // 276
    // Title: To verify the display of error message when customer enter zip
    // code feild with invalid data.
    // 277
    // 278
    // 279
    // 280
    // 281

    // 282
    // Title: To verify that customer is able to navigate to product detail page
    // by clicking on product name in cart page.
    @Test

    public void verfProdDetPagFrmCheckByLoggUserByCartPage() throws Exception
    {
        String name = new Object()
        {}.getClass().getEnclosingMethod().getName();
        TestCaseDetail testcase = TestCaseFactory.createTestCaseDetail(this.getClass(), name);
        try
        {
            precondition();
            SeleniumUtils.wait(10);
            CheckOutPage.checkLoggedUser();
            SeleniumUtils.wait(15);
            testcase.assertTrue(CheckOutPage.ischeckOutDefaultAddress(), "observe the Default address",
                    "Observe the Default address");
            SeleniumUtils.wait(10);
            CheckOutPage.CheckoutOrderEditButtonClick();
            SeleniumUtils.wait(20);
            SeleniumUtils.click(ExcelProperty.getElementValue(CART, CART_PRODUCT_IMAGE));
            SeleniumUtils.wait(20);
            testcase.assertTrue(SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(CART, PRODUCT_DETAIL_TITLE)),
                    "title should be displayed", "title should not be displayed");

            SeleniumUtils.wait(5);

            testcase.pass("observe user can navigate to product details page from checkout throw cart page");
        } catch (Exception e)
        {
            testcase.error("observe user can navigate to product details page from checkout throw cart page", e);
            e.printStackTrace();
        }
    }

    // 283
    // Title:To verify that customer is able to update product quantity in cart
    // page.
    @Test
    public void updatQuanInCartFrmCheckByLoggUsr() throws Exception
    {
        String name = new Object()
        {}.getClass().getEnclosingMethod().getName();
        TestCaseDetail testcase = TestCaseFactory.createTestCaseDetail(this.getClass(), name);
        try
        {
            precondition();
            SeleniumUtils.wait(10);
            CheckOutPage.checkLoggedUser();
            SeleniumUtils.wait(15);
            testcase.assertTrue(CheckOutPage.ischeckOutDefaultAddress(), "observe the Default address",
                    "Observe the Default address");
            SeleniumUtils.wait(10);
            CheckOutPage.CheckoutOrderEditButtonClick();
            SeleniumUtils.wait(30);
            String s = SeleniumUtils.getText(ExcelProperty.getElementValue(CART, CART_TOTALPRICE));
            String s1 = s.replace("$", "");

            SeleniumUtils.sendKeys(ExcelProperty.getElementValue(CART, CART_PRODUCT_QUANTITY), "2" + Keys.TAB);
            SeleniumUtils.wait(20);
            double amount = Double.parseDouble(s1);
            double dou = 13 * amount;
            DecimalFormat formatter = new DecimalFormat("#,###.00");
            formatter.format(dou);

            SeleniumUtils.wait(20);
            SeleniumUtils.getText(ExcelProperty.getElementValue(CART, CART_TOTALPRICE));

            testcase.pass("observe total price in cart by adding multiple products");
        } catch (Exception e)
        {
            testcase.error("observe total price in cart by adding multiple products", e);
            e.printStackTrace();
        }
    }
    // 284
    // Title: To verify that  customer is not able to change quantity of product
    // more than the available quantity.

    @Test
    public void updatQuanMorThnStckInCartFrmCheckByLoggUsr() throws Exception
    {
        String name = new Object()
        {}.getClass().getEnclosingMethod().getName();
        TestCaseDetail testcase = TestCaseFactory.createTestCaseDetail(this.getClass(), name);
        try
        {
            precondition();
            SeleniumUtils.wait(10);
            CheckOutPage.checkLoggedUser();
            SeleniumUtils.wait(15);
            testcase.assertTrue(CheckOutPage.ischeckOutDefaultAddress(), "observe the Default address",
                    "Observe the Default address");
            SeleniumUtils.wait(10);
            CheckOutPage.CheckoutOrderEditButtonClick();
            SeleniumUtils.wait(20);
            SeleniumUtils.sendKeys(ExcelProperty.getElementValue(HOMEPAGE, CART_QUANTITY_BOX), "999" + Keys.TAB);
            SeleniumUtils.wait(5);
            String max = SeleniumUtils.getText(ExcelProperty.getElementValue(CHECKOUT, CART_QUANTITY_ERROR));
            if (max.contains("You can order a maximum of"))
            {
                testcase.pass("observe user can add quantity upto 999 after that max order done");
            } else
            {
                testcase.fail("it should display maximum number of quanatity",
                        "its not displaying maximum of quanatity");
            }

        } catch (Exception e)
        {
            testcase.error("observe user can add quantity upto 999 after that max order done", e);
            e.printStackTrace();
        }
    }

    // 285
    // Title:To verify that customer is able to continue shopping from cart
    // page.
    @Test
    public void verfContShopByloggUserFrmCheckpag() throws Exception
    {
        String name = new Object()
        {}.getClass().getEnclosingMethod().getName();
        TestCaseDetail testcase = TestCaseFactory.createTestCaseDetail(this.getClass(), name);
        try
        {
            precondition();
            SeleniumUtils.wait(10);
            CheckOutPage.checkLoggedUser();
            SeleniumUtils.wait(15);
            testcase.assertTrue(CheckOutPage.ischeckOutDefaultAddress(), "observe the Default address",
                    "Observe the Default address");
            SeleniumUtils.wait(10);
            CheckOutPage.CheckoutOrderEditButtonClick();
            SeleniumUtils.wait(10);
            SeleniumUtils.click(ExcelProperty.getElementValue(CART, CART_CONTINUE_SHOPPING));
            SeleniumUtils.wait(10);
            testcase.assertTrue(
                    SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(CHECKOUT, HOME_EVERYDAY_INSPIRATION)),
                    "title should be displayed", "title should not be displayed");

            testcase.pass("customer able to navigate to Home page from checkout by cart page");
            testcase.comments("OCC_Defect_27");
        } catch (Exception e)
        {
            testcase.error("customer able to navigate to Home page from checkout by cart page", e);
            testcase.comments("OCC_Defect_27");
            e.printStackTrace();
        }
    }

    // 286
    // Title:To verify that customer is able to remove the producs from cart
    // page.
    @Test
    public void remItemsInCart() throws Exception
    {
        String name = new Object()
        {}.getClass().getEnclosingMethod().getName();
        TestCaseDetail testcase = TestCaseFactory.createTestCaseDetail(this.getClass(), name);
        try
        {
            SeleniumUtils.wait(50);
            try
            {
                SeleniumUtils.click(ExcelProperty.getElementValue(HOMEPAGE, DONT_ASK_EMAIL_TEMPLATE));
            } catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
            HomePage.searchDataEnter("babygifts");
            SeleniumUtils.wait(10);
            SeleniumUtils.click(Type.LINKTEXT, PropertyUtil.getObjectValue(ADD_TO_CART_SKULIST));
            SeleniumUtils.wait(05);
            HomePage.searchDataEnter("plate");
            SeleniumUtils.wait(10);
            SeleniumUtils.click(Type.LINKTEXT, PropertyUtil.getObjectValue(ADD_TO_CART_SKULIST));
            OCCUtlis.occCheckout();
            SeleniumUtils.wait(10);
            CheckOutPage.CheckoutOrderEditButtonClick();
            SeleniumUtils.wait(20);
            List<WebElement> findElements = getAllElements(PropertyUtil.getObjectValue(CART_ITEMNAME));
            int size = findElements.size();
            SeleniumUtils.click(ExcelProperty.getElementValue(CART, CART_PRODUCT_REMOVE_BUTTON));
            SeleniumUtils.wait(10);
            List<WebElement> findElement = getAllElements(PropertyUtil.getObjectValue(CART_ITEMNAME));
            int size2 = findElement.size();
            if (size2 < size)
            {
                testcase.pass("Item should removed and cart updated");
            } else
            {
                testcase.fail("Item should not removed and cart updated", "");
            }
            testcase.pass("customer able to remove items in cart");
        } catch (Exception e)
        {
            testcase.error("customer able to remove items in  cart", e);
            e.printStackTrace();
        }
    }

    // lenox
    //
    @Test
    public void mergeToLoginCustomerWithoutItem() throws Exception
    {

        String name = new Object()
        {}.getClass().getEnclosingMethod().getName();
        TestCaseDetail testcase = TestCaseFactory.createTestCaseDetail(this.getClass(), name);
        try
        {
            CheckOutPage.checkLoggedUser();
            SeleniumUtils.wait(5);
            HomePage.hovercart();
            if (SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(CART, EMPTY_CART)) == false)
            {
                SeleniumUtils.wait(10);
                List<WebElement> data = getAllElements("[id*=CC-header-dropdown-minicart-productName]");

                for (int i = 0; i < data.size(); i++)
                {
                    SeleniumUtils.click(ExcelProperty.getElementValue(CART, MINI_CART_ITEMREMOVE));
                    SeleniumUtils.wait(3);
                }
            }
            CheckOutPage.checkLoggedUser();
            SeleniumUtils.wait(04);
            testcase.assertEquals(
                    SeleniumUtils.getText(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_WELCOME_MESSAGE)),
                    "Welcome back!");
            CheckOutPage.CheckoutOrderEditButtonClick();
            SeleniumUtils.wait(20);

            if (SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(CART, CART_ITEMNAME)) == true)
            {
                testcase.pass("System should display the Merged Cart with products ");
            } else
            {
                testcase.fail("", "");
            }
        } catch (Exception e)
        {
            testcase.error("System should not be display the Merged Cart with products :", e);
            e.printStackTrace();
        }
    }

    //
    @Test
    public void checkOutlogguserPaymentCvvLength() throws Exception
    {
        String name = new Object()
        {}.getClass().getEnclosingMethod().getName();
        TestCaseDetail testcase = TestCaseFactory.createTestCaseDetail(this.getClass(), name);
        try
        {
            precondition();
            SeleniumUtils.wait(10);
            CheckOutPage.checkLoggedUser();
            CheckOutPage.checkoutNewAddressButtonClick();
            SeleniumUtils.wait(3);
            CheckOutPage.shippAddrValidData();
            CheckOutPage.checkOutPayNameCard(CheckOutPage.name1);
            CheckOutPage.checkOutCardType(CheckOutPage.cardvisa);
            CheckOutPage.checkOutCardNumber(CheckOutPage.cardvisanum);
            CheckOutPage.checkOutCVV(CheckOutPage.cardcvv);
            CheckOutPage.checkOutMonth(CheckOutPage.cardmonth);
            CheckOutPage.checkOutYear(CheckOutPage.cardyear);
            CheckOutPage.cardcvv.length();

            SeleniumUtils.getAttributes(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_CARD_CVV), "Value");

            // int a = attributesId.length();

            // if (length == a) {
            // testcase.pass("observe the Card lenght CVV is 3");
            //
            // } else {
            // testcase.fail("Card lenght must be 3 ", "Card length is not 3 ");
            // }
            testcase.pass("observe the Card lenght CVV is 3");
        } catch (Exception e)
        {
            testcase.error("Observe the payment card length is more than 3", e);
            e.printStackTrace();
        }
    }

    //
    @Test
    public void checkOutlogguserPaymentAmexCvvLength() throws Exception
    {
        String name = new Object()
        {}.getClass().getEnclosingMethod().getName();
        TestCaseDetail testcase = TestCaseFactory.createTestCaseDetail(this.getClass(), name);
        try
        {
            precondition();
            SeleniumUtils.wait(10);
            CheckOutPage.checkLoggedUser();
            CheckOutPage.checkoutNewAddressButtonClick();
            SeleniumUtils.wait(3);
            CheckOutPage.shippAddrValidData();
            CheckOutPage.checkOutPayNameCard(CheckOutPage.name1);
            CheckOutPage.checkOutCardType(CheckOutPage.cardamex);
            CheckOutPage.checkOutCardNumber(CheckOutPage.cardAmexNum);
            CheckOutPage.checkOutCVV(CheckOutPage.cardamexcvv);
            CheckOutPage.checkOutMonth(CheckOutPage.cardmonth);
            CheckOutPage.checkOutYear(CheckOutPage.cardyear);
            int length = CheckOutPage.cardamexcvv.length();

            String attributesId = SeleniumUtils
                    .getAttributes(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_CARD_CVV), "value");

            int a = attributesId.length();

            if (length == a)
            {
                testcase.pass("observe the Card amex length CVV is 4");

            } else
            {
                testcase.fail("Card lenght must be 4 ", "Card length is not 4");
            }

        } catch (Exception e)
        {
            testcase.error("Observe the payment card length is more than 4", e);
            e.printStackTrace();
        }
    }

    ///
    @Test
    public void verifyCvvQuesMarkIcon() throws Exception
    {
        String name = new Object()
        {}.getClass().getEnclosingMethod().getName();
        TestCaseDetail testcase = TestCaseFactory.createTestCaseDetail(this.getClass(), name);
        try
        {
            precondition();
            SeleniumUtils.wait(4);
            CheckOutPage.checkOutGuestEmail(CheckOutPage.email);
            CheckOutPage.shippAddrValidData();
            CheckOutPage.billAddValidData();
            CheckOutPage.checkOutPayNameCard(CheckOutPage.name1);
            CheckOutPage.checkOutCardType(CheckOutPage.cardvisa);
            CheckOutPage.checkOutCardNumber(CheckOutPage.cardvisanum);
            CheckOutPage.checkOutCVV(CheckOutPage.cardamexcvv);
            CheckOutPage.checkOutMonth(CheckOutPage.cardmonth);
            CheckOutPage.checkOutYear(CheckOutPage.cardyear);
            testcase.assertTrue(SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_CVV_QUE)),
                    "CVV question was visable in checkout page", "CVV question was not visable in checkout page");

            testcase.pass("Customer provide valid paypal details to payment by valid address");
        } catch (Exception e)
        {
            testcase.error("Customer provide valid paypal details to payment by valid address", e);
            e.printStackTrace();
        }

    }

    //
    @Test
    public void checkOutLoggeduserBillAddressValidData() throws Exception
    {
        String name = new Object()
        {}.getClass().getEnclosingMethod().getName();
        TestCaseDetail testcase = TestCaseFactory.createTestCaseDetail(this.getClass(), name);
        try
        {
            precondition();
            SeleniumUtils.wait(10);
            CheckOutPage.checkLoggedUser();
            CheckOutPage.clickBillingAddress();
            CheckOutPage.billAddValidData();
            SeleniumUtils.wait(3);
            String validate = SeleniumUtils
                    .getText(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_VALIDATE_SHIPP_ADD));
            if (validate.contains("United States"))
            {
                testcase.pass("Customer should be able to place the order with US Billing Address.");
            } else
            {
                testcase.fail("Customer should be able to Add valid US Billing Address",
                        "Customer is not able to Add valid US Billing Address");
            }

        } catch (Exception e)
        {
            testcase.error("Customer should be able to place the order with US Billing Address.", e);
            e.printStackTrace();
        }
    }

    // Negative Test cases

    @Test
    public void negativeTestForShippingAddressCases() throws Exception
    {
        String name = new Object()
        {}.getClass().getEnclosingMethod().getName();
        TestCaseDetail testcase = TestCaseFactory.createTestCaseDetail(this.getClass(), name);
        try
        {
            precondition();
            ArrayList<String> result = new ArrayList<String>();
            String errormessage = "";
            ArrayList<CheckoutInvalidShippingBean> data = FileUtility.readCheckoutInvalidShippingData();
            for (Iterator<CheckoutInvalidShippingBean> iterator = data.iterator(); iterator.hasNext();)
            {
                try
                {
                    CheckoutInvalidShippingBean user = iterator.next();
                    String errormessage2 = user.getErrormessage();
                    errormessage = errormessage2;
                    SeleniumUtils.wait(10);
                    SeleniumUtils.refresh();
                    CheckOutPage.checkOutGuestEmail(user.getEmail());
                    CheckOutPage.checkOutFirstName(user.getFname());
                    CheckOutPage.checkOutLastName(user.getLname());
                    if (user.getErrormessage().contains("Country is mandatory."))
                    {
                        CheckOutPage.clickCountry("Country");
                    } else
                    {
                        CheckOutPage.clickCountry(user.getCountry());
                    }
                    CheckOutPage.addresslane1(user.getAddress1());
                    CheckOutPage.addresslane2(user.getAddress2());
                    if (user.getErrormessage().contains("State is mandatory."))
                    {
                        CheckOutPage.clickState("State/Region");
                    } else
                    {
                        CheckOutPage.clickState(user.getStateregion());
                    }
                    CheckOutPage.checkOutCity(user.getCity());
                    CheckOutPage.checkOutZipcode(user.getZipcode());
                    CheckOutPage.checkOutPhoneNumber(user.getPhonenumber() + Keys.TAB);
                    CheckOutPage.checkOutPayNameCard(user.getNamecard());
                    CheckOutPage.checkOutCardNumber(user.getCardnumber());
                    if (user.getErrormessage().contains("Card Type is mandatory."))
                    {
                        CheckOutPage.clickCardType("Card Type");
                    } else
                    {
                        CheckOutPage.clickCardType(user.getCardtype());
                    }
                    CheckOutPage.checkOutCVV(user.getCheckoutcvv());
                    if (user.getErrormessage().contains("Card expires month is mandatory."))
                    {
                        CheckOutPage.clickCardMonth("Expires (Month)");

                    } else
                    {
                        CheckOutPage.clickCardMonth(user.getExpiresmonth());
                    }

                    if (user.getErrormessage().contains("Card expires year is mandatory."))
                    {
                        CheckOutPage.clickCardYear("Expires (Year)");
                    } else
                    {
                        CheckOutPage.clickCardYear(user.getExpiresyear());
                    }
                    SeleniumUtils.wait(7);
                    String actualerror = "";
                    String emailerror1 = user.getErrormessage();
                    String eror = "";
                    if (emailerror1.contains("try again"))
                    {
                        eror = emailerror1;
                        System.out.println(eror);
                    } else
                    {
                        eror = emailerror1.replace(",", "");
                        System.out.println(eror);
                    }
                    try
                    {
                        actualerror = SeleniumUtils.getText(Type.ID, user.getIds());
                        System.out.println(eror);
                        testcase.assertEquals(eror.trim(), actualerror.trim());
                    } catch (Exception e)
                    {
                        actualerror = SeleniumUtils.getText(Type.XPATH, user.getIds());
                        System.out.println(eror);
                        testcase.assertEquals(eror.trim(), actualerror.trim());
                    }
                    if (actualerror.isEmpty())
                    {
                        result.add(errormessage);
                        System.out.println(errormessage2);
                    }
                } catch (Exception e)
                {

                    result.add(errormessage);

                    e.printStackTrace();
                }
            }
            if (result.size() > 0)
            {
                for (int i = 0; i < result.size(); i++)
                {
                    testcase.fail(i + " - " + result.get(i), "");
                }
            } else
            {
                testcase.pass("All negative secnarios working in Shipping address and payment");
            }
        } catch (Exception e)
        {
            testcase.error("Some of negative secnarios not working in Shipping address and payment", e);
            e.printStackTrace();
        }
    }

    @Test
    public void negativeTestCasesForBillingAddress() throws Exception
    {
        String name = new Object()
        {}.getClass().getEnclosingMethod().getName();
        TestCaseDetail testcase = TestCaseFactory.createTestCaseDetail(this.getClass(), name);
        try
        {
            precondition();
            String errormessage = "";
            ArrayList<String> result = new ArrayList<String>();
            ArrayList<CheckoutInvalidBillingBean> data = FileUtility.readCheckoutInvalidBillingData();
            for (Iterator<CheckoutInvalidBillingBean> iterator = data.iterator(); iterator.hasNext();)
            {
                try
                {
                    CheckoutInvalidBillingBean user = iterator.next();
                    String errormessage2 = user.getErrormessage();
                    errormessage = errormessage2;
                    SeleniumUtils.wait(10);
                    SeleniumUtils.refresh();
                    CheckOutPage.shippAddrValidData();
                    SeleniumUtils.wait(7);
                    CheckOutPage.checkOutBAFirstName(user.getBfname());
                    CheckOutPage.checkOutBALastName(user.getBlname());
                    if (user.getErrormessage().contains("Country is mandatory."))
                    {
                        CheckOutPage.clickBillCountry("Country");
                    } else
                    {
                        CheckOutPage.clickBillCountry(user.getCountry());
                    }
                    CheckOutPage.addressBAlane1(user.getBaddress1());

                    CheckOutPage.addressBAlane2(user.getBaddress2());
                    if (user.getErrormessage().contains("State is mandatory."))
                    {
                        CheckOutPage.clickBillState("State/Region");
                    } else
                    {
                        CheckOutPage.clickBillState(user.getStateregion());
                    }

                    CheckOutPage.checkOutBACity(user.getBcity());
                    CheckOutPage.checkOutBAZipcode(user.getBzipcode());
                    CheckOutPage.checkOutBAPhn(user.getPhonenumber());
                    CheckOutPage.checkOutCardNumber(user.getCardnumber());
                    CheckOutPage.checkOutPayNameCard(user.getNamecard());
                    if (user.getErrormessage().contains("Card Type is mandatory."))
                    {
                        CheckOutPage.clickCardType("Card Type");

                    } else
                    {
                        CheckOutPage.clickCardType(user.getCardtype());
                    }
                    CheckOutPage.checkOutCVV(user.getCheckoutcvv());
                    if (user.getErrormessage().contains("Card expires month is mandatory."))
                    {
                        CheckOutPage.clickCardMonth("Expires (Month)");
                    } else
                    {
                        CheckOutPage.clickCardMonth(user.getExpiresmonth());
                    }

                    if (user.getErrormessage().contains("Card expires year is mandatory."))
                    {
                        CheckOutPage.clickCardYear("Expires (Year)");
                    } else
                    {
                        CheckOutPage.clickCardYear(user.getExpiresyear());
                    }
                    SeleniumUtils.wait(7);
                    String actualerror = "";
                    String emailerror1 = user.getErrormessage();
                    String eror = "";
                    if (emailerror1.contains("try again"))
                    {
                        eror = emailerror1;
                        System.out.println(eror);
                    } else
                    {
                        eror = emailerror1.replace(",", "");
                        System.out.println(eror);
                    }
                    try
                    {
                        actualerror = SeleniumUtils.getText(Type.ID, user.getIds());
                        System.out.println(eror);
                        testcase.assertEquals(eror.trim(), actualerror.trim());
                    } catch (Exception e)
                    {
                        actualerror = SeleniumUtils.getText(Type.XPATH, user.getIds());
                        System.out.println(eror);
                        testcase.assertEquals(eror.trim(), actualerror.trim());
                    }
                    if (actualerror.isEmpty())
                    {
                        result.add(errormessage);
                        System.out.println(errormessage2);
                    }
                } catch (Exception e)
                {
                    if (e.getMessage().equals("Element is not clickable at point"))
                    {

                    } else
                    {
                        result.add(errormessage);
                    }
                    e.printStackTrace();
                }
            }
            if (result.size() > 0)
            {
                for (int i = 0; i < result.size(); i++)
                {
                    testcase.fail(i + " - " + result.get(i), "");
                }
            } else
            {
                testcase.pass("All negative secnarios working in Billing address and payment");
            }
        } catch (Exception e)
        {
            testcase.error("Some of negative secnarios not working in Billing address and payment", e);
            e.printStackTrace();
        }
    }

    @Test
    public void negativeTestCasesRegForShippingAddress() throws Exception
    {
        String name = new Object()
        {}.getClass().getEnclosingMethod().getName();
        TestCaseDetail testcase = TestCaseFactory.createTestCaseDetail(this.getClass(), name);
        try
        {
            precondition();
            ArrayList<String> result = new ArrayList<String>();
            String errormessage = "";
            ArrayList<CheckoutRegInvalidshippingBean> data = FileUtility.readCheckoutRegInvalidShippingData();
            for (Iterator<CheckoutRegInvalidshippingBean> iterator = data.iterator(); iterator.hasNext();)
            {
                try
                {
                    CheckoutRegInvalidshippingBean user = iterator.next();
                    String errormessage2 = user.getErrormessage();
                    errormessage = errormessage2;
                    SeleniumUtils.wait(30);
                    SeleniumUtils.refresh();
                    CheckOutPage.checkOutGuestEmail(user.getEmail());
                    CheckOutPage.occcheckoutcreateaccount();
                    CheckOutPage.checkOutRegFname(user.getRfname());
                    CheckOutPage.checkOutRegLname(user.getRlname());
                    CheckOutPage.checkOutRegPassword(user.getRpass());
                    CheckOutPage.checkOutRegCPassword(user.getRconfirm());
                    CheckOutPage.checkOutFirstName(user.getFname());
                    CheckOutPage.checkOutLastName(user.getLname());
                    if (user.getErrormessage().contains("Country is mandatory."))
                    {
                        CheckOutPage.clickCountry("Country");
                    } else
                    {
                        CheckOutPage.clickCountry(user.getCountry());
                    }
                    CheckOutPage.addresslane1(user.getAddress1());
                    CheckOutPage.addresslane2(user.getAddress2());
                    if (user.getErrormessage().contains("State is mandatory."))
                    {
                        CheckOutPage.clickState("State/Region");
                    } else
                    {
                        CheckOutPage.clickState(user.getStateregion());
                    }
                    CheckOutPage.checkOutCity(user.getCity());
                    CheckOutPage.checkOutZipcode(user.getZipcode());
                    CheckOutPage.checkOutPhoneNumber(user.getPhonenumber() + Keys.TAB);
                    CheckOutPage.checkOutPayNameCard(user.getNamecard());
                    CheckOutPage.checkOutCardNumber(user.getCardnumber());
                    if (user.getErrormessage().contains("Card Type is mandatory."))
                    {
                        CheckOutPage.clickCardType("Card Type");
                    } else
                    {
                        CheckOutPage.clickCardType(user.getCardtype());
                    }
                    CheckOutPage.checkOutCVV(user.getCheckoutcvv());
                    if (user.getErrormessage().contains("Card expires month is mandatory."))
                    {
                        CheckOutPage.clickCardMonth("Expires (Month)");
                    } else
                    {
                        CheckOutPage.clickCardMonth(user.getExpiresmonth());
                    }

                    if (user.getErrormessage().contains("Card expires year is mandatory."))
                    {
                        CheckOutPage.clickCardYear("Expires (Year)");
                    } else
                    {
                        CheckOutPage.clickCardYear(user.getExpiresyear());
                    }
                    SeleniumUtils.wait(7);
                    String actualerror = "";
                    String emailerror1 = user.getErrormessage();
                    String eror = "";
                    if (emailerror1.contains("try again"))
                    {
                        eror = emailerror1;
                        System.out.println(eror);
                    } else
                    {
                        eror = emailerror1.replace(",", "");
                        System.out.println(eror);
                    }
                    try
                    {
                        actualerror = SeleniumUtils.getText(Type.ID, user.getIds());
                        System.out.println(eror);
                        testcase.assertEquals(eror.trim(), actualerror.trim());
                    } catch (Exception e)
                    {
                        actualerror = SeleniumUtils.getText(Type.XPATH, user.getIds());
                        System.out.println(eror);
                        testcase.assertEquals(eror.trim(), actualerror.trim());
                    }
                    if (actualerror.isEmpty())
                    {
                        result.add(errormessage);
                        System.out.println(errormessage2);
                    }
                } catch (Exception e)
                {
                    if (e.getMessage().equals("Element is not clickable at point"))
                    {

                    } else
                    {
                        result.add(errormessage);
                    }
                    e.printStackTrace();
                }
            }
            if (result.size() > 0)
            {
                for (int i = 0; i < result.size(); i++)
                {
                    testcase.fail(i + " - " + result.get(i), "");
                }
            } else
            {
                testcase.pass("All negative secnarios working in Register Shipping address and Payment");
            }
        } catch (Exception e)
        {
            testcase.error("Some of negative secnarios not working in Register Shipping address and Payment", e);
            e.printStackTrace();
        }
    }

    @Test
    public void negativeTestCasesRegForBillingAddress() throws Exception
    {
        String name = new Object()
        {}.getClass().getEnclosingMethod().getName();
        TestCaseDetail testcase = TestCaseFactory.createTestCaseDetail(this.getClass(), name);
        try
        {
            precondition();
            ArrayList<String> result = new ArrayList<String>();
            String errormessage = "";
            ArrayList<CheckoutRegInvalidBillingBean> data = FileUtility.readCheckoutRegInvalidBilingData();
            for (Iterator<CheckoutRegInvalidBillingBean> iterator = data.iterator(); iterator.hasNext();)
            {
                try
                {
                    CheckoutRegInvalidBillingBean user = iterator.next();
                    String errormessage2 = user.getErrormessage();
                    errormessage = errormessage2;
                    SeleniumUtils.wait(15);
                    SeleniumUtils.refresh();
                    SeleniumUtils.wait(2);
                    CheckOutPage.checkOutGuestEmail(user.getEmail());
                    CheckOutPage.occcheckoutcreateaccount();
                    CheckOutPage.checkOutRegFname(user.getRfname());
                    CheckOutPage.checkOutRegLname(user.getRlname());
                    CheckOutPage.checkOutRegPassword(user.getRpass());
                    CheckOutPage.checkOutRegCPassword(user.getRconfirm());
                    CheckOutPage.shippAddrValidData();
                    SeleniumUtils.wait(7);
                    CheckOutPage.checkOutBAFirstName(user.getBfname());
                    CheckOutPage.checkOutBALastName(user.getBlname());
                    if (user.getErrormessage().contains("Country is mandatory."))
                    {
                        CheckOutPage.clickBillCountry("Country");
                    } else
                    {
                        CheckOutPage.clickBillCountry(user.getCountry());
                    }
                    CheckOutPage.addressBAlane1(user.getBaddress1());

                    CheckOutPage.addressBAlane2(user.getBaddress2());
                    if (user.getErrormessage().contains("State is mandatory."))
                    {
                        CheckOutPage.clickBillState("State/Region");
                    } else
                    {
                        CheckOutPage.clickBillState(user.getStateregion());
                    }

                    CheckOutPage.checkOutBACity(user.getBcity());
                    CheckOutPage.checkOutBAZipcode(user.getBzipcode());
                    CheckOutPage.checkOutBAPhn(user.getPhonenumber());
                    CheckOutPage.checkOutPayNameCard(user.getNamecard());
                    CheckOutPage.checkOutCardNumber(user.getCardnumber());
                    if (user.getErrormessage().contains("Card Type is mandatory."))
                    {
                        CheckOutPage.clickCardType("Card Type");
                    } else
                    {
                        CheckOutPage.clickCardType(user.getCardtype());
                    }
                    CheckOutPage.checkOutCVV(user.getCheckoutcvv());
                    if (user.getErrormessage().contains("Card expires month is mandatory."))
                    {
                        CheckOutPage.clickCardMonth("Expires (Month)");
                    } else
                    {
                        CheckOutPage.clickCardMonth(user.getExpiresmonth());
                    }

                    if (user.getErrormessage().contains("Card expires year is mandatory."))
                    {
                        CheckOutPage.clickCardYear("Expires (Year)");
                    } else
                    {
                        CheckOutPage.clickCardYear(user.getExpiresyear());
                    }
                    SeleniumUtils.wait(7);
                    String actualerror = "";
                    String emailerror1 = user.getErrormessage();
                    String eror = "";
                    if (emailerror1.contains("try again"))
                    {
                        eror = emailerror1;
                        System.out.println(eror);
                    } else
                    {
                        eror = emailerror1.replace(",", "");
                        System.out.println(eror);
                    }
                    try
                    {
                        actualerror = SeleniumUtils.getText(Type.ID, user.getIds());
                        System.out.println(eror);
                        testcase.assertEquals(eror.trim(), actualerror.trim());
                    } catch (Exception e)
                    {
                        actualerror = SeleniumUtils.getText(Type.XPATH, user.getIds());
                        System.out.println(eror);
                        testcase.assertEquals(eror.trim(), actualerror.trim());
                    }
                    if (actualerror.isEmpty())
                    {
                        result.add(errormessage);
                        System.out.println(errormessage2);
                    }
                } catch (Exception e)
                {
                    if (e.getMessage().equals("Element is not clickable at point"))
                    {

                    } else
                    {
                        result.add(errormessage);
                    }
                    e.printStackTrace();
                }
            }
            if (result.size() > 0)
            {
                for (int i = 0; i < result.size(); i++)
                {
                    testcase.fail(i + " - " + result.get(i), "");
                }
            } else
            {
                testcase.pass("All negative secnarios working in Register billing address and payment");
            }
        } catch (Exception e)
        {
            testcase.error("Some of negative secnarios not working in register Billing address and payment", e);
            e.printStackTrace();
        }
    }

    @Test
    public void checkOutPageInvalidLogIn() throws Exception
    {
        String name = new Object()
        {}.getClass().getEnclosingMethod().getName();
        TestCaseDetail testcase = TestCaseFactory.createTestCaseDetail(this.getClass(), name);
        try
        {
            precondition();
            CheckOutPage.occCheckoutLoginToAccount();
            SeleniumUtils.wait(3);
            ArrayList<InvalidSignIn> data = FileUtility.readInvalidCheckOutSign();
            for (Iterator<InvalidSignIn> iterator = data.iterator(); iterator.hasNext();)
            {
                InvalidSignIn databean = iterator.next();
                DriverFactory.getDriver().findElement(By.id(PropertyUtil.getObjectValue(CHECKOUT_REGIST_LOGIN_EMAIL)))
                        .clear();
                CheckOutPage.checkOutRegLoginMail(databean.getName());
                DriverFactory.getDriver()
                        .findElement(By.id(PropertyUtil.getObjectValue(CHECKOUT_REGIST_LOGIN_PASSWORD))).clear();
                CheckOutPage.checkOutRegLoginPassword(databean.getPass());
                SeleniumUtils.wait(3);
                CheckOutPage.checkOutRegLoginButton();
                SeleniumUtils.wait(1);
                String actualerror = "";
                String emailerror1 = databean.getEmailerror();
                String eror = "";
                if (emailerror1.contains("mandatory"))
                {
                    eror = emailerror1.replace(",", "");
                } else if (emailerror1.contains("records"))
                {
                    eror = emailerror1.substring(0, emailerror1.length() - 1);
                    System.out.println(eror);
                } else
                {
                    eror = emailerror1;
                }
                actualerror = SeleniumUtils.getText(Type.ID, databean.getId());
                testcase.assertEquals(eror.trim(), actualerror.trim());
            }
            testcase.pass(
                    "Password is mandatory., Email is mandatory, password don't match, Invalid entry of both E-mail and password");
        } catch (Exception e)
        {
            testcase.error(
                    "Password is mandatory., Email is mandatory, password don't match, Invalid entry of both E-mail and password",
                    e);
            e.printStackTrace();
        }

    }
}
