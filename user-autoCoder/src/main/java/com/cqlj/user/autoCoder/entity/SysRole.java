package com.cqlj.user.autoCoder.entity;
import java.math.BigDecimal;

public class SysRole {
	/** 自增ID号 */
  	private int id;
	/** 角色名称 */
  	private String name;
	/** 角色代码 */
  	private String rolekey;
	/** 角色描述 */
  	private String description;
	
	/** 获取表名 */
    public String getTableName() {
        return "sys_role";
    }
    /** 不带参数的构造方法 */
    public SysRole() {
        super();
    }
	
    public void setId(int id){
		this.id = id;
	}
	
	public int getId(){
		return this.id;
	}
	
    public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
    public void setRolekey(String rolekey){
		this.rolekey = rolekey;
	}
	
	public String getRolekey(){
		return this.rolekey;
	}
	
    public void setDescription(String description){
		this.description = description;
	}
	
	public String getDescription(){
		return this.description;
	}
	
}