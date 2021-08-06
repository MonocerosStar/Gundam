package cn.com.java.fraction;
/**
 * 分数计算类
 * @author Monoceros
 *
 */
public class Fraction {
	public int molecule;//分子
	public int denominator;//分母
	public Fraction(int molecule, int denominator) {
		if (denominator == 0) {
			try {
				throw new Exception("denominator cannot be zero!");
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		this.molecule = molecule;
		this.denominator = denominator;
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
}
