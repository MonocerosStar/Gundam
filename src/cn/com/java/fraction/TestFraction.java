package cn.com.java.fraction;

import java.util.Scanner;
import java.util.StringTokenizer;

public class TestFraction {
	public static void main(String[] args) {
		// 用户输入两分数和运算符
		Scanner input = new Scanner(System.in);
		System.out.println("请用户输入第一个分数(格式a/b)");
		String data = input.next();
		System.out.println("请用户输入要进行运算的运算符(+-*/)");
		String operation = input.next();
		System.out.println("请用户输入第二个分数(格式c/d)");
		String data1 = input.next();
		StringTokenizer st = new StringTokenizer(data,"/");
		StringTokenizer st2 = new StringTokenizer(data1,"/");
		int firNum = Integer.parseInt(st.nextToken());
		int secNum = Integer.parseInt(st.nextToken());

		int firNum1 = Integer.parseInt(st2.nextToken());
		int secNum1 = Integer.parseInt(st2.nextToken());
		Fraction fraction = new Fraction(firNum, secNum);
		switch (operation) {
		case "+":
			System.out.println(fraction.add(firNum1,secNum1).toString());
			break;
		case "-":
			System.out.println(fraction.sub(firNum1,secNum1).toString());
			break;
		case "*":
			System.out.println(fraction.multiply(firNum1,secNum1).toString());
			break;
		case "/":
			System.out.println(fraction.divide(firNum1,secNum1).toString());
			break;
		default:
			break;
		}
	}
}
