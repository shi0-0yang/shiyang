package com.shiyang.accountBook;

import jxl.Sheet;
import jxl.Workbook;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class Account {
	/**
	 * 计算各账户消费总额
	 * @param file 文件地址
	 * @throws Exception 抛出异常
	 */
    public static void myAccount(File file) throws Exception {
		HashMap<String, ArrayList<Double>> hashMap=new HashMap<>();
		Workbook readdb=Workbook.getWorkbook(file);
    	Sheet sheet=readdb.getSheet(0);
    	int rsRows=sheet.getRows();
    	for (int i=2;i<rsRows;i++){
    		String key=sheet.getCell(1,i).getContents();
    		if(!"".equals(key)){
        		Double value=Double.parseDouble(sheet.getCell(2,i).getContents());
    			if(hashMap.containsKey(key)){
    				hashMap.get(key).add(value);
				}else {
    				ArrayList<Double> list=new ArrayList<>();
    				list.add(value);
    				hashMap.put(key,list);
				}
			}
		}
		for (String key:hashMap.keySet()) {
			Double dd=hashMap.get(key).stream()
					.reduce((double) 0,(x,y) -> x+y);
			System.out.println(key+"："+String.format("%.2f", dd));
		}
		readdb.close();
    }

    public static void main(String[] args) {
        try {
//            readSpecifyColumns(new File("C:\\Users\\wasd1\\Desktop\\账本.xls"));
//            //获取指定列的值
//            readSpecifyColumns(new File("C:\\Users\\wasd1\\Desktop\\账本.xls"));
//
//            //获取指定行的值
//            readSpecifyRows(new File("C:\\Users\\wasd1\\Desktop\\账本.xls"));
//
//            //读取行列的值
//            readRowsAndColums(new File("C:\\Users\\wasd1\\Desktop\\账本.xls"));
//
//            //将获取到的值写入到TXT或者xls中
//            copy_excel(new File("C:\\Users\\wasd1\\Desktop\\账本.xls"));
			myAccount(new File("C:\\Users\\wasd1\\Desktop\\账本.xls"));

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
}
}
