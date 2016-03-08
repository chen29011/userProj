package com.cqlj.user.autoCoder.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.cqlj.user.autoCoder.Entity;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class GenEntity {
	// http://blog.csdn.net/lufeng20/article/details/8730604
	private String pageEncoding = "UTF-8";
	private Configuration configuration; // FreeMarker配置

	private String sourceDir; // 配置源文件夹
	private String targetDir;

	/**
	 * 创建和调整配置,这个在生命周期中只做一次
	 */
	public GenEntity() {
		configuration = new Configuration();

		try {
			String tempDir = Entity.class.getResource("/").getPath();
			configuration.setDirectoryForTemplateLoading(new File(tempDir));
			configuration.setEncoding(Locale.getDefault(), pageEncoding);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 生成java实体类的核心方法
	 * 
	 * @param clazz
	 * @throws Exception
	 */
	private void genFileHandler() throws Exception {
		/* 1，获取模板 */
		Template temp = configuration.getTemplate("testEntity.ftl", pageEncoding);
		temp.setEncoding(pageEncoding);

		/* 2，设置模板的数据内容Map */
		// 获取实体类名,表名,包名
		String entityName = "Teacher";
		String tableName = "t_teacher";
		String packageName = "com.cqlj.user.autoCoder.entity";

		// 填充Map
		Map<String, Object> targetClazz = new HashMap<String, Object>();
		List<Map<String, String>> fields = new ArrayList<Map<String, String>>();
		
		targetClazz.put("packageName", packageName);
		targetClazz.put("entityName", entityName);
		targetClazz.put("tableName", tableName);
		targetClazz.put("fields", fields);

		
		Map<String, String> field = new HashMap<String, String>();
		field.put("name", "stuName");
		field.put("type", "String");
		
		fields.add(field);
		
		Map<String, String> field2 = new HashMap<String, String>();
		field2.put("name", "age");
		field2.put("type", "int");
		fields.add(field2);
		

		// 判断目标文件夹不存在，则新建文件夹
		String fileName = System.getProperty("user.dir") + "/src/main/java/"+packageName.replace(".", "/")+"/"+entityName+".java";
		System.out.println("-------开始生成" + fileName + "文件......------");

		File target = new File(fileName);
		Writer out = new OutputStreamWriter(new FileOutputStream(target), pageEncoding);
		temp.process(targetClazz, out);
		out.flush();
		out.close();

		System.out.println("-------" + fileName + "文件生成完毕!-------\n");
	}
	
	public static void main(String[] args) throws Exception {
		GenEntity ge = new GenEntity();
		ge.genFileHandler();
	}
}
