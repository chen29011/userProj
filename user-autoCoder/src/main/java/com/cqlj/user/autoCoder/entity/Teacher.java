package com.cqlj.user.autoCoder.entity;

public class Teacher {
  	private String stuName;
  	private int age;

    public String getTableName() {
        return "t_teacher";
    }
      
    public Teacher() {
        super();
    }

    public void setStuName(String stuName){
		this.stuName = stuName;
	}
	
	public String getStuName(){
		return this.stuName;
	}
	
    public void setAge(int age){
		this.age = age;
	}
	
	public int getAge(){
		return this.age;
	}
	
}