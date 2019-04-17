package sumit_ExcelFileHandlingWithApachePOI;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Sumit_ReadMethodApachPoi 
{
	public void readexcelFile(int row_No, int cell_No) throws IOException
	{
		File getFile = new File("../ExcelFileHandlingbysumit/MethodDataStorageFilebyAppcahePOI.xlsx");
		
		FileInputStream inputFile = new FileInputStream(getFile);
		
		XSSFWorkbook getWordBook = new XSSFWorkbook(inputFile);
		
		XSSFSheet getSheet = getWordBook.getSheetAt(0);
		
		// row_No = getSheet.getPhysicalNumberOfRows();
		
		for (int i=0; i<row_No; i++)
		{
			
			XSSFRow getRow = getSheet.getRow(i);
			// cell_No = getRow.getPhysicalNumberOfCells();
			for (int j=0; j<cell_No; j++)
			{
				XSSFCell getCell = getRow.getCell(j);
				System.out.println(getCell.getStringCellValue());
			}		
		}
	}
	
	public static void main(String[] args) throws IOException 
	{
		Sumit_ReadMethodApachPoi obj = new Sumit_ReadMethodApachPoi();
		
		System.out.println("Please enter the Row and Cell number which data you want read\n");
		
		Scanner sc= new Scanner(System.in);
		int a=sc.nextInt(); int b=sc.nextInt();
		System.out.println("Your data is \n");
		obj.readexcelFile(a, b);
		
		
	}

}
