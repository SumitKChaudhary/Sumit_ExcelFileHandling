package sumit_ExcelFileHandlingWithApachePOI;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Sumit_ReadDataWithApachePOi 
{
	public static void main(String[] args) throws IOException 
	{
		File getFile = new File("../ExcelFileHandlingbysumit/DataFile_Apache.xlsx");
		
		FileInputStream inputFile = new FileInputStream(getFile);
		
		XSSFWorkbook getWordBook = new XSSFWorkbook(inputFile);
		
		XSSFSheet getSheet = getWordBook.getSheetAt(0);
		
		int row_No = getSheet.getPhysicalNumberOfRows();
		
		for (int i=0; i<row_No; i++)
		{
			
			XSSFRow getRow = getSheet.getRow(i);
			int sheetCell = getRow.getPhysicalNumberOfCells();
			for (int j=0; j<sheetCell; j++)
			{
				XSSFCell getCell = getRow.getCell(j);
				System.out.println(getCell.getStringCellValue());
			}
			
		}
		
		
	}
	
	
	

}
