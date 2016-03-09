package com.cqlj.user.autoCoder.entity;
import java.math.BigDecimal;

public class TRolesPermissions {
	/**  */
  	private BigDecimal id;
	/**  */
  	private String roleName;
	/**  */
  	private String permission;
	
	/** 获取表名 */
    public String getTableName() {
        return "t_roles_permissions";
    }
    /** 不带参数的构造方法 */
    public TRolesPermissions() {
        super();
    }
	
    public void setId(BigDecimal id){
		this.id = id;
	}
	
	public BigDecimal getId(){
		return this.id;
	}
	
    public void setRoleName(String roleName){
		this.roleName = roleName;
	}
	
	public String getRoleName(){
		return this.roleName;
	}
	
    public void setPermission(String permission){
		this.permission = permission;
	}
	
	public String getPermission(){
		return this.permission;
	}
	
}