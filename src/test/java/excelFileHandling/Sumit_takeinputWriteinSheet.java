package excelFileHandling;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class Sumit_takeinputWriteinSheet 
{
	public static void main(String[] args) throws IOException, WriteException 
	{
		File storeFile = new File("../ExcelFileHandlingbysumit/StoreData.xls");
		
		WritableWorkbook createWorkbook = Workbook.createWorkbook(storeFile);
		
		WritableSheet createSheet=createWorkbook.createSheet("Sheet1",0);
		
		System.out.println("Enter your data to store in excel");
		
		String data = null;
		
		for(int i=0; i<3; i++)
		{
			for (int j=0; j<3;j++)
				
			{
				Scanner sc= new Scanner(System.in);
				data= sc.nextLine();
				Label l = new Label(j,i, data );
				createSheet.addCell(l);
				
			}
		}
		System.out.println("Your input limit is exceed and your entered data is stored in the excel file");
		createWorkbook.write();
		createWorkbook.close();
		
		
		
	}

}
