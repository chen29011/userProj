package com.cqlj.user.autoCoder.entity;
import java.math.BigDecimal;

public class THallRoomMsg {
	/** 自增ID号 */
  	private int id;
	/** 大厅/包厢名称 */
  	private String hallRomeName;
	
	/** 获取表名 */
    public String getTableName() {
        return "t_hall_room_msg";
    }
    /** 不带参数的构造方法 */
    public THallRoomMsg() {
        super();
    }
	
    public void setId(int id){
		this.id = id;
	}
	
	public int getId(){
		return this.id;
	}
	
    public void setHallRomeName(String hallRomeName){
		this.hallRomeName = hallRomeName;
	}
	
	public String getHallRomeName(){
		return this.hallRomeName;
	}
	
}