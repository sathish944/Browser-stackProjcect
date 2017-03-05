package com.lenox.api.test;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ch.occ.utils.constants.FileConstants;
import com.lenox.api.bean.AddressBean;
import com.lenox.api.utils.APIConstants;
import com.lenox.api.utils.APIFileUtility;
import com.lenox.api.utils.AddressAPIUtility;

public class AddressSuggestionsTest implements APIConstants, FileConstants
{
    @Test
    public static void main() throws Exception
    {
        testValidateAddress();
    }
 
    private static void testValidateAddress() throws Exception
    { 
        ArrayList<AddressBean> data = APIFileUtility.getAllAddressBeanObjects(ADDRESS_API);
        for (AddressBean addressBean : data)
        {
            AddressAPIUtility.validate(addressBean);
            System.out.println(addressBean.getAddressLine2());
            Assert.assertEquals(addressBean.getError(), addressBean.getErroractual());
        }
    }

}
