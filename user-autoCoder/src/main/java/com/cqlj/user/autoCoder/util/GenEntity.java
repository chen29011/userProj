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
	public void genFileHandler(Map<String, Object> targetClazz, String fileName) throws Exception {
		/* 1，获取模板 */
		Template temp = configuration.getTemplate("testEntity.ftl", pageEncoding);
		temp.setEncoding(pageEncoding);

		// 判断目标文件夹不存在，则新建文件夹
		
		System.out.println("-------开始生成" + fileName + "文件......------");

		File target = new File(fileName);
		Writer out = new OutputStreamWriter(new FileOutputStream(target), pageEncoding);
		temp.process(targetClazz, out);
		out.flush();
		out.close();

		System.out.println("-------" + fileName + "文件生成完毕!-------\n");
	}
}
