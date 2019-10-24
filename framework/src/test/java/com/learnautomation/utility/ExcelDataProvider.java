package com.learnautomation.utility;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
//in order towork with excel we need third party library like apache poi add poi and poi.ooxml dependencies
	
	XSSFWorkbook wb;
	public ExcelDataProvider()
	{//contructor used
		//load excel 
		File src=new File("./TestData/Data.xlsx");
		
		try {
		FileInputStream fis=new FileInputStream(src);
		wb=new XSSFWorkbook(fis);
		}
		catch(Exception e)
		{
			System.out.println("unable to read excel file"+e.getMessage());
		}
	}		
		public String getStringData(int sheetindex,int row,int column)
		{//method overloading
			return wb.getSheetAt(sheetindex).getRow(row).getCell(column).getStringCellValue();
		}
		public String getStringData(String sheetName,int row,int column)
		{//method overloading
			return wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
		}
		public double getNumericData(String sheetName,int row,int column)
		{//method overloading
			return wb.getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue();
		}
	}

