package genericPakage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Flib {
	public String readExcelData(String ExcelPath,String SheetName,int rowcount,int Cellcount) throws EncryptedDocumentException, IOException
	{
	FileInputStream flib = new FileInputStream(ExcelPath);
	Workbook wb = WorkbookFactory.create(flib);
	Sheet sheet = wb.getSheet(SheetName);
	Row row = sheet.getRow(rowcount);
	Cell cell = row.getCell(Cellcount);
	String data = cell.getStringCellValue();
	return data;
	}
public int getLastRowCount(String Excelpath,String sheetname) throws EncryptedDocumentException, IOException
{
	FileInputStream flib1 = new FileInputStream(Excelpath);
	Workbook wh = WorkbookFactory.create(flib1);
	Sheet sheet = wh.getSheet(sheetname);
	int rownum = sheet.getLastRowNum();
	return rownum;
}
	
	//to write data in Excel Sheet
	public void writeExcelData(String excelpath,String sheetname,int rowcount ,int cellcount, String data) throws EncryptedDocumentException, IOException
	{
		FileInputStream flib = new FileInputStream(excelpath);
		Workbook wb = WorkbookFactory.create(flib);
		Sheet sheet = wb.getSheet(sheetname);
		Row row = sheet.getRow(rowcount);
		Cell cell = row.createCell(cellcount);
		cell.setCellValue(data);
		  
		FileOutputStream fos = new FileOutputStream(excelpath);
		  wb.write(fos);
	}
	public String readProertyData(String proppath,String values) throws IOException
	{
		FileInputStream fos = new FileInputStream(proppath);
		Properties prop = new Properties( );
		prop.load(fos);
		String data = prop.getProperty(values);
		return data;
	}

}
