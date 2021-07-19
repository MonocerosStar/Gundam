package com.java.homework;

public class Test {
	public static void main(String[] args) {
		String str = "abcsdavsb";
		lengthOfLongestSubstring(str);
		System.out.println(lengthOfLongestSubstring(str));
	}
	public static int lengthOfLongestSubstring(String s) {
        int strLength = -1;
        if("".equals(s) || s == null){
            strLength = 0 ;
            return strLength;
        }
         char[] str = s.toCharArray();
         int i = 0;
         for(char p : str){
             i++;
             int subLength =  s.substring(i).indexOf(p) + 1;
             strLength = subLength > strLength ? subLength : strLength;
         }
         return strLength;
         
    }
}
