package com.cqlj.user.autoCoder.util;

import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.cqlj.user.autoCoder.Entity;

import jodd.util.StringUtil;

public class XmlUtil {
	public static String getJavaDataType(String dataBase, String dbType) throws DocumentException {
		String javaType = "";
		boolean mappinFlag = false;
		SAXReader reader = new SAXReader();
		String url = Entity.class.getResource("/").getPath();
		Document document = reader.read(url + "dataTypeMapping.xml");
		Element root = document.getRootElement();
		for (Iterator i = root.elementIterator(); i.hasNext();) {
			Element element = (Element) i.next();
			for (Iterator j = element.elementIterator(); j.hasNext();) {
				Element elementChild = (Element) j.next();
				if ("java".equals(elementChild.getName())) {
					javaType = elementChild.getTextTrim();
				}
				if (dataBase.equals(elementChild.getName()) && (elementChild.getTextTrim()).contains(dbType)) {
					mappinFlag = true;
				}
				if (StringUtil.isNotEmpty(javaType) && mappinFlag) {
					break;
				}
			}
			if (mappinFlag) {
				break;
			}
		}
		return javaType;
	}
}
