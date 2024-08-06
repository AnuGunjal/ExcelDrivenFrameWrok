import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven {

	public ArrayList getData(String testcasename) throws IOException
	{
		ArrayList<String> a = new ArrayList<String>();
		String path = System.getProperty("user.dir");
		FileInputStream fis = new FileInputStream(path+"\\src\\test\\resources\\demodata.xlsx");

		// XSSFWorkbook accepts fileinput stream argument
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		// to get the count of sheets from workbook
		// getNumberOfSheets return the integers hence we are storing in int

		int sheets = workbook.getNumberOfSheets();
		for (int i = 0; i < sheets; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("TestData")) {

				XSSFSheet sheet = workbook.getSheetAt(i); // getSheetAt method return XSSFSheet hence we are storing in
															// the same
				// identify testcase column by scanning entire 1st row (headers)
				// to read each row we create the iterator and create the object out of it

				Iterator<Row> rows = sheet.rowIterator(); // sheet is a collection of row
				Row firstRow = rows.next(); // this next is used to move to the next row
				Iterator<Cell> cells =firstRow.cellIterator();  // row is a collection of cells
				 // this will move to the next cell from the row
				int k = 0;
				int column=0;
				while(cells.hasNext())// hasNext() method tells if the next present or not
				{
					Cell value =cells.next();
					if(value.getStringCellValue().equalsIgnoreCase("TestCase"))
					{
						//selected desired colum
						column=k;
						
					}
					k++;
				}
				System.out.println(column);
				
				// once column is identified then scan entire testcase column to identify
				while(rows.hasNext())
				{
					Row nextRow = rows.next();
					if(nextRow.getCell(column).getStringCellValue().equalsIgnoreCase(testcasename))
					{
						System.out.println(nextRow.getCell(column).getStringCellValue());
						
					  Iterator<Cell> rowCells=  nextRow.cellIterator();
					  
					 while(rowCells.hasNext())
					 {
						
						 //System.out.println(rowCells.next().getStringCellValue());
						 Cell c = rowCells.next();
						
						if(c.getCellType()==CellType.STRING)
                         {
                        	 a.add(c.getStringCellValue());
                         }
                         else
                         {
                        	a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
                        	 
                         }
							
						 
					 }
					}
				}
			}
		}
		return a;

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// identify testcase column by scanning entire 1st row (headers)
		// once column is identified then scan entire testcase column to identify
		// purchase testcase row
		// after you grab purchase tetscase row- pull all data of purchase row and feed
		// to the testcase

	}

}
