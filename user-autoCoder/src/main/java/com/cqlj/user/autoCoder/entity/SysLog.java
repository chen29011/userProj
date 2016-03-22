package com.cqlj.user.autoCoder.entity;
import java.math.BigDecimal;

public class SysLog {
	/** 自增ID号 */
  	private int id;
	/** 用户账号 */
  	private String accountname;
	/** 模块名称 */
  	private String module;
	/** 操作名称 */
  	private String methods;
	/** 描述 */
  	private String description;
	/** 创建日期 */
  	private BigDecimal createdate;
	
	/** 获取表名 */
    public String getTableName() {
        return "sys_log";
    }
    /** 不带参数的构造方法 */
    public SysLog() {
        super();
    }
	
    public void setId(int id){
		this.id = id;
	}
	
	public int getId(){
		return this.id;
	}
	
    public void setAccountname(String accountname){
		this.accountname = accountname;
	}
	
	public String getAccountname(){
		return this.accountname;
	}
	
    public void setModule(String module){
		this.module = module;
	}
	
	public String getModule(){
		return this.module;
	}
	
    public void setMethods(String methods){
		this.methods = methods;
	}
	
	public String getMethods(){
		return this.methods;
	}
	
    public void setDescription(String description){
		this.description = description;
	}
	
	public String getDescription(){
		return this.description;
	}
	
    public void setCreatedate(BigDecimal createdate){
		this.createdate = createdate;
	}
	
	public BigDecimal getCreatedate(){
		return this.createdate;
	}
	
}