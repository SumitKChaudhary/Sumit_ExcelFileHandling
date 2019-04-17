package excelFileHandling;
import java.io.File;
import java.io.IOException;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class Sumit_WriteDataInExcel 
{
	public static void main(String[] args) throws IOException, RowsExceededException, WriteException 
	{
		File filePath = new File("../ExcelFileHandlingbysumit/ExcelWriteRead.xls");
		if (filePath.createNewFile())
		{
			WritableWorkbook writeFile = Workbook.createWorkbook(filePath);// create workbook is static method 
			WritableSheet writeSheet = writeFile.createSheet("Sheet1", 0);
			for(int i=0;i<5;i++)
			{
				for (int j=0; j<5;j++)
				{
					Label l = new Label(j,i, "Sumit");
					writeSheet.addCell(l);
				}
			
			}
			
			writeFile.write();
			writeFile.close();
			System.out.println("success");
		}
		
		
		else
		{
			System.out.println("This file is already exist please change name of the file");
		}
		
	}

}
