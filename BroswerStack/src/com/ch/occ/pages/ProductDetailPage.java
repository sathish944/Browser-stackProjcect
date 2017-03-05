/**
 * user
 */
package com.ch.occ.pages;

import com.ch.ExcelUtils.ExcelProperty;
import com.ch.occ.utils.SeleniumUtils;
import com.ch.occ.utils.constants.FileConstants;

/**
 * @author user 2:19:06 am
 */
public class ProductDetailPage implements FileConstants
{
    public static boolean isAddtoWishList() throws Exception
    {
        boolean flag = false;
        try
        {
            flag = SeleniumUtils.iSDisplayed(ExcelProperty.getElementValue(CART, WISHLIST));
        } catch (Exception e)
        {
            e.printStackTrace();;
        }
        return flag;
    }

}
