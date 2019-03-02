package framework.utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataReader {
	
	
	
	public static String[][] getData(String ExcelFileName, String sheetName) {
		String[][] data = null; 
		
		try( FileInputStream fis = new FileInputStream("./TestData/"+ExcelFileName+".xlsx")) {
			
			
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet(sheetName);
		
		
		int rowNum = sheet.getLastRowNum();
		int columnNum = sheet.getRow(0).getLastCellNum();
		////System.out.prinln("Data Rows - "+ rowNum);  In MAC, when deleting a row, it is mandatory to use clear all button. 
		////System.out.prinln("Column count is - " +columnNum);
		
		
		data = new String[rowNum][columnNum];
		
		
		
		for (int i =1; i<=rowNum; i++)
		{
			for (int j=0; j<columnNum; j++)
				
			{
				CellType cellTypeEnum = sheet.getRow(i).getCell(j).getCellTypeEnum();
				if(cellTypeEnum == CellType.STRING)
				{
				data[i-1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
				}
				else if(cellTypeEnum == CellType.NUMERIC)
				{
					data[i-1][j] = "" + sheet.getRow(i).getCell(j).getNumericCellValue();	
				}
			}
		}
		wb.close();
	
		
	
	} catch(IOException e)
	{
		//System.out.prinln("Specified excel file could not be loaded");
	}

		return data;
		
	}
	
	
	}
