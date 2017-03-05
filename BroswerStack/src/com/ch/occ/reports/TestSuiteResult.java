/**
 * 
 */
package com.ch.occ.reports;

public class TestSuiteResult
{

    String suiteName  = "";

    int    pass       = 0;

    int    fail       = 0;

    int    total      = 0;

    String percentage = "";

    public TestSuiteResult(String name, int pass, int fail)
    {
        suiteName = name;
        this.pass = pass;
        this.fail = fail;
        total = pass + fail;
        int temp = (pass * 100 / total);
        percentage = temp + "";
    }

    /**
     * @return the suiteName
     */
    public String getSuiteName()
    {
        return suiteName;
    }

    /**
     * @param suiteName
     *            the suiteName to set
     */
    public void setSuiteName(String suiteName)
    {
        this.suiteName = suiteName;
    }

    /**
     * @return the pass
     */
    public String getPassCount()
    {
        if (0 == pass)
        {
            return "-";
        }
        return pass + "";
    }

    /**
     * @param pass
     *            the pass to set
     */
    public void setPass(int pass)
    {
        this.pass = pass;
    }

    /**
     * @return the fail
     */
    public String getFailCount()
    {
        if (0 == fail)
        {
            return "-";
        }
        return fail + "";
    }

    /**
     * @param fail
     *            the fail to set
     */
    public void setFail(int fail)
    {
        this.fail = fail;
    }

    /**
     * @return the total
     */
    public int getTotal()
    {
        return total;
    }

    /**
     * @param total
     *            the total to set
     */
    public void setTotal(int total)
    {
        this.total = total;
    }

    /**
     * @return the percentage
     */
    public String getPercentage()
    {
        return percentage;
    }

    /**
     * @param percentage
     *            the percentage to set
     */
    public void setPercentage(String percentage)
    {
        this.percentage = percentage;
    }

}
