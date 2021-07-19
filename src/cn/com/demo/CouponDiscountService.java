package cn.com.demo;

public class CouponDiscountService {
	public double discountAmount(int type,double typeContent,double skuPrice,double typeExt) {
		//1.直减卷
		if (1==type) {
			return skuPrice - typeContent;
		}
		//2.满减卷
		if (2==type) {
			if (skuPrice <typeExt) {
				return skuPrice;
			}
			return skuPrice - typeContent;
		}
		//3.折扣卷
		if (3==type) {
			return skuPrice*typeContent;
		}
		//3.n元购
		if (4==type) {
			return typeContent;
		}
		return 0D;
	}
}
