package com.cqlj.user.autoCoder.entity;
import java.math.BigDecimal;

public class TestDecimal {
	/** 订单价格 */
  	private BigDecimal orderPrice;
	
	/** 获取表名 */
    public String getTableName() {
        return "test_decimal";
    }
    /** 不带参数的构造方法 */
    public TestDecimal() {
        super();
    }
	
    public void setOrderPrice(BigDecimal orderPrice){
		this.orderPrice = orderPrice;
	}
	
	public BigDecimal getOrderPrice(){
		return this.orderPrice;
	}
	
}