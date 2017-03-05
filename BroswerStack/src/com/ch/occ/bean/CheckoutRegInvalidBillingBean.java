
package com.ch.occ.bean;

public class CheckoutRegInvalidBillingBean
{

    String email        = "";
    String rfname       = "";
    String rlname       = "";
    String rpass        = "";
    String rconfirm     = "";
    String fname        = "";
    String lname        = "";
    String country      = "";
    String address1     = "";
    String address2     = "";
    String city         = "";
    String stateregion  = "";
    String zipcode      = "";
    String phonenumber  = "";
    String bfname       = "";
    String blname       = "";
    String bcountry     = "";
    String baddress1    = "";
    String baddress2    = "";
    String bcity        = "";
    String bstateregion = "";
    String bzipcode     = "";
    String bphone = "";
    String namecard     = "";
    String cardtype     = "";
    String cardnumber   = "";
    String checkoutcvv  = "";
    String expiresmonth = "";
    String expiresyear  = "";
    String errormessage = "";
    String ids          = "";

    public int getIntValue(String string)
    {
        if (!"".equalsIgnoreCase(string.trim()))
        {
            return Integer.parseInt(string);
        }
        return 0;
    }

    public CheckoutRegInvalidBillingBean(String[] line)
    {
        email = line[0];
        rfname = line[1];
        rlname = line[2];
        rpass = line[3];
        rconfirm = line[4];
        fname = line[5];
        lname = line[6];
        country = line[7];
        address1 = line[8];
        address2 = line[9];
        city = line[10];
        stateregion = line[11];
        zipcode = line[12];
        phonenumber = line[13];
        bfname = line[14];
        blname = line[15];
        bcountry = line[16];
        baddress1 = line[17];
        baddress2 = line[18];
        bcity = line[19];
        bstateregion = line[20];
        bzipcode = line[21];
        bphone = line[22];
        namecard = line[23];
        cardtype = line[24];
        cardnumber = line[25];
        checkoutcvv = line[26];
        expiresmonth = line[27];
        expiresyear = line[28];
        errormessage = line[29]+","+line[30];
        ids = line[31];
    }

    
    
    public String getBphone()
    {
        return bphone;
    }

    public void setBphone(String bphone)
    {
        this.bphone = bphone;
    }

    /**
     * @return the email
     */
    public String getEmail()
    {
        return email;
    }

    /**
     * @param email
     *            the email to set
     */
    public void setEmail(String email)
    {
        this.email = email;
    }

    /**
     * @return the fname
     */
    public String getFname()
    {
        return fname;
    }

    public String getRfname()
    {
        return rfname;
    }

    public void setRfname(String rfname)
    {
        this.rfname = rfname;
    }

    public String getRlname()
    {
        return rlname;
    }

    public void setRlname(String rlname)
    {
        this.rlname = rlname;
    }

    public String getRpass()
    {
        return rpass;
    }

    public void setRpass(String rpass)
    {
        this.rpass = rpass;
    }

    public String getRconfirm()
    {
        return rconfirm;
    }

    public void setRconfirm(String rconfirm)
    {
        this.rconfirm = rconfirm;
    }

    /**
     * @param fname
     *            the fname to set
     */
    public void setFname(String fname)
    {
        this.fname = fname;
    }

    /**
     * @return the lname
     */
    public String getLname()
    {
        return lname;
    }

    /**
     * @param lname
     *            the lname to set
     */
    public void setLname(String lname)
    {
        this.lname = lname;
    }

    /**
     * @return the country
     */

    /**
     * @return the address1
     */
    public String getAddress1()
    {
        return address1;
    }

    /**
     * @return the country
     */
    public String getCountry()
    {
        return country;
    }

    /**
     * @param country
     *            the country to set
     */
    public void setCountry(String country)
    {
        this.country = country;
    }

    /**
     * @param address1
     *            the address1 to set
     */
    public void setAddress1(String address1)
    {
        this.address1 = address1;
    }

    /**
     * @return the address2
     */
    public String getAddress2()
    {
        return address2;
    }

    /**
     * @param address2
     *            the address2 to set
     */
    public void setAddress2(String address2)
    {
        this.address2 = address2;
    }

    
    
    public String getBfname()
    {
        return bfname;
    }

