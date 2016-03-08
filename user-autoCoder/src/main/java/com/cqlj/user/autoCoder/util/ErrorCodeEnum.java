package com.cqlj.user.autoCoder.util;

public enum ErrorCodeEnum {
	E001("SystemError"), E002("DBConnectError");

	private String value;

	private ErrorCodeEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public static ErrorCodeEnum getEnumByValue(String value) {
		for (ErrorCodeEnum ws : ErrorCodeEnum.values()) {
			if (ws.getValue().equals(value)) {
				return ws;
			}
		}
		return null;
	}

}
