/**
 * user
 */
package com.lenox.api.test;

import org.testng.annotations.Test;

import com.lenox.api.utils.OrderDetailAPIUtility;

/**
 * @author user 11:59:05 pm
 */
public class OrderAPITest
{
    @Test
    public static void main() throws Exception
    {
        testOrderDetail();
    }
 
    public static void testOrderDetail()
    {
        String orderId = "o000001";
        String summary = OrderDetailAPIUtility.getSummary(orderId);
        System.out.println(summary);
    }
}
