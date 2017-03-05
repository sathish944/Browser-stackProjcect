/**
 * user
 */
package com.ch.occ.pages;

import com.ch.ExcelUtils.ExcelProperty;
import com.ch.occ.utils.SeleniumUtils;
import com.ch.occ.utils.Type;
import com.ch.occ.utils.constants.FileConstants;

/**
 * @author Prasanna Kumar Reddy 1:51:22 am
 */
public class SearchPage implements FileConstants
{
    public static void clicksecondProduct() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(SEARCH, SECOND_PRODUCT));
    }

    public static boolean isFilters()
    {
        boolean flag = false;
        try
        {
            flag = SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(SEARCH, SEARCH_FILTER));
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return flag;
    }

    public static boolean sort()
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

    public static boolean paginationNext()
    {
        boolean flag = false;
        try
        {
            flag = SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(SEARCH, B_S_PAGINATION_NEXT));
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return flag;
    }

    public static boolean isPaginationPrevious()
    {
        boolean flag = false;
        try
        {
            flag = SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(SEARCH, B_S_PAGINATION_PREVIOUS));
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return flag;
    }

    public static void clickFirstProduct() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(SEARCH, F_PRODUCT));
    }

    public static void clickNextPagination() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(SEARCH, B_S_PAGINATION_NEXT));
    }

    public static void clickPreviousPagination() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(SEARCH, B_S_PAGINATION_PREVIOUS));
    }

    public static boolean isStarRating()
    {
        boolean flag = false;
        try
        {
            flag = SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(SEARCH, SEARCH_STAR_RATING));
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return flag;
    }

    public static void clickPagination(int n) throws Exception
    {
        String s = "" + n;
        SeleniumUtils.click(Type.LINKTEXT, s);
    }

    public static String paginationValidate(int n) throws Exception
    {
        String s = "" + n;
        return SeleniumUtils.getCssValue(Type.LINKTEXT, s, "color");
    }

    public static String personlizedTitle() throws Exception
    {

        return SeleniumUtils.getCssValue(ExcelProperty.getElementValue(HOMEPAGE, TITLE_PERSONALIZED), "color");

    }

    public static boolean isProductImage()
    {
        boolean flag = false;
        try
        {
            flag = SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(SEARCH, F_PRODUCT));
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return flag;
    }

    public static String getProductTitle() throws Exception
    {
        return SeleniumUtils.getText(ExcelProperty.getElementValue(SEARCH, FIRST_PRODUCT));
    }

    public static void click24PerPage() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(SEARCH, SORT_VIEW_24));
    }

    public static void clickPersonlize() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(SEARCH, PLP_PERSONALIZE_IT_BUTTON));
    }

    public static boolean isAddToCart()
    {
        boolean flag = false;
        try
        {
            flag = SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(SEARCH, ADD_TO_CART_SKULIST));
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return flag;
    }

    public static boolean isPrice()
    {
        boolean flag = false;
        try
        {
            flag = SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(SEARCH, PRODUCT_PRICE));
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return flag;
    }

    public static boolean isProductTitle()
    {
        boolean flag = false;
        try
        {
            flag = SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(SEARCH, FIRST_PRODUCT));
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return flag;
    }

    public static String isdefaultSortViewValue() throws Exception
    {
        return SeleniumUtils.getText(ExcelProperty.getElementValue(SEARCH, SORT_VIEW));
    }

    public static boolean isSortView24PerPage()
    {
        boolean flag = false;
        try
        {
            flag = SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(SEARCH, SORT_VIEW_24));
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return flag;
    }

    public static boolean isSortView36PerPage()
    {
        boolean flag = false;
        try
        {
            flag = SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(SEARCH, SORT_VIEW_36));
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return flag;
    }

    public static boolean isSortViewViewAll()
    {
        boolean flag = false;
        try
        {
            flag = SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(SEARCH, SORT_VIEW_VIEW_ALL));
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return flag;
    }

    public static void clickViewViewAll() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(SEARCH, SORT_VIEW_VIEW_ALL));
    }

    public static boolean isSortPriceLowToHigh()
    {
        boolean flag = false;
        try
        {
            flag = SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(SEARCH, SORT_SORT_BY_LOW_HIGH));
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return flag;
    }

    public static boolean isSortPriceHighToLow()
    {
        boolean flag = false;
        try
        {
            flag = SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(SEARCH, SORT_SORT_BY_HIGH_LOW));
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return flag;
    }

    public static void clickSortViewBy() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(SEARCH, SORT_VIEW));
    }

    public static void clickSort() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(SEARCH, B_S_SORT_SELECT));
    }

    public static void selectPDPSecondValue() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(SEARCH, SELECT_RING_SIZE));
    }

    public static void enablePDPSecondValue() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(SEARCH, SELECT_RING_SIZE));
    }

    public static void clickFirstCategory() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(SEARCH, CATEGORY_FIRST_ITEM));
    }

    public static void clickRemoveAll() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(SEARCH, REMOVE_ALL_SEARCH));
    }

    public static boolean isRemoveAll() throws Exception
    {
        boolean flag = false;
        try
        {
            flag = SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(SEARCH, REMOVE_ALL_SEARCH));
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return flag;
    }

    public static void clickLowToHighInSort() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(SEARCH, SORT_SORT_BY_LOW_HIGH));
    }

    public static void clickHighToLowInSort() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(SEARCH, SORT_SORT_BY_HIGH_LOW));
    }

    public static void clickProductNameInSort() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(SEARCH, SORT_PRODUCT_NAME));
    }

    public static String getPDPDescription() throws Exception
    {
        return SeleniumUtils.getText(ExcelProperty.getElementValue(SEARCH, PDP_PRODUCT_DESC));
    }

    public static String getCategoryBreadCrumb() throws Exception
    {
        return SeleniumUtils.getText(ExcelProperty.getElementValue(SEARCH, CATEGORY_BREADCRUMB));
    }

    public static boolean isCategoryBreadCrumb() throws Exception
    {
        boolean flag = false;
        try
        {
            flag = SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(SEARCH, CATEGORY_BREADCRUMB));
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return flag;
    }

    public static void clickAutumnCheckBox() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(SEARCH, AUTUMN_CHECK_BOX));
    }

    public static void clickBrandCheckBox() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(SEARCH, BRAND_CHECK_BOX));
    }

    public static boolean isFacetSelected() throws Exception
    {
        boolean flag = false;
        try
        {
            flag = SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(SEARCH, YOUR_SELECTION_REFINEMENT));
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return flag;
    }

    public static boolean isFacetXsign() throws Exception
    {
        boolean flag = false;
        try
        {
            flag = SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(SEARCH, FACET_FIRST_REMOVE_ICON));
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return flag;
    }

    public static void clickFacetXsign() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(SEARCH, FACET_FIRST_REMOVE_ICON));
    }

    public static void clickMoreDetailsButton() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(SEARCH, MORE_DETAILS_SEARCH));
    }

    public static void clickDinnerCheckBox() throws Exception
    {
        try
        {
            SeleniumUtils.javaScriptClick(ExcelProperty.getElementValue(SEARCH, DINNERWARE_CHECK_BOX), 230);
        } catch (Exception e)
        {
            SeleniumUtils.click(ExcelProperty.getElementValue(SEARCH, DINNERWARE_CHECK_BOX));
        }

    }

    public static void clickMoreLink() throws Exception
    {
        SeleniumUtils.javaScriptClick(ExcelProperty.getElementValue(SEARCH, MORE_LINK_FILTER), 230);
    }

    public static void clickLessLink() throws Exception
    {
        SeleniumUtils.javaScriptClick(ExcelProperty.getElementValue(SEARCH, LESS_LINK_FILTER), 230);
    }

    public static void clickclearAll() throws Exception
    {
        try
        {
            SeleniumUtils.javaScriptClick(ExcelProperty.getElementValue(SEARCH, CLEAR_ALL), 230);
        } catch (Exception e)
        {
            SeleniumUtils.javaScriptClick(ExcelProperty.getElementValue(SEARCH, CLEAR_ALL), 250);
        }
    }

    public static void isClearAll() throws Exception
    {
        try
        {
            SeleniumUtils.javaScriptClick(ExcelProperty.getElementValue(SEARCH, CLEAR_ALL), 230);
        } catch (Exception e)
        {
            SeleniumUtils.javaScriptClick(ExcelProperty.getElementValue(SEARCH, CLEAR_ALL), 230);
        }
    }
}
