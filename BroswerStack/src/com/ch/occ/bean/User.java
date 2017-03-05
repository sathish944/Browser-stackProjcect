package com.ch.occ.bean;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class User
{

    String firstName       = "";

    String lastName        = "";

    String email           = "";

    String confirmemail    = "";

    String addone          = "";

    String addtwo          = "";

    String city            = "";

    String prefix          = "";

    String zip             = "";

    String phn             = "";

    String password        = "";

    String confirmPassword = "";

    String birthday        = "";

    String birthmonth      = "";

    String birthyear       = "";

    String errorid         = "";

    String errormsg        = "";

    public User(String[] data)
    {
        prefix = data[0];
        firstName = data[1];
        lastName = data[2];
        birthday = data[3];
        birthmonth = data[4];
        birthyear = data[5];
        addone = data[6];
        addtwo = data[7];
        city = data[8];
        zip = data[9];
        phn = data[10];
        email = random() + data[11];
        password = data[12];
        confirmPassword = data[12];
        errorid = data[13];
        errormsg = data[14];
    }

    /**
     * @return the errorid
     */
    public String getErrorid()
    {
        return errorid;
    }

    /**
     * @param errorid the errorid to set
     */
    public void setErrorid(String errorid)
    {
        this.errorid = errorid;
    }

    /**
     * @return the errormsg
     */
    public String getErrormsg()
    {
        return errormsg;
    }

    /**
     * @param errormsg the errormsg to set
     */
    public void setErrormsg(String errormsg)
    {
        this.errormsg = errormsg;
    }

    /**
     * @return the confirmemail
     */
    public String getConfirmemail()
    {
        return confirmemail;
    }

    /**
     * @param confirmemail
     *            the confirmemail to set
     */
    public void setConfirmemail(String confirmemail)
    {
        this.confirmemail = confirmemail;
    }

    /**
     * @return the prefix
     */
    public String getPrefix()
    {
        return prefix;
    }

    /**
     * @param prefix
     *            the prefix to set
     */
    public void setPrefix(String prefix)
    {
        this.prefix = prefix;
    }

    /**
     * @return the birthday
     */
    public String getBirthday()
    {
        return birthday;
    }

    /**
     * @param birthday
     *            the birthday to set
     */
    public void setBirthday(String birthday)
    {
        this.birthday = birthday;
    }

    /**
     * @return the birthmonth
     */
    public String getBirthmonth()
    {
        return birthmonth;
    }

    /**
     * @param birthmonth
     *            the birthmonth to set
     */
    public void setBirthmonth(String birthmonth)
    {
        this.birthmonth = birthmonth;
    }

    /**
     * @return the birthyear
     */
    public String getBirthyear()
    {
        return birthyear;
    }

    /**
     * @param birthyear
     *            the birthyear to set
     */
    public void setBirthyear(String birthyear)
    {
        this.birthyear = birthyear;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getConfirmPassword()
    {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword)
    {
        this.confirmPassword = confirmPassword;
    }

    public static String random()
    {
        Date date = new Date();
        DateFormat df = new SimpleDateFormat("dmMM");
        String str = df.format(date);
        return str;
    }

    public String getAddone()
    {
        return addone;
    }

    public void setAddone(String addone)
    {
        this.addone = addone;
    }

    public String getAddtwo()
    {
        return addtwo;
    }

    public void setAddtwo(String addtwo)
    {
        this.addtwo = addtwo;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getZip()
    {
        return zip;
    }

    public void setZip(String zip)
    {
        this.zip = zip;
    }

    public String getPhn()
    {
        return phn;
    }

    public void setPhn(String phn)
    {
        this.phn = phn;
    }

}
