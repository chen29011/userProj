package com.cqlj.user.autoCoder.entity;
import java.math.BigDecimal;

public class SysRolePer {
	/** 自增ID号 */
  	private int id;
	/** 菜单ID */
  	private int menuid;
	/** 菜单代码 */
  	private String menucode;
	/** 角色ID */
  	private int roleid;
	
	/** 获取表名 */
    public String getTableName() {
        return "sys_role_per";
    }
    /** 不带参数的构造方法 */
    public SysRolePer() {
        super();
    }
	
    public void setId(int id){
		this.id = id;
	}
	
	public int getId(){
		return this.id;
	}
	
    public void setMenuid(int menuid){
		this.menuid = menuid;
	}
	
	public int getMenuid(){
		return this.menuid;
	}
	
    public void setMenucode(String menucode){
		this.menucode = menucode;
	}
	
	public String getMenucode(){
		return this.menucode;
	}
	
    public void setRoleid(int roleid){
		this.roleid = roleid;
	}
	
	public int getRoleid(){
		return this.roleid;
	}
	
}