package com.cqlj.user.autoCoder.entity;
import java.math.BigDecimal;

public class SysUser {
	/** 自增ID号 */
  	private int id;
	/** 用户姓名 */
  	private String username;
	/** 用户账号 */
  	private String accountname;
	/** 密码 */
  	private String password;
	/** 角色ID */
  	private int roleid;
	/** 用户状态:1-有效;2-无效 */
  	private char status;
	/** 创建时间 */
  	private BigDecimal createdate;
	
	/** 获取表名 */
    public String getTableName() {
        return "sys_user";
    }
    /** 不带参数的构造方法 */
    public SysUser() {
        super();
    }
	
    public void setId(int id){
		this.id = id;
	}
	
	public int getId(){
		return this.id;
	}
	
    public void setUsername(String username){
		this.username = username;
	}
	
	public String getUsername(){
		return this.username;
	}
	
    public void setAccountname(String accountname){
		this.accountname = accountname;
	}
	
	public String getAccountname(){
		return this.accountname;
	}
	
    public void setPassword(String password){
		this.password = password;
	}
	
	public String getPassword(){
		return this.password;
	}
	
    public void setRoleid(int roleid){
		this.roleid = roleid;
	}
	
	public int getRoleid(){
		return this.roleid;
	}
	
    public void setStatus(char status){
		this.status = status;
	}
	
	public char getStatus(){
		return this.status;
	}
	
    public void setCreatedate(BigDecimal createdate){
		this.createdate = createdate;
	}
	
	public BigDecimal getCreatedate(){
		return this.createdate;
	}
	
}