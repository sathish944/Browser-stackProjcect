package com.lenox.api.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import com.ch.occ.utils.PropertyUtil;

public class WebServiceUtils implements APIConstants
{
    public static String post(String suffix, String jsonInput)
    { 
        try
        { 
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpPost postRequest = new HttpPost(PropertyUtil.getConfigValue(API_URL) + suffix);
            StringEntity input = new StringEntity(jsonInput);
            input.setContentType(CONTENT_TYPE);
            postRequest.setEntity(input);
            HttpResponse response = httpClient.execute(postRequest);
            return parseResponseMsg(httpClient, response);
        } catch (MalformedURLException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return "";
    }

    public static String get(String suffix)
    {
        try
        {
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpGet getRequest = new HttpGet(PropertyUtil.getConfigValue(API_URL) + suffix);
            getRequest.addHeader(ACCEPT, CONTENT_TYPE);
            HttpResponse response = httpClient.execute(getRequest);
            return parseResponseMsg(httpClient, response);
        } catch (ClientProtocolException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return "";
    }

    public static String parseResponseMsg(DefaultHttpClient httpClient, HttpResponse response) throws IOException
    {
        if (response.getStatusLine().getStatusCode() != 200)
        {
            throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
        }
        BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
        String output = "", content = "";
        while ((output = br.readLine()) != null)
        {
            System.out.println(output);
            content = content + output;
        }
        httpClient.getConnectionManager().shutdown();
        return content;
    }

    public static Map<String, String> parseJSOn(String json, String content)
    {
        Map<String, String> map = new HashMap<String, String>();
        try
        {
            JSONObject jObject = new JSONObject(json);
            JSONObject menu = jObject.getJSONObject(content);
            Iterator<?> iter = menu.keys();
            while (iter.hasNext())
            {
                String key = (String) iter.next();
                String value = menu.getString(key);
                map.put(key, value);
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return map;
    }
}
