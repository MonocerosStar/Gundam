package cn.com.demo;

import java.math.BigDecimal;

public interface ICouponDiscount<T> {
/**
 * 优惠券金额计算
 *@parma couponInfo  卷折扣信息：直减、满减、折扣 、N元购
 *@param skuPrice  sku 金额
 *@return 优惠后金额
 */
	BigDecimal discountAmount(T couponInfo,BigDecimal skuPrice);
}
