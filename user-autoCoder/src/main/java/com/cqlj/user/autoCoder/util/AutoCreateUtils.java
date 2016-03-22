package com.cqlj.user.autoCoder.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.DocumentException;

public class AutoCreateUtils {
	/**
	 * 查询数据库所有表名
	 * 
	 * @return 返回数据库所有表名
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static List<String> getTablesName() throws ClassNotFoundException, SQLException {
		List<String> list = new ArrayList<String>();
		String sql = "show tables";
		ResultSet rs = DBConnection.getResultSet(sql);
		while (rs.next()) {
			list.add(rs.getString(1));
		}
		return list;
	}

	/**
	 * 获取表中所有字段、字段类型以及注释
	 * 
	 * @return 返回表中所有字段、字段类型以及注释
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws DocumentException
	 */
	public static List<Map<String, String>> getTablesMsg(String dbName, String tableName)
			throws ClassNotFoundException, SQLException, DocumentException {
		String sql = "SELECT column_name AS columnName, data_type AS dataType, column_comment AS comment FROM information_schema.columns WHERE table_schema = '"
				+ dbName + "' and table_name ='" + tableName + "'";
		System.out.println(sql);
		ResultSet rs = DBConnection.getResultSet(sql);
		List<Map<String, String>> fields = new ArrayList<Map<String, String>>();
		while (rs.next()) {
			Map<String, String> field = new HashMap<String, String>();
			field.put(Constants.COLUMNNAME, AutoCreateUtils.getFieldName(rs.getString("columnName")));
			field.put(Constants.DATATYPE, XmlUtil.getJavaDataType("mysql", rs.getString("dataType")));
			field.put(Constants.COMMENT, rs.getString("comment"));
			fields.add(field);
		}
		return fields;
	}

	/**
	 * 将表名转换成实体名称
	 * 
	 * @param tableName
	 * @return 实体名
	 */
	public static String getEntityName(String tableName) {
		tableName = tableName.toLowerCase();
		String[] arr = tableName.split("_");
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < arr.length; i++) {
			String temp = arr[i].substring(0, 1).toUpperCase() + arr[i].substring(1);
			sb.append(temp);
		}
		return sb.toString();
	}

	/**
	 * 将列名转换为实体类的域名
	 * 
	 * @param columnName
	 * @return
	 */
	public static String getFieldName(String columnName) {
		columnName = columnName.toLowerCase();
		String[] arr = columnName.split("_");
		StringBuffer sb = new StringBuffer(arr[0]);
		for (int i = 1; i < arr.length; i++) {
			String temp = arr[i].substring(0, 1).toUpperCase() + arr[i].substring(1);
			sb.append(temp);
		}
		return sb.toString();
	}

}
