package com.ch.occ.bean;

public class CountryBean
{
    String drop = "";
    
    String assertion = "";
    
    public CountryBean(String[] data)
    {
        drop = data[0];
        assertion = data[1];
    }

    public String getDrop()
    {
        return drop;
    }

    public void setDrop(String drop)
    {
        this.drop = drop;
    }

    public String getAssertion()
    {
        return assertion;
    }

    public void setAssertion(String assertion)
    {
        this.assertion = assertion;
    }
    
    
}
