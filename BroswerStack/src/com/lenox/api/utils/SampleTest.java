/**
 * user
 */
package com.lenox.api.utils;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author user 11:06:18 pm
 */
public class SampleTest
{ 

    public static void main(String[] args) throws JSONException
    {
        String id = "{\"orderDetail\": {\"orderHeaderID\": 62," + "\"clientReference\": \"o000001\","
                + "\"createDate\": \"06/14/2016\",\"orderTotal\": {\"initialItemTotal\": 43.31,\"itemTotal\": 43.31}}}";
        JSONObject obj = new JSONObject(id);
        JSONObject jsonObject = obj.getJSONObject("orderDetail");

        System.out.println(jsonObject.getString("createDate"));

        String pageName = jsonObject.getString("clientReference");
        System.out.println(pageName);

        String key = "orderDetail#orderTotal#itemTotal";

        String[] split = key.split("#");
        JSONObject obj2 = obj;
        int i = 0;
        System.out.println(split.length);
        for (; i < split.length - 1; i++)
        {
            obj2 = obj2.getJSONObject(split[i]);
        }
        System.out.println(obj2.getInt(split[i]));

        JSONObject jsonObject2 = jsonObject.getJSONObject("orderTotal");
        System.out.println(jsonObject2.getInt("initialItemTotal"));
        // JSONArray arr = obj.getJSONArray("posts");
        // for (int i = 0; i < arr.length(); i++)
        // {
        // String post_id = arr.getJSONObject(i).getString("post_id");
        // System.out.println(post_id);
        // }
    }
}
