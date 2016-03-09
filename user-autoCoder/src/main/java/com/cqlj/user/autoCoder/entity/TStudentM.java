package com.cqlj.user.autoCoder.entity;
import java.math.BigDecimal;

public class TStudentM {
	/** 自增ID号 */
  	private int id;
	/** 学生姓名 */
  	private String stuName;
	/** 学生年龄 */
  	private BigDecimal stuAge;
	/** 学生性别 */
  	private BigDecimal stuSex;
	/** 创建时间 */
  	private BigDecimal createTime;
	/** 修改时间 */
  	private BigDecimal modifyTime;
	
	/** 获取表名 */
    public String getTableName() {
        return "t_student_m";
    }
    /** 不带参数的构造方法 */
    public TStudentM() {
        super();
    }
	
    public void setId(int id){
		this.id = id;
	}
	
	public int getId(){
		return this.id;
	}
	
    public void setStuName(String stuName){
		this.stuName = stuName;
	}
	
	public String getStuName(){
		return this.stuName;
	}
	
    public void setStuAge(BigDecimal stuAge){
		this.stuAge = stuAge;
	}
	
	public BigDecimal getStuAge(){
		return this.stuAge;
	}
	
    public void setStuSex(BigDecimal stuSex){
		this.stuSex = stuSex;
	}
	
	public BigDecimal getStuSex(){
		return this.stuSex;
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