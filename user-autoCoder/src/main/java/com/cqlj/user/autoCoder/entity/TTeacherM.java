package com.cqlj.user.autoCoder.entity;
import java.math.BigDecimal;

public class TTeacherM {
	/** 自增ID号 */
  	private int id;
	/** 教师姓名 */
  	private String tecName;
	/** 教师性别 */
  	private BigDecimal tecSex;
	/** 教师年龄 */
  	private BigDecimal tecAge;
	/** 创建时间 */
  	private BigDecimal createTime;
	/** 修改时间 */
  	private BigDecimal modifyTime;
	
	/** 获取表名 */
    public String getTableName() {
        return "t_teacher_m";
    }
    /** 不带参数的构造方法 */
    public TTeacherM() {
        super();
    }
	
    public void setId(int id){
		this.id = id;
	}
	
	public int getId(){
		return this.id;
	}
	
    public void setTecName(String tecName){
		this.tecName = tecName;
	}
	
	public String getTecName(){
		return this.tecName;
	}
	
    public void setTecSex(BigDecimal tecSex){
		this.tecSex = tecSex;
	}
	
	public BigDecimal getTecSex(){
		return this.tecSex;
	}
	
    public void setTecAge(BigDecimal tecAge){
		this.tecAge = tecAge;
	}
	
	public BigDecimal getTecAge(){
		return this.tecAge;
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