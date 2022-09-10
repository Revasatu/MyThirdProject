package org.sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenLancher {
	public static void main(String[] args) throws IOException {
	File f = new File("C:\\Users\\ELCOT\\OneDrive\\Documents\\Documents\\RS.xlsx");
	FileInputStream stream = new FileInputStream(f);
	Workbook book = new XSSFWorkbook(stream);
	Sheet sheet = book.getSheet("Sheet1");
	for (int i = 0; i <sheet.getPhysicalNumberOfRows(); i++) {
		Row row = sheet.getRow(i);
		for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
			Cell cell = row.getCell(j);
			CellType cellType = cell.getCellType();
			switch (cellType) {
			case STRING:
		String stringCellValue = cell.getStringCellValue();
		System.out.println(stringCellValue);
				break;

			default:
				if(DateUtil.isCellDateFormatted(cell))
				{
					Date dateCellValue = cell.getDateCellValue();
					Date dateCellValue2 = cell.getDateCellValue();
					SimpleDateFormat s = new SimpleDateFormat("dd/mm/yyyy");
					String format = s.format(dateCellValue2);
					System.out.println(format);
					
				}
				else
				{double numericCellValue = cell.getNumericCellValue();
				long l =(long)numericCellValue;
				System.out.println(l);
				}
				
				break;
			}
			
		}
		
	}

	
	}


	
	

}
