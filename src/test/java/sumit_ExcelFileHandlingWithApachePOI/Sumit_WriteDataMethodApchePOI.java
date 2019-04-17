package sumit_ExcelFileHandlingWithApachePOI;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Sumit_WriteDataMethodApchePOI 
{
	public void writeExcelData(int row_no, int cell_No) throws IOException
	{
File  createFile = new File("../ExcelFileHandlingbysumit/MethodDataStorageFilebyAppcahePOI.xlsx");
		
		FileOutputStream createFile2 = new FileOutputStream(createFile);
		
		XSSFWorkbook createWorkBook = new XSSFWorkbook();
		
		XSSFSheet createSheet = createWorkBook.createSheet();
		
		System.out.println("Enter the data which you want to write in file");
		Scanner sc = new Scanner(System.in);
		
		String data = null;
		
		
		for (int i=0; i<row_no; i++)
		{
			XSSFRow cellRow= createSheet.createRow(i);
			for (int j=0; j<cell_No; j++)
			{
				XSSFCell cellCreate= cellRow.createCell(j);
				data=sc.nextLine();
				cellCreate.setCellValue(data);
			}
		}
		
		createWorkBook.write(createFile2);
		createFile2.flush();
		createFile2.close();
		System.out.println("\nEntered data is write in file please check the file ");
	}
	public static void main(String[] args) throws IOException
	{
		Sumit_WriteDataMethodApchePOI obj = new Sumit_WriteDataMethodApchePOI();
		System.out.println("Enter the row and column no which you want print");
		Scanner scc = new Scanner(System.in);
		int a=scc.nextInt(); int b= scc.nextInt();
		obj.writeExcelData(a, b);
		
	}

}
