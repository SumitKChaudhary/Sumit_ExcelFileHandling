package excelFileHandling;

import java.io.File;
import java.io.IOException;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

/*@author 	:	Sumit Kumar Chaudhary
 * Class	:	Create method for write a file data
 * Date		:	17 April 2019 
 * */
public class Sumit_WriteDataUsingMethods 

{
	
	public void createData(int row_No, int column_No ) throws IOException, RowsExceededException, WriteException
	{
		File createFile = new File("../ExcelFileHandlingbysumit/MethodData.xls");
		
		WritableWorkbook createWorkBook = Workbook.createWorkbook(createFile);
		
		WritableSheet createSheet = createWorkBook.createSheet("MethodData1", 0);
		int a=0; 
		for (int i=0; i<row_No; i++)
		{
			for (int j=0; j<column_No; j++)
				
			{
				a++;
				Label labelCell = new Label(j,i, "Sumit "+a);
				createSheet.addCell(labelCell);
			}
		}
		createWorkBook.write();
		createWorkBook.close();
		
	}
	
	public static void main(String[] args) throws RowsExceededException, WriteException, IOException 
	{
		Sumit_WriteDataUsingMethods obj = new Sumit_WriteDataUsingMethods();
		
		obj.createData(3, 3);
		System.out.println("Succeessfully Write");
	}

}
