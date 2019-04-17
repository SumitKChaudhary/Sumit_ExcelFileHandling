package sumit_ExcelFileHandlingWithApachePOI;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Sumit_WriteDataUsingApachePOI 
{
	public static void main(String[] args) throws IOException 
	{
		File  createFile = new File("../ExcelFileHandlingbysumit/StorageFilebyAppcahePOI.xlsx");
		
		FileOutputStream createFile2 = new FileOutputStream(createFile);
		
		XSSFWorkbook createWorkBook = new XSSFWorkbook();
		
		XSSFSheet createSheet = createWorkBook.createSheet();
		
		int a=0;
		
		for (int i=0; i<3; i++)
		{
			XSSFRow cellRow= createSheet.createRow(i);
			for (int j=0; j<3; j++)
			{
				XSSFCell cellCreate= cellRow.createCell(j);
				a++;
				cellCreate.setCellValue("Sumit"+a);
			}
		}
		
		createWorkBook.write(createFile2);
		createFile2.flush();
		createFile2.close();
		
	}

}
