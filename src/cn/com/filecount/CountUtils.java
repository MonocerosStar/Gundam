package cn.com.filecount;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class CountUtils {

	private Map getCharNums(String fileName,String letter) throws IOException{
	int count = 0 ;
	int rowLocation = 0; 
	int colLocation = 0;
	Map<String,Integer> map = new HashMap<String,Integer>();
	File file = new File(fileName);
	//记录行数line
	String line = null;
	if (file.exists() && letter != null) {
		//读文件 file
		BufferedReader br = new BufferedReader(new FileReader(file));
		while ((line = br.readLine()) != null) {
			Pattern p = Pattern.compile("\\s*|\\t|\\r|\\n");
			
		}
	}else {
		System.out.println("文件不存在，或统计的字母不存在！");
	}
	return map;
	
}
}
