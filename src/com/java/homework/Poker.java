package com.java.homework;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;
public class Poker {
	private static String [] colors = {"♥","♦","♠","♣"};
	private static String [] nums = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
	private String [] poker = new String[54];	
	
	public void init() {
		int index = 0;
		for(int i=0;i<nums.length;i++) { 
			for(int j=0;j<colors.length;j++) { 
				poker[index] = colors[j]+nums[i];
				index++;
			}
		}
		poker[index++] = "小王";
		poker[index] = "大王";
		show();
	}
	
	
	public void show() {
		for(int i =0;i<poker.length;i++) {
			System.out.print(poker[i]+"\t");
			if((i+1) % 4 ==0) 
				System.out.println();
		}
	}
	 public static void dispatcher() {
		 	TreeSet<Integer> w1set = new TreeSet<>();//玩家1牌组集合
	        TreeSet<Integer> w2set = new TreeSet<>();//玩家2牌组集合
	        TreeSet<Integer> w3set = new TreeSet<>();//玩家3牌组集合
	        TreeSet<Integer> dpset = new TreeSet<>();//底牌牌组集合
	        ArrayList<Integer> list = new ArrayList<>();//存放扑克牌的索引
	        HashMap<Integer, String> hezi = new HashMap<>();//存放扑克牌和它的索引
	        int index = 0;//扑克牌的索引
	        
	        //将扑克牌存放进HashMap集合中
	        for (int i = 0; i < nums.length; i++) {
	            for (int j = 0; j < colors.length; j++) {
	                String poker = colors[j].concat(nums[i]);
	                hezi.put(index, poker);
	                list.add(index);
	                index++;
	            }
	        }
	        hezi.put(index, "小王");
	        list.add(index);
	        index++;
	        hezi.put(index, "大王");
	        list.add(index);
	        //发牌
	        for (int i = 0; i < list.size(); i++) {
	            if (i >= list.size()-3) {
	                dpset.add(list.get(i));
	            }else if (i%3 == 0) {
	                w1set.add(list.get(i));
	            }else if (i%3 == 1) {
	                w2set.add(list.get(i));
	            }else {
	                w3set.add(list.get(i));
	            }
	        }
	        
	        int d = 0;        
	        while (true) {
	            d = (int)(Math.random()*54);//产生一个0-53之间的随机数，对应着扑克的索引
	            if (!dpset.contains(d)) {//地主牌的索引不是底牌索引
	                break;//结束循环
	            }
	        }
	        System.out.println("地主牌为："+hezi.get(d));
	        
	        if (w1set.contains(d)) {
	            w1set.addAll(dpset);
	        } else if (w2set.contains(d)) {
	            w2set.addAll(dpset);
	        } else {
	            w3set.addAll(dpset);
	        }
	        //看牌
	        look("玩家1", w1set, hezi);
	        look("玩家2", w2set, hezi);
	        look("玩家3", w3set, hezi);
	        look("底牌", dpset, hezi);
	    }
	 public static void look(String name, TreeSet<Integer> set, HashMap<Integer, String> map) {
	        System.out.println(name+"的牌是：");
	        for (Integer i : set) {
	            System.out.print(map.get(i)+" ");
	        }
	        System.out.println();
	    }
	
	public static void main(String[] args) {
		Poker p = new Poker();
		p.init();

	}
}
