package com.cqlj.user.autoCoder.entity;
import java.math.BigDecimal;

public class TUserRoles {
	/**  */
  	private BigDecimal id;
	/**  */
  	private String username;
	/**  */
  	private String roleName;
	
	/** 获取表名 */
    public String getTableName() {
        return "t_user_roles";
    }
    /** 不带参数的构造方法 */
    public TUserRoles() {
        super();
    }
	
    public void setId(BigDecimal id){
		this.id = id;
	}
	
	public BigDecimal getId(){
		return this.id;
	}
	
    public void setUsername(String username){
		this.username = username;
	}
	
	public String getUsername(){
		return this.username;
	}
	
    public void setRoleName(String roleName){
		this.roleName = roleName;
	}
	
	public String getRoleName(){
		return this.roleName;
	}
	
}