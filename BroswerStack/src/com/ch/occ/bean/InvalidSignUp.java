/**
 * user
 */
package com.ch.occ.bean;

/**
 * @author Prasanna Kumar Reddy 7:06:27 am
 */
public class InvalidSignUp
{
    String name       = "";
    String emailerror = "";

    
    public InvalidSignUp(String[] data)
    {
        name = data[0];
        emailerror = data[1];
    }
    
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getEmailerror()
    {
        return emailerror;
    }

    public void setEmailerror(String emailerror)
    {
        this.emailerror = emailerror;
    }

}
