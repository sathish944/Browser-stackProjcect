
package com.ch.occ.reports;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;

import com.ch.occ.utils.CommonUtils;
import com.ch.occ.utils.DriverFactory;
import com.ch.occ.utils.constants.FileConstants;

/**
 * @author 11:59:11 AM Prasanna Kumar Reddy Mar 6, 2016
 */
public class TestCaseDetail extends CommonUtils implements FileConstants
{
    String testsuitename    = "";
    String testcasename     = "";
    String expectedresult   = "";
    String result           = "";
    String errorlog         = "";
    String exceptionmessage = "";
    String comment          = "";

    /**
     * @return the testsuitename
     */

    public TestCaseDetail(String testsuitename, String tcname, String expectdresult, String result, String errorlog,
            String excepmsg)
    {
        this.testsuitename = testsuitename;
        testcasename = tcname;
        this.expectedresult = expectdresult;
        this.result = result;
        this.errorlog = errorlog;
        exceptionmessage = excepmsg;
    }

    public TestCaseDetail(Class<?> object, String name)
    {
        this.testsuitename = object.getSimpleName();
        this.testcasename = name;
    }

    public void pass(String expectedResult)
    {
        if ("".equalsIgnoreCase(result))
        {
            this.expectedresult = expectedResult;
            result = "PASS";
        }
    }

    public void setErrorLogFile(Throwable trace) throws IOException
    {
        String errorFile = "err_" + getCurrentDate() + ".log";
        try
        {
            File textr = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
            String file = getCurrentDate() + ".png";
            FileUtils.copyFile(textr, new File(REPORTS_HOME + file));
            PrintWriter printWriter = new PrintWriter(REPORTS_HOME + errorFile);
            trace.printStackTrace(printWriter);
            printWriter.close();
            this.errorlog = "<a target=\"_balnk\" href=\"" + "./" + errorFile + "\"> <font color=\"red\">Error Log</a>"
                    + "<br>" + "<a target=\"_balnk\" href=\"" + "./" + file + "\"> <font color=\"red\">Screen Shot</a>";
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    public String getComment()
    {
        return comment;
    }

    public void setComment(String comment)
    {
        this.comment = comment;
    }

    public void comments(String def)
    {
        if (result == "PASS")
        {

        } else
        {
            this.comment = def;
        }
    }

    public void assertTrue(boolean flag, String expected, String actual)
    {
        if (flag == false)
        {
            fail(expected, actual);
        }
    }

    public void assertFalse(boolean flag, String expected, String actual)
    {
        if (flag == true)
        {
            fail(expected, actual);
        }
    }

    public void forceAssert(boolean flag, String expected, String actual)
    {
        if (flag == false)
        {
            fail(expected, actual);
            Assert.fail(expected);
        }
    }

    public void assertEquals(String expected, String actual)
    {
        if (null == actual || null == expected || actual.equalsIgnoreCase(expected) == false)
        {
            fail(expected, actual);
        }
    }

    public void forceAssertEquals(String expected, String actual)
    {
        if (null == actual || null == expected || actual.equalsIgnoreCase(expected) == false)
        {
            fail(expected, actual);
            Assert.assertEquals(actual, expected);
        }
    }

    public void fail(String expectedResult, String actual)
    {
        if ("".equalsIgnoreCase(result))
        {
            this.expectedresult = expectedResult;
            result = "FAIL";
            errorlog = actual;
        } else
        {
            this.expectedresult = this.expectedresult + "\n" + expectedResult;
            result = "FAIL";
            errorlog = this.errorlog + "\n" + actual;
        }
    }

    public void error(String expectedResult, Throwable trace) throws Exception
    {
        this.expectedresult = expectedResult;
        result = "ERROR";
        exceptionmessage = trace.getMessage();
        setErrorLogFile(trace);
    }

    public String getTestsuitename()
    {
        return testsuitename;
    }

    /**
     * @param testsuitename
     *            the testsuitename to set
     */
    public void setTestsuitename(String testsuitename)
    {
        this.testsuitename = testsuitename;
    }

    /**
     * @return the testcasename
     */
    public String getTestcasename()
    {
        return testcasename;
    }

    /**
     * @param testcasename
     *            the testcasename to set
     */
    public void setTestcasename(String testcasename)
    {
        this.testcasename = testcasename;
    }

    /**
     * @return the expectedresult
     */
    public String getExpectedresult()
    {
        return expectedresult;
    }

    /**
     * @param expectedresult
     *            the expectedresult to set
     */
    public void setExpectedresult(String expectedresult)
    {
        this.expectedresult = expectedresult;
    }

    /**
     * @return the result
     */
    public String getResult()
    {
        return result;
    }

    /**
     * @param result
     *            the result to set
     */
    public void setResult(String result)
    {
        this.result = result;
    }

    /**
     * @return the errorlog
     */
    public String getErrorlog()
    {
        return errorlog;
    }

    /**
     * @param errorlog
     *            the errorlog to set
     */
    public void setErrorlog(String errorlog)
    {
        this.errorlog = errorlog;
    }

    /**
     * @return the exceptionmessage
     */
    public String getExceptionmessage()
    {
        return exceptionmessage;
    }

    /**
     * @param exceptionmessage
     *            the exceptionmessage to set
     */
    public void setExceptionmessage(String exceptionmessage)
    {
        this.exceptionmessage = exceptionmessage;
    }

}
