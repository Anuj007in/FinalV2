package UtilitiesHelper;
import java.io.FileInputStream;
import UtilitiesHelper.Constants;
import java.io.FileOutputStream;

import org.apache.bcel.classfile.Constant;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.xssf.usermodel.XSSFCell;

import org.apache.poi.xssf.usermodel.XSSFRow;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//Author: Anuj Sharma

public class ExcelUtility {
	private static XSSFSheet ExcelWSheet;

	private static XSSFWorkbook ExcelWBook;

	private static XSSFCell Cell;

	private static XSSFRow Row;
	
	private static WebDriver driver= null;
	public static WebDriver getWebDriverfor(){
		if(driver==null)
		{
			setWebDriver();
		}
		return driver;
		
	}
	

//This method is to set the File path and to open the Excel file, Pass Excel Path and Sheetname as Arguments to this method

public static void setExcelFile(String Path,String SheetName) throws Exception {

		try {
			
			if(ExcelWSheet==null){
				FileInputStream ExcelFile = new FileInputStream(Path);

				// Access the required test data sheet

				ExcelWBook = new XSSFWorkbook(ExcelFile);

				ExcelWSheet = ExcelWBook.getSheet(SheetName);

			}} catch (Exception e){

					throw (e);

				}


			// Open the Excel file

		
}

//This method is to read the test data from the Excel cell, in this we are passing parameters as Row num and Col num

public static String getCellData(int RowNum, int ColNum) throws Exception{

		try{

			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

			String CellData = Cell.getStringCellValue();

			return CellData;

			}catch (Exception e){

			return"";

			}

}



//This method is to write in the Excel cell, Row num and Col num are the parameters

public static void setCellData(String Result,  int RowNum, int ColNum, String status) throws Exception	{
	 CellStyle style = ExcelWBook.createCellStyle();
     Font font = ExcelWBook.createFont();
    // font.setColor(HSSFColor.BLACK.getIndex());
     font.setColor(HSSFColor.GREEN.index);
     style.setFont(font);

		try{
if(status=="Pass")
{
			Row  = ExcelWSheet.getRow(RowNum);

		Cell = Row.getCell(ColNum, Row.RETURN_BLANK_AS_NULL);

		if (Cell == null) {

			Cell = Row.createCell(ColNum);

			Cell.setCellValue(Result);
			Cell.setCellStyle(style);
			
			}
		 else {
				
				Cell.setCellValue(Result);
				//Cell.setCellStyle(style);

			}}
		else
		{
			Row  = ExcelWSheet.getRow(RowNum);

			Cell = Row.getCell(ColNum, Row.RETURN_BLANK_AS_NULL);
			font.setColor(HSSFColor.RED.index);
			Cell = Row.createCell(ColNum);
		     style.setFont(font);
		     Cell.setCellValue(Result);
				Cell.setCellStyle(style);
			}
		
// Constant variables Test Data path and Test Data file name

				//FileOutputStream fileOut = new FileOutputStream(Constant.Path_TestData + Constant.File_TestData);
				FileOutputStream fo= new FileOutputStream(Constants.Path_TestData + Constants.File_TestData);

				ExcelWBook.write(fo);

				fo.flush();

				fo.close();

			}catch(Exception e){

				throw (e);

		}

	}

public static void setWebDriver()
{
	//if(browserName.equals("chrome"))
	String browserName=Constants.Browser; //this should be in config file prop
		if(browserName.equals("chrome"))
	{
			//read it from config prop
	//System.setProperty("webdriver.chrome.driver","C:\Users\anujksharma\Downloads\Eclipse_NewMachine\eclipseDev (USHYDBGANTASAL6)\UI AUtomation_Selenium\Lib\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver","D:/chromedriver.exe");

		driver= new ChromeDriver();
		
		//String BrowserURL=Constants.
		//driver.get(Constants.URLHome);
		//driver.get("https://google.com");
	}
	
}
	
}
