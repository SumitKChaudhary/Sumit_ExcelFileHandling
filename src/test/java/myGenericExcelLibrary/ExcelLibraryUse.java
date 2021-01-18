package myGenericExcelLibrary;

import java.io.File;

public class ExcelLibraryUse 
{
	public static void main(String[] args) {
		//ExcelFils/verficationNew.xlsx
		String directoryPath=System.getProperty("user.dir")+File.separator;
		
		String filePath=directoryPath+"ExcelFils"+File.separator+"verficationNew.xlsx";
		System.out.println(filePath);
		
		ExcelFilehandler obj=new ExcelFilehandler("ExcelFils"+File.separator+"verficationNew.xlsx");
		
		String sheetName="Dynamic";
		if(!obj.isSheetExist(sheetName)) {
			obj.addSheet(sheetName);
			obj.addColumn(sheetName, "Name");
		}
		obj.setCellData(sheetName, "Name", 2, "Ram");
		obj.setCellData(sheetName, "Name", 2, "Shaym");
		
		System.out.println("Success");
		
	}

}
