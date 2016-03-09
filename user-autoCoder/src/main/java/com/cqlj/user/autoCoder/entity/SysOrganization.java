package com.cqlj.user.autoCoder.entity;
import java.math.BigDecimal;

public class SysOrganization {
	/** 自增ID号 */
  	private int id;
	/** 组织机构名 */
  	private String name;
	/** 显示顺序 */
  	private int priority;
	/** 父编号 */
  	private int parentId;
	/** 父编号列表 */
  	private String parentIds;
	/** 是否可用 */
  	private BigDecimal available;
	/** 创建时间 */
  	private BigDecimal createTime;
	/** 修改时间 */
  	private BigDecimal modifyTime;
	
	/** 获取表名 */
    public String getTableName() {
        return "sys_organization";
    }
    /** 不带参数的构造方法 */
    public SysOrganization() {
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