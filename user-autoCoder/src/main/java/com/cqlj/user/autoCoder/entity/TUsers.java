package com.cqlj.user.autoCoder.entity;
import java.math.BigDecimal;

public class TUsers {
	/**  */
  	private BigDecimal id;
	/**  */
  	private String username;
	/**  */
  	private String password;
	/**  */
  	private String passwordSalt;
	
	/** 获取表名 */
    public String getTableName() {
        return "t_users";
    }
    /** 不带参数的构造方法 */
    public TUsers() {
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
	
    public void setPassword(String password){
		this.password = password;
	}
	
	public String getPassword(){
		return this.password;
	}
	
    public void setPasswordSalt(String passwordSalt){
		this.passwordSalt = passwordSalt;
	}
	
	public String getPasswordSalt(){
		return this.passwordSalt;
	}
	
}