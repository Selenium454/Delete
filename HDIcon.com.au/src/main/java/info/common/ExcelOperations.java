package info.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelOperations {
 
	public static String cellData = null;
	public static XSSFSheet getDataFromExcel(String filePath, String sheetName) {
		try {
			XSSFWorkbook workBook = new XSSFWorkbook(new FileInputStream(filePath));
			XSSFSheet sheet = workBook.getSheet(sheetName);
			return sheet;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static Object[][] getCellData(XSSFSheet sheet) {

		int rowsSize = sheet.getLastRowNum();
		int columnSize = sheet.getRow(0).getLastCellNum();
		Object testData[][] = new Object[rowsSize][columnSize];

		for (int i = 0; i < rowsSize; i++) {
			XSSFRow row = sheet.getRow(i+1);
			System.out.println(row);

			for (int j = 0; j < row.getLastCellNum(); j++) {
				if(row.getCell(j).getCellType() == CellType.STRING)
				{
					 cellData = row.getCell(j).getStringCellValue();
				}
				else
				{
					cellData = row.getCell(j).getRawValue();
				}

				testData[i][j] = cellData;
			}
		}

		return testData;

	}
	
	public static Object[][] getCellData1(XSSFSheet sheet) {

		int rowsSize = sheet.getLastRowNum();
		int columnSize = sheet.getRow(0).getLastCellNum();
		
		int notRunRows=0;
		for (int i = 0; i < rowsSize; i++) {
			XSSFRow row = sheet.getRow(i+1);
			if(row.getCell(0).getStringCellValue().equalsIgnoreCase("no")) {
				notRunRows =notRunRows+1;
			}
		}
		
		Object testData[][] = new Object[rowsSize-notRunRows][columnSize];

		for (int i = 0; i < rowsSize; i++) {
			XSSFRow row = sheet.getRow(i+1);
			System.out.println(row);

			if(row.getCell(0).getStringCellValue().equalsIgnoreCase("no")) {
				continue;
			}
			for (int j = 0; j < row.getLastCellNum(); j++) {
				
				if(row.getCell(j).getCellType() == CellType.STRING)
				{
					 cellData = row.getCell(j).getStringCellValue();					
				}
				else
				{
					cellData = row.getCell(j).getRawValue();
				}

				testData[i][j] = cellData;
			}
		}

		return testData;

	}
	
}
