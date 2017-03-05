/**
 * 
 */
package com.ch.occ.report.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.ch.occ.utils.constants.FileConstants;

/**
 * @author Prasanna Kumar Reddy
 *12:23:27 AM
 */
public class CommonReportUtility implements FileConstants
{

    public static String getCurrentDate()
    {
        Date date = new Date();
        DateFormat df = new SimpleDateFormat("ddMMMYYhhmmss");
        String str = df.format(date);
        return str;
    }
    
    public static String getMyIPAddress()
    {
        InetAddress addr;
        String host = "";
        try
        {
            addr = InetAddress.getLocalHost();
            host = "http://"+addr.getHostAddress() + ":9080";
        } catch (UnknownHostException e)
        {
            e.printStackTrace();
        }
        return host;
    }
}
