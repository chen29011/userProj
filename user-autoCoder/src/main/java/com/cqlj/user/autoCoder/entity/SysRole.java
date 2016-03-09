package com.cqlj.user.autoCoder.entity;
import java.math.BigDecimal;

public class SysRole {
	/** 自增ID号 */
  	private int id;
	/** 角色名称 */
  	private String role;
	/** 角色描述 */
  	private String description;
	/** 授权的资源 */
  	private String resourceIds;
	/** 是否可用 */
  	private BigDecimal available;
	/** 创建时间 */
  	private BigDecimal createTime;
	/** 修改时间 */
  	private BigDecimal modifyTime;
	/**  */
  	private int roleId;
	/**  */
  	private String roleName;
	/**  */
  	private String roleDesc;
	/**  */
  	private String recordId;
	/**  */
  	private BigDecimal recordDate;
	/**  */
  	private String lastmodiId;
	/**  */
  	private BigDecimal lastmodiDate;
	/**  */
  	private int companyId;
	
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
	
    public void setRole(String role){
		this.role = role;
	}
	
	public String getRole(){
		return this.role;
	}
	
    public void setDescription(String description){
		this.description = description;
	}
	
	public String getDescription(){
		return this.description;
	}
	
    public void setResourceIds(String resourceIds){
		this.resourceIds = resourceIds;
	}
	
	public String getResourceIds(){
		return this.resourceIds;
	}
	
    public void setAvailable(BigDecimal available){
		this.available = available;
	}
	
	public BigDecimal getAvailable(){
		return this.available;
	}
	
    public void setCreateTime(BigDecimal createTime){
		this.createTime = createTime;
	}
	
	public BigDecimal getCreateTime(){
		return this.createTime;
	}
	
    public void setModifyTime(BigDecimal modifyTime){
		this.modifyTime = modifyTime;
	}
	
	public BigDecimal getModifyTime(){
		return this.modifyTime;
	}
	
    public void setRoleId(int roleId){
		this.roleId = roleId;
	}
	
	public int getRoleId(){
		return this.roleId;
	}
	
    public void setRoleName(String roleName){
		this.roleName = roleName;
	}
	
	public String getRoleName(){
		return this.roleName;
	}
	
    public void setRoleDesc(String roleDesc){
		this.roleDesc = roleDesc;
	}
	
	public String getRoleDesc(){
		return this.roleDesc;
	}
	
    public void setRecordId(String recordId){
		this.recordId = recordId;
	}
	
	public String getRecordId(){
		return this.recordId;
	}
	
    public void setRecordDate(BigDecimal recordDate){
		this.recordDate = recordDate;
	}
	
	public BigDecimal getRecordDate(){
		return this.recordDate;
	}
	
    public void setLastmodiId(String lastmodiId){
		this.lastmodiId = lastmodiId;
	}
	
	public String getLastmodiId(){
		return this.lastmodiId;
	}
	
    public void setLastmodiDate(BigDecimal lastmodiDate){
		this.lastmodiDate = lastmodiDate;
	}
	
	public BigDecimal getLastmodiDate(){
		return this.lastmodiDate;
	}
	
    public void setCompanyId(int companyId){
		this.companyId = companyId;
	}
	
	public int getCompanyId(){
		return this.companyId;
	}
	
}