package com.hms.PracticePacage;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonDataTest {

	public static void main(String[] args) throws Throwable {
		JSONParser p = new JSONParser();
		FileReader fr = new FileReader(".\\src\\test\\resources\\jsonFile.json");
		Object obj = p.parse(fr);
		JSONObject map = (JSONObject) obj;
		System.out.println(map.get("browser"));
		System.out.println(map.get("username"));
		System.out.println(map.get("password"));
		System.out.println(map.get("url"));
	}

}
