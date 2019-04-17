package sumit_ExcelFileHandlingWithApachePOI;
/*@author		: Sumit Kumar Chaudahry
 * File			: take 9 input and write in file using apache poi api
 * date			:	18 april 2019
 * */

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Sumit_TakeInputWriteInFileApache 
{
	public static void main(String[] args) throws IOException {
		File  createFile = new File("../ExcelFileHandlingbysumit/InputDataStorageFilebyAppcahePOI.xlsx");
		
		FileOutputStream createFile2 = new FileOutputStream(createFile);
		
		XSSFWorkbook createWorkBook = new XSSFWorkbook();
		
		XSSFSheet createSheet = createWorkBook.createSheet();
		
		System.out.println("Enter the data which you want to write in file");
		Scanner sc = new Scanner(System.in);
		
		String data = null;
		
		
		for (int i=0; i<3; i++)
		{
			XSSFRow cellRow= createSheet.createRow(i);
			for (int j=0; j<3; j++)
			{
				XSSFCell cellCreate= cellRow.createCell(j);
				data=sc.nextLine();
				cellCreate.setCellValue(data);
			}
		}
		
		createWorkBook.write(createFile2);
		createFile2.flush();
		createFile2.close();
		System.out.println("\nEntered data is write in file please check");
	}

}
