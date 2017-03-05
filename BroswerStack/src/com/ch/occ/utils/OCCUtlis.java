package com.ch.occ.utils;

import com.ch.ExcelUtils.ExcelProperty;
import com.ch.occ.utils.constants.FileConstants;

/**
 * @author 11:59:11 AM Prasanna Kumar Reddy Mar 6, 2016
 */
public class OCCUtlis implements FileConstants
{
    public static void occLogin() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(ACCOUNTMANAGEMENT, LOGIN));
    }

    public static void occHeaderCheckOut() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(HOMEPAGE, HOME_CHECKOUT));
    }

    public static boolean isMyAccout() throws Exception
    {
        try
        {

            return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(HOMEPAGE, MY_ACCOUNT));
        } catch (Exception e)
        {
            // TODO: handle exception
        }
        return false;
    }

    public static void occHeaderWishlist() throws Exception
    {

        SeleniumUtils.click(ExcelProperty.getElementValue(HOMEPAGE, WISHLIST_LOGIN));
    }

    public static boolean isWishlist() throws Exception
    {
        try
        {

            return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(HOMEPAGE, WISHLIST_LOGIN));
        } catch (Exception e)
        {
            // TODO: handle exception
        }
        return false;
    }

    public static void occMyAccount() throws Exception
    {

        SeleniumUtils.click(ExcelProperty.getElementValue(HOMEPAGE, MY_ACCOUNT));
    }

    public static boolean isHeaderCheckOut() throws Exception
    {
        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(HOMEPAGE, HOME_CHECKOUT));
    }


    public static void occLogout() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(HOMEPAGE, HOME_LOGOUT));
    }

    public static void occRegister() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(HOMEPAGE, REGISTER));
    }

    public static void occAddToCart() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(HOMEPAGE, ADD_TO_CART));
    }

    public static void occShopingItems() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(HOMEPAGE, SHOPPING_ITEMS_CART));
    }

    public static void occCheckout() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(HOMEPAGE, CHECK_OUT));
    }

    public static void hoverMainNav1() throws Exception
    {
        SeleniumUtils.onHover(ExcelProperty.getElementValue(HOMEPAGE, MAIN_NAV1));
    }

    public static void hoverMainNav2() throws Exception
    {
        SeleniumUtils.onHover(ExcelProperty.getElementValue(HOMEPAGE, MAIN_NAV2));
    }

    public static void clickQuickView() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(BROWSEANDSHOP, QUICK_VIEW));
    }

    public static void hoverMainNav3() throws Exception
    {
        SeleniumUtils.onHover(ExcelProperty.getElementValue(HOMEPAGE, MAIN_NAV3));
    }

    public static void hoverMainNav4() throws Exception
    {
        SeleniumUtils.onHover(ExcelProperty.getElementValue(HOMEPAGE, MAIN_NAV4));
    }

    public static void hoverMainNav5() throws Exception
    {
        SeleniumUtils.onHover(ExcelProperty.getElementValue(HOMEPAGE, MAIN_NAV5));
    }

    public static void secondarySubNav1() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(HOMEPAGE, SECONDARY_SUB_NAV1));
    }

    public static void hoverMainNav6() throws Exception
    {
        SeleniumUtils.onHover(ExcelProperty.getElementValue(HOMEPAGE, MAIN_NAV6));
    }

    public static void hoverSecondaryNav1() throws Exception
    {
        SeleniumUtils.onHover(ExcelProperty.getElementValue(HOMEPAGE, SECONDARY_NAV1));
    }

    public static void hoverSecondaryNav2() throws Exception
    {
        SeleniumUtils.onHover(ExcelProperty.getElementValue(HOMEPAGE, SECONDARY_NAV2));
    }

    public static void hoverSecondaryNav3() throws Exception
    {
        SeleniumUtils.onHover(ExcelProperty.getElementValue(HOMEPAGE, SECONDARY_NAV3));
    }

    public static void hoverSecondaryNav4() throws Exception
    {
        SeleniumUtils.onHover(ExcelProperty.getElementValue(HOMEPAGE, SECONDARY_NAV4));
    }

    public static void hoverSecondaryNav5() throws Exception
    {
        SeleniumUtils.onHover(ExcelProperty.getElementValue(HOMEPAGE, SECONDARY_NAV5));
    }

    public static void hoverSecondaryNav6() throws Exception
    {
        SeleniumUtils.onHover(ExcelProperty.getElementValue(HOMEPAGE, SECONDARY_NAV6));
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

    public static void clickMainNav1() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(HOMEPAGE, MAIN_NAV1));
    }

    public static void clickMainNav2() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(HOMEPAGE, MAIN_NAV2));
    }

    public static void clickMainNav3() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(HOMEPAGE, MAIN_NAV3));
    }

    public static void clickMainNav4() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(HOMEPAGE, MAIN_NAV4));
    }

    public static void clickMainNav5() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(HOMEPAGE, MAIN_NAV5));
    }

    public static void clickMainNav6() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(HOMEPAGE, MAIN_NAV6));
    }

    public static void payWithGiftcard() throws Exception
    {
        if (PropertyUtil.getPropertyValue(URL, SERVER_PROPERTY_FILE)
                .equalsIgnoreCase(PropertyUtil.getObjectValue(ROCK_CREEK)))
        {
            SeleniumUtils.click(ExcelProperty.getElementValue(CHECKOUT, CHECKOUT_GIFT_CARD));
        }
    }

    public static void selectColorDrop(int color) throws Exception
    {
        if (SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(CART, ITEM_COLOR_SELECT)) == true)
        {
            SeleniumUtils.click(ExcelProperty.getElementValue(CART, ITEM_COLOR_SELECT));

        } else if (SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(CHECKOUT, ITEM_COLOR_DROPDOWN)) == true)
        {
            SeleniumUtils.dropDownByIndex(ExcelProperty.getElementValue(CART, ITEM_COLOR_DROPDOWN), color);
        }
    }

    public static boolean isLogOut() throws Exception
    {
        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(HOMEPAGE, HOME_LOGOUT));
    }

    public static boolean verifyRegister() throws Exception
    {
        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(HOMEPAGE, REGISTER));
    }

    public static boolean isHomePageSreachHelpBox() throws Exception
    {

        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(SEARCH, SEARCH_HELP_BOX));

    }

    public static boolean isHomePageWishList() throws Exception
    {

        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(HOMEPAGE, WISHLIST_HEADER));

    }

    public static boolean isHomePageHomeFooter() throws Exception
    {

        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(HOMEPAGE, FOOTER_HOME_BUTTON));

    }

    public static boolean isHomePageHomeAboutus() throws Exception
    {

        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(HOMEPAGE, FOOTER_ABOUTUS_BUTTON));

    }

    public static boolean isHomePageHomeContactus() throws Exception
    {

        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(HOMEPAGE, FOOTER_CONTACTUS_BUTTON));

    }

    public static boolean isHomePageHomeReturns() throws Exception
    {
        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(HOMEPAGE, FOOTER_RETURNS_BUTTON));
    }

    public static boolean isHomePageSiteLogo() throws Exception
    {
        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(HOMEPAGE, SITELOGO));
    }

    public static boolean isHomePageLogin() throws Exception
    {
        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(HOMEPAGE, LOGIN));
    }

    public static boolean isHomePageCreateAccount() throws Exception
    {
        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(HOMEPAGE, REGISTER));
    }

    public static boolean isHomePageCartEmpty() throws Exception
    {
        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(HOMEPAGE, CART_EMPTY));
    }

    public static boolean isHomePageSearchHelpBox() throws Exception
    {
        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(HOMEPAGE, SEARCH_HELP_BOX));
    }

    public static boolean isHomePageWomensClothingBanner() throws Exception
    {
        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(HOMEPAGE, WOMENS_CLOTHING_PAGE_BANNER));
    }

    public static boolean isHomePageFooterFacebookIcon() throws Exception
    {
        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(HOMEPAGE, FACEBOOK_SOCIAL_ICON));
    }

    public static boolean isHomePageFooterPinterestIcon() throws Exception
    {
        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(HOMEPAGE, PINTEREST_SOCIAL_ICON));
    }

    public static boolean isHomePageFooterInstagramIcon() throws Exception
    {

        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(HOMEPAGE, INSTAGRAM_SOCIAL_ICON));

    }

    public static boolean isHomePageFooterTwitterIcon() throws Exception
    {

        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(HOMEPAGE, TWITTER_SOCIAL_ICON));

    }

    public static boolean isHomePageFooterYoutubeIcon() throws Exception
    {

        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(HOMEPAGE, YOUTUBE_SOCIAL_ICON));

    }

    public static boolean isHomePageLoginUserWelcome() throws Exception
    {

        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(HOMEPAGE, USER_WELCOME_TEXT));

    }

    public static boolean isHomePageNewUserEmptyCart() throws Exception
    {

        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(CART, EMPTY_CART));

    }

    public static boolean isHomePageObserveRegisterForm() throws Exception
    {

        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(HOMEPAGE, REGISTER_FORM_VERIFY));

    }

    public static boolean isHomePageObserveMyaccount() throws Exception
    {

        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(HOMEPAGE, MY_ACCOUNT));

    }

    public static boolean isHomePageObserveCopyrightText() throws Exception
    {

        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(HOMEPAGE, COPYRIGHT_TEXT));

    }

    public static boolean isHomePageObserveMyaccountPageTitle() throws Exception
    {

        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(HOMEPAGE, MYACCOUNT_PAGE_TITLE));

    }

    public static boolean issearchBoxVisiable() throws Exception
    {

        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(SEARCH, SEARCH_HELP_BOX));

    }

    public static boolean isVerifysearchSubmit() throws Exception
    {

        return SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(SEARCH, SEARCH_SUBMIT));

    }

    public static void productItemSearch() throws Exception

    {

        SeleniumUtils.click(ExcelProperty.getElementValue(SEARCH, PRODUCT_SEARCH));

    }

    public static void subscribeEmailUpdateFromTheSite(String email) throws Exception
    {

        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(HOMEPAGE, EMAIL_SUBSCRIBE), email);

    }

    public static void emailSubscribeSubmitButton() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(HOMEPAGE, EMAIL_SUBMIT_BUTTON));

    }

}