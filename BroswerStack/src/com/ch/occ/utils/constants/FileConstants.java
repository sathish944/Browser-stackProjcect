package com.ch.occ.utils.constants;

/**
 * @author 10:09:42 PM Prasanna Kumar Reddy Feb 17, 2016
 */
public interface FileConstants extends ObjectConstants, ModuleNames
{

    public static final String TEST_HOME                          = System.getProperty("test.home", "./");

    public static final String RESOURCES_HOME                     = TEST_HOME + "resources/";

    public static final String CONFIG_HOME                        = RESOURCES_HOME + "config/";

    public static final String TESTDATA_HOME                      = RESOURCES_HOME + "testdata/";

    public static final String JSON_HOME                          = RESOURCES_HOME + "jsonfiles/";

    public static final String GEO_LOC                            = JSON_HOME + "geoloc.json";

    public static final String AUTOIT_HOME                        = RESOURCES_HOME + "AutoIt/";

    public static final String TBC_CONTACTUS_AUTOIT               = AUTOIT_HOME + "TBC_Contactus.exe";

    public static final String INVALID_ABOUT_YOU_FILE             = TESTDATA_HOME + "invalidAboutYou.csv";

    public static final String INVALID_CONTACT_INFO_FILE          = TESTDATA_HOME + "invalidContactInfo.csv";

    public static final String LOGIN_DATA_FILE                    = TESTDATA_HOME + "LoginTestData.csv";

    public static final String LOAD_DATA_FILE                     = TESTDATA_HOME + "loadData.csv";

    public static final String FORGOT_PWD_DATA_FILE               = TESTDATA_HOME + "ForgotPwdTestData.csv";

    public static final String USER_DATA_FILE                     = TESTDATA_HOME + "UserData.csv";

    public static final String VEHICLE_DATA_FILE                  = TESTDATA_HOME + "vehicleselectordata.csv";

    public static final String IMAGE_DATA_FILE                    = TESTDATA_HOME + "ImageText.csv";

    public static final String REPORTS_HOME                       = TEST_HOME + "reports/";

    public static final String DRIVERS_HOME                       = RESOURCES_HOME + "drivers/";

    public static final String CHROME                             = DRIVERS_HOME + "chromedriver.exe";

    public static final String PHANTOMJS_WIN                      = DRIVERS_HOME + "phantomjs.exe";

    public static final String I_E                                = DRIVERS_HOME + "IEDriverServer.exe";

    public static final String OPERA                              = DRIVERS_HOME + "operadriver.exe";

    public static final String HEAD_FILE                          = CONFIG_HOME + "head.txt";

    public static final String TABLEHEAD_FILE                     = CONFIG_HOME + "tablehead.txt";

    public static final String TABLEDETAIL_HEAD_FILE              = CONFIG_HOME + "detailimagehead.txt";

    public static final String TABLEDEATILCASE_HEAD_FILE          = CONFIG_HOME + "detailtestcase.txt";

    public static final String TEST_PROPERTY_FILE                 = CONFIG_HOME + "testconfig.properties";

    public static final String TABELT_OBJ_PROPERTY                = CONFIG_HOME + "tabletObject.properties";

    public static final String STATIC_TEXT_PROPERTY               = CONFIG_HOME + "staticText.properties";

    public static final String SERVER_PROPERTY_FILE               = CONFIG_HOME + "server.properties";

    public static final String OBJECT_PROPERTY_FILE               = CONFIG_HOME + "object.properties";

    public static final String MOBILE_OBJ_PROPERTY_FILE           = CONFIG_HOME + "mobileObject.properties";

    public static final String PLATFORM_NAME                      = "platform.name";

    public static final String PLATFORM_VERSION                   = "platform.version";

    public static final String DEVICE_NAME                        = "device.name";

    public static final String BROWSE_NAME                        = "browser";

    public static final String DEVICE_URL                         = "driver.url";

    public static final String MOBILE_PC                          = "MOBILE_PC";

    public static final String PLATFORMEXE                        = "platformexe.name";

    public static final String APP_NAME                           = "app.name";

    public static final String BROWSER_NAME                       = "BROWSER_NAME";

    public static final String EMAIL_SIGNUP_DATA_FILE             = TESTDATA_HOME + "SignUpData.csv";

    public static final String LOG_PATH                           = "LOG_PATH";

    public static final String EXCEL_FILENAME                     = CONFIG_HOME + "ExcelObjectProperties.xls";

    public static final String ADDRESS_API                        = TESTDATA_HOME + "AddressAPI.csv";

    public static final String INVALID_SEARCH                     = TESTDATA_HOME + "SearchInvalid.csv";

    public static final String INVALID_SIGNIN                     = TESTDATA_HOME + "invalidSignIn.csv";

    public static final String INVALID_CHECKOUT_SIGNIN            = TESTDATA_HOME + "invalidCheckOutSignIn.csv";

    public static final String CHECKOUT_INVALID_SHIPPING_DATA     = TESTDATA_HOME + "CheckoutDataInvalidShipping.csv";

    public static final String CHECKOUT_INVALID_BILLING_DATA      = TESTDATA_HOME + "CheckoutDataBillingInvalid.csv";

    public static final String CHECKOUT_REG_INVALID_BILLING_DATA  = TESTDATA_HOME + "ReguserinvalidBillingdata.csv";

    public static final String CHECKOUT_REG_INVALID_SHIPPING_DATA = TESTDATA_HOME + "ReguserinvalidShipingdata.csv";

    public static final String ISDISPLAYEDDATA                    = TESTDATA_HOME + "IsDisplayed.csv";

    public static final String INVALID_SIGNUP_DATA_FILE           = TESTDATA_HOME + "InvalidSignUpData.csv";

    public static final String CHECKOUT_DATA                      = TESTDATA_HOME + "CheckoutData.csv";

    public static final String BROWSER_PROPERTY_FILE              = CONFIG_HOME + "browser.properties";

    public static final String EMAILIDS                           = "EMAILIDS";
}
