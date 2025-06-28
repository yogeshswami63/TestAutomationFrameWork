package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import  com.constants.Env;
import com.google.gson.Gson;
import com.ui.pojo.Config;
import com.ui.pojo.Environment;

public class JsonUtility {
  public static Environment readJson(Env env)  {
	 

	Gson gson = new Gson();
	File jsonFile = new File(System.getProperty("user.dir") + "\\configuration\\config.json");
	FileReader fileRead = null;
	try {
		fileRead = new FileReader(jsonFile);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	Config config=gson.fromJson(fileRead, Config.class);
	Environment environment=config.getEnvironments().get("QA");
	return environment;

}
}
