import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import javax.script.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class URLWindow {
	public static void main(String[] args) {

		JFrame frameWindow = new JFrame();
		frameWindow.setSize(800, 500);
		frameWindow.setVisible(true);
		frameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton exportToExcelButton = new JButton();
		exportToExcelButton.setText("Export to Excel");
		exportToExcelButton.setVisible(true);
		exportToExcelButton.setSize(150, 50);
		exportToExcelButton.setLocation(100, 200);

		/*
		 * JButton createExcelButton = new JButton();
		 * exportToExcelButton.setText("Create Excel");
		 * exportToExcelButton.setVisible(true);
		 * exportToExcelButton.setSize(150, 50);
		 * exportToExcelButton.setLocation(100,300 );
		 */
		frameWindow.add(exportToExcelButton);
		// frameWindow.add(createExcelButton);

		exportToExcelButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				// Method 2
				/*
				 * Document doc; try { doc =
				 * Jsoup.connect("http://www.w3.org/TR/html5/tabular-data.html")
				 * .get(); //Elements newsHeadlines = doc.select("body a");
				 * Elements links = doc.getElementsByTag("table"); while
				 * (links!=null) { System.out.println(links); } } catch
				 * (IOException e1) { // TODO Auto-generated catch block
				 * e1.printStackTrace(); }
				 * 
				 * 
				 */
				// Working code
				HSSFWorkbook workbook = new HSSFWorkbook();
				HSSFSheet sheet = workbook.createSheet("Sample");
				Row excelRow;
				int rownum = 0;
				int colnum = 0;
				Cell cell;
				Document doc;
				try {
					doc = Jsoup.connect("http://espn.go.com/mens-college-basketball/conferences/standings/_/id/2/year/2012/acc-conference").get();

					for (Element table : doc.select("table")) {
						rownum=0;
						for (Element row : table.select("tr")) {
							rownum++;
							colnum=0;
							excelRow = sheet.createRow(rownum);
							for (Element tds : row.select("td")) {
								// colnum++;
								cell = excelRow.createCell(colnum++);
								String newString = tds.toString().replace("<td>", "");
								String new1String = newString.replace("</td>", "");
								cell.setCellValue(new1String);
								// cell.setCellValue(((ArrayList<Element>)
								// tds).get(colnum).text());}
								/*
								 * if(tds.size()>3) {
								 * System.out.println(tds.get(0).text()+"|"+tds.
								 * get(1).text()+"|"+tds.get(2).text()); }
								 */
							}
						}
					}
					FileOutputStream out;
					out = new FileOutputStream(new File("D:\\new.xls"));
					workbook.write(out);
					out.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					
				// Method 1

				/*
				 * try { URL oracle = new URL(
				 * "http://espn.go.com/mens-college-basketball/conferences/standings/_/id/2/year/2012/acc-conference"
				 * ); URLConnection yc = oracle.openConnection(); BufferedReader
				 * in = new BufferedReader(new
				 * InputStreamReader(yc.getInputStream())); String inputLine;
				 * while ((inputLine = in.readLine()) != null)
				 * System.out.println(inputLine); in.close(); } catch
				 * (IOException e1) { // TODO Auto-generated catch block
				 * e1.printStackTrace(); }
				 */

			}
		});
	}
}
