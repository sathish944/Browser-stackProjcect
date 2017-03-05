package com.lenox.api.bean;

public class AddressBean
{
    String addressLine1 = "";

    String addressLine2 = "";

    String city         = "";

    String state        = "";

    String zip          = "";

    String country      = "";

    String error        = "";

    String erroractual  = "";

    String jsonContent  = "";

    String response     = "";

    public AddressBean(String[] column, String line)
    {
        addressLine1 = column[0];
        addressLine2 = column[1];
        city = column[2];
        state = column[3];
        zip = column[4];
        country = column[5];
        error = column[6];

        setJsonContent(column, line);
    }

    public String getJsonContent()
    {
        return jsonContent;
    }

    private void setJsonContent(String[] column, String line)
    {
        jsonContent = jsonContent + "{\n\"inputAddress\":{\n";
        String[] headers = line.split(",");
        for (int i = 0; i < headers.length; i++)
        {
            String comma = ",";
            if (i == headers.length - 1)
            {
                comma = "";
            }
            jsonContent = jsonContent + "\"" + headers[i] + "\":\"" + column[i] + "\"" + comma + "\n";
        }
        jsonContent = jsonContent + "\n}\n}";
    }

    public String getAddressLine1()
    {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1)
    {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2()
    {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2)
    {
        this.addressLine2 = addressLine2;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public String getZip()
    {
        return zip;
    }

    public void setZip(String zip)
    {
        this.zip = zip;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    /**
     * @param response
     */
    public void setResponse(String response)
    {
        this.response = response;
    }

    public String getResponse()
    {
        return response;
    }

    public String getError()
    {
        return error;
    }

    public void setError(String eror)
    {
        this.error = eror;
    }

    public String getErroractual()
    {
        return erroractual;
    }

    public void setErroractual(String erroractual)
    {
        this.erroractual = erroractual.trim();
    }
    
    

}
