package cn.com.filecount;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException{
		CountUtils util = new CountUtils();
		System.out.println("-w 返回文件 file.c 中指定的字符的数目和位置  \n" +"-l 返回文件 file.c 的总行数 \n"+"-x 返回文件 file.c 的行数/注释行数/空行数");
		System.out.println("-o 文件路径 (生成result文件)\n");
		System.out.println("----------------------------------------------------------------------------------------------------------");
		System.out.println("请输入命令：（格式为：命令 文件路径 需要查询的字符）");
		while(true){
			//流处理处理输入的文件数据
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String input=br.readLine();
			//将输入以空格进行分割,command分割成数组进行存储工作
			String[] commond = input.split(" ");
			//使用switch输入的命令进行分割
			switch(commond[0]) {
			case "-w": 
				Map<String,Integer> map = new HashMap<String, Integer>();
				Map resMap = util.getCharNums(commond[1],commond[2]);
				List<Coords> list =new ArrayList<Coords>();
				if (null != resMap) {
					map = (Map<String, Integer>) resMap.get(commond[2]);
					list = (List<Coords>) resMap.get("location");
					if (null !=map) {
						System.out.println("字符"+commond[2]+"出现的次数为"+map.get(commond[2]));
					}
					if (list !=null && list.size()>0) {
						for (Coords coords : list) {
							System.out.println(coords.toString());
						}
					}
				}
				break;
			case "-l":
				int num = util.getLineNumber(commond[1]);
				System.out.println("行数："+num);
				break;
			case "-x":
				util.countDiffLine(commond[1]);
				break;
			case"-o":
				util.outFile(commond[1]);
				break;
			default:
				System.out.println("命令不正确,请重新输入!");
				break;
			}
		}
	}
}
