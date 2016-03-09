package com.cqlj.user.autoCoder.entity;
import java.math.BigDecimal;

public class SysResource {
	/** 自增ID号 */
  	private int id;
	/** 资源名称 */
  	private String name;
	/** 资源类型 */
  	private String type;
	/** 显示顺序 */
  	private int priority;
	/** 父编号 */
  	private int parentId;
	/** 父编号列表 */
  	private String parentIds;
	/** 权限字符串 */
  	private String permission;
	/** 是否可用 */
  	private BigDecimal available;
	/** 创建时间 */
  	private BigDecimal createTime;
	/** 修改时间 */
  	private BigDecimal modifyTime;
	
	/** 获取表名 */
    public String getTableName() {
        return "sys_resource";
    }
    /** 不带参数的构造方法 */
    public SysResource() {
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
	
    public void setType(String type){
		this.type = type;
	}
	
	public String getType(){
		return this.type;
	}
	
    public void setPriority(int priority){
		this.priority = priority;
	}
	
	public int getPriority(){
		return this.priority;
	}
	
    public void setParentId(int parentId){
		this.parentId = parentId;
	}
	
	public int getParentId(){
		return this.parentId;
	}
	
    public void setParentIds(String parentIds){
		this.parentIds = parentIds;
	}
	
	public String getParentIds(){
		return this.parentIds;
	}
	
    public void setPermission(String permission){
		this.permission = permission;
	}
	
	public String getPermission(){
		return this.permission;
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
	
}