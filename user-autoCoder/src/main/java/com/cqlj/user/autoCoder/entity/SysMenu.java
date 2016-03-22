package com.cqlj.user.autoCoder.entity;
import java.math.BigDecimal;

public class SysMenu {
	/** 自增ID号 */
  	private int id;
	/** 操作名称 */
  	private String name;
	/** 操作代码 */
  	private String code;
	/** 父ID */
  	private int pid;
	/** 资源图片路径 */
  	private String icon;
	/** 资源文件路径 */
  	private String url;
	/** 类型 */
  	private char type;
	/** 级别 */
  	private int level;
	/** 顺序 */
  	private int sequence;
	/** 描述 */
  	private String description;
	/** 按钮函数 */
  	private String btnfun;
	
	/** 获取表名 */
    public String getTableName() {
        return "sys_menu";
    }
    /** 不带参数的构造方法 */
    public SysMenu() {
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
	
    public void setCode(String code){
		this.code = code;
	}
	
	public String getCode(){
		return this.code;
	}
	
    public void setPid(int pid){
		this.pid = pid;
	}
	
	public int getPid(){
		return this.pid;
	}
	
    public void setIcon(String icon){
		this.icon = icon;
	}
	
	public String getIcon(){
		return this.icon;
	}
	
    public void setUrl(String url){
		this.url = url;
	}
	
	public String getUrl(){
		return this.url;
	}
	
    public void setType(char type){
		this.type = type;
	}
	
	public char getType(){
		return this.type;
	}
	
    public void setLevel(int level){
		this.level = level;
	}
	
	public int getLevel(){
		return this.level;
	}
	
    public void setSequence(int sequence){
		this.sequence = sequence;
	}
	
	public int getSequence(){
		return this.sequence;
	}
	
    public void setDescription(String description){
		this.description = description;
	}
	
	public String getDescription(){
		return this.description;
	}
	
    public void setBtnfun(String btnfun){
		this.btnfun = btnfun;
	}
	
	public String getBtnfun(){
		return this.btnfun;
	}
	
}