package com.java.homework;

public class MathUtil {
	public static void isPrime(int n){
	    int i=2;
	    for(;i<n;i++){
	        if(n%i==0){
	            System.out.println(n+"不是素数");
	            break;
	        }
	    }
	    if(n==i){
	        System.out.println(n+"是素数");
	    }
	}
	   static void primeFactorization(int num){
	        int origin = num;
	        StringBuilder sb = new StringBuilder();
	        for(int i = 2; i <= Math.sqrt(num); i++){
	            while(num % i == 0){
	                num = num/i;
	                sb.append(i).append("*");
	            }
	        }
	        sb.append(num);
	        System.out.println(origin + " = " + sb.toString());
	    }
	public static void main(String[] args) {
		isPrime(7);
		primeFactorization(60);
	}

}
