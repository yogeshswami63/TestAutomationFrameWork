package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.ui.pojo.User;

public class CsvReaderUtility {
	public static Iterator<User> readCsvFile(String fileName) {

		File csvFile = new File(System.getProperty("user.dir") + "//testData//"+fileName);
		FileReader csvFileReader = null;
		CSVReader csv;
		String[] line;
		User userData;
		List<User> userList=null;
		try {
			csvFileReader = new FileReader(csvFile);
			csv = new CSVReader(csvFileReader);
			csv.readNext();
			userList = new ArrayList<User>();
			
			while ((line = csv.readNext()) != null) {
				userData = new User(line[0], line[1]);
				userList.add(userData);

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		catch (CsvValidationException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return userList.iterator();
	}

}
