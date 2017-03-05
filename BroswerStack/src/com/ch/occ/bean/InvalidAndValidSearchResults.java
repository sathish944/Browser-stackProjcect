/**
 * user
 */
package com.ch.occ.bean;

/**
 * @author Prasanna Kumar Reddy 7:06:27 am
 */
public class InvalidAndValidSearchResults
{
    String searchKeyword       = "";
    String searcherror = "";

    
    public InvalidAndValidSearchResults(String[] data)
    {
        searchKeyword = data[0];
        searcherror = data[1];
    }
    
    public String SearchKeyword()
    {
        return searchKeyword;
    }

    public void setName(String name)
    {
        this.searchKeyword = name;
    }

    public String getSearcherror()
    {
        return searcherror;
    }

    public void setEmailerror(String emailerror)
    {
        this.searcherror = emailerror;
    }

}
