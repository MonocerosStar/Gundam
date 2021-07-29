package cn.com.filecount;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class CountUtils {

	public Map getCharNums(String fileName,String letter) throws IOException{
		//保存字符出现的位置及次数
		int rowLocation = 0; 
		int colLocation = 0;
		int counts = 0;
		int letterLength = letter.length();
		//存放字符出现的次数
		Map<String,Integer> map = new HashMap<String,Integer>();
		Map<String,Object> ret = new HashMap<String,Object>();
		File file = new File(fileName);
		String line = null;
		List<Coords> list =new ArrayList<Coords>();
		if (file.exists() && letter != null) {
			//读取文件 file
			BufferedReader br = new BufferedReader(new FileReader(file));
			while ((line = br.readLine()) != null) {
				rowLocation++ ;
				colLocation = 0;
				while (line.contains(letter)) {
					colLocation += line.indexOf(letter);
					list.add(new Coords(rowLocation,colLocation));
					line = line.substring(line.indexOf(letter)+letterLength);
					counts++;	
				}		
			}
			map.put(letter, counts);
			ret.put(letter, map);
			ret.put("location", list);
			br.close();
		}else {
			System.out.println("文件不存在，请重新输入：");
		}
		return ret;
	}
	//获取文件总行数
	public int getLineNumber(String fileName) throws IOException{
		int counts = 0;
		File file = new File(fileName);
		if (file.exists()) {
			BufferedReader br = new BufferedReader(new FileReader(file));
			while(br.readLine()!=null){
				counts++;
			}
			br.close();
		}else {
			System.out.println("文件不存在，请重新输入：");
		}
		return counts;
	}
	//统计注释行、空行、代码行
	public void countDiffLine(String path) {
		int annotationLineNum = 0;
		int codeLineNum = 0;
		int nullLineNum = 0;
		String line;
		BufferedReader br = null;
		// 注释匹配器(匹配单行、多行、文档注释)
		Pattern annotationLinePattern = Pattern.compile("(//)|(/\\*)|(^\\s*\\*)|(^\\s*\\*+/)");    
		try {
			br = new BufferedReader(new FileReader(path));
			while((line = br.readLine()) != null){
				if(annotationLinePattern.matcher(line).find()) {//注释行       
					annotationLineNum++;
				}else if (line.matches("\\s*\\p{Graph}?\\s*")) {//空行
					nullLineNum++;
				}else {                 
					codeLineNum++;
				}               
			}
			System.out.println("空白行数是: " + nullLineNum);
			System.out.println("注释行数是: " + annotationLineNum);
			System.out.println("代码行数是: " + codeLineNum);
			br.close();
		} catch (IOException e) {
			System.out.println(path + "文件名错误");
		}   
	}
	//  控制台内容输出到控制指定的文档中进行保存
	public void outFile(String fileName) throws FileNotFoundException{
		PrintStream print=new PrintStream(fileName);
		System.setOut(print);
	}
}
