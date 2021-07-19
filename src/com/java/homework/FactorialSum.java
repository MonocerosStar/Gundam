package com.java.homework;

public class FactorialSum {
	public static void main(String[] args) {
		long sum=0;
		for (int i = 1; i <= 16; i+=3) {
			long count=1;
			for (int j = i; j >1; j--) {
				count=count*j;
			}
			sum+=count;
		}
		System.out.println(sum);
	}

}
