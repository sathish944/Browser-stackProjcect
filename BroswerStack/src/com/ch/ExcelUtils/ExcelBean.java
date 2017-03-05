package com.ch.ExcelUtils;

/**
 * @author Prasanna kumar Reddy 9:20:46 pm
 */

public class ExcelBean
{
    private String type;
    
    private String value;

    private String name;

    public String getName()
    {
        return name;
    }

    public void setKey(String name)
    {
        this.name = name;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getValue()
    {
        return value;
    }

    public void setValue(String value)
    {
        this.value = value;
    }

    @Override
    public String toString()
    {
        return "Type: " + this.getType() + ", " + "Value: " + this.getValue() + "\n";
    }

}

/**
 * @author Prasanna kumar reddy 9:20:46 pm
 */

