package com.utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ui.pojo.User;

public class ExcelReaderUtility {

	public static Iterator<User> readEceFileName(String fileName)   {

		File xssFile = new File(System.getProperty("user.dir") + "\\testData\\"+fileName);
		XSSFWorkbook workbook = null;
		XSSFSheet sheet;
		List<User> userList=null	;
		Row row;
		Cell emailAddressCell;
		Cell passwordCell;
		User user;
		Iterator<Row> rowIterator;
		try {
			workbook = new XSSFWorkbook(xssFile);
			sheet = workbook.getSheet("loginData");
			userList = new ArrayList<User>();
			
			 rowIterator = sheet.iterator();
			rowIterator.next();
			while (rowIterator.hasNext()) {
				row = rowIterator.next();
				emailAddressCell = row.getCell(0);
				passwordCell = row.getCell(1);
				user=new User(emailAddressCell.toString(),passwordCell.toString());
				userList.add(user);
				workbook.close();

			}

		} catch (InvalidFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	return userList.iterator();
	}
	

}
