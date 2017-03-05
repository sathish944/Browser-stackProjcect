package com.lenox.api.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import com.ch.occ.utils.constants.FileConstants;
import com.lenox.api.bean.AddressBean;

public class APIFileUtility implements FileConstants
{ 
    public static ArrayList<AddressBean> getAllAddressBeanObjects(String fileName) throws Exception
    {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        ArrayList<AddressBean> data = new ArrayList<AddressBean>();
        String headerline = reader.readLine();

        String line = reader.readLine();

        while (null != line)
        { 
            String[] records = line.split(",");
            if (records.length >= 7)
            {
                data.add(new AddressBean(records, headerline));
            }
            line = reader.readLine();
        }
        reader.close();

        return data;
    }
    
}
