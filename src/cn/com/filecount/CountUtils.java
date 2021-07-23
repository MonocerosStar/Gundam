package cn.com.filecount;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class CountUtils {

	private Map getCharNums(String fileName,String letter) throws IOException{
	int count = 0 ;
	//记录行数行数、列数和次数-用来对应坐标
	int rowLocation = 0; 
	int colLocation = 0;
	int counts = 0;
	//用来存放字符出现的总次数
	Map<String,Integer> map = new HashMap<String,Integer>();
	Map<String,Object> ret = new HashMap<String,Object>();
	File file = new File(fileName);
	String line = null;
	List<Coords> list =new ArrayList<Coords>();
	if (file.exists() && letter != null) {
		//读文件 file
		BufferedReader br = new BufferedReader(new FileReader(file));
		while ((line = br.readLine()) != null) {
			rowLocation++ ;
			while (line.contains(letter)) {
				colLocation = line.indexOf(letter);
				list.add(new Coords(rowLocation,colLocation));
				line = line.substring(line.indexOf(letter));
				counts++;	
			}		
		}
		map.put(letter, counts);
		ret.put(letter, map);
		ret.put("location", list);
		br.close();
	}else {
		System.out.println("文件不存在，或统计的字母不存在！");
	}
	return ret;
}
}
