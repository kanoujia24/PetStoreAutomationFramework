package api.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {
	public  static FileInputStream fi;
	public  static FileOutputStream fo;//above two come from java rest of coming from apachepoi
	public  static XSSFWorkbook workbook;
	public  static XSSFSheet sheet;
	public  static XSSFRow row;
	public  static XSSFCell cell;
	static String path;
	
	
	public XLUtils(String path) {
		this.path=path;
	}
	
	public static int getRowCount(String sheetname) throws IOException  {//xlfile=path of the file
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetname);
		int rowcount=sheet.getLastRowNum();
		workbook.close();
		fi.close();
		return rowcount;
	}
	public static int getCellCount(String sheetname, int rownum) throws IOException {
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetname);
		row=sheet.getRow(rownum);
		int cellcount=row.getLastCellNum();
		workbook.close();
		fi.close();
		return cellcount;
	}
	
	public  static String getCellData(String sheetname,int rownum,int column) throws IOException {
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetname);
		row=sheet.getRow(rownum);
		cell=row.getCell(column);
		
		DataFormatter formatter=new DataFormatter();
		String data;
	   try {
			String CellData=formatter.formatCellValue(cell);
			return CellData;
		}
		catch(Exception e) {
			data=" ";
		}
		workbook.close();
		fi.close();
		return data;
	}
	public  static void setCellData(String sheetname,int rownum, int column, String data) throws IOException {
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetname);
		row=sheet.getRow(rownum);
		cell=row.createCell(column);
		cell.setCellValue(data);
		
		fo=new FileOutputStream(path);
		workbook.write(fo);
		workbook.close();
		fi.close();
		fo.close();
		
	}

}
