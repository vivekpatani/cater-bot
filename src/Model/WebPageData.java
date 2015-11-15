package Model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
/*import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;*/
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class WebPageData {
	public String getData(String URL) {

		// Working code
		//HSSFWorkbook workbook = new HSSFWorkbook();
		//HSSFSheet sheet = workbook.createSheet("Sample");
		//Row excelRow;
		int rownum = 0;
		int colnum = 0;
		Cell cell;
		Document doc;
		try {
			doc = Jsoup
					.connect(URL)
					.get();

			for (Element table : doc.select("table")) {
				rownum = 0;
				for (Element row : table.select("tr")) {
					rownum++;
					colnum = 0;
					//excelRow = sheet.createRow(rownum);
					for (Element tds : row.select("td")) {
						//cell = excelRow.createCell(colnum++);
						String newString = tds.toString().replace("<td>", "");
						String new1String = newString.replace("</td>", "");
						//cell.setCellValue(new1String);
					/*	if (tds.size() > 3) {
							return System.out.println(tds.get(0).text() + "|" + tds.get(1).text() + "|" + tds.get(2).text());
						}
*/
					}
				}
			}
			FileOutputStream out;
			out = new FileOutputStream(new File("D:\\new.xls"));
			//workbook.write(out);
			out.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
return null;
	}

	public boolean writeData() {
		return false;

	}
}
