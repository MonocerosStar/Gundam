package com.java.calculator;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入算表达式，按回车键结束：");
        String str = sc.nextLine();
        System.out.println(cacResult(str));
    }
 
    private static double cacResult(String str) {
        if ("".equals(str))
            return 0;
        int cl = str.lastIndexOf('('); 
        if (cl == -1)
            return cac(str);
        int cr = str.indexOf(')', cl);
        String left = str.substring(0, cl);
        String right = str.substring(cr + 1);
        String middle = str.substring(cl + 1, cr);
        return cacResult(left + cac(middle) + right);
    }
 
    public static double cac(String str) {
        if ("".equals(str))
            return 0;
 
        int ml = str.indexOf('*');
        int dl = str.indexOf('/');
 
        if (ml == -1 && dl == -1) {
            return cacNoMD(str);
        }
        int index = ml == -1 ? dl : ml;
        String left = str.substring(0, index);
        String m1 = isNumber(left);
        left = left.substring(0, left.length() - m1.length());
        String right = str.substring(index + 1);
        String m2 = isNumber(right);
        right = right.substring(m2.length());
        double d1 = Double.parseDouble(m1);
        double d2 = Double.parseDouble(m2);
        double tmp = 0;
        if (index == ml) {
            tmp = d1 * d2;
        } else if (index == dl) {
            tmp = d1 / d2;
        }
        return cac(left + tmp + right);
    }
 
 
    private static String isNumber(String str) {
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c) && c != '.')
                break;
            sb.append(c);
        }
        return sb.toString();
    }
 
    private static double cacNoMD(String str) {
        double ret = 0;
        StringBuilder sb = new StringBuilder();
        char sign = '+';
        for (char c : (str + "+").toCharArray()) {
            if (!Character.isDigit(c) && c != '.') {
                if (sb.length() == 0)
                    continue;
                double tmp = Double.parseDouble(sb.toString());
                if (sign == '+') {
                    ret += tmp;
                } else {
                    ret -= tmp;
                }
                sb = new StringBuilder();
                sign = c;
            } else {
                sb.append(c);
            }
        }
        return ret;
    }
 
}
