package com.ch.occ.pages;

import org.openqa.selenium.Keys;

import com.ch.ExcelUtils.ExcelProperty;
import com.ch.occ.utils.DriverFactory;
import com.ch.occ.utils.SeleniumUtils;
import com.ch.occ.utils.constants.FileConstants;

public class BrowseAndShopPage implements FileConstants
{

    public static void clickImagePLP() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(BROWSEANDSHOP, PRODUCT_IMAGE));
    }
    public static void clickVideoImage() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(BROWSEANDSHOP, VIDEO_IMAGE));
    }
    public static void clickRatingsImage() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(BROWSEANDSHOP, RATINGS_IMAGE));
    }
   
    public static void maximumQuantity(String quantity) throws Exception
    {
        SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(CART, CART_QUANTITY_BOX));
        SeleniumUtils.clear(ExcelProperty.getElementValue(CART, CART_QUANTITY_BOX));
        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(CART, CART_QUANTITY_BOX), Keys.CONTROL + "a");
        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(CART, CART_QUANTITY_BOX), quantity + Keys.TAB);
    }

    public static void clickImage1PLP() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(BROWSEANDSHOP, PDP_IMAGE));
    }

    public static void clickImageGiftsPLP() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(BROWSEANDSHOP, HOME_DECOR_GIFTS_PLP_IMAGE));
    }

    public static String maximumQuantityValue() throws Exception
    {
        return SeleniumUtils.getAttributes(ExcelProperty.getElementValue(BROWSEANDSHOP, CART_QUANTITY_BOX), "value");
    }

    public static void zeroQuantity() throws Exception
    {
        SeleniumUtils.clear(ExcelProperty.getElementValue(CART, CART_QUANTITY_BOX));
        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(CART, CART_QUANTITY_BOX), "0");
    }

    public static boolean addToCartDisabled() throws Exception
    {
        boolean flag = false;
        try
        {
            flag = SeleniumUtils.isEnabled(ExcelProperty.getElementValue(BROWSEANDSHOP, PERSONALISED_PREVIEW_ADDTOCART));
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return flag;

    }

    public static void addToCart() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(BROWSEANDSHOP, PDP_ADD_TO_CART));
    }

    public static void personalisedAddToCart() throws Exception
    {
        SeleniumUtils.javaScriptClick(ExcelProperty.getElementValue(BROWSEANDSHOP, PERSONALISED_PREVIEW_ADDTOCART), 230);
    }

    public static void personalisedVariantAddToCart() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(BROWSEANDSHOP, PERSONALISED_PREVIEW_ADDTOCART));
    }

    public static void clickPersonalisedImagePlp() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(BROWSEANDSHOP, PERSONALISED_PRODUCT_IMAGE_PLP));
    }

    public static String noPersonalisationDefault() throws Exception
    {
        return SeleniumUtils.getText(ExcelProperty.getElementValue(BROWSEANDSHOP, PERSONALISED_DEFAULT_DROP_DOWN_VALUE));
    }

    public static void previewPersonalisation(String personal) throws Exception
    {
        try
        {
            SeleniumUtils.javaScriptExecutorDown("150");
            SeleniumUtils.click(ExcelProperty.getElementValue(BROWSEANDSHOP, PERSONALISED_DROP_DOWN_ACCORDION));
            SeleniumUtils.click(ExcelProperty.getElementValue(BROWSEANDSHOP, PERSONALISED_DROP_DOWN_CREATE_VALUE));
            SeleniumUtils.sendKeys(ExcelProperty.getElementValue(BROWSEANDSHOP, PERSONALISED_TEXT), personal);
            SeleniumUtils.javaScriptExecutorDown("250");
        } catch (Exception e)
        {
            SeleniumUtils.javaScriptExecutorUp("250");
            SeleniumUtils.click(ExcelProperty.getElementValue(BROWSEANDSHOP, PERSONALISED_DROP_DOWN_ACCORDION));
            //SeleniumUtils.click(ExcelProperty.getElementValue(BROWSEANDSHOP, PERSONALISED_DROP_DOWN_CREATE_VALUE));
            SeleniumUtils.javaScriptClick(ExcelProperty.getElementValue(BROWSEANDSHOP, PERSONALISED_DROP_DOWN_CREATE_VALUE), 250);
            SeleniumUtils.sendKeys(ExcelProperty.getElementValue(BROWSEANDSHOP, PERSONALISED_TEXT), personal);
            SeleniumUtils.javaScriptExecutorDown("250");
        }

    }

    public static void initialPersonalisation() throws Exception
    {
        SeleniumUtils.javaScriptClick(ExcelProperty.getElementValue(BROWSEANDSHOP,PERSONALISED_DROP_DOWN_ACCORDION), 230);
        // SeleniumUtils.clickByCSSSelector(PropertyUtil.getObjectValue(PERSONALISED_DROP_DOWN_ACCORDION));
        SeleniumUtils.click(ExcelProperty.getElementValue(BROWSEANDSHOP, PERSONALISED_DROP_DOWN_MONOGRAM_VALUE));
        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(BROWSEANDSHOP, FIRST_INITIAL), "R");
        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(BROWSEANDSHOP, LAST_INITIAL), "D");
        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(BROWSEANDSHOP, MIDDLE_INITIAL), "R");
        SeleniumUtils.javaScriptExecutorDown("250");
        SeleniumUtils.click(ExcelProperty.getElementValue(CART, PDP_ADD_TO_CART));
    }

    public static void onlyCharPersonalisation() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(BROWSEANDSHOP, PERSONALISED_DROP_DOWN_ACCORDION));
        SeleniumUtils.javaScriptClick(ExcelProperty.getElementValue(BROWSEANDSHOP, PERSONALISED_DROP_DOWN_CREATE_VALUE),200);
        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(BROWSEANDSHOP, PERSONALISED_TEXT), "123");
        SeleniumUtils.javaScriptExecutorDown("250");

    }

    public static void editPersonalisationButton() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(BROWSEANDSHOP, EDIT_PERSONALISATION));
    }

    public static void confirmPersonalisation() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(BROWSEANDSHOP, CONFIRM_PERSONALISATION));
    }

    public static void editPersonalisation() throws Exception
    {
        SeleniumUtils.clear(ExcelProperty.getElementValue(BROWSEANDSHOP, PERSONALISED_TEXT));
        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(BROWSEANDSHOP, PERSONALISED_TEXT), "HEY");
        SeleniumUtils.click(ExcelProperty.getElementValue(BROWSEANDSHOP, PDP_ADD_TO_CART));
    }

    public static void noPersonalisation() throws Exception
    {
        SeleniumUtils.javaScriptClick(ExcelProperty.getElementValue(BROWSEANDSHOP, PERSONALISED_DROP_DOWN_ACCORDION), 230);
        SeleniumUtils.click(ExcelProperty.getElementValue(BROWSEANDSHOP, PERSONALISED_DROP_DOWN_NO_PERSONALISATION));
    }

    public static String personalizedLabel() throws Exception
    {
        return SeleniumUtils.getAttributes(ExcelProperty.getElementValue(BROWSEANDSHOP, PERSONALIZED_LABEL), "color");
    }

    public static void previewPersonalisationDisabled() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(BROWSEANDSHOP, PERSONALISED_DROP_DOWN_ACCORDION));
        SeleniumUtils.javaScriptClick(ExcelProperty.getElementValue(BROWSEANDSHOP,PERSONALISED_DROP_DOWN_CREATE_VALUE), 230);
    }

    public static void writeAReviewButton() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(BROWSEANDSHOP, PDP_WRITE_A_REVIEW));
    }

    public static void reviewShowMore() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(BROWSEANDSHOP, READ_REVIEW_SHOW_MORE));
    }

    public static void productQNAArrow() throws Exception
    {
        try
        {
            SeleniumUtils.javaScriptExecutorDown("250");
            SeleniumUtils.click(ExcelProperty.getElementValue(BROWSEANDSHOP, PDP_PAGE_PRODUCT_Q_AND_A));
        } catch (Exception e)
        {
            SeleniumUtils.javaScriptExecutorUp("250");
            SeleniumUtils.click(ExcelProperty.getElementValue(BROWSEANDSHOP, PDP_PAGE_PRODUCT_Q_AND_A));
        }

    }

    public static void shippingNReturnsArrow() throws Exception
    {
        try
        {
            SeleniumUtils.javaScriptExecutorDown("250");
            // SeleniumUtils.javaScriptExecutorDown("250");
            SeleniumUtils.click(ExcelProperty.getElementValue(BROWSEANDSHOP, SHIPPING_N_RETURNS_ARROW));
        } catch (Exception e)
        {
            SeleniumUtils.javaScriptExecutorUp("250");
            SeleniumUtils.click(ExcelProperty.getElementValue(BROWSEANDSHOP, SHIPPING_N_RETURNS_ARROW));
        }

    }

    public static boolean productShippingNReturnsDefaultDisplay() throws Exception
    {
        boolean flag = false;
        try
        {
            flag = SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(BROWSEANDSHOP, SHIPPING_N_RETURNS_DISPLAY));
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return flag;

    }

    public static void clickAskQuestionLink() throws Exception
    {
        try
        {
            SeleniumUtils.javaScriptExecutorDown("250");
            SeleniumUtils.click(ExcelProperty.getElementValue(BROWSEANDSHOP, PDP_PAGE_PRODUCT_Q_AND_A_ASK_QUESTION));
        } catch (Exception e)
        {
            SeleniumUtils.javaScriptExecutorUp("250");
            SeleniumUtils.click(ExcelProperty.getElementValue(BROWSEANDSHOP, PDP_PAGE_PRODUCT_Q_AND_A_ASK_QUESTION));
        }
    }

    public static void productQNACreateQuestion() throws Exception
    {
        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(BROWSEANDSHOP, ASK_QUESTION_TEXTBOX_1),
                "what is the quantity of 24 carat gold in the sculpture?");
        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(BROWSEANDSHOP, ASK_QUESTION_TEXTBOX_2), "ABCDEXYZ");
        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(BROWSEANDSHOP, ASK_QUESTION_TEXTBOX_3), "New York");
        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(BROWSEANDSHOP, ASK_QUESTION_TEXTBOX_4), "abcdefgh1234@gmail.com");
        SeleniumUtils.click(ExcelProperty.getElementValue(BROWSEANDSHOP, ASK_QUESTION_CHECKBOX));
        SeleniumUtils.click(ExcelProperty.getElementValue(BROWSEANDSHOP, ASK_QUESTION_POST_QUESTION));
    }

    public static void writeAReviewUsingLink() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(BROWSEANDSHOP, WRITE_REVIEW_OVERALL_RATING));
        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(BROWSEANDSHOP, ASK_QUESTION_TEXTBOX_2), "ABCDEXYZ");
        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(BROWSEANDSHOP, ASK_QUESTION_TEXTBOX_3), "New York");
        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(BROWSEANDSHOP, ASK_QUESTION_TEXTBOX_4), "abcdefgh1234@gmail.com");
        SeleniumUtils.click(ExcelProperty.getElementValue(BROWSEANDSHOP, ASK_QUESTION_CHECKBOX));
        SeleniumUtils.click(ExcelProperty.getElementValue(BROWSEANDSHOP, WRITE_REVIEW_POST_REVIEW));
    }

    public static void closeSubmissionNotification() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(BROWSEANDSHOP, ASK_QUESTION_NOTIFICATION_CLOSE));
    }

    public static void closeReviewSubmissionNotification() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(BROWSEANDSHOP, WRITE_REVIEW_CANCEL_NOTIFICATION));
    }

    public static void clickWriteFirstReviewLink() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(BROWSEANDSHOP, PDP_PAGE_PRODUCT_REVIEWS_WRITE));
    }

    public static boolean productQNADefaultDisplay() throws Exception
    {
        boolean flag = false;
        try
        {
            flag = SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(BROWSEANDSHOP, PDP_PAGE_PRODUCT_Q_AND_A_ASK_QUESTION));
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return flag;

    }

    public static boolean personalisedProductRRDefaultDisplay() throws Exception
    {
        boolean flag = false;
        try
        {
            flag = SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(BROWSEANDSHOP, PDP_WRITE_A_REVIEW));;
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return flag;

    }

    public static boolean noFirstReviewLink() throws Exception
    {
        boolean flag = false;
        try
        {
            flag = SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(BROWSEANDSHOP, PDP_PAGE_PRODUCT_REVIEWS_WRITE));
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return flag;
    }

    public static void personalisedProductVariantAddToCart() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(BROWSEANDSHOP, FONT_CHOICE_FRONT));
        SeleniumUtils.javaScriptClick(ExcelProperty.getElementValue(BROWSEANDSHOP, PERSONALISED_PRODUCT_VARIANT_SIZE), 232);
        // SeleniumUtils.clickByLinkText(PropertyUtil.getObjectValue(PERSONALISED_PRODUCT_VARIANT_SIZE));
        SeleniumUtils.click(ExcelProperty.getElementValue(BROWSEANDSHOP, PERSONALISED_PRODUCT_VARIANT_SIZE_ACC2));
        SeleniumUtils.click(ExcelProperty.getElementValue(BROWSEANDSHOP, PERSONALISED_PRODUCT_VARIANT_GEM));
        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(BROWSEANDSHOP, PERSONALISED_PRODUCT_VARIANT_NAME1), "ABC");
        SeleniumUtils.click(ExcelProperty.getElementValue(BROWSEANDSHOP, PERSONALISED_PRODUCT_VARIANT_SIZE_ACC3));
        SeleniumUtils.click(ExcelProperty.getElementValue(BROWSEANDSHOP, PERSONALISED_PRODUCT_VARIANT_GEM));
        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(BROWSEANDSHOP, PERSONALISED_PRODUCT_VARIANT_NAME2), "DEF");
        SeleniumUtils.javaScriptExecutorDown("250");
        SeleniumUtils.click(ExcelProperty.getElementValue(BROWSEANDSHOP, PERSONALISED_PREVIEW_ADDTOCART));
    }

    public static void clickAlternateImage() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(BROWSEANDSHOP, ALTERNATE_IMAGE_PDP));
    }

    public static void clickImageDinnerwarePLP() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(BROWSEANDSHOP, DINNERWARE_REVIEW_PLP_IMAGE));
    }

    public static boolean verifyIfAddToWishListUnAvailable() throws Exception
    {
        boolean flag = false;
        try
        {
            flag = SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(BROWSEANDSHOP, SKUDETAIL_ADDWISHLIST));
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return flag;

    }

    public static void personalisetocart() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(BROWSEANDSHOP, PERSONALISED_PREVIEW_ADDTOCART));

    }

    public static void personalizeditemsearch(String data) throws Exception

    {
        try
        {
            SeleniumUtils.javaScriptExecutorDown("150");
            SeleniumUtils.click(ExcelProperty.getElementValue(BROWSEANDSHOP, PERSONALISED_DROP_DOWN_ACCORDION));
            SeleniumUtils.sendKeys(ExcelProperty.getElementValue(BROWSEANDSHOP, PERSONALIZED_OPTIONS_PRODUCTNAME), data);
            SeleniumUtils.sendKeys(ExcelProperty.getElementValue(BROWSEANDSHOP, PERSONALIZED_OPTIONS_PRODUCTYEAR),
                    "2016" + Keys.ENTER);
            SeleniumUtils.click(ExcelProperty.getElementValue(BROWSEANDSHOP, PDP_ADD_TO_CART));
        } catch (Exception e)
        {
            SeleniumUtils.javaScriptExecutorUp("250");
            SeleniumUtils.click(ExcelProperty.getElementValue(BROWSEANDSHOP, PERSONALISED_DROP_DOWN_ACCORDION));
            SeleniumUtils.sendKeys(ExcelProperty.getElementValue(BROWSEANDSHOP, PERSONALIZED_OPTIONS_PRODUCTNAME), data);
            SeleniumUtils.sendKeys(ExcelProperty.getElementValue(BROWSEANDSHOP, PERSONALIZED_OPTIONS_PRODUCTYEAR),
                    "2016" + Keys.ENTER);
            SeleniumUtils.click(ExcelProperty.getElementValue(BROWSEANDSHOP, PDP_ADD_TO_CART));

        }
    }

    public static void productWithColorVariant() throws Exception
    {
        SeleniumUtils.javaScriptClick(ExcelProperty.getElementValue(BROWSEANDSHOP, FANCY_BROWN_RING_DROP_DOWN), 232);
        SeleniumUtils.click(ExcelProperty.getElementValue(BROWSEANDSHOP, COLOR_VARIANT_70_ROUND));
        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(BROWSEANDSHOP, PERSONALISED_NAME), "ABC");
        SeleniumUtils.sendKeys(ExcelProperty.getElementValue(BROWSEANDSHOP, PERSONALISED_DATE), "07/12/2016");
        SeleniumUtils.javaScriptClick(ExcelProperty.getElementValue(BROWSEANDSHOP, COLOR_VARIANT_ACC), 232);
        SeleniumUtils.click(ExcelProperty.getElementValue(BROWSEANDSHOP, PERSONALISED_COLOR));
        SeleniumUtils.click(ExcelProperty.getElementValue(BROWSEANDSHOP, PDP_ADD_TO_CART));
    }

    public static void customerBoughtCarouselRight() throws Exception
    {
        SeleniumUtils.javaScriptClick(ExcelProperty.getElementValue(BROWSEANDSHOP, CUSTOMER_ALSO_BOUGHT_CAROUSEL_RIGHT), 232);
    }

    public static void customerBoughtCarouselLeft() throws Exception
    {
        SeleniumUtils.javaScriptClick(ExcelProperty.getElementValue(BROWSEANDSHOP, CUSTOMER_ALSO_BOUGHT_CAROUSEL_LEFT), 232);
    }

    public static void recentlyViewedInfo() throws Exception
    {
        SeleniumUtils.javaScriptClick(ExcelProperty.getElementValue(BROWSEANDSHOP, RECENTLY_VIEWED_INFO), 232);
    }

    public static void clickOutOfStockImagePLP() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(BROWSEANDSHOP, HOME_DECOR_GIFTS_PLP_IMAGE_OUT_OF_STOCK));
    }

    public static void clickRightNav() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(BROWSEANDSHOP, RIGHT_NAVIGATION_BABIES_AND_CHILDREN));
    }

    public static void clickLeftNav() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(BROWSEANDSHOP, LEFT_NAVIGATION_BABIES_AND_CHILDREN));
    }

    public static void clickRightNav2() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(BROWSEANDSHOP, PAGE_2_BABIES_AND_CHILDREN));
    }

    public static void clickHomeBreadcrumb() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(BROWSEANDSHOP, HOME_CLICK_BREADCRUMB));
    }

    public static void clickBreadcrumbBabycups() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(BROWSEANDSHOP, BREACRUMB_BABYCUPS));
    }

    public static void selectCheckbox1() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(BROWSEANDSHOP, PEWTER_SELECT_CHECKBOX_BABY_CUPS));
    }

    public static void selectCheckbox2() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(BROWSEANDSHOP, BABY_COLLECTION_CHECKBOX));
    }

    public static void clickClear() throws Exception
    {
        SeleniumUtils.javaScriptClick(ExcelProperty.getElementValue(BROWSEANDSHOP, FACET_FIRST_REMOVE_ICON), 230);
        //SeleniumUtils.click(ExcelProperty.getElementValue(BROWSEANDSHOP, FACET_FIRST_REMOVE_ICON));
    }

    public static void clickDropDown() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(BROWSEANDSHOP, SORTBY_DROPDOWN_BABIES_AND_CHILDREN));
    }

    public static void clickLowToHigh() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(BROWSEANDSHOP, LOW_TO_HIGH_OPTION));
    }

    public static void clickHighToLow() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(BROWSEANDSHOP, HIGH_TO_LOW_OPTION));
    }

    public static void clickProductImage() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(BROWSEANDSHOP, PRODUCT_IMAGE));
    }
    public static void clickViewPatternProductImage() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(BROWSEANDSHOP, VIEW_MORE_PATTERN_IMAGE));
    }
    
    public static void clickProductImage3() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(BROWSEANDSHOP, ON_SALE_BADGE_PRODUCT));
    }
    public static void clickOnNewBadgeProduct() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(BROWSEANDSHOP, NEW_BADGE_IMAGE));
    }   
    
    public static void clickProductName() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(BROWSEANDSHOP, PLP_PRODUCT_NAME_LINK));
    }

    public static void clickProductImage2() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(BROWSEANDSHOP, ORNAMENTS_ANGELS_PLP_IMAGE));
    }

    public static void clickAddToCart() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(BROWSEANDSHOP, PDP_ADD_TO_CART));
    }

    public static void clickAddToWishList() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(BROWSEANDSHOP, PDP_ADD_WISHLIST));
    }

    public static void clickLoginAddButton() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(BROWSEANDSHOP, PDP_PAGE_WISHLIST_LOGIN_ADD_BUTTON));
    }

    public static void clickShowMoreDesc() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(BROWSEANDSHOP, PDP_PAGE_PRODUCT_SHOW_MORE));
    }

    public static void clickTwitterLink() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(BROWSEANDSHOP, PDP_PAGE_PRODUCT_TWITTER_LINK));
    }

    public static void clickEmailLink() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(BROWSEANDSHOP, PDP_PAGE_PRODUCT_EMAIL_LINK));
    }

    public static void clickImage3() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(BROWSEANDSHOP, FIGURINES_PLP_PAGE_IMAGE_CAT_AND_MOUSE));
    }

    public static void clickBreadcrumbHomeDecor() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(BROWSEANDSHOP, PRODUCT_BREADCRUMB_HOME_DECOR));
    }

    public static void clickBreadcrumbBabyGifts() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(BROWSEANDSHOP, PRODUCT_BREADCRUMB_BABYGIFTS));
    }

    public static void clickAddToRegistry() throws Exception
    {
        SeleniumUtils.javaScriptClick(ExcelProperty.getElementValue(BROWSEANDSHOP, ADD_TO_REGISTRY), 230);

    }

    public static void clickAddToRegistryButton() throws Exception
    {
        SeleniumUtils.switchingFrameById("AddToMr2Iframe");
        SeleniumUtils.javaScriptClick(ExcelProperty.getElementValue(BROWSEANDSHOP, ADD_TO_REGISTRY_BTN), 230);
        DriverFactory.getDriver().switchTo().defaultContent();
    }

    public static void clickSortByDropDown() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(BROWSEANDSHOP, SORTBY_DROPDOWN_BABIES_AND_CHILDREN));
    }

    public static void clickRingSize() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(BROWSEANDSHOP, FANCY_BROWN_RING_SIZE_6));
    }

    public static void recentlyViewedRight() throws Exception
    {
        SeleniumUtils.javaScriptClick(ExcelProperty.getElementValue(BROWSEANDSHOP, RECENTLY_VIEWED_RIGHT), 230);
    }

    public static void recentlyViewedLeft() throws Exception
    {
        SeleniumUtils.javaScriptClick(ExcelProperty.getElementValue(BROWSEANDSHOP, RECENTLY_VIEWED_LEFT), 230);
    }

    public static void personalizeditemsearch1(String personal) throws Exception

    {
        try
        {
            SeleniumUtils.javaScriptExecutorDown("150");
            SeleniumUtils.click(ExcelProperty.getElementValue(BROWSEANDSHOP, PERSONALISED_DROP_DOWN_ACCORDION));
            SeleniumUtils.javaScriptExecutorDown("150");
            SeleniumUtils.click(ExcelProperty.getElementValue(BROWSEANDSHOP, PERSONALISED_DROP_DOWN_CREATE_VALUE));
            SeleniumUtils.sendKeys(ExcelProperty.getElementValue(BROWSEANDSHOP, PERSONALISED_TEXT), personal + Keys.TAB);
            SeleniumUtils.click(ExcelProperty.getElementValue(BROWSEANDSHOP, FONT_CHOICE_FRONT));
            SeleniumUtils.click(ExcelProperty.getElementValue(BROWSEANDSHOP, FONT_CHOICE_FRONT_LINK));
            SeleniumUtils.javaScriptExecutorDown("250");
            SeleniumUtils.click(ExcelProperty.getElementValue(BROWSEANDSHOP, PDP_ADD_TO_CART));
            SeleniumUtils.javaScriptExecutorDown("150");

        } catch (Exception e)
        {
            SeleniumUtils.javaScriptExecutorUp("250");
            SeleniumUtils.click(ExcelProperty.getElementValue(BROWSEANDSHOP, PERSONALISED_DROP_DOWN_ACCORDION));
            SeleniumUtils.javaScriptExecutorDown("150");
            SeleniumUtils.click(ExcelProperty.getElementValue(BROWSEANDSHOP, PERSONALISED_DROP_DOWN_CREATE_VALUE));
            SeleniumUtils.sendKeys(ExcelProperty.getElementValue(BROWSEANDSHOP, PERSONALISED_TEXT), personal + Keys.TAB);
            SeleniumUtils.click(ExcelProperty.getElementValue(BROWSEANDSHOP, FONT_CHOICE_FRONT));
            SeleniumUtils.click(ExcelProperty.getElementValue(BROWSEANDSHOP, FONT_CHOICE_FRONT_LINK));
            SeleniumUtils.javaScriptExecutorDown("250");
            SeleniumUtils.click(ExcelProperty.getElementValue(BROWSEANDSHOP, PDP_ADD_TO_CART));
            SeleniumUtils.javaScriptExecutorDown("150");
        }
    }

    public static void cstmrBoughtCarouselInfo() throws Exception
    {
        SeleniumUtils.javaScriptOnHover(ExcelProperty.getElementValue(BROWSEANDSHOP, CUSTOMER_ALSO_BOUGHT_ON_HOVER), 232);
    }

    public static void personalisedFontChoice() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(BROWSEANDSHOP, FONT_CHOICE_FRONT));
        SeleniumUtils.click(ExcelProperty.getElementValue(BROWSEANDSHOP, FONT_CHOICE_FRONT_LINK));
        SeleniumUtils.click(ExcelProperty.getElementValue(BROWSEANDSHOP, PDP_ADD_TO_CART));
    }

    public static void clickBreakageReplacement() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(BROWSEANDSHOP, BREAKAGE_REPLACEMENT));
    }
    public static void clickOnRatingsAndReviews() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(BROWSEANDSHOP, PDP_PAGE_PRODUCT_RATING_AND_REVIEWS));
    }
}
