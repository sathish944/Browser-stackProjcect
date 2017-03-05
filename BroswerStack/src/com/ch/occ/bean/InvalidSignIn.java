/**
 * user
 */
package com.ch.occ.bean;

/**
 * @author Prasanna Kumar Reddy 3:17:48 pm
 */
public class InvalidSignIn
{
    String name       = "";
    String pass       = "";
    String emailerror = "";
    String id         = "";

    public InvalidSignIn(String[] data)
    {
        name = data[0];
        pass = data[1];
        emailerror = data[2] + "," + data[3] + "," + data[4];
        id = data[5];
    }

    public String getName()
    {
        return name;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getPass()
    {
        return pass;
    }

    public void setPass(String pass)
    {
        this.pass = pass;
    }

    public String getEmailerror()
    {
        return emailerror;
    }

    public void setEmailerror(String emailerror)
    {
      
            this.emailerror = emailerror.replaceAll(",", "");
    }

}
