package sumit_ExcelFileHandlingWithApachePOI;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class Sumit_ReadAndWrite_ApachPOI
{
	public static String createNewExcelFile(String expectedFileName) {
		String getCreatedFilePath=null;
		File filePath=new File(System.getProperty("user.dir")+File.separator+"ExcelFils"+File.separator+expectedFileName+".xlsx");
		FileOutputStream fileOutput;
		if(!filePath.exists()) {
			try {
				
				fileOutput= new FileOutputStream(filePath);
				fileOutput.flush();
				fileOutput.close();	
				getCreatedFilePath=filePath.getAbsolutePath();
				} catch (IOException e) {
					e.printStackTrace();
				}
		
		}else {
				try {
				
				//fileOutput= new FileOutputStream(filePath);
				//fileOutput.flush();
				//fileOutput.close();	
				getCreatedFilePath=filePath.getAbsolutePath();
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
		return getCreatedFilePath;
		
	}
	/*
	public static void main(String[] args) throws RowsExceededException, WriteException, IOException {
			//String newExcelFile=;
			File filePath = new File(createNewExcelFile("newBlankFile2"));
			FileOutputStream createNewFile = new FileOutputStream(filePath);
			XSSFWorkbook writeFile = new XSSFWorkbook(); 
			
			XSSFSheet createSheet=writeFile.createSheet();
			
			int a=0;
			for(int i=0;i<5;i++)
			{
				XSSFRow createRow = createSheet.createRow(i);
				for (int j=0; j<5;j++)
				{
					XSSFCell createCell = createRow.createCell(j);
					createCell.setCellValue("Sumit"+a);
					a=+i;
				}
			}
			writeFile.write(createNewFile);
			createNewFile.flush();
			createNewFile.close();
			//writeFile.
			System.out.println("success");
		
	}*/
}
