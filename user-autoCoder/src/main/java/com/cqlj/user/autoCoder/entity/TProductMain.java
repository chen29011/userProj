package com.cqlj.user.autoCoder.entity;
import java.math.BigDecimal;

public class TProductMain {
	/** 商品主键ID */
  	private int id;
	/** 商品名称 */
  	private String productName;
	/** 创建时间 */
  	private BigDecimal createTime;
	/** 更新时间 */
  	private BigDecimal updateTime;
	
	/** 获取表名 */
    public String getTableName() {
        return "t_product_main";
    }
    /** 不带参数的构造方法 */
    public TProductMain() {
        super();
    }
	
    public void setId(int id){
		this.id = id;
	}
	
	public int getId(){
		return this.id;
	}
	
    public void setProductName(String productName){
		this.productName = productName;
	}
	
	public String getProductName(){
		return this.productName;
	}
	
    public void setCreateTime(BigDecimal createTime){
		this.createTime = createTime;
	}
	
	public BigDecimal getCreateTime(){
		return this.createTime;
	}
	
    public void setUpdateTime(BigDecimal updateTime){
		this.updateTime = updateTime;
	}
	
	public BigDecimal getUpdateTime(){
		return this.updateTime;
	}
	
}