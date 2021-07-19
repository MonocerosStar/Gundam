package cn.com.zy.test;

import java.util.Date;

/**
 * 
 *@author wangliuyang
 *@Date 2020/12/31 14:54
 *@Version 1.0
 */
public class TreasureChest {
	private int treasureChestNum;//箱子编号
	private String hashCode;
	private String lastHashCode;
	private int mysteryNum;
	
	
	@Override
	public String toString() {
		return "TreasureChest [treasureChestNum=" + treasureChestNum + ", hashCode=" + hashCode + ", lastHashCode="
				+ lastHashCode + ", mysteryNum=" + mysteryNum + "]";
	}
	public int getTreasureChestNum() {
		return treasureChestNum;
	}
	public void setTreasureChestNum(int treasureChestNum) {
		this.treasureChestNum = treasureChestNum;
	}
	
	public String getHashCode() {
		return hashCode;
	}
	public void setHashCode(String hashCode) {
		this.hashCode = hashCode;
	}
	public String getLastHashCode() {
		return lastHashCode;
	}
	public void setLastHashCode(String lastHashCode) {
		this.lastHashCode = lastHashCode;
	}
	public int getMysteryNum() {
		return mysteryNum;
	}
	public void setMysteryNum(int mysteryNum) {
		this.mysteryNum = mysteryNum;
	}

	
}
