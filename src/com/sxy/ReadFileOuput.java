package com.sxy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class ReadFileOuput {
	public static void main(String[] args) {
		StringBuilder string = readTxt("C:\\\\Users\\\\wasd1\\\\Desktop\\\\add.txt");
		System.out.println(string);

	}

	public static StringBuilder readTxt(String filePath) {
		StringBuilder result = new StringBuilder();
		try {
			BufferedReader bfr = new BufferedReader(
					new InputStreamReader(new FileInputStream(new File(filePath)), "GBK"));

			String lineTxt = null;
			while ((lineTxt = bfr.readLine()) != null) {
				result.append(lineTxt);
				result.append("\n");
			}
			bfr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	

}
