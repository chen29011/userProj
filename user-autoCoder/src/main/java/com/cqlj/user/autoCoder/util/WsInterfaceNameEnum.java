package com.cqlj.user.autoCoder.util;

public enum WsInterfaceNameEnum {
	
	XZCF("createChufaCaseWithWebservice"),///** 接口1:行政处罚案件 */
	YSXF("createYisongCaseWithWebservice"),///** 接口2:移送涉嫌犯罪案件 */
	JYYSGA("createCaseJyysWithWebservice"),///** 接口3:建议移送公安 */
	YSGA("createCaseYsgaWithWebservice"),///**  接口4:移送公安 */
	JDLA("createCaseLaWithWebservice"),///** 接口5:决定立案 */
	BLA("createCaseBlaWithWebservice"),///** 接口6:不立案 */
	TZLA("createCaseJctzlaWithWebservice"),///** 接口7:通知立案 */
	TQDB("createCaseTqdbWithWebservice"),///** 接口8:提请逮捕 */
	SCDB("createCaseScdbWithWebservice"),///** 接口9:审查逮捕 */
	YSQS("createCaseYsqsWithWebservice"),///** 接口10:移送起诉 */
	SCQS("createCaseScqsWithWebservice"),///** 接口11:审查起诉 */
	THBCZC("createCaseThgabczcWithWebservice"),///** 接口12:退回公安补充侦查 */
	BCZC("createCaseGabczcWithWebservice"),///** 接口13:公安补充侦查 */
	FYPJ("createCaseFypjWithWebservice");///** 接口2:移送涉嫌犯罪案件 */

	//ws接口名称
	private String value;

	private WsInterfaceNameEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public static WsInterfaceNameEnum getEnumByValue(String value){
		for(WsInterfaceNameEnum ws:WsInterfaceNameEnum.values()){
			if(ws.getValue().equals(value)){
				return ws;
			}
		}
		
		return null;
	}

	
	
	
}
