package excelFileHandling;
import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ReadDataFromExcel 
{
	public static void main(String[] args) throws BiffException, IOException {
		
		//.out.println("heelo");
		
		File filePath = new File("../ExcelFileHandlingbysumit/ExcelDataRead.xls");
		if (filePath.exists()) {
		Workbook wb=Workbook.getWorkbook(filePath);
		
		Sheet sb=wb.getSheet(0);
		
		int row =sb.getRows();
		int col =sb.getColumns();
		
		for(int i=0; i<row; i++)
		{
			for (int j=0; j<col;j++)
			{
				Cell sheetCell= sb.getCell(j,i);
				System.out.println(sheetCell.getContents());
			}
		}
		}
		else
		{
			System.out.println("File not exist please check");
		}
		
		
		
		
	}

}
