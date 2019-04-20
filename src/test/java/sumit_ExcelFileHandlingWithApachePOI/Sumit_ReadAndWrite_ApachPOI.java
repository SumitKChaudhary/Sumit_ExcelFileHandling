package sumit_ExcelFileHandlingWithApachePOI;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Sumit_ReadAndWrite_ApachPOI
{
	public static void main(String[] args) throws IOException 
	{
		File readFile = new File("../ExcelFileHandlingbysumit/DataFile_Apache.xlsx");
		FileInputStream inputFile = new FileInputStream(readFile);
		XSSFWorkbook getData = new XSSFWorkbook(inputFile);
		XSSFSheet getSheet = getData.getSheetAt(0);
		int row_No = getSheet.getPhysicalNumberOfRows();
		
		
		File copiedFile = new File("../ExcelFileHandlingbysumit/CopiedStorageFile_Apache.xlsx");
		FileOutputStream outFile = new FileOutputStream(copiedFile);
		
		XSSFWorkbook copiedDataFile = new XSSFWorkbook();
		
		XSSFSheet copiedSheet = copiedDataFile.createSheet();
		
		String copiedData= null; 
		for (int i=0; i<row_No; i++)
		{
			XSSFRow getRow = getSheet.getRow(i);
			
			XSSFRow createRow = copiedSheet.createRow(i);
			
			int sheetCell= getRow.getPhysicalNumberOfCells();
			
			for (int j=0; j<sheetCell; j++)
			{
				XSSFCell getCell = getRow.getCell(j);
				XSSFCell createCell = createRow.createCell(j);
				
				copiedData = getCell.getStringCellValue();
				
				createCell.setCellValue(copiedData);
				
				//System.out.println(getCell.getStringCellValue());
			}
					
		}
		copiedDataFile.write(outFile);
		outFile.flush();
		outFile.close();
		System.out.println( "Read Data from : "+readFile.getName()+ "\nData Successfully copyed :   "+ copiedFile.getName());
		
	}

}
