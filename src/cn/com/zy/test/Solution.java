package cn.com.zy.test;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

/**
 * 
 *@author wangliuyang
 *@Date 2020/12/31 15:40
 *@Version 1.0
 */
public class Solution {
	public static void main(String[] args) {
		final int BOX_LENGTH = 10;
		ArrayList<TreasureChest> boxes = new ArrayList<>(BOX_LENGTH);
		//创建10个箱子
		for (int i = 1; i <=BOX_LENGTH; i++) {
			boxes.add(new TreasureChest());
		}
		//给每个箱子赋值编号
		for (int i = 1; i <=boxes.size(); i++) {
			boxes.get(i-1).setTreasureChestNum(i);
		}
		//先算出第一个箱子的神秘数字
		boxes.get(0).setLastHashCode("0");
		boxes.get(0).setMysteryNum(1);
		String hashCode = ""+ boxes.get(0).getTreasureChestNum()+boxes.get(0).getLastHashCode()+boxes.get(0).getMysteryNum();
		for(int i = 2; ;i++) {
            if (getSHA256StrJava(hashCode).substring(0, 5).equals("00000")) {
            	boxes.get(0).setHashCode(getSHA256StrJava(hashCode));
            	break;
            }
            boxes.get(0).setMysteryNum(i);
            hashCode = ""+ boxes.get(0).getTreasureChestNum()+boxes.get(0).getLastHashCode()+boxes.get(0).getMysteryNum();
        }
		getBoxesMysteryNum(boxes);
		for (int i = 0; i <boxes.size(); i++) {
			System.out.println(boxes.get(i).getMysteryNum());
		}
	}	
	/**
     * 利用java原生的摘要实现SHA256加密
     * @param str 加密后的报文
     * @return
     */
    public static String getSHA256StrJava(String str){
        MessageDigest messageDigest;
        String encodeStr = "";
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(str.getBytes("UTF-8"));
            encodeStr = byte2Hex(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return encodeStr;
    }
    /**
     * 将byte转为16进制
     * @param bytes
     * @return
     */
    private static String byte2Hex(byte[] bytes){
        StringBuffer stringBuffer = new StringBuffer();
        String temp = null;
        for (int i=0;i<bytes.length;i++){
            temp = Integer.toHexString(bytes[i] & 0xFF);
            if (temp.length()==1){
                //1得到一位的进行补0操作
                stringBuffer.append("0");
            }
            stringBuffer.append(temp);
        }
        return stringBuffer.toString();
    }
    
    public static ArrayList<TreasureChest>getBoxesMysteryNum(ArrayList<TreasureChest> boxes) {
    	for (int i = 1; i < boxes.size(); i++) {
			boxes.get(i).setLastHashCode(boxes.get(i-1).getHashCode());
			boxes.get(i).setMysteryNum(1);
			String hashCode = ""+ boxes.get(i).getTreasureChestNum()+boxes.get(i).getLastHashCode()+boxes.get(i).getMysteryNum();
			for(int j = 2; ;j++) {
	            if (getSHA256StrJava(hashCode).substring(0, 5).equals("00000")) {
	            	boxes.get(i).setHashCode(getSHA256StrJava(hashCode));
	            	break;
	            }
	            boxes.get(i).setMysteryNum(j);
	            hashCode = ""+ boxes.get(i).getTreasureChestNum()+boxes.get(i).getLastHashCode()+boxes.get(i).getMysteryNum();       
	        }
		}
    	return boxes;
    	
    }
}
