package com.ch.occ.bean;

/**
 * Sathish naidu lingutla 12.39 pm 31-10-2016
 */

public class IsDisplayedBean
{

    String module  = "";
    String key     = "";
    String type    = "";
    String message = "";

    public IsDisplayedBean(String[] line)
    {
        module = line[0];
        key = line[1];
        type = line[2];
        message = line[3];
    }

    public String getModule()
    {
        return module;
    }

    public void setModule(String module)
    {
        this.module = module;
    }

    public String getKey()
    {
        return key;
    }

    public void setKey(String key)
    {
        this.key = key;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    
    

   

}
