package Utilities;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

//Function to READ and WRITE EXCEL.

public class xlReadWrite {
	public static int xRow; static int xCol;
 
//Method to read from Excel
	public static String[][]  xlRead(String sPath, String iSheet) throws Exception{   // This line xlRead is the call to this function. We are passing the xl path in this
		//String[][] myExcel = null;
			//int xRow, xCol; commenting as I will declare it main code.
			String[][] xData;
		
		//file, wb,sheets
		File myxl = new File(sPath); // File is telling Java that it will use I/p o/p streams to interact with Java. The name of the file is myxl here.		
		FileInputStream myStream = new FileInputStream(myxl); //  FIle input stream reads i/p and o/p into the file path we created above. 		
		HSSFWorkbook myWB = new HSSFWorkbook(myStream); // Creates workbook within this file.			
		HSSFSheet mySheet = myWB.getSheet(iSheet);	// getSheetAt(0) method - Referring to 1st sheet, 1 -2nd sheet and so on
		
		//Get row count
		xRow = mySheet.getLastRowNum()+1;  //gets number of rows in my sheet. SInce it starts with 0, adding +1 to it will get total number of rows which is the last row.
		xCol = mySheet.getRow(0).getLastCellNum(); // to get cells or number of columns, first go to row 0, then get the last cell number of that row.
		xData = new String[xRow][xCol];  // we are creating an Array of type string. This puts the number of rows and cols.		
				
		System.out.println("Rows are " + xRow);
		System.out.println("Cols are " + xCol);
		
		// Go to each cell
		for (int i = 0; i < xRow; i++) {                           
			HSSFRow row = mySheet.getRow(i); // select and point to a specific row in my sheet it points according to the iteration
			for (int j = 0; j < xCol; j++) {                               
				HSSFCell cell = row.getCell(j);        // on that row, get the value of each column of each row.                       
				String value = cellToString(cell);   //convert a specific cell type(int,string/double etc) to a simple string  - this I can get from the function HSSFcell                 
				xData[i][j] = value;     
				
			
				}   
			
		}
		return xData;
	}
	
	// Method to write into an XL
		public static void writeXL(String sPath, String iSheet, String[][] xData) throws Exception{

	    	File outFile = new File(sPath);
	        HSSFWorkbook wb = new HSSFWorkbook();
	        HSSFSheet osheet = wb.createSheet(iSheet);
	        int xR_TS = xData.length;
	        int xC_TS = xData[0].length;
	    	for (int myrow = 0; myrow < xR_TS; myrow++) {
		        HSSFRow row = osheet.createRow(myrow);
		        for (int mycol = 0; mycol < xC_TS; mycol++) {
		        	HSSFCell cell = row.createCell(mycol);
		        	cell.setCellType(HSSFCell.CELL_TYPE_STRING);
		        	cell.setCellValue(xData[myrow][mycol]);
		        }
		        FileOutputStream fOut = new FileOutputStream(outFile);
		        wb.write(fOut);
		        fOut.flush();
		        fOut.close();
	    	}
		}
	
// A new function to convert an object of type excel cell to a string value.
	public static String cellToString(HSSFCell cell) {
	// This function will convert an object of type excel cell to a string value
       int type = cell.getCellType();  //cell.getcell type returns an integer which
        Object result;
        switch (type) {
            case HSSFCell.CELL_TYPE_NUMERIC: //0
                           
                    String stringValue=""+cell.getNumericCellValue();
                    String[] splitValue=stringValue.split(".0");
                    //System.out.println(splitValue[0]);
                
			
			result = splitValue[0];
             
                break;
            case HSSFCell.CELL_TYPE_STRING: //1
                result = cell.getStringCellValue();
                break;
            case HSSFCell.CELL_TYPE_FORMULA: //2
                throw new RuntimeException("We can't evaluate formulas in Java");
            case HSSFCell.CELL_TYPE_BLANK: //3
                result = "-";
                break;
            case HSSFCell.CELL_TYPE_BOOLEAN: //4
                result = cell.getBooleanCellValue();
                break;
            case HSSFCell.CELL_TYPE_ERROR: //5
                throw new RuntimeException ("This cell has an error");
            default:
                throw new RuntimeException("We don't support this cell type: " + type);
        }
        return result.toString();
    }
	
}