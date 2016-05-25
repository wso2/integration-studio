package org.wso2.developerstudio.eclipse.ds.wizards.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;

public class ExelReader {

	String filePath;

	public ExelReader(String filePath) {

		this.filePath = filePath;

	}

	public ArrayList<String> getHeaders(String nameOfWorkSheet) {
		ArrayList<String> headerHolder = new ArrayList<String>();
		try {

			// Create a work book reference
			HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(filePath));

			// get the first sheet
			HSSFSheet sheet = workbook.getSheet(nameOfWorkSheet);

			// Reading the TOP LEFT CELL
			HSSFRow row = sheet.getRow(0);

			Iterator<Cell> i = row.cellIterator();
			while (i.hasNext()) {

				headerHolder.add(i.next().getStringCellValue());

			}

		} catch (FileNotFoundException e) {
			MessageDialog.openInformation(Display.getCurrent().getActiveShell(), "File not found",
			                              e.toString());
		} catch (IOException e) {
			MessageDialog.openInformation(Display.getCurrent().getActiveShell(),
			                              "Error occured while reading the file", e.toString());
		}

		return headerHolder;
	}

	public ArrayList<String> getWorkSheets() throws FileNotFoundException, IOException {

		ArrayList<String> sheetNames = new ArrayList<String>();

		HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(filePath));

		int numOfSheets = workbook.getNumberOfSheets();

		for (int i = 0; i < numOfSheets; i++) {

			sheetNames.add(workbook.getSheetAt(i).getSheetName());
		}

		return sheetNames;

	}
}
