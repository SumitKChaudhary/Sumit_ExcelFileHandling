package excelFileHandling;
/*@author 	:	Sumit Kumar Chaudhary
 * Class	:	Read the data from one sheet and copy to second sheet in one file 
 * Date		:	16 April 2019 
 * */

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class Sumit_CopyDataOneToSecondSheet
{
	public static void main(String[] args) throws BiffException, IOException, RowsExceededException, WriteException {
		
		//ReadData From file's sheet 
		File fileRead = new File("../ExcelFileHandlingbysumit/ReadFile.xls");
		
		
		Workbook getFile = Workbook.getWorkbook(fileRead);
		Sheet getSheet = getFile.getSheet(0);
		
		File myWrite = new File("../ExcelFileHandlingbysumit/Write1.xls");
		WritableWorkbook copyWorkSheet = Workbook.createWorkbook(myWrite);
		WritableSheet copySheet = copyWorkSheet.createSheet("CopiedSheet", 0);

		String copyData = null;
		
		int row = getSheet.getRows();
		int col = getSheet.getColumns();
		
		for (int i=0; i<row; i++)
		{
			for (int j=0; j<col; j++)
			{
				Cell getsheetCell = getSheet.getCell(j,i);
				copyData = getsheetCell.getContents();
		//		System.out.println(getsheetCell.getContents());
				 Label l = new Label(j,i, copyData); 
				  copySheet.addCell(l); 
			}
		}
		  copyWorkSheet.write();
		  copyWorkSheet.close();
		  System.out.println("Read from        :  "+fileRead.getName()+ "\nCopy success to  :   " +myWrite.getName());
		 
	}

}
