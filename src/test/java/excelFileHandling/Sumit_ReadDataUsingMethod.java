package excelFileHandling;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Sumit_ReadDataUsingMethod 
{
	public void readFileData( int row_No, int column_No) throws BiffException, IOException
	{
		File createFile = new File("../ExcelFileHandlingbysumit/MethodData.xls");
		
		Workbook readWorkSheet = Workbook.getWorkbook(createFile);
		
		Sheet readSheet = readWorkSheet.getSheet(0);
		
		//row_No = readSheet.getRows();
		//column_No = readSheet.getColumns();
		Cell getCell=null;
		
		
		for (int i=0; i<row_No; i++)
		{
			for (int j=0; j<column_No; j++)
			{
				 getCell= readSheet.getCell(j,i);
				 
				 
			}
		}
		
		System.out.println(getCell.getContents());
	}
	
	public static void main(String[] args) throws BiffException, IOException {
		
		Sumit_ReadDataUsingMethod obj = new Sumit_ReadDataUsingMethod();
		
		System.out.println("Enter Row no & Column no for read the perticuler ");
		Scanner sc= new Scanner(System.in);
		int a=sc.nextInt(); int b=sc.nextInt();
		
		obj.readFileData(a, b);
	}

}
