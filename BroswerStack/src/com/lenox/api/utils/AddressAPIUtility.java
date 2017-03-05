package com.lenox.api.utils;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;

import com.lenox.api.bean.AddressBean;

public class AddressAPIUtility extends WebServiceUtils
{

    static String URL_SUFFIX = "history/order/validate/address";

    public static void validate(AddressBean address)
    {
        String response = post(URL_SUFFIX, address.getJsonContent());
        address.setResponse(response);
        parseJSOnContent(response, address);
    } 
 
    public static void parseJSOnContent(String response, AddressBean addressBean)
    {
        JSONObject obj;
        try
        {
            obj = new JSONObject(response);
            String addressSuggestion = obj.getBoolean("addressSuggestionAvailable") + "";
            if ("true".equalsIgnoreCase(addressSuggestion))
            {
                JSONObject jsonObject = obj.getJSONObject("validatedAddress");
                String address2 = jsonObject.getString("addressLine2");
                System.out.println(address2);
                Assert.assertEquals(addressBean.getAddressLine2().toUpperCase(), address2);

            } else if ("false".equalsIgnoreCase(addressSuggestion))
            {
                String errorDes = obj.getString("errorDescription");
                System.out.println(errorDes);
                String error = obj.getString("errorDescription");
                addressBean.setErroractual(error);
            }

        } catch (JSONException e)
        {
            e.printStackTrace();
        }
    }
}
