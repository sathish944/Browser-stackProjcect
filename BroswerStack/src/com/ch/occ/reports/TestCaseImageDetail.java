/**
 * 
 */
package com.ch.occ.reports;

import java.util.HashMap;

import com.ch.occ.bean.ImageTextBean;

/**
 * @author 1:04:36 PM Prasanna Kumar Reddy Mar 3, 2016
 */
public class TestCaseImageDetail
{
    String suitename     = "";
    String testcasesname = "";
    String errorlog      = "";
    String height        = "";
    String width         = "";
    String top           = "";
    String left          = "";
    String right         = "";
    String marginright   = "";
    String marginleft    = "";
    String margintop     = "";
    String marginbottom  = "";
    String bottom        = "";
    String fontSize      = "";
    String color         = "";
    String result        = "";
    String logFile       = "";

    public TestCaseImageDetail(ImageTextBean bean)
    {
        suitename = "Image Verification";
        testcasesname = bean.getImagename();
        HashMap<String, String> results = bean.getCSSResults();
        height = results.get("height");
        width = results.get("width");
        top = results.get("top");
        left = results.get("left");
        right = results.get("right");
        marginright = results.get("margin-right");
        marginleft = results.get("margin-left");
        margintop = results.get("margin-top");
        marginbottom = results.get("margin-bottom");
        bottom = results.get("bottom");
        fontSize = results.get("fontSize");
        color = results.get("color");
        result = bean.getFinalResult();
    }

    /**
     * @return the suitename
     */
    public TestCaseImageDetail(String testsuitename, String testcasename, String testerrorlog, String height,
            String width, String top, String left, String right, String Botto, String fontsize, String color,
            String result)
    {
        suitename = testsuitename;
        testcasesname = testcasename;
        errorlog = testerrorlog;
        this.height = height;
        this.width = width;
        this.top = top;
        this.left = left;
        this.right = right;
        bottom = Botto;
        this.fontSize = fontsize;
        this.color = color;
        this.result = result;

    }

    public String getResult()
    {
        return result;
    }

    public void setResult(String result)
    {
        this.result = result;
    }

    public String getSuitename()
    {
        return suitename;
    }

    /**
     * @param suitename
     *            the suitename to set
     */
    public void setSuitename(String suitename)
    {
        this.suitename = suitename;
    }

    /**
     * @return the testcasename
     */
    public String getTestCaseName()
    {
        return testcasesname;
    }

    /**
     * @param testcasename
     *            the testcasename to set
     */
    public void setTestcasename(String testcasename)
    {
        this.testcasesname = testcasename;
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
     * @return the height
     */
    public String getHeight()
    {
        return height;
    }

    /**
     * @param height
     *            the height to set
     */
    public void setHeight(String height)
    {
        this.height = height;
    }

    /**
     * @return the width
     */
    public String getWidth()
    {
        return width;
    }

    /**
     * @param width
     *            the width to set
     */
    public void setWidth(String width)
    {
        this.width = width;
    }

    /**
     * @return the top
     */
    public String getTop()
    {
        return top;
    }

    /**
     * @param top
     *            the top to set
     */
    public void setTop(String top)
    {
        this.top = top;
    }

    /**
     * @return the left
     */
    public String getLeft()
    {
        return left;
    }

    public void setLeft(String left)
    {
        this.left = left;
    }

    public String getRight()
    {
        return right;
    }

    public void setRight(String right)
    {
        this.right = right;
    }

    /**
     * @return the bottom
     */
    public String getBottom()
    {
        return bottom;
    }

    /**
     * @param bottom
     *            the bottom to set
     */
    public void setBottom(String bottom)
    {
        this.bottom = bottom;
    }

    /**
     * @return the fontSize
     */
    public String getFontSize()
    {
        return fontSize;
    }

    /**
     * @param fontSize
     *            the fontSize to set
     */
    public void setFontSize(String fontSize)
    {
        this.fontSize = fontSize;
    }

    /**
     * @return the color
     */
    public String getColor()
    {
        return color;
    }

    /**
     * @param color
     *            the color to set
     */
    public void setColor(String color)
    {
        this.color = color;
    }

    /**
     * @return the logFile
     */
    public String getLogFile()
    {
        return logFile;
    }

    /**
     * @param logFile
     *            the logFile to set
     */
    public void setLogFile(String logFile)
    {
        this.logFile = logFile;
    }

    /**
     * @return the marginright
     */
    public String getMarginright()
    {
        return marginright;
    }

    /**
     * @param marginright the marginright to set
     */
    public void setMarginright(String marginright)
    {
        this.marginright = marginright;
    }

    /**
     * @return the marginleft
     */
    public String getMarginleft()
    {
        return marginleft;
    }

    /**
     * @param marginleft the marginleft to set
     */
    public void setMarginleft(String marginleft)
    {
        this.marginleft = marginleft;
    }

    /**
     * @return the margintop
     */
    public String getMargintop()
    {
        return margintop;
    }

    /**
     * @param margintop the margintop to set
     */
    public void setMargintop(String margintop)
    {
        this.margintop = margintop;
    }

    /**
     * @return the marginbottom
     */
    public String getMarginbottom()
    {
        return marginbottom;
    }

    /**
     * @param marginbottom the marginbottom to set
     */
    public void setMarginbottom(String marginbottom)
    {
        this.marginbottom = marginbottom;
    }

}
