package cn.com.demo;

import java.math.BigDecimal;

public class NYGCouponDiscount implements ICouponDiscount<Double>{
	
	/**
	 * n元购买
	 * 1.无论原价多少钱都固定金额购买
	 */
	public BigDecimal discountAmount(Double couponInfo,BigDecimal skuprice) {
		return new BigDecimal(couponInfo);
	}
}