    public void setBfname(String bfname)
    {
        this.bfname = bfname;
    }

    public String getBlname()
    {
        return blname;
    }

    public void setBlname(String blname)
    {
        this.blname = blname;
    }

    public String getBcountry()
    {
        return bcountry;
    }

    public void setBcountry(String bcountry)
    {
        this.bcountry = bcountry;
    }

    public String getBaddress1()
    {
        return baddress1;
    }

    public void setBaddress1(String baddress1)
    {
        this.baddress1 = baddress1;
    }

    public String getBaddress2()
    {
        return baddress2;
    }

    public void setBaddress2(String baddress2)
    {
        this.baddress2 = baddress2;
    }

    public String getBcity()
    {
        return bcity;
    }

    public void setBcity(String bcity)
    {
        this.bcity = bcity;
    }

    public String getBstateregion()
    {
        return bstateregion;
    }

    public void setBstateregion(String bstateregion)
    {
        this.bstateregion = bstateregion;
    }

    public String getBzipcode()
    {
        return bzipcode;
    }

    public void setBzipcode(String bzipcode)
    {
        this.bzipcode = bzipcode;
    }

    /**
     * @return the city
     */
    public String getCity()
    {
        return city;
    }

    /**
     * @param city
     *            the city to set
     */
    public void setCity(String city)
    {
        this.city = city;
    }

    /**
     * @return the stateregion
     */
    public String getStateregion()
    {
        return stateregion;
    }

    /**
     * @param stateregion
     *            the stateregion to set
     */
    public void setStateregion(String stateregion)
    {
        this.stateregion = stateregion;
    }

    /**
     * @return the zipcode
     */
    public String getZipcode()
    {
        return zipcode;
    }

    /**
     * @param zipcode
     *            the zipcode to set
     */
    public void setZipcode(String zipcode)
    {
        this.zipcode = zipcode;
    }

    /**
     * @return the phonenumber
     */
    public String getPhonenumber()
    {
        return phonenumber;
    }

    /**
     * @param phonenumber
     *            the phonenumber to set
     */
    public void setPhonenumber(String phonenumber)
    {
        this.phonenumber = phonenumber;
    }

    /**
     * @return the namecard
     */
    public String getNamecard()
    {
        return namecard;
    }

    /**
     * @param namecard
     *            the namecard to set
     */
    public void setNamecard(String namecard)
    {
        this.namecard = namecard;
    }

    /**
     * @return the cardtype
     */
    public String getCardtype()
    {
        return cardtype;
    }

    /**
     * @param cardtype
     *            the cardtype to set
     */
    public void setCardtype(String cardtype)
    {
        this.cardtype = cardtype;
    }

    /**
     * @return the cardnumber
     */
    public String getCardnumber()
    {
        return cardnumber;
    }

    /**
     * @param cardnumber
     *            the cardnumber to set
     */
    public void setCardnumber(String cardnumber)
    {
        this.cardnumber = cardnumber;
    }

    /**
     * @return the checkoutcvv
     */
    public String getCheckoutcvv()
    {
        return checkoutcvv;
    }

    /**
     * @param checkoutcvv
     *            the checkoutcvv to set
     */
    public void setCheckoutcvv(String checkoutcvv)
    {
        this.checkoutcvv = checkoutcvv;
    }

    /**
     * @return the expiresmonth
     */
    public String getExpiresmonth()
    {
        return expiresmonth;
    }

    /**
     * @param expiresmonth
     *            the expiresmonth to set
     */
    public void setExpiresmonth(String expiresmonth)
    {
        this.expiresmonth = expiresmonth;
    }

    /**
     * @return the expiresyear
     */
    public String getExpiresyear()
    {
        return expiresyear;
    }

    /**
     * @param expiresyear
     *            the expiresyear to set
     */
    public void setExpiresyear(String expiresyear)
    {
        this.expiresyear = expiresyear;
    }

    /**
     * @return the expiresyear
     */

    public String getErrormessage()
    {
        return errormessage;
    }

    public void setErrormessage(String errormessage)
    {
        this.errormessage = errormessage;
    }

    public String getIds()
    {
        return ids;
    }

    public void setIds(String ids)
    {
        this.ids = ids;
    }

}
