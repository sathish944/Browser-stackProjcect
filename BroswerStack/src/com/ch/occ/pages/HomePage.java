package com.ch.occ.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.ch.ExcelUtils.ExcelProperty;
import com.ch.occ.utils.DriverFactory;
import com.ch.occ.utils.OCCUtlis;
import com.ch.occ.utils.PropertyUtil;
import com.ch.occ.utils.SeleniumUtils;
import com.ch.occ.utils.Type;
import com.ch.occ.utils.constants.FileConstants;

public class HomePage implements FileConstants
{

    public static void clickLogin() throws Exception
    {
        OCCUtlis.occLogin();
    }

    public static void clickAddtoCart() throws Exception
    {
        SeleniumUtils.javaScriptClick(ExcelProperty.getElementValue(HOMEPAGE, ADD_TO_CART_SKULIST), 200);
    }

    public static void hovercart() throws Exception
    {
        SeleniumUtils.onHover(ExcelProperty.getElementValue(HOMEPAGE, CART_CLICK));
    }

    public static boolean cartGetText() throws Exception
    {
        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(HOMEPAGE, EMPTY_CART));
    }

    public static void navAfterSignin() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(HOMEPAGE, REGISTER));
    }

    public static boolean isHomeEveryDayInspi()
    {
        boolean flag = false;
        try
        {
            flag = SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(HOMEPAGE, HOME_EVERYDAY_INSPIRATION));
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return flag;
    }

    public static boolean verifyLogin() throws Exception
    {

        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(HOMEPAGE, LOGIN));
    }

    public static void clickRegister() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(HOMEPAGE, REGISTER));
        Thread.sleep(2000);
    }

    public static boolean verifyRegister() throws Exception
    {
        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(HOMEPAGE, REGISTER));
    }

    public static void enterEmailSignupEmail(String data) throws Exception
    {
        SeleniumUtils.wait(3);
        DriverFactory.getDriver().findElement(By.cssSelector(PropertyUtil.getObjectValue(SIGNUP_EMAIL))).clear();
        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(HOMEPAGE, SIGNUP_EMAIL), data + Keys.ENTER);
    }

    public static String emailSignupEmailerror() throws Exception
    {
        return SeleniumUtils.getText(ExcelProperty.getElementValue(HOMEPAGE, EMAIL_SIGNUP_ERROR));
    }

    public static boolean isTrackOrder() throws Exception
    {
        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(HOMEPAGE, TRACK_ORDER));
    }

    public static boolean isHeaderEmailSignUp() throws Exception
    {
        boolean flag = false;
        try
        {
            flag = SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(HOMEPAGE, HEADER_EMAIL_SIGN_UP));
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return flag;
    }

    public static void clickHeaderEmailSignUp() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(HOMEPAGE, HEADER_EMAIL_SIGN_UP));
    }

    public static void clickFooterEmailSignUp() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(HOMEPAGE, FOOTER_EMAIL_SIGN_UP));
    }

    public static boolean isLiveChat() throws Exception
    {
        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(HOMEPAGE, HOME_LIVE_CHAT));
    }

    public static boolean isLiveChatPopUp() throws Exception
    {
        boolean flag = false;
        try
        {
            flag = SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(HOMEPAGE, LIVE_CHAT_POPUP_SEND_MSG));
        } catch (Exception e)
        {
            e.printStackTrace();;
        }
        return flag;
    }

    public static void clickLiveChat() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(HOMEPAGE, HOME_LIVE_CHAT));
    }

    public static void logoutLink() throws Exception
    {

        SeleniumUtils.click(ExcelProperty.getElementValue(HOMEPAGE, HOME_LOGOUT));
    }

    public static boolean isLogoutLink() throws Exception
    {

        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(HOMEPAGE, HOME_LOGOUT));
    }

    public static void myAccount() throws Exception
    {
        SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(HOMEPAGE, MY_ACCOUNT));
    }

    public static void VerifyMyAccount() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(HOMEPAGE, MY_ACCOUNT));
    }

    public static boolean ismyAccountLink() throws Exception
    {

        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(HOMEPAGE, MY_ACCOUNT));
    }

    public static void mainNav1() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(HOMEPAGE, MAIN_NAV1));
    }

    public static void mainNav2() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(HOMEPAGE, MAIN_NAV2));
    }

    public static void mainNav3() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(HOMEPAGE, MAIN_NAV3));
    }

    public static void mainNav4() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(HOMEPAGE, MAIN_NAV4));
    }

    public static void mainNav5() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(HOMEPAGE, MAIN_NAV5));
    }

    public static void mainNav6() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(HOMEPAGE, MAIN_NAV6));
    }

    public static void secondaryNav1() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(HOMEPAGE, SECONDARY_NAV1));
    }

    public static void secondaryNav2() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(HOMEPAGE, SECONDARY_NAV2));
    }

    public static void secondaryNav3() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(HOMEPAGE, SECONDARY_NAV3));
    }

    public static void viewCart() throws Exception
    {

        SeleniumUtils.onHover(Type.CSSSELECTOR, PropertyUtil.getObjectValue(CART_ICON));
        SeleniumUtils.click(ExcelProperty.getElementValue(HOMEPAGE, MIN_CART_VIEW_CART));
    }

    public static void clickcart() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(HOMEPAGE, CART_CLICK));

    }

    public static void secondaryNav4() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(HOMEPAGE, SECONDARY_NAV4));
    }

    public static void secondaryNav5() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(HOMEPAGE, SECONDARY_NAV5));
    }

    public static void secondaryNav6() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(HOMEPAGE, SECONDARY_NAV6));
    }

    public static void customerEmailReceive() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(HOMEPAGE, REG_EMAIL_CHECKBOX));
    }

    public static void searchData(String data) throws Exception
    {
        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(HOMEPAGE, SEARCH_HELP_BOX), data);
    }

    public static void clickProductSuggestion() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(HOMEPAGE, SUGGESTION_PRODUCT));
    }

    public static void hoverFigurines(String submenu) throws Exception
    {
        SeleniumUtils.onHoverClick(ExcelProperty.getElementValue(HOMEPAGE, PLP_PRODUCT_NAME_LINK),
                ExcelProperty.getElementValue(HOMEPAGE, submenu));
    }

    public static boolean isShowAll() throws Exception
    {
        boolean flag = false;
        try
        {
            flag = SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(HOMEPAGE, SUGGESTION_PRODUCT));
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return flag;
    }

    public static boolean isFirstHeroBannerImage() throws Exception
    {
        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(HOMEPAGE, HOME_HERO_BAN1));
    }

    public static boolean isSecondHeroBannerImage() throws Exception
    {
        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(HOMEPAGE, HOME_HERO_BAN2));
    }

    public static boolean isThirdHeroBannerImage() throws Exception
    {
        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(HOMEPAGE, HOME_HERO_BAN3));
    }

    public static void clickShowAllAutoSuggestion() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(HOMEPAGE, SHOW_ALL_AUTO_SUGESTION));
    }

    public static void clickSearchButton() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(HOMEPAGE, SEARCH_SUBMIT));
    }

    public static String searchPlaceHolder() throws Exception
    {
        return SeleniumUtils.getAttributes(ExcelProperty.getElementValue(HOMEPAGE, SEARCH_HELP_BOX), "placeholder");
    }

    public static boolean searchSuggestions() throws Exception
    {
        boolean flag = false;
        try
        {
            flag = SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(HOMEPAGE, PRODUCT_SUGESTIONS));
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return flag;
    }

    public static boolean cartIcon() throws Exception
    {
        boolean flag = false;
        try
        {
            flag = SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(HOMEPAGE, CART_ICON));
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return flag;
    }

    public static boolean isMiniCartDisplay() throws Exception
    {
        boolean flag = false;
        try
        {
            flag = SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(HOMEPAGE, MINI_CART_ITEM));
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return flag;
    }

    public static void hoverSetYourTable(String submenu) throws Exception
    {
        SeleniumUtils.onHoverClick(ExcelProperty.getElementValue(HOMEPAGE, MAIN_NAV1_SET_YOUR_TABLE),
                ExcelProperty.getElementValue(HOMEPAGE, submenu));
    }

    public static void clickSetYourTable() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(HOMEPAGE, MAIN_NAV1_SET_YOUR_TABLE));
    }

    public static void footerConatctUs() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(HOMEPAGE, CONTACTUS_FOOTER));
    }

    public static void footerAboutUs() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(HOMEPAGE, FOOTER_ABOUT_US));
    }

    public static void footerReturnPolicy() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(HOMEPAGE, FOOTER_RETURN_POLICY));
    }

    public static void footerEmailPrefer() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(HOMEPAGE, FOOTER_EMAIL_PREFE));
    }

    public static void footerTrackOrder() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(HOMEPAGE, FOOTER_TRACK_ORDER));
    }

    public static void footerEasyPay() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(HOMEPAGE, FOOTER_LENOX_EASY_PAY));
    }

    public static void footerShippingRates() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(HOMEPAGE, FOOTER_SHIPPING_RATES));
    }

    public static void footerBreakageReplacement() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(HOMEPAGE, FOOTER_BREAKAGE_REPLACEMENT));
    }

    public static void footerPrivacyPoclicy() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(HOMEPAGE, FOOTER_PRIVACY));
    }

    public static void footerCalifornia() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(HOMEPAGE, FOOTER_CALIFORNIA));
    }

    public static void footerChain() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(HOMEPAGE, FOOTER_CHAIN_DISCLOSURE));
    }

    public static void footerAffiliate() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(HOMEPAGE, FOOTER_AFFILIATE_PROG));
    }

    public static void footerCatlog() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(HOMEPAGE, FOOTER_OLINE_CATALOG));
    }

    public static void footerCatlogReq() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(HOMEPAGE, FOOTER_CATALOG_REQ));
    }

    public static void footerHospitaliy() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(HOMEPAGE, FOOTER_HOSPITALITY));
    }

    public static void footerDesigner() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(HOMEPAGE, FOOTER_DESIGNER));
    }

    public static void footerPatterns() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(HOMEPAGE, FOOTER_PATTERNS));
    }

    public static void footerBrands() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(HOMEPAGE, FOOTER_BRANDS));
    }

    public static void footerStore() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(HOMEPAGE, FOOTER_STORE_LOC));
    }

    public static void footerSecureShop() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(HOMEPAGE, FOOTER_SECURE_SHOP));
    }

    public static boolean firstTimeEmailSignup() throws Exception
    {
        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(HOMEPAGE, EVERY_TIME_SIGN_UP));
    }

    public static void footerEmailSignUp() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(HOMEPAGE, FOOTER_SECURE_SHOP));
    }

    public static boolean isFooterSocialIcons() throws Exception
    {
        boolean flag = false;
        try
        {

            flag = SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(HOMEPAGE, FOOTER_TWITTER));
            flag = SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(HOMEPAGE, FOOTER_PININTREST));
            flag = SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(HOMEPAGE, FOOTER_TUMBLER));
            flag = SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(HOMEPAGE, FOOTER_INSTAGRAM));
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return flag;
    }

    public static boolean browseAndShopPage() throws Exception
    {
        boolean flag = false;
        try
        {

            flag = SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(SEARCH, B_S_SORT_SELECT));
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return flag;
    }

    public static void corosels(int number) throws Exception
    {
        if (number == 1)
        {
            SeleniumUtils.click(ExcelProperty.getElementValue(HOMEPAGE, FIRST_COROSEL));
        }
        if (number == 2)
        {
            SeleniumUtils.click(ExcelProperty.getElementValue(HOMEPAGE, SECOND_COROSEL));
        }
        if (number == 3)
        {
            SeleniumUtils.click(ExcelProperty.getElementValue(HOMEPAGE, THIRD_COROSEL));
        }

    }

    public static void emailIdError() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(HOMEPAGE, EMAIL_ERROR_MSG));
    }

    public static void clickAnItem() throws Exception
    {
        if (PropertyUtil.getPropertyValue(URL, SERVER_PROPERTY_FILE)
                .equalsIgnoreCase("https://ccstore-z1ga.oracleoutsourcing.com/"))
        {
            try
            {
                Alert al = DriverFactory.getDriver().switchTo().alert();
                al.accept();
                al.dismiss();
            } catch (Throwable e)
            {
                e.getMessage();
            }
            SeleniumUtils.click(Type.CSSSELECTOR, "img.hero-image");
            SeleniumUtils.click(Type.CSSSELECTOR, "div.bg-product-image");
            Thread.sleep(5000);
        } else if (PropertyUtil.getPropertyValue(URL, SERVER_PROPERTY_FILE)
                .equalsIgnoreCase(PropertyUtil.getPropertyValue(ELAINE_TURNER, SERVER_PROPERTY_FILE)))
        {
            Thread.sleep(5000);
            SeleniumUtils.onHover(Type.CSSSELECTOR, "[id*=Nav_1_1]");
            try
            {
                SeleniumUtils.click(Type.ID, "CC-product-grid-displayName-LZDR000");
            } catch (Exception e)
            {
                // SeleniumUtils.pageup();
                SeleniumUtils.click(Type.ID, "CC-product-grid-displayName-MIWG003");
            }
        } else if (PropertyUtil.getPropertyValue(URL, SERVER_PROPERTY_FILE)
                .equalsIgnoreCase(PropertyUtil.getPropertyValue(ROCK_CREEK, SERVER_PROPERTY_FILE)))
        {

            SeleniumUtils.click(Type.ID, "CC-product-image-48254");
            System.out.println("rc");
            Thread.sleep(5000);
        }
    }

    public static void enterSearch(String data) throws Exception
    {
        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(HOMEPAGE, SEARCH_HELP_BOX), data + Keys.ENTER);
    }

    public static void hoverHomeDecor() throws Exception
    {
        SeleniumUtils.onHover(ExcelProperty.getElementValue(HOMEPAGE, MAIN_NAV4_HOME_DECOR));
    }

    public static void hoverSetYourTable() throws Exception
    {
        SeleniumUtils.onHover(ExcelProperty.getElementValue(HOMEPAGE, MAIN_NAV1_SET_YOUR_TABLE));
    }

    public static void searchDataEnter(String data) throws Exception
    {
        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(HOMEPAGE, SEARCH_HELP_BOX), data + Keys.ENTER);
    }

    public static void jewlleryHover(String name) throws Exception
    {
        SeleniumUtils.onHoverClick(ExcelProperty.getElementValue(HOMEPAGE, MAIN_NAV5_JWELLERY),
                ExcelProperty.getElementValue(HOMEPAGE, name));
    }

    public static void jewlleryRings() throws Exception
    {
        jewlleryHover(MAIN_NAV5_JWELLERY_EARRINGS);
    }

    public static void homeDecor(String name) throws Exception
    {
        SeleniumUtils.onHoverClick(ExcelProperty.getElementValue(HOMEPAGE, MAIN_NAV4_HOME_DECOR),
                ExcelProperty.getElementValue(HOMEPAGE, name));
    }

    public static void homeDecorBabyGifts() throws Exception
    {
        homeDecor(MAIN_NAV4_BABY_GIFTS);
    }

    public static void ornaments(String name) throws Exception
    {
        SeleniumUtils.onHoverClick(ExcelProperty.getElementValue(HOMEPAGE, MAIN_NAV2_ORNAMENTS),
                ExcelProperty.getElementValue(HOMEPAGE, name));
    }

    public static void ornamentsAngels() throws Exception
    {
        ornaments(ORNAMENTS_ANGELS);
    }

    public static void figurines(String name) throws Exception
    {
        SeleniumUtils.onHoverClick(ExcelProperty.getElementValue(HOMEPAGE, MAIN_NAV3_FIGURINES),
                ExcelProperty.getElementValue(HOMEPAGE, name));
    }

    public static void clickOrnaments() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(HOMEPAGE, MAIN_NAV2_ORNAMENTS));
    }

    public static void clickFigurines() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(HOMEPAGE, MAIN_NAV3_FIGURINES));
    }

    public static void clickJewellery() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(HOMEPAGE, MAIN_NAV5_JWELLERY));
    }

    public static void clickHomeDecor() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(HOMEPAGE, MAIN_NAV4_HOME_DECOR));
    }

    public static void clickGifts() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(HOMEPAGE, MAIN_NAV6_GIFTS));
    }

    public static void clickDesigners() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(HOMEPAGE, MAIN_NAV7_DESIGNERS));
    }

    public static void clickClearance() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(HOMEPAGE, MIAN_NAV8_CLEARANCE));
    }

    public static void hoverGifts(String name) throws Exception
    {
        SeleniumUtils.onHoverClick(ExcelProperty.getElementValue(HOMEPAGE, MAIN_NAV6_GIFTS),
                ExcelProperty.getElementValue(HOMEPAGE, name));
    }

    public static void giftsTestGifts() throws Exception
    {
        hoverGifts(MAIN_NAV6_TEST_GIFTS);
    }

    public static void editCart()
    {
        // TODO Auto-generated method stub

    }
}
