package com.lenox.api.utils;

import org.json.JSONException;
import org.json.JSONObject;

public class OrderDetailAPIUtility extends WebServiceUtils
{

    static String URL_SUFFIX = "history/order/detail/external/";

    public static String getSummary(String orderId)
    {
        String response = get(URL_SUFFIX + orderId);
        parseJSOnContent(response);
        return response;
    } 
     
    public static void parseJSOnContent(String response)
    {
        JSONObject obj;
        try
        {
            obj = new JSONObject(response);
            JSONObject jsonObject = obj.getJSONObject("orderDetail");
            System.out.println(jsonObject.getString("createDate"));
            String pageName = jsonObject.getString("clientReference");
            System.out.println(pageName);
            JSONObject jsonObject2 = jsonObject.getJSONObject("orderTotal");
            System.out.println(jsonObject2.getInt("initialItemTotal"));
        } catch (JSONException e)
        {
            e.printStackTrace();
        }
    }

}
