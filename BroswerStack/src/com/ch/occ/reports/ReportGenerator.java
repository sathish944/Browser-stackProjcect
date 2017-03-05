/**
 * 
 */
package com.ch.occ.reports;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import com.ch.occ.utils.FileUtility;
import com.ch.occ.utils.constants.FileConstants;

/**
 * 11:59:37 PM Prasanna Kumar Reddy Mar 1, 2016
 */
public class ReportGenerator implements FileConstants
{

    public static void main(String[] args) throws Exception
    {
        String starthtml = "<html>";
        String head = FileUtility.readContent(HEAD_FILE);
        String body = "<body bgcolor=\"#f1f1c1\">";
        String endhtml = "</body></html>";

        String summaryTable = generateSummaryTable(getAllTestSuiteResults());
        String DetailReport = generateCaseDetailTable(getAllTestCasesDetailreport());
        String ImageDeatilReport = generateDetailTable(getAllTestCasesDetailResults());

        String htmlContent = starthtml + head + body + summaryTable + DetailReport + ImageDeatilReport + endhtml;
        String currentDate = getCurrentDate();
        FileUtility.writeHTMLContent(REPORTS_HOME + currentDate + ".html", htmlContent);
        // EmailUtility.sendEmail("Test Report at :: " + currentDate,
        // htmlContent);
    }

    public static String generateSummaryTable(ArrayList<TestSummaryResult> testsuites) throws Exception
    {
        if (0 == testsuites.size())
        {
            return "";
        }
        String starttable = FileUtility.readContent(TABLEHEAD_FILE);
        String content = "";
        String test = "";
        for (Iterator<TestSummaryResult> iterator = testsuites.iterator(); iterator.hasNext();)
        {
            TestSummaryResult testSuite = (TestSummaryResult) iterator.next();
            String color = "red";
            if ("-".equalsIgnoreCase(testSuite.getFailCount()))
            {
                color = "green";
            }
            content = content + "<tr><td>" + testSuite.getSuiteName() + "</td><td>" + testSuite.getTotal() + "</td><td>"
                    + testSuite.getPassCount() + "</td><td><font color= \"" + color + "\">" + testSuite.getFailCount()
                    + "</font color></td><td>" + testSuite.getPercentage() + "%</td></tr>";
            
        }
        String endtable = "</table>";

        return starttable + content + test + endtable;
    }

    private static ArrayList<TestSummaryResult> getAllTestSuiteResults()
    {
        ArrayList<TestSummaryResult> testsuites = new ArrayList<TestSummaryResult>();
        for (int i = 0; i < 5; i++)
        {
            TestSummaryResult testSuite = new TestSummaryResult("Register Test Suite" + i, 10 + i, 4 - i);
            testsuites.add(testSuite);
        }
        return testsuites;
    }

    //

    public static String generateCaseDetailTable(ArrayList<TestCaseDetail> testcases) throws Exception
    {
        if (0 == testcases.size())
        {
            return "";
        }
        String starttable = FileUtility.readContent(TABLEDEATILCASE_HEAD_FILE);
        String content = "";
        for (Iterator<TestCaseDetail> iterator = testcases.iterator(); iterator.hasNext();)
        {
            TestCaseDetail testSuite = (TestCaseDetail) iterator.next();
            String color;
            if ("Pass".equalsIgnoreCase(testSuite.getResult()))
            {
                color = "green";
            } else
            {
                color = "red";
            }
            content = content + "<tr><td>" + testSuite.getTestsuitename() + "</td><td>" + testSuite.getTestcasename()
                    + "</td><td>" + testSuite.getExpectedresult() + "</td><td> <font color= \"" + color + "\">"
                    + testSuite.getResult() + "</td><td>" + testSuite.getErrorlog() + "</td></td>";
            // + "</td><td>"
            // + testSuite.getExceptionmessage()
        }
        String endtable = "</table>";

        return starttable + content + endtable;
    }

    public static ArrayList<TestCaseDetail> getAllTestCasesDetailreport()
    {
        ArrayList<TestCaseDetail> testsuites = new ArrayList<TestCaseDetail>();
        for (int i = 0; i < 4; i++)
        {
            if (i == 0)
            {

                TestCaseDetail testSuite = new TestCaseDetail("Login", "Login Password", "Error Msseage thrown", "Pass",
                        "alsk", "a,SNc");
                testsuites.add(testSuite);
            }
            if (i == 1)
            {

                TestCaseDetail testSuite = new TestCaseDetail("Login", "Login Invalid", "Error Msseage thrown", "Pass",
                        "alsk", "a,SNc");
                testsuites.add(testSuite);
            }
            if (i == 2)
            {
                TestCaseDetail testSuite = new TestCaseDetail("Login", "Login valid", "Error Msseage thrown", "Pass",
                        "alsk", "a,SNc");
                testsuites.add(testSuite);
            }
        }
        return testsuites;
    }

    //

    public static String generateDetailTable(ArrayList<TestCaseImageDetail> testcases) throws Exception
    {
        if (0 == testcases.size())
        {
            return "";
        }
        String starttable = FileUtility.readContent(TABLEDETAIL_HEAD_FILE);
        String content = "";
        for (Iterator<TestCaseImageDetail> iterator = testcases.iterator(); iterator.hasNext();)
        {
            TestCaseImageDetail testSuite = (TestCaseImageDetail) iterator.next();
            String color = "";
            if ("Pass".equalsIgnoreCase(testSuite.getResult()))
            {
                color = "green";
            } else
            {
                color = "red";
            }
            content = content + "<tr><td>" + testSuite.getSuitename() + "</td><td>" + testSuite.getTestCaseName()
                    + "</td><td>" + testSuite.getErrorlog() + "</td><td>" + testSuite.getHeight() + "</td><td>"
                    + testSuite.getWidth() + "</td><td>" + testSuite.getTop() + "</td><td>" + testSuite.getLeft()
                    + "</td><td>" + testSuite.getRight() + "</td><td>" + testSuite.getBottom() + "</td><td>"
                    + testSuite.getFontSize() + "</td><td>" + testSuite.getColor() + "</td><td><font color= \"" + color
                    + "\">" + testSuite.getResult() + "</td></tr>";

        }
        String endtable = "</table>";

        return starttable + content + endtable;
    }

    public static ArrayList<TestCaseImageDetail> getAllTestCasesDetailResults()
    {
        ArrayList<TestCaseImageDetail> testsuites = new ArrayList<TestCaseImageDetail>();
        for (int i = 0; i < 5; i++)
        {
            TestCaseImageDetail testSuite = new TestCaseImageDetail("Test", "Image Verification", "60", "70", "80",
                    "90", "20", "20", "60", "50", "30", "Fail");
            testsuites.add(testSuite);
        }
        return testsuites;
    }

    public static String getCurrentDate()
    {
        Date date = new Date();
        DateFormat df = new SimpleDateFormat("ddMMMYYhhmm");
        String str = df.format(date);
        return str;
    }

}