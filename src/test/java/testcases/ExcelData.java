package testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		// FileInputStream is class in java which is capable to read any files
		String path= System.getProperty("user.dir");
		FileInputStream fis = new FileInputStream(path+"\\src\\test\\resources\\Tdata.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		// this class is to access/ control over excel and it accepts the FileInpustream
		// object as parameter

		int sheets = workbook.getNumberOfSheets(); // this is to get the count of sheets and it return int hence storing
													// in the same datatype

		// using for loop to iterate over the sheets to get required sheet
		for (int i = 0; i < sheets; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("testdata")) {
				XSSFSheet sheet = workbook.getSheetAt(i); // sheet is collection of rows
				Iterator<Row> row = sheet.rowIterator();
				Row firstRow = row.next();
				Iterator<Cell> cells = firstRow.cellIterator(); // Row is collection of cell

				int k = 0;
				int column = 0;
				while (cells.hasNext()) {
					Cell cvalue = cells.next();
					if (cvalue.getStringCellValue().equalsIgnoreCase("Testcase")) {
						// to get the desired column no
						column = k;
					}
					k++;
				}
				System.out.println(column);

				// to iterate over the Testcase column to find Integration testcasename

				while (row.hasNext()) {
					Row rvalue = row.next();
					if (rvalue.getCell(column).getStringCellValue().equalsIgnoreCase("Regression")) {
						System.out.println(rvalue.getCell(column).getStringCellValue());
						Iterator<Cell> rcell = rvalue.cellIterator();
						       while(rcell.hasNext())
						       {
						    	  System.out.println(rcell.next().getStringCellValue());
						       }
						

					}

				}

			}
		}
	}

}
