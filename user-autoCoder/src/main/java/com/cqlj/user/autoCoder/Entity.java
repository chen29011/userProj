package com.cqlj.user.autoCoder;

import org.dom4j.DocumentException;

import com.cqlj.user.autoCoder.util.XmlUtil;

public class Entity {

	public static void main(String[] args) throws DocumentException{
		System.out.println(XmlUtil.getJavaDataType("mysql", "varchar"));
	}
}
