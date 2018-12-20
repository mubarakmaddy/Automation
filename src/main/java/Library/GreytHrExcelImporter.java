package Library;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class GreytHrExcelImporter {
	public String getExcelData(String sheetName, int rowNumber, int cellNumber) {
		try {
			FileInputStream fis = new FileInputStream("D:/Automation/Excel import/GreytHr.xls");
			Workbook wb = WorkbookFactory.create(fis);
			Sheet s = wb.getSheet(sheetName);
			Row r = s.getRow(rowNumber);
			Cell c = r.getCell(cellNumber);
			String val = c.getStringCellValue();
			return val;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
