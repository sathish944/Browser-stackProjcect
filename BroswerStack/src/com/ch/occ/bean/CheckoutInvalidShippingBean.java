
package com.ch.occ.bean;

public class CheckoutInvalidShippingBean
{

    String email        = "";
    String fname        = "";
    String lname        = "";
    String country      = "";
    String address1     = "";
    String address2     = "";
    String city         = "";
    String stateregion  = "";
    String zipcode      = "";
    String phonenumber  = "";
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

    public CheckoutInvalidShippingBean(String[] line)
    {
        email = line[0];
        fname = line[1];
        lname = line[2];
        country = line[3];
        address1 = line[4];
        address2 = line[5];
        city = line[6];
        stateregion = line[7];
        zipcode = line[8];
        phonenumber = line[9];
        namecard = line[10];
        cardtype = line[11];
        cardnumber = line[12];
        checkoutcvv = line[13];
        expiresmonth = line[14];
        expiresyear = line[15];
        errormessage = line[16]+","+line[17];
        ids = line[18];
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
