package com.shiyang.arithmetic;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class testFile {
	public static void main(String[] args) throws IOException {
	    String path=".\\output.txt";
	    File file=new File(path);
        //如果文件不存在，则自动生成文件；
	    if(!file.exists()){
	       file.createNewFile();
        }
	    //引入输入流
        OutputStream outputStream;
	    try{
	        outputStream=new FileOutputStream(file);
	        StringBuilder stringBuilder=new StringBuilder();
            stringBuilder.append("文件内容");//追加文件内容
            //TODO 这里写你的代码逻辑;

            String context = stringBuilder.toString();//将可变字符串变为固定长度的字符串，方便下面的转码；
            byte[]  bytes = context.getBytes(StandardCharsets.UTF_8);//因为中文可能会乱码，这里使用了转码，转成UTF-8；
            outputStream.write(bytes);//开始写入内容到文件；
            outputStream.close();//一定要关闭输出流；
        }catch(Exception e){
            e.printStackTrace();//获取异常
        }

		// 用File对象表示一个目录,.表示当前目录
		File dir = new File(".\\TestDir");
		// 创建HTML文件过滤器
		Filter filter = new Filter("html");
		System.out.println("HTML文件目录：" + dir);
		// 列出目录TestDir下，文件后缀名为HTML的所有文件
		String files[] = dir.list(filter);
		// dir.list();
		// 遍历文件列表
		for (String fileName : files) {
			// 为目录TestDir下的文件或目录创建File对象
			File f = new File(dir, fileName);
			// 如果该f对象是文件，则打印文件名
			if (f.isFile()) {
				System.out.println("文件名：" + f.getName());
				System.out.println("文件绝对路径：" + f.getAbsoluteFile());
				System.out.println("文件路径：" + f.getPath());
			} else {
				System.out.println("子目录：" + f);
			}
		}
		
	}

}
// 自定义基于文件扩展名的文件过滤器
class Filter implements FilenameFilter {
	// 文件扩展名
	String extent;
	// 构造方法
	public Filter(String extent) {
		// TODO Auto-generated constructor stub
		this.extent=extent;
	}

	@Override
	public boolean accept(File dir, String name) {
		// 测试文件扩展名是否为extent所指定的
		return name.endsWith("." + extent);
	}
}
