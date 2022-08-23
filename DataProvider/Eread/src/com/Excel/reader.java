package com.Excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class reader {

	public static Workbook book;
	public static Sheet Sheet;

	static ArrayList<Object []> mydata = new ArrayList<Object []>();
//	static ArrayList<String> details = new ArrayList<String>(); 
	
	public static ArrayList<Object []> Excelreader() {
		FileInputStream file = null;

		ArrayList<Object[]> myData = new ArrayList<Object[]>();

		FileInputStream fs = null;
		try {
			fs = new FileInputStream("C:\\selenium\\Eread\\src\\Datadriven.xlsx");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		XSSFWorkbook workbook = null;
		try {
			workbook = new XSSFWorkbook(fs);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		XSSFSheet sheet = workbook.getSheetAt(0);

//		Row row = sheet.getRow(0);
//		Cell cell = row.getCell(0);
//		System.out.println(sheet.getRow(0).getCell(0));
//		Row row1 = sheet.getRow(1);
//		Cell cell1 = row1.getCell(1);
//		System.out.println(sheet.getRow(0).getCell(1));
//		Row row2 = sheet.getRow(1);
//		Cell cell2 = row2.getCell(1);
//		System.out.println(sheet.getRow(1).getCell(0));
//		Row row3 = sheet.getRow(1);
//		Cell cell3 = row3.getCell(1);
//		System.out.println(sheet.getRow(1).getCell(1));

		int k = 0;
		for (int rc = 1; rc <= sheet.getLastRowNum(); rc++) {

			String fn = sheet.getRow(rc).getCell(k).toString().trim();
			String ln = sheet.getRow(rc).getCell(k + 1).toString().trim();
			String em = sheet.getRow(rc).getCell(k + 2).toString().trim();
			String pw = sheet.getRow(rc).getCell(k + 3).toString().trim();

			//mydata.add(new Object[] { fn, ln, em, pw });
//			details.add(fn);
//			details.add(ln);
//			details.add(em);
//			details.add(pw);
			
			
			System.out.println("fn : " + fn + "ln : " + ln + " em : " + em + " pw : " + pw);

//			Iterator<Object[]> itr = mydata.iterator();
//			while(itr.hasNext()) {
//				System.out.println(itr.next());
			
//			mydata.add(details);
			
			Object ob[] = {fn,ln,em,pw};
			mydata.add(ob);
//			}

		}

		return mydata;

	}

}
