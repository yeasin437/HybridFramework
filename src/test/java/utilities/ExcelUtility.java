package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	public String path;
	XSSFWorkbook wb;
	public  ExcelUtility(String path)
			{
				this.path = path;
			}
	public  int getRowCount(String sheetName) throws IOException
	{
	FileInputStream	fi = new FileInputStream(path);
	XSSFWorkbook	wb = new XSSFWorkbook(fi);
	XSSFSheet	ws=wb.getSheet(sheetName);
		int rowcount = ws.getLastRowNum();
		wb.close();
		fi.close();
		return rowcount;
	}
	public int getCellCount(String sheetName,int rownum) throws IOException
	{
		FileInputStream fi = new FileInputStream(path);
	XSSFWorkbook	wb = new XSSFWorkbook(fi);
	XSSFSheet	ws = wb.getSheet(sheetName);
	XSSFRow	row = ws.getRow(rownum);
		int cellcount = row.getLastCellNum();
		wb.close();
		fi.close();
		return cellcount;
	}
	public String getCellData(String sheetName,int rownum,int colnum) throws IOException
	{
	FileInputStream	fi = new FileInputStream(path);
		wb = new XSSFWorkbook(fi);
		XSSFSheet ws = wb.getSheet(sheetName);
	XSSFRow	row = ws.getRow(rownum);
		XSSFCell cell = row.getCell(colnum);
		DataFormatter formatter = new DataFormatter();
		String data;
		try
		{//either can be used
			//data = cell.toString();
			
			//Returns the formatted value of a cell as a string regardless of the cell type.
			data = formatter.formatCellValue(cell);//apache poi method formatcellvalue
		}
		catch(Exception e)
		{
			data = "";//if cell has no data,exception comes up,catch will handle and assign data = empty
		}
		wb.close();
		fi.close();
		return data;
	}
	public void setCellData(String sheetName, int rownum, int colnum, String data) throws IOException {
	    File file = new File(path);
	   

	    // Step 1: Create a new workbook if the file does not exist
	    if (!file.exists()) {
	        wb = new XSSFWorkbook(); // Create a new workbook
	        try (FileOutputStream fos = new FileOutputStream(file)) {
	            wb.write(fos); // Write the empty workbook to the file
	        }
	        wb.close(); // Close after writing the workbook
	    }

	    // Step 2: Load the workbook
	    try (FileInputStream fis = new FileInputStream(file)) {
	        wb = new XSSFWorkbook(fis);
	    }

	    // Step 3: Modify the workbook and write back to the file
	    try (FileOutputStream fos = new FileOutputStream(file)) {
	        XSSFSheet ws = wb.getSheet(sheetName);
	        if (ws == null) {
	            ws = wb.createSheet(sheetName);
	        }

	        XSSFRow row = ws.getRow(rownum);
	        if (row == null) {
	            row = ws.createRow(rownum);
	        }

	        XSSFCell cell = row.createCell(colnum);
	        cell.setCellValue(data);

	        wb.write(fos); // Write the changes back to the file
	    }

	    // Close the workbook
	    wb.close();
	}


}
