package com.utility;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;

import java.io.File;
	import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

	public class ExcelDataProvider {
	//in order to work with excel we need third party library like apache poi add poi and poi.ooxml dependencies
		
		XSSFWorkbook wb;
		DecimalFormat df = new DecimalFormat("#"); 
		public ExcelDataProvider()
		{//contructor used
			//load excel 
			File src=new File("/Users/MaheshwariB/eclipse-workspace/MPL/SeleniumFramework/TestData/DatafromExcel.xlsx");
			try {
			FileInputStream fis=new FileInputStream(src);
			wb=new XSSFWorkbook(fis);
			}
			catch(Exception e)
			{
				System.out.println("unable to read excel file"+e.getMessage());
			}
		}	
		
		//if u write another method with same name and same parameters but type is different--method overloading---polymorphism concept
		
			public String getNumericData(String sheetName,int row,int column)
			{//Read data from excel
				DataFormatter d1;
				Cell c1=wb.getSheet(sheetName).getRow(row).getCell(column);
				String s1=new DataFormatter().formatCellValue(c1);
                //System.out.println(s1);
				
                return s1;
			}
		
	}
	
	
	
	
	