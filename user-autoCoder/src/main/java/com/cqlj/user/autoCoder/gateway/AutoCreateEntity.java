package com.cqlj.user.autoCoder.gateway;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.cqlj.user.autoCoder.util.AutoCreateUtils;
import com.cqlj.user.autoCoder.util.Constants;
import com.cqlj.user.autoCoder.util.GenEntity;
import com.cqlj.user.autoCoder.util.PropsUtil;

public class AutoCreateEntity {
	public static void main(String[] args) throws Exception {
		// 获取所有表名
		List<String> tablesName = AutoCreateUtils.getTablesName();
		Iterator iter = tablesName.iterator();
		while (iter.hasNext()) {
			String tableName = (String) iter.next();
			// 获取表对应的表信息
			List<Map<String, String>> tablesMsg = AutoCreateUtils.getTablesMsg(tableName);
			String packageName = PropsUtil.getParamcValue("entityPackageName");
			String entityName = AutoCreateUtils.getEntityName(tableName);
			Map<String, Object> targetClazz = new HashMap<String, Object>();
			targetClazz.put(Constants.EPKNAME, packageName);
			targetClazz.put(Constants.TABNAME, tableName);
			targetClazz.put(Constants.ENTITYNAME, entityName);
			targetClazz.put("fields", tablesMsg);
			// 生成文件路径
			String fileName = System.getProperty("user.dir") + "/src/main/java/" + packageName.replace(".", "/") + "/"
					+ entityName + ".java";
			GenEntity ge = new GenEntity();
			ge.genFileHandler(targetClazz, fileName);
		}
	}
}
