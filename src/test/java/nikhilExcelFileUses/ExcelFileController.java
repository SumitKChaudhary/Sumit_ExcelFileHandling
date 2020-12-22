package nikhilExcelFileUses;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.concurrent.ExecutionException;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFCreationHelper;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFHyperlink;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileController 
{
	public String filePath;
	public FileInputStream fis=null;
	public FileOutputStream fileOut=null;
	public XSSFWorkbook workBook=null;
	public XSSFSheet sheet = null;
	public XSSFRow row=null;
	public XSSFCell cell=null;
	
	public ExcelFileController(String filePath) {
		this.filePath=filePath;
		try {
			fis=new FileInputStream(filePath);
			workBook = new XSSFWorkbook(fis);
			sheet = workBook.getSheetAt(0);
			fis.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public int getRowCount(String sheetName) {
		int index = workBook.getSheetIndex(sheetName);
		if(index == -1) 
			return 0;
		else {
			sheet = workBook.getSheetAt(index);
			int number = sheet.getLastRowNum() +1;
			return number;
		}
	}
	
	public String getCellData(String sheetName, String colName, int rowNum) {
		try {
			if(rowNum <=0)
				return "";
			int index = workBook.getSheetIndex(sheetName);
			int colNum = -1;
			if(index ==-1)
				return "";
			sheet = workBook.getSheetAt(index);
			row = sheet.getRow(0);
			for(int i=0; i<row.getLastCellNum(); i++) {
				if(row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
				colNum=i;
			}
			if(colNum == -1)
				return "";
			sheet = workBook.getSheetAt(index);
			row = sheet.getRow(rowNum -1);
			if (row == null)
				return "";
			if (cell.getCellType() == Cell.CELL_TYPE_STRING)
				return cell.getStringCellValue();
			else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC || cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
				
				String cellText = String.valueOf(cell.getNumericCellValue());
				if(HSSFDateUtil.isCellDateFormatted(cell)) {
					double d=cell.getNumericCellValue();
					Calendar cal = Calendar.getInstance();
					cal.setTime(HSSFDateUtil.getJavaDate(d));
					cellText = (String.valueOf(cal.get(Calendar.YEAR))).substring(2);
					cellText = cal.get(Calendar.DAY_OF_MONTH) + "/" + cal.get(Calendar.MONTH) + 1 + "/" + cellText;
				}
				return cellText;
				
			}else if (cell.getCellType() == Cell.CELL_TYPE_BLANK)
				return "";
			else
				return String.valueOf(cell.getBooleanCellValue());
		} catch (Exception e) {
			e.printStackTrace();
			return "row" + rowNum + "or Column" + colName + " dows not exist in xls";
		}
	}
	
	public String getCellData(String sheetName, int colNum, int rowNum) {
		try {
			if (rowNum <= 0)
				return "";

			int index = workBook.getSheetIndex(sheetName);

			if (index == -1)
				return "";

			sheet = workBook.getSheetAt(index);
			row = sheet.getRow(rowNum - 1);
			if (row == null)
				return "";
			cell = row.getCell(colNum);
			if (cell == null)
				return "";

			if (cell.getCellType() == Cell.CELL_TYPE_STRING)
				return cell.getStringCellValue();
			else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC || cell.getCellType() == Cell.CELL_TYPE_FORMULA) {

				String cellText = String.valueOf(cell.getNumericCellValue());
				if (HSSFDateUtil.isCellDateFormatted(cell)) {
					// format in form of M/D/YY
					double d = cell.getNumericCellValue();

					Calendar cal = Calendar.getInstance();
					cal.setTime(HSSFDateUtil.getJavaDate(d));
					cellText = (String.valueOf(cal.get(Calendar.YEAR))).substring(2);
					cellText = cal.get(Calendar.MONTH) + 1 + "/" + cal.get(Calendar.DAY_OF_MONTH) + "/" + cellText;

					// System.out.println(cellText);

				}

				return cellText;
			} else if (cell.getCellType() == Cell.CELL_TYPE_BLANK)
				return "";
			else
				return String.valueOf(cell.getBooleanCellValue());
		} catch (Exception e) {

			e.printStackTrace();
			return "row " + rowNum + " or column " + colNum + " does not exist  in xls";
		}
	}
	public boolean setCellData(String sheetName, String colName, int rowNum, String data) {
		try {
			fis = new FileInputStream(filePath);
			workBook = new XSSFWorkbook(fis);

			if (rowNum <= 0)
				return false;

			int index = workBook.getSheetIndex(sheetName);
			int colNum = -1;
			if (index == -1)
				return false;

			sheet = workBook.getSheetAt(index);

			row = sheet.getRow(0);
			for (int i = 0; i < row.getLastCellNum(); i++) {
				
				if (row.getCell(i).getStringCellValue().trim().equals(colName))
					colNum = i;
			}
			if (colNum == -1)
				return false;

			sheet.autoSizeColumn(colNum);
			row = sheet.getRow(rowNum - 1);
			if (row == null)
				row = sheet.createRow(rowNum - 1);

			cell = row.getCell(colNum);
			if (cell == null)
				cell = row.createCell(colNum);

			cell.setCellValue(data);

			fileOut = new FileOutputStream(filePath);

			workBook.write(fileOut);

			fileOut.close();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean setCellData(String sheetName, String colName, int rowNum, String data, String url) {
	
		try {
			fis = new FileInputStream(filePath);
			workBook = new XSSFWorkbook(fis);

			if (rowNum <= 0)
				return false;

			int index = workBook.getSheetIndex(sheetName);
			int colNum = -1;
			if (index == -1)
				return false;

			sheet = workBook.getSheetAt(index);
			// System.out.println("A");
			row = sheet.getRow(0);
			for (int i = 0; i < row.getLastCellNum(); i++) {
				// System.out.println(row.getCell(i).getStringCellValue().trim());
				if (row.getCell(i).getStringCellValue().trim().equalsIgnoreCase(colName))
					colNum = i;
			}

			if (colNum == -1)
				return false;
			sheet.autoSizeColumn(colNum); // ashish
			row = sheet.getRow(rowNum - 1);
			if (row == null)
				row = sheet.createRow(rowNum - 1);

			cell = row.getCell(colNum);
			if (cell == null)
				cell = row.createCell(colNum);

			cell.setCellValue(data);
			XSSFCreationHelper createHelper = workBook.getCreationHelper();

			// cell style for hyperlinks
			// by default hypelrinks are blue and underlined
			CellStyle hlink_style = workBook.createCellStyle();
			XSSFFont hlink_font = workBook.createFont();
			hlink_font.setUnderline(XSSFFont.U_SINGLE);
			hlink_font.setColor(IndexedColors.BLUE.getIndex());
			hlink_style.setFont(hlink_font);
			// hlink_style.setWrapText(true);

			XSSFHyperlink link = createHelper.createHyperlink(XSSFHyperlink.LINK_FILE);
			link.setAddress(url);
			cell.setHyperlink(link);
			cell.setCellStyle(hlink_style);

			fileOut = new FileOutputStream(filePath);
			workBook.write(fileOut);

			fileOut.close();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean addSheet(String sheetname) {

		FileOutputStream fileOut;
		try {
			workBook.createSheet(sheetname);
			fileOut = new FileOutputStream(filePath);
			workBook.write(fileOut);
			fileOut.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean removeSheet(String sheetName) {
		int index = workBook.getSheetIndex(sheetName);
		if (index == -1)
			return false;

		FileOutputStream fileOut;
		try {
			workBook.removeSheetAt(index);
			fileOut = new FileOutputStream(filePath);
			workBook.write(fileOut);
			fileOut.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean addColumn(String sheetName, String colName) {
		// System.out.println("**************addColumn*********************");

		try {
			fis = new FileInputStream(filePath);
			workBook = new XSSFWorkbook(fis);
			int index = workBook.getSheetIndex(sheetName);
			if (index == -1)
				return false;

			XSSFCellStyle style = workBook.createCellStyle();
			style.setFillForegroundColor(HSSFColor.GREY_40_PERCENT.index);
			style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

			sheet = workBook.getSheetAt(index);

			row = sheet.getRow(0);
			if (row == null)
				row = sheet.createRow(0);

			// cell = row.getCell();
			// if (cell == null)
			// System.out.println(row.getLastCellNum());
			if (row.getLastCellNum() == -1)
				cell = row.createCell(0);
			else
				cell = row.createCell(row.getLastCellNum());

			cell.setCellValue(colName);
			cell.setCellStyle(style);

			fileOut = new FileOutputStream(filePath);
			workBook.write(fileOut);
			fileOut.close();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;

	}
	
	public boolean removeColumn(String sheetName, int colNum) {
		try {
			if (!isSheetExist(sheetName))
				return false;
			fis = new FileInputStream(filePath);
			workBook = new XSSFWorkbook(fis);
			sheet = workBook.getSheet(sheetName);
			XSSFCellStyle style = workBook.createCellStyle();
			style.setFillForegroundColor(HSSFColor.GREY_40_PERCENT.index);
			XSSFCreationHelper createHelper = workBook.getCreationHelper();
			style.setFillPattern(HSSFCellStyle.NO_FILL);

			for (int i = 0; i < getRowCount(sheetName); i++) {
				row = sheet.getRow(i);
				if (row != null) {
					cell = row.getCell(colNum);
					if (cell != null) {
						cell.setCellStyle(style);
						row.removeCell(cell);
					}
				}
			}
			fileOut = new FileOutputStream(filePath);
			workBook.write(fileOut);
			fileOut.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean isSheetExist(String sheetName) {
		int index = workBook.getSheetIndex(sheetName);
		if (index == -1) {
			index = workBook.getSheetIndex(sheetName.toUpperCase());
			if (index == -1)
				return false;
			else
				return true;
		} else
			return true;
	}
	public int getColumnCount(String sheetName) {
		// check if sheet exists
		if (!isSheetExist(sheetName))
			return -1;

		sheet = workBook.getSheet(sheetName);
		row = sheet.getRow(0);

		if (row == null)
			return -1;

		return row.getLastCellNum();

	}

	public boolean addHyperLink(String sheetName, String screenShotColName, String testCaseName, int index, String url,
			String message) {
		// System.out.println("ADDING addHyperLink******************");

		url = url.replace('\\', '/');
		if (!isSheetExist(sheetName))
			return false;

		sheet = workBook.getSheet(sheetName);

		for (int i = 2; i <= getRowCount(sheetName); i++) {
			if (getCellData(sheetName, 0, i).equalsIgnoreCase(testCaseName)) {
				// System.out.println("**caught "+(i+index));
				setCellData(sheetName, screenShotColName, i + index, message, url);
				break;
			}
		}

		return true;
	}
	public int getCellRowNum(String sheetName, String colName, String cellValue) {

		for (int i = 2; i <= getRowCount(sheetName); i++) {
			if (getCellData(sheetName, colName, i).equalsIgnoreCase(cellValue)) {
				return i;
			}
		}
		return -1;

	}


}
