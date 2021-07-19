package com.java.homework;
import java.util.Arrays;


public class ArrayUtil {
	
	public static void bubbleSort(char[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				// 降序输出
				if (arr[j]<arr[j + 1]) {
					char temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				} 
			} 
		} 
	}
	public static void moveOne(int k,int[] arr) {
		
		 	k=k%arr.length;
		 	moveTwo(arr,1,arr.length);
		 	moveTwo(arr,1,k);
		 	moveTwo(arr,k+1,arr.length);
	        System.out.println("右移"+k+"位的结果为：");
			for (int i : arr) {
				System.out.print(i+" ");
			}

		
	}
	
	 public static void moveTwo(int[] arr,int begin,int end){
		 	int temp;
	        while(begin<end){
	        	temp=arr[begin-1];
	        	arr[begin-1]=arr[end-1];
	        	arr[end-1]=temp;
	        	begin++;
	        	end--;
	        }
	    }


	public static void main(String[] args) {
		
		
		  char []arr= {'a','b','c','d','e','f'}; System.out.println("原字符串数组为：");
		  System.out.println(Arrays.toString(arr)); 
		  bubbleSort(arr);
		  System.out.println(Arrays.toString(arr));
		  
		  int[]brr= {1,2,3,4,5}; 
		  int k=2;
		  moveOne(k,brr);
	}

}

