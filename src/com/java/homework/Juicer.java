package com.java.homework;

public class Juicer {

	String name;

	public String getName(){ 
			return name;
	}

	public void setName(String name){
	this.name =name;

	}
	public  static void main(String [] arges){
		Juicer juicer= new Juicer();
		juicer.setName("白色苏泊尔牌榨汁机");
		Fruit apple =new Apple(juicer);
		Fruit pear =new Pear(juicer);
		apple.squeeze();
		pear.squeeze();

	}
	
}
abstract  class Fruit{
	abstract void squeeze();

	protected void cleanTwoSecond(){
		try{
			Thread.sleep(2000L);
			System.out.println("----榨汁机清洗完成----");
		}catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
class Apple extends Fruit{
	private Juicer juicer;

	public Apple(Juicer juicer){
		this.juicer=juicer;
	}
	

	void squeeze(){
		System.out.println(juicer.getName()+"榨出苹果汁");
		System.out.println("----榨汁机正在清洗中----");
		cleanTwoSecond();
	}
}
	class Pear extends Fruit{
		private Juicer juicer;
		public Pear(Juicer juicer){
			this.juicer=juicer;
		}

	void squeeze(){
		System.out.println(juicer.getName()+"榨出梨汁");
		System.out.println("----榨汁机正在清洗中----");
		cleanTwoSecond();

	}


}

