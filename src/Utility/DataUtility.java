package Utility;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

public class DataUtility {
	public static HSSFWorkbook book;
	public static HSSFSheet sheet;
	public static HSSFRow row;
	static BufferedWriter bw = null;
	static FileWriter fw = null;
	private static FileReader fr;
	private static BufferedReader br;
	
	public static void writeReferenceNumber(String refNumber){
		try {
			File f = new File("RefrenceNumber.txt");
			fw = new FileWriter(f,true);	
			bw = new BufferedWriter(fw);
			bw.write(refNumber);
			bw.newLine();
			System.out.println("Done");
		} catch (Exception e) {			
			e.printStackTrace();
		}finally {
			try {
				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public static String readReferenceNumber(){
		String refNum = null;		
		try {
			File f = new File("RefrenceNumber.txt");
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			while((refNum = br.readLine()) != null) {
				refNum.trim();
            }  
		} catch (Exception e) {
			e.printStackTrace();
		}
		return refNum;
	}
	
	public static void initializeExcel() {
		try {
			File f = new File(System.getProperty("user.dir") + "NavigateWriter.xls");
			FileInputStream fis = new FileInputStream(f);
			book = new HSSFWorkbook(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	public static void endExcel(){
		try{
			File f = new File(System.getProperty("user.dir") + "/src/main/com/utility/Navigate2Data.xls");
			FileOutputStream fo = new FileOutputStream(f);
			book.write(fo);
			fo.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void setSheet(String SheetName) {
		sheet = book.createSheet(SheetName);
	}

	public static void getSheet(String SheetName) {
		sheet = book.getSheet(SheetName);
	}

	public static void getRow(int RowNum) {
		row = sheet.getRow(RowNum);
	}

	public static int getRowCount() {
		return sheet.getLastRowNum();
	}

	public static String getCellData(int row, int col) {
		String value = null;
		HSSFCell xcell = sheet.getRow(row).getCell(col);
		xcell.setCellType(1);
		switch (xcell.getCellType()) {
		case HSSFCell.CELL_TYPE_BLANK:
			xcell.setCellValue(" ");
			value = xcell.getStringCellValue();
			break;
		case HSSFCell.CELL_TYPE_STRING:
			value = xcell.getStringCellValue();
			break;
		case HSSFCell.CELL_TYPE_BOOLEAN:
			value = String.valueOf(xcell.getBooleanCellValue());
			break;
		case HSSFCell.CELL_TYPE_ERROR:
			value = xcell.getStringCellValue();
			break;
		default:
			value = xcell.getStringCellValue();
		}
		return value;
	}

	public static String getCellData(int col) {
		String value = null;
		HSSFCell xcell = row.getCell(col);
		xcell.setCellType(1);
		switch (xcell.getCellType()) {
		case HSSFCell.CELL_TYPE_BLANK:
			xcell.setCellValue(" ");
			value = xcell.getStringCellValue();
			break;
		case HSSFCell.CELL_TYPE_STRING:
			value = xcell.getStringCellValue();
			break;
		case HSSFCell.CELL_TYPE_BOOLEAN:
			value = String.valueOf(xcell.getBooleanCellValue());
			break;
		case HSSFCell.CELL_TYPE_ERROR:
			value = xcell.getStringCellValue();
			break;
		default:
			value = xcell.getStringCellValue();
		}
		return value;
	}

	public static String getCellData(int row, String ColumnName,int rowCount) {
		int colID = getColumnIndex(ColumnName);
		return getCellData(row, colID);
	}
	
	public static void setCellData(String columnName,String refValue,int rowCount){
		setCellData(getColumnIndex(columnName),refValue,rowCount);

	}
	
	
	public static void setCellData(int column,String value,int rowCount){
		HSSFRow xrow = sheet.getRow(rowCount);
		if (xrow == null) {
			xrow = sheet.createRow(rowCount);
		}		
		HSSFCell xcell = row.getCell(column);
		if (xcell == null) {
			xcell = row.createCell(column, Cell.CELL_TYPE_STRING);
		}
		xcell.setCellValue(value);
	}

	public static String getCellData(String ColumnName) {
		return getCellData(getColumnIndex(ColumnName));
	}	

	public static int getColumnIndex(String ColumnName) {
		HSSFRow r = sheet.getRow(0);
		int colCount = r.getLastCellNum();
		int colIndex = -1;

		for (int i = 0; i < colCount; i++) {
			String ColHeader = r.getCell(i).getStringCellValue();
			if (ColHeader.equalsIgnoreCase(ColumnName)) {
				colIndex = i;
				break;
			}
		}
		return colIndex;
	}

	public static int getActualRowOnTestCaseName(String testCaseName) {
		int columnCount = getColumnIndex("Testcaseno");
		int index = -1;
		int rowIndex = getRowCount();
		for (int i = 1; i < rowIndex + 1; i++) {
			HSSFRow r = sheet.getRow(i);
			HSSFCell c = r.getCell(columnCount);
			String ValueName = c.getStringCellValue();
			if (ValueName.trim().equals(testCaseName)) {
				index = i;
				break;
			}
		}
		return index;
	}
	
	public static int getLastRowCountofTestCase(String testCaseName) {
		int columnCount = getColumnIndex("Testcaseno");
		int index = -1;
		int rowIndex = getRowCount();
		for (int i = 1; i < rowIndex + 1; i++) {
			HSSFRow r = sheet.getRow(i);
			HSSFCell c = r.getCell(columnCount);
			String ValueName = c.getStringCellValue();
			if (ValueName.trim().equals(testCaseName)) {
				index = i;				
			}
		}
		return index;
	}
}
