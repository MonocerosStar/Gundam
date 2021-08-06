package cn.com.java.fraction;
/**
 * 分数计算类
 * @author Monoceros
 *
 */
public class Fraction {
	public int molecule;//分子
	public int denominator;//分母
	public int sign;//符号
	public Fraction(int molecule, int denominator) {
		if (denominator == 0) {
			try {
				throw new Exception("denominator cannot be zero!");
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		sign = molecule * denominator > 0 ? 1 :-1;
		this.molecule = molecule;
		this.denominator = denominator;
		simplify();
	}
	//简化分数
	public void simplify() {
		if (molecule == 0) {
			return;
		}
		int maxDivisior = findMaxDivisior(molecule,denominator);
		molecule /= maxDivisior;
		denominator /= maxDivisior;
	}
	//欧几里得法求最大公约数
	public int findMaxDivisior(int num1, int num2) {
		int comDivisor1;
		int comDivisor2;
		if (num1 > num2) {
			comDivisor1 = Math.abs(num1);
			comDivisor2 = Math.abs(num2);
		}else {
			comDivisor2 = Math.abs(num1);
			comDivisor1 = Math.abs(num2);
		}
		int remainder = comDivisor1 % comDivisor2;
		if (remainder == 0) 
			return comDivisor2;
		else 
			return findMaxDivisior(comDivisor2,remainder);
	}
	/***********************************************
	 *     加减乘除四则运算和相应的四个方便操作的重载。
	 ***********************************************/ 
	public Fraction add(Fraction fraction) {
		molecule = this.sign * (molecule * fraction.denominator) + (denominator * fraction.molecule) * fraction.sign;
		denominator = denominator * fraction.denominator;
		simplify();
		return this;
	}
	public Fraction sub(Fraction fraction) {
		return add(fraction.molecule,fraction.denominator);
	}
	
	public Fraction multiply(Fraction fraction) {
		this.sign *= fraction.sign;
		this.molecule *= fraction.molecule;
		this.denominator *= fraction.denominator;
		this.simplify();
		return this;
	}
	public Fraction divide(Fraction fraction) {
		return multiply(fraction.sign * fraction.denominator,fraction.molecule);
	}
	public Fraction divide(int n, int m) {
		return divide(new Fraction(n,m));
	}
	private Fraction multiply(int n, int m) {
		// TODO Auto-generated method stub
		return multiply(new Fraction(n,m));
	}
	public Fraction add(int molecule2, int denominator2) {
		// TODO Auto-generated method stub
		return add(new Fraction(molecule2,denominator2));
	}
	
	public Fraction sub(int molecule2, int denominator2) {
		// TODO Auto-generated method stub
		return add(new Fraction(-molecule2,denominator2));
	}
}
