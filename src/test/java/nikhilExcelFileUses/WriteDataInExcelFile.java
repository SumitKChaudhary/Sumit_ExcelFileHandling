package nikhilExcelFileUses;

import java.io.File;

import nikhilExcelLibrary.ExcelFilehandler;
import sumit_ExcelFileHandlingWithApachePOI.Sumit_ReadAndWrite_ApachPOI;

public class WriteDataInExcelFile
{
	public static void main(String[] args) {
		//Sumit_ReadAndWrite_ApachPOI.createNewExcelFile("verification");
		ExcelFilehandler obj = new ExcelFilehandler(System.getProperty("user.dir")+File.separator+"ExcelFils"+File.separator+"verficationNew.xlsx");
		
		String sheetName="data1";
		
		System.out.println(obj.getCellData(sheetName, "RollNo", 2));
		System.out.println(obj.getCellData(sheetName, "Name", 2));
		
	}

}
