package com.ch.ExcelUtils;

import java.util.HashMap;
import java.util.List;

/**
 * @author Prasanna kumar Reddy 10:37:46 pm
 */

public class ExcelProperty extends ReadExcelUtils
{
    static HashMap<String, ExcelSheet> excelSheet = null;

    public static ExcelBean getElementValue(String sheetName, String key) throws Exception
    {
        if (null == excelSheet)
        {
            excelSheet = new HashMap<>();
            List<ExcelSheet> sheets = readBooksFromExcelFile();
            for (ExcelSheet excelSheet : sheets)
            {
                System.out.println(excelSheet);
            }
        }
        ExcelSheet sheet = excelSheet.get(sheetName);
        if (null == sheet)
        {
            throw new Exception("Sheet name is wrong");
        }
        ExcelBean bean = sheet.getBean(key);
        if (null == bean)
        {
            throw new Exception("Key name is wrong");
        }
        return bean;
    }

    public HashMap<String, ExcelSheet> getExcelSheet()
    {
        return excelSheet;
    }

    public static void setExcelSheet(String name, ExcelSheet sheet)
    {
        excelSheet.put(name, sheet);
    }

}
/**
 * @author Prasanna kumar reddy 10:37:46 pm
 */
