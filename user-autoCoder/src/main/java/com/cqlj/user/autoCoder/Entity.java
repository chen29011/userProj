package com.cqlj.user.autoCoder;

import java.io.File;
import java.lang.reflect.Method;

import org.dom4j.DocumentException;

import com.cqlj.user.autoCoder.util.PropsUtil;
import com.cqlj.user.autoCoder.util.XmlUtil;

public class Entity {

	public static void main(String[] args) throws Exception {
		System.out.println(XmlUtil.getJavaDataType("mysql", "varchar"));
		System.out.println(PropsUtil.getParamcValue("entityPackageName"));

		System.out.println(System.getProperty("user.dir") + "/src/");
		String packageName = "";
		File root = new File(System.getProperty("user.dir") + "\\src");
		loop(root, packageName);

	}

	public static void loop(File folder, String packageName) throws Exception {
		File[] files = folder.listFiles();
		for (int fileIndex = 0; fileIndex < files.length; fileIndex++) {
			File file = files[fileIndex];
			if (file.isDirectory()) {
				loop(file, packageName + file.getName() + ".");
			} else {
				listMethodNames(file.getName(), packageName);
			}
		}
	}

	public static void listMethodNames(String filename, String packageName) {
		try {
			String name = filename.substring(0, filename.length() - 5);
			Object obj = Class.forName(packageName + name);
			Method[] methods = obj.getClass().getDeclaredMethods();
			System.out.println(filename);
			for (int i = 0; i < methods.length; i++) {
				System.out.println("\t" + methods[i].getName());
			}
		} catch (Exception e) {
			System.out.println("exception = " + e.getLocalizedMessage());
		}
	}
}
